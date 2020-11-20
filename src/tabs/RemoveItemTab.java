package tabs;

import javafx.scene.control.Tab;

public class RemoveItemTab extends Tab {
    private static RemoveItemTab tab;
    private RemoveItemTab() {
        this.setText("Remove Item");
    }

    public static RemoveItemTab getInstance() {
        if (tab == null) {
            tab = new RemoveItemTab();
        }
        return tab;
    }
}
