package lab4.DAO;

public class Goods {
    private String name;
    private int quantity;
    private float price;
    private int shopId;

    public Goods(String name, int shopId, int quantity, float price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    public int getShopId() {
        return shopId;
    }
}
