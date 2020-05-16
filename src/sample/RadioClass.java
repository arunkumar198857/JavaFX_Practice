package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RadioClass {
    public static void display(){
        Stage window = new Stage();
        window.setTitle("RadioMenu");
        window.setMinWidth(300);
        window.setMinHeight(300);


        //RadioMenu items
        Menu difficultyMenu = new Menu("Difficulty");
        ToggleGroup difficultyToggle = new ToggleGroup();

        RadioMenuItem easy = new RadioMenuItem("Easy");
        easy.setOnAction(e -> System.out.println("Easy Difficulty selected."));
        RadioMenuItem medium = new RadioMenuItem("Medium");
        medium.setOnAction(e -> System.out.println("Medium Difficulty selected."));
        RadioMenuItem hard = new RadioMenuItem("Hard");
        hard.setOnAction(e -> System.out.println("Hard Difficulty selected."));
        RadioMenuItem insane = new RadioMenuItem("Insane");
        insane.setOnAction(e -> System.out.println("Insane Difficulty selected."));
        easy.setToggleGroup(difficultyToggle);
        medium.setToggleGroup(difficultyToggle);
        hard.setToggleGroup(difficultyToggle);
        insane.setToggleGroup(difficultyToggle);

        //Theme items
        Menu themeMenu = new Menu("Theme");
        ToggleGroup themeToggle = new ToggleGroup();

        RadioMenuItem lightTheme = new RadioMenuItem("Light");
        RadioMenuItem darkTheme = new RadioMenuItem("Dark");
        lightTheme.setToggleGroup(themeToggle);
        darkTheme.setToggleGroup(themeToggle);

        difficultyMenu.getItems().addAll(easy, medium, hard, insane);
        themeMenu.getItems().addAll(lightTheme,darkTheme);

        //MenuBar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(difficultyMenu,themeMenu);

        //Layout
        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(20,20,20,20));
        vBox.getChildren().addAll(menuBar);
        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }
}
