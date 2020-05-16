package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CheckBoxx {

    public static void display(){
        Stage window = new Stage();
        window.setTitle("CheckBox");
        window.setMinWidth(300);
        window.setMinHeight(300);

        //CheckBoxes
        CheckBox javaFx = new CheckBox("JavaFX");
        CheckBox deepLearning = new CheckBox("Deep Learning");
        CheckBox java = new CheckBox("Java");
        CheckBox cPlusplus = new CheckBox("C++");

        //Button
        Button checkSelected = new Button("Check Selected");
        checkSelected.setOnAction(e -> check(java,javaFx,deepLearning,cPlusplus));

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(5);
        grid.setHgap(5);

        GridPane.setConstraints(javaFx,0,0);
        GridPane.setConstraints(deepLearning,0,1);
        GridPane.setConstraints(java,0,2);
        GridPane.setConstraints(cPlusplus,0,3);
        GridPane.setConstraints(checkSelected,0,4);

        grid.getChildren().addAll(java,javaFx,cPlusplus,deepLearning,checkSelected);
        Scene scene = new Scene(grid,300,300);
        window.setScene(scene);
        window.show();
    }

    private static void check(CheckBox java, CheckBox jfx, CheckBox deep, CheckBox cplus){
        String msg = "";
        if(java.isSelected()) msg+= java.getText()+"\n";
        if(jfx.isSelected()) msg+= jfx.getText()+"\n";
        if(deep.isSelected()) msg+= deep.getText()+"\n";
        if(cplus.isSelected()) msg+= cplus.getText()+"\n";
        msg+="\nare selected.";
        AlertBox.display("CheckBox Alert",msg);
    }
}
