package tabs;

import javafx.scene.control.Tab;

public class AddItemTab extends Tab {

    private static AddItemTab tab;
    private AddItemTab() {
        this.setText("Add Item");
    }

    public static AddItemTab getInstance() {
        if (tab == null) {
            tab = new AddItemTab();
        }
        return tab;
    }
}
