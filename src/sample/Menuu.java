package sample;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Menuu {
    public static void display(){

        Stage window = new Stage();
        window.setTitle("Menu");

        //File Menu
        Menu fileMenu = new Menu("_File");

        //File menu items
        fileMenu.getItems().add(new MenuItem("New..."));
        MenuItem openFile = new MenuItem("Open...");
        openFile.setOnAction(e -> AlertBox.display("Open file...","Open the file?"));
        fileMenu.getItems().add(openFile);
        fileMenu.getItems().add(new MenuItem("Save..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Project Structure..."));
        fileMenu.getItems().add(new MenuItem("Settings..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Exit"));

        //Edit Menu
        Menu editMenu = new Menu("_Edit");

        //Edit Menu items
        editMenu.getItems().add(new MenuItem("Undo..."));
        editMenu.getItems().add(new MenuItem("Redo..."));
        editMenu.getItems().add(new SeparatorMenuItem());
        editMenu.getItems().add(new MenuItem("Cut"));
        editMenu.getItems().add(new MenuItem("Copy"));
        editMenu.getItems().add(new MenuItem("Paste"));
        editMenu.getItems().add(new SeparatorMenuItem());
        editMenu.getItems().add(new MenuItem("Find"));

        //Help Menu
        Menu helpMenu = new Menu("_Help");
        MenuItem aboutItem = new MenuItem("About");
        aboutItem.setOnAction( e -> AlertBox.display("About...","A product by charMANder, all rights reserved."));

        //Help Menu Items
        CheckMenuItem showLines = new CheckMenuItem("Show line numbers");
        showLines.setOnAction(e -> {
            if(showLines.isSelected())
                System.out.println("Program Will now display line numbers.");
            else
                System.out.println("Hiding line numbers now.");
        });
        CheckMenuItem autoSave = new CheckMenuItem("AutoSave file");
        autoSave.setOnAction(e -> {
            if(autoSave.isSelected())
                System.out.println("Auto Save feature enabled.");
            else
                System.out.println("Auto Save feature disabled.");
        });
        helpMenu.getItems().addAll(showLines,autoSave,aboutItem);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,editMenu,helpMenu);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);

        Scene scene = new Scene(borderPane, 400, 300);
        window.setScene(scene);
        window.show();
    }
}
