package tabs;


import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import pojo.Category;
import pojo.Item;
import pojo.ItemName;
import table.CategoryTable;
import table.ItemNameTable;
import table.ItemTable;

public class AddItemTab extends Tab {

    private static AddItemTab tab;
    private AddItemTab() {
        this.setText("Add Item");
        ItemTable itemTable = new ItemTable();
        CategoryTable categoryTable = new CategoryTable();
        ItemNameTable itemNameTable = new ItemNameTable();

        GridPane root = new GridPane();

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

        Button submit = new Button("SUBMIT");
        submit.setOnAction(e-> {
            Item item = new Item(
                    comboBox.getSelectionModel().getSelectedItem().getId(),
                    comboItemName.getSelectionModel().getSelectedItem().getId(),
                    Integer.parseInt(price.getText()));
            itemTable.createItem(item);

          //  categoryTable.createTable(category);
        });

        root.add(submit,2,3);
        this.setContent(root);
    }

    public static AddItemTab getInstance() {
        if (tab == null) {
            tab = new AddItemTab();
        }
        return tab;
    }
}
