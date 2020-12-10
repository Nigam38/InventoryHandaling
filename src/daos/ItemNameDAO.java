package daos;

import pojo.ItemName;

import java.util.ArrayList;

public interface ItemNameDAO {
    public ArrayList<ItemName> getAllItemName();
    public ItemName getItemName(int id);
}
