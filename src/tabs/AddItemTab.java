package tabs;


import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import pojo.Category;
import table.CategoryTable;

public class AddItemTab extends Tab {

    private static AddItemTab tab;
    private AddItemTab() {
        this.setText("Add Item");
        CategoryTable categoryTable = new CategoryTable();

        GridPane root = new GridPane();

        Text name = new Text("ADD");
        root.add(name,0,0);

        ComboBox<Category> comboBox = new ComboBox<Category>();
        comboBox.setItems(
                FXCollections.observableArrayList(categoryTable.getAllCategories()));

        root.add(comboBox,1,0);

        TextField price = new TextField();
        root.add(price,1,1);

        Button submit = new Button();
        submit.setOnAction(e-> {
            Category category = new Category(comboBox.getSelectionModel().getSelectedItem().getId());

            Double.parseDouble(price.getText());

          //  categoryTable.createTable(category);
        });

        root.add(submit,2,1);
    }

    public static AddItemTab getInstance() {
        if (tab == null) {
            tab = new AddItemTab();
        }
        return tab;
    }
}
