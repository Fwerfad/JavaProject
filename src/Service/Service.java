package lab4.Service;

import lab4.DAO.*;

import java.io.IOException;
import java.util.HashMap;

public class Service {
    private Dao dao;

    public Service(boolean mode) throws IOException {
        dao = new Dao(mode);
    }

    public void createShop(int id, String name) {
        dao.createShop(new Shop(id, name));
    }

    public void createGoods(String name, int shopId, int quantity, float price) {
        dao.createGoods(new Goods(name, shopId, quantity, price));
    }

    public String getCheapest(String name) {
        return dao.getCheapest(name);
    }

    public String getGoodsByBudget(int shopId, float cash) {
      return dao.getGoodsByBudget(shopId, cash);
    }

    public float getShipment(int shopId, HashMap<String,Integer> shipment) {
        return dao.getShipment(shopId, shipment);
    }

    public int getAverageCheapest(HashMap<String,Integer> shipment) {
      return dao.getAverageCheapest(shipment);
    }
}
