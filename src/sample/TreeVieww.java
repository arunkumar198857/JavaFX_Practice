package sample;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TreeVieww {

    public static void display(){
        Stage window = new Stage();
        window.setTitle("ListVieww");

        //Intro label
        Label intro = new Label();
        intro.setText("Tree View:");

        TreeView<String> mytree;
        TreeItem<String> root, charMANder, Arun;

        //root
        root = new TreeItem<>();
        root.setExpanded(true);

        //charMANder
        //makeBranch(itemName, parentName)
        charMANder = makeBranch("charMANder", root);
        makeBranch("CSGO", charMANder);
        makeBranch("Rage", charMANder);
        makeBranch("Pero", charMANder);
        makeBranch("Awper", charMANder);

        //Arun
        Arun = makeBranch("Arun", root);
        makeBranch("Caring", Arun);
        makeBranch("Extrovert", Arun);
        makeBranch("Friendly", Arun);
        makeBranch("Namuna", Arun);

        //create Tree
        mytree = new TreeView<>(root);
        mytree.setShowRoot(false);

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(intro, mytree);

        Scene scene = new Scene(layout,400,400);
        window.setScene(scene);
        window.show();
    }

    private static TreeItem<String> makeBranch(String str, TreeItem<String> parent){
        TreeItem<String> item = new TreeItem<>(str);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }
}
