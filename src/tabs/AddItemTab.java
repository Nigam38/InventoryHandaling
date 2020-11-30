package tabs;


import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import pojo.Category;
import pojo.DisplayItem;

import pojo.Item;
import pojo.ItemName;
import table.CategoryTable;
import table.ItemNameTable;
import table.ItemTable;

public class AddItemTab extends Tab {

    private static AddItemTab tab;
    public TableView tableView;

    ItemTable itemTable = new ItemTable();
    CategoryTable categoryTable = new CategoryTable();
    ItemNameTable itemNameTable = new ItemNameTable();

    private AddItemTab() {

        this.setText("Add/Remove Item");
        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(addGridPane());
        mainPane.setCenter(tablePane());
        this.setContent(mainPane);
    }


    public GridPane addGridPane() {
        GridPane root = new GridPane();
        root.setVgap(10);

        Text cat = new Text("SELECT CATEGORY : ");
        root.add(cat,0,0);

        ComboBox<Category> comboBox = new ComboBox<Category>();
        comboBox.setItems(
                FXCollections.observableArrayList(categoryTable.getAllCategories()));
        root.add(comboBox,1,0);

        Text name = new Text("ITEM NAME: ");
        root.add(name,0,1);

        ComboBox<ItemName> comboItemName = new ComboBox<ItemName>();
        comboItemName.setItems(
                FXCollections.observableArrayList(itemNameTable.getAllItemName()));
        root.add(comboItemName,1,1);

        Text priceText = new Text("PRICE: ");
        root.add(priceText,0,2);

        TextField price = new TextField();
        root.add(price,1,2);

        Button submit = new Button("INSERT");

        submit.setOnAction(e-> {
            Item item = new Item(
                    comboBox.getSelectionModel().getSelectedItem().getId(),
                    comboItemName.getSelectionModel().getSelectedItem().getId(),
                    Integer.parseInt(price.getText()));
            itemTable.createItem(item);

            Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Data inserted");
            alert.show();

            refreshTable();
        });

        Button removeButton = new Button("DELETE");
        removeButton.setOnAction(e->{
            DisplayItem item = (DisplayItem) tableView.getSelectionModel().getSelectedItem();
            itemTable.deleteItem(item.getId());

            Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Data deleted");
            alert.show();

            refreshTable();


        });

        root.add(submit,0,3);
        root.add(removeButton,1,3);

        return root;
    }

    public BorderPane tablePane() {
        BorderPane deletePane = new BorderPane();
        tableView = new TableView();

        TableColumn<DisplayItem, String> column1 =
                new TableColumn<>("ITEM NAME");
        column1.setCellValueFactory(
                e -> new SimpleStringProperty(e.getValue().getName()));
        tableView.getColumns().add(column1);

        TableColumn<DisplayItem, String> column2 =
                new TableColumn<>("CATEGORY NAME");
        column2.setCellValueFactory(
                e -> new SimpleStringProperty(e.getValue().getCatName()));
        tableView.getColumns().add(column2);

        TableColumn<DisplayItem, String> column3 =
                new TableColumn<>("PRICE ($)");
        column3.setCellValueFactory(
                e -> new SimpleStringProperty(
                        e.getValue().getPrice()));
        tableView.getColumns().add(column3);

        tableView.getItems().addAll(itemTable.getPrettyItems());

        deletePane.setCenter(tableView);

        return deletePane;
    }

    public void refreshTable() {
        ItemTable table = new ItemTable();
        tableView.getItems().clear();
        tableView.getItems().addAll(table.getPrettyItems());
    }

    public static AddItemTab getInstance() {
        if (tab == null) {
            tab = new AddItemTab();
        }
        return tab;
    }
}
