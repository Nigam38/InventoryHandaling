package pojo;

public class Item {
    private int id;
    private int cat_name;
    private int name;
    private int price;

    public Item(int id, int cat_name, int name, int price) {
        this.id = id;
        this.cat_name = cat_name;
        this.name = name;
        this.price = price;
    }

    public Item(int cat_name, int name, int price) {
        this.cat_name = cat_name;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCat_name() {
        return cat_name;
    }

    public void setCat_name(int cat_name) {
        this.cat_name = cat_name;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString(){
        return getName() + " ";
    }
}
