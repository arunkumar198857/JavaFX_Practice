package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableVieww {

    //Initializing fields for custom input
    public static TextField nameInput, quantityInput, priceInput;

    //TableView
    public static TableView<Product> mytable;


    public static void display(){
        Stage window = new Stage();
        window.setTitle("TableView");


        //Name column
        TableColumn<Product,String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Quantity Column
        TableColumn<Product,Double> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //Price Column
        TableColumn<Product,Integer> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        //Name input
        nameInput = new TextField();
        nameInput.setPromptText("Product name");
        nameInput.setMinWidth(100);

        //Price input
        priceInput = new TextField();
        priceInput.setPromptText("Product price");
        priceInput.setMinWidth(100);

        //Quantity input
        quantityInput = new TextField();
        quantityInput.setPromptText("Product quantity");
        quantityInput.setMinWidth(100);

        //Add and delete buttons
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button delButton = new Button("Delete");
        delButton.setOnAction(e -> delButtonClicled());


        //Setting up Table
        mytable = new TableView<>();
        mytable.setItems(getProduct());
        mytable.getColumns().addAll(nameColumn,quantityColumn,priceColumn);

        //Horizontal layout for Add and Delete
        HBox hBox = new HBox(20);
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput,priceInput,quantityInput,addButton,delButton);

        //Layout
        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(mytable, hBox);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    public static ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop",999.0,2));
        products.add(new Product("Mouse",59.0,10));
        products.add(new Product("Headset",99.0,10));
        products.add(new Product("Mousepad",19.0,15));
        products.add(new Product("Redbull",3.99,50));
        products.add(new Product("Miscellaneous",50.0,5));
        return products;
    }

    public static void addButtonClicked(){
        Product product = new Product(nameInput.getText().toString(), Double.parseDouble(priceInput.getText()), Integer.parseInt(quantityInput.getText()));
        mytable.getItems().add(product);
        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();
    }

    public static void delButtonClicled(){
        ObservableList<Product> productSelected, allProducts;
        allProducts = mytable.getItems();
        productSelected = mytable.getSelectionModel().getSelectedItems();

        //Shorthand version
        productSelected.forEach(allProducts::remove);
    }
}
