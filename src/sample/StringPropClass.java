package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicReference;


public class StringPropClass {

    private StringProperty firstName = new SimpleStringProperty(this,"firstName","");

    //returns the address where the StringProperty is stored in the memory
    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public static void display(){
        AtomicReference<String> strRes = new AtomicReference<>("");
        Stage window = new Stage();
        window.setTitle("StringProperty Class");
        window.setMinHeight(400);
        window.setMinWidth(300);

        //Simple Button
        Button checkButton = new Button("Check Property");

        //TextArea
        TextArea resultArea = new TextArea();
        resultArea.setPromptText("Result");

        //Making an object to manipulate
        StringPropClass person = new StringPropClass();
        person.firstNameProperty().addListener((v, oldValue, newValue) -> {
            System.out.println("Name changed to: "+newValue);
            System.out.println("firstNameProperty(): "+ person.firstNameProperty());
            System.out.println("getFirstName(): "+person.getFirstName());
            strRes.set(newValue + "\n" + person.firstNameProperty() + "\n" + person.getFirstName() + "\n\n" + "are the changes made.");
        });

        checkButton.setOnAction( e-> {
            person.setFirstName("charMANder");
            resultArea.setText(strRes.toString());
        });

        //Layout
        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(20,20,20,20));
        vBox.getChildren().addAll(checkButton,resultArea);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }
}
