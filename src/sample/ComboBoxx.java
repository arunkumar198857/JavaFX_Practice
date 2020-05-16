package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxx {
    public static void display(){
        Stage window = new Stage();
        window.setTitle("ComboBox");


        ComboBox<String> box = new ComboBox<>();
        box.getItems().addAll(
                "Slime datta ken",
                "Overlord",
                "Akame ga kill!",
                "Death note",
                "Kimi no na wa",
                "Ao no exorcist"
        );
        Label txt = new Label();
        txt.setText("Fav. anime: ");

        box.setEditable(true);

        //Output text field
        TextField field = new TextField();
        field.setPromptText("Result");

        box.setOnAction( e-> {
            field.setText(box.getValue());
        });

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(txt,box,field);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
}
