package lab4.DAO;

import java.util.HashMap;

public class Shop {
    private String name;
    private int id;
    private HashMap<String, Goods> storage;

    public Shop(int id, String name) {
        this.name = name;
        this.id = id;
        this.storage = new HashMap<>();
    }

    public void insertGoods(Goods goods) {
        if (storage.get(goods.getName()) == null)
            storage.put(goods.getName(), goods);
        else {
            int currentQuantity = storage.get(goods.getName()).getQuantity();
            storage.put(goods.getName(), new Goods(goods.getName(), id, goods.getQuantity() + currentQuantity, goods.getPrice()));
        }
    }

    public int getId() {
        return id;
    }

    public float getGoodsPrice (String name) {
        Goods goods = storage.get(name);
        if (goods != null)
            return goods.getPrice();
        return -1;
    }

    public String getName() {
        return name;
    }

    public String getGoodsByBudget(float cash) {
        String list = "";
        for (Goods goods : storage.values()) {
            int quantity = Math.round(cash / goods.getPrice());
            list += quantity + "," + goods.getName() + "|";
        }
        return list;
    }

    public float getShipment(HashMap<String, Integer> shipment) {
        float summ = 0;
        boolean flag = false;
        for (String goodsName : shipment.keySet())
            if (storage.get(goodsName) != null)
                if (storage.get(goodsName).getQuantity() >= shipment.get(goodsName))
                    summ += storage.get(goodsName).getPrice() * shipment.get(goodsName);
                else {
                    flag = true;
                    break;
                }
            else {
                flag = true;
                break;
            }
        if (flag)
            return -1;
        return summ;
    }
}
