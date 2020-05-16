package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    Stage window;
    Scene scene1, scene2;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        Label label1 = new Label("Welcome to the first scene!");

        //First Scene
        Button button1 = new Button("Go to scene 2.");
        button1.setOnAction(e -> window.setScene(scene2));

        //ConfirmBox
        Button confirmButton = new Button("ConfirmBox");
        confirmButton.setOnAction(e->{
            boolean answer = ConfirmBox.display("Title of the window","Are you sure you want to do this?");
            System.out.println(answer);
        });

        //RadioMenu
        Button rad = new Button("RadioMenu");
        rad.setOnAction( e-> RadioClass.display());

        //String Property Class
        Button strButton = new Button("StringProperty Class");
        strButton.setOnAction( e-> StringPropClass.display());

        //Close Window
        Button closeButton = new Button("Close window.");
        closeButton.setOnAction(e-> closeWindow());

        VBox layout1 = new VBox(15);
        layout1.setPadding(new Insets(20,20,20,20));
        layout1.getChildren().addAll(label1, button1, confirmButton,rad,strButton,closeButton);
        scene1 = new Scene(layout1, 400, 300);


        //Second Scene
        Label label2 = new Label("Welcome to the second scene!");
        Button button2 = new Button("Go back to scene 1.");
        button2.setOnAction(e -> window.setScene(scene1));

        //Login Class
        Button loginButton = new Button("Login Class");
        loginButton.setOnAction(e -> LoginClass.display());

        //AlertBox Class
        Button button3 = new Button("AlertBox");
        button3.setOnAction(e -> AlertBox.display("AlertBox","This is an Alert Box, BE ALERT!"));

        //CheckBoxx Class
        Button check = new Button("Check Boxx");
        check.setOnAction(e -> CheckBoxx.display());

        //DropDownMenu Class
        Button drop = new Button("DropDownMenu");
        drop.setOnAction(e -> DropDownMenu.display());

        //DropDownMenu with Listener
        Button drop2 = new Button("DropDownMenu2");
        drop2.setOnAction(e -> DropDownMenu2.display());

        //ComboBoxx Class
        Button combo = new Button("ComboBoxx");
        combo.setOnAction(e -> ComboBoxx.display());

        //ListVieww Class
        Button lis = new Button("ListVieww");
        lis.setOnAction(e-> ListVieww.display());

        //TreeVieww Class
        Button tre = new Button("TreeVieww");
        tre.setOnAction(e -> TreeVieww.display());

        //TableVieww Class
        Button tab = new Button("TableVieww");
        tab.setOnAction(e-> TableVieww.display());

        //Menu Class
        Button men = new Button("Menu");
        men.setOnAction(e -> Menuu.display());

        VBox layout2 = new VBox(15);
        layout2.setPadding(new Insets(20,20,20,20));
        layout2.getChildren().addAll(label2, button2, button3,loginButton,check,drop,drop2,combo,lis,tre,tab,men);
        scene2 = new Scene(layout2,400,500);

        window.setScene(scene1);
        window.setOnCloseRequest(e -> {
            e.consume();
            closeWindow();
        });
        window.setTitle("Scene switching");
        window.show();

    }

    private void closeWindow(){
        Boolean answer = ConfirmBox.display("charMANder sad.","Are you sure you want to close the program?");
        if(answer)
            window.close();
    }
}
