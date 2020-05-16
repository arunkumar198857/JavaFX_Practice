package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DropDownMenu2 {

    public static void display() {
        Stage window = new Stage();
        window.setTitle("ChoiceBox");
        window.setMinHeight(300);
        window.setMinWidth(300);

        Label select = new Label();
        select.setText("Select course:");

        //DropDownMenu
        ChoiceBox<String> mychoicebox = new ChoiceBox<String>();
        mychoicebox.getItems().addAll("JavaFx", "Java", "C++", "C", "Python", "HTML", "PHP", "JavaScript", "None");

        //set a default value (can only be the one already in the list)
        mychoicebox.setValue("None");

        //TextField for output
        TextField output = new TextField();
        output.setPromptText("Output");


        //Listening for Selection Changes
        mychoicebox.getSelectionModel().selectedIndexProperty().addListener( (v, oldItem, newItem) -> {
            String str = mychoicebox.getItems().get((Integer) newItem);
            output.setText(str);
        });

        GridPane mygrid = new GridPane();
        mygrid.setVgap(20);
        mygrid.setPadding(new Insets(10, 30, 30, 10));
        GridPane.setConstraints(select, 0, 0);
        GridPane.setConstraints(mychoicebox, 1, 0);
        GridPane.setConstraints(output, 0, 2);

        mygrid.getChildren().addAll(select, mychoicebox, output);

        Scene scene = new Scene(mygrid, 300, 300);
        window.setScene(scene);
        window.show();
    }
}
