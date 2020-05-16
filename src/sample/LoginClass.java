package sample;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginClass{

    public static Connection connection = null;
    public static PreparedStatement preparedStatement = null;
    public static ResultSet resultSet = null;

    public static void display(){
        Stage window = new Stage();
        window.setTitle("Login Class");
        window.setMinWidth(400);
        window.setMinHeight(300);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20,20,20,20));
        grid.setVgap(8);
        grid.setHgap(10);

        //Name
        Label name = new Label();
        name.setText("Name:");
        GridPane.setConstraints(name,0,0);

        //Name Textfield
        TextField nameInput= new TextField();
        nameInput.setPromptText("username");
        GridPane.setConstraints(nameInput,1,0);

        //Password
        Label pass = new Label();
        pass.setText("Password:");
        GridPane.setConstraints(pass,0,1);

        //Password Textfield
        PasswordField passInput = new PasswordField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput,1,1);

        //Login Button
        Button loginButton = new Button("Login");

        GridPane.setConstraints(loginButton,1,2);

        grid.getChildren().addAll(name,nameInput,pass,passInput,loginButton);

        Scene scene = new Scene(grid,300,200);
        window.setScene(scene);
        window.show();


        loginButton.setOnAction(e -> {
            String username = nameInput.getText().toString().trim();
            String password = passInput.getText().toString().trim();
            System.out.println("Username entered: "+username);
            System.out.println("Passowrd entered: "+password);

            String sql = "select * from userLogin where username = ? and userpassword = ?;";

            //Connecting to Database
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost/YOUR DATABASE HERE","root","INSERT YOUR PASSWORD HERE");
                System.out.println("Connection with database established!");
            }
            catch(Exception exception)
            {
                System.out.println("Connection with database NOT established.");
                JOptionPane.showMessageDialog(null, exception);
            }


            //Executing Query
            try{
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if(!resultSet.next()){
                    AlertBox.display("Login failed","Please enter correct username or password.");
                }else{
                    AlertBox.display("Login successful!","Login successful, welcome "+username+"!");
                    Node node = (Node)e.getSource();
                }
            }
            catch(Exception exception){
                exception.printStackTrace();
            }
        });
    }
}
