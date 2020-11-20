package tabs;

import javafx.scene.control.Tab;

public class UpdateItemTab extends Tab {

    private static UpdateItemTab tab;
    private UpdateItemTab() {
        this.setText("Update Item");
    }

    public static UpdateItemTab getInstance() {
        if (tab == null) {
            tab = new UpdateItemTab();
        }
        return tab;
    }
}
