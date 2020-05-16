package sample;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListVieww {

    public static void display(){
        Stage window = new Stage();
        window.setTitle("ListView");

        //Introductory label
        Label intro = new Label();
        intro.setText("Select Fav. Series:");

        ListView<String> mylist= new ListView<>();
        mylist.getItems().addAll("Avengers","Harry Potter","Bad boys","American Pie","Back to the future","Scary Movie");
        mylist.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //TextArea to print all the selected series
        TextArea res = new TextArea();
        res.setPromptText("Result");

        ///Button to print selected series
        Button button = new Button("Print List");
        button.setOnAction(e -> printIt(mylist, res));


        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(intro,mylist,button,res);

        Scene scene = new Scene(layout,600,600);
        window.setScene(scene);
        window.show();
    }

    private static void printIt(ListView<String> mylist, TextArea res){
        String msg = "";
        ObservableList<String> series;
        series = mylist.getSelectionModel().getSelectedItems();

        for(String s : series){
            msg += s+"\n";
        }
        msg += "\n"+" are selected!";
        res.setText(msg);
    }
}
