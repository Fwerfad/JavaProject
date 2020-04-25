package lab4.DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Dao {
    private HashMap<Integer, Shop> shops;
    private boolean mode;

    public Dao(boolean mode) throws IOException {
        this.mode = mode;
        if (!mode) {
            shops = new HashMap<>();
            this.insertShops();
            this.insertGoods();
        }
        else {
            System.out.println("To be continued");
        }
    }

    private void insertShops() throws IOException {
        Pattern delimeter = Pattern.compile(",");
        BufferedReader file = new BufferedReader(new FileReader("C:\\Users\\Fwerfad\\IdeaProjects\\OOP_new\\src\\lab4\\files\\Shops.csv"));
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String parsedString = scanner.nextLine();
            String[] parameters = delimeter.split(parsedString);
            Shop shop = new Shop(Integer.parseInt(parameters[0]), parameters[1]);
            shops.put(shop.getId(), shop);
        }
    }

    private void insertGoods() throws IOException {
        Pattern delimiter = Pattern.compile(",");
        BufferedReader file = new BufferedReader(new FileReader("C:\\Users\\Fwerfad\\IdeaProjects\\OOP_new\\src\\lab4\\files\\Goods.csv"));
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String parsedString = scanner.nextLine();
            String[] parameters = delimiter.split(parsedString);
            for (int i = 0; i < parameters.length - 1; i += 3) {
                int id = i + 1;
                int quantity = id + 1;
                int price = quantity + 1;
                shops.get(Integer.parseInt(parameters[id])).insertGoods(new Goods(parameters[0], Integer.parseInt(parameters[id]), Integer.parseInt(parameters[quantity]), Float.parseFloat(parameters[price])));
            }
        }
    }

    public void createShop(Shop shop) {
        if (mode) {

        }
        else {
            shops.put(shop.getId(), shop);
        }
    }

    public void createGoods(Goods goods) {
        if (mode) {

        }
        else {
            shops.get(goods.getShopId()).insertGoods(goods);
        }
    }

    public String getCheapest(String name) {
        String shopName = null;
        float cheapest = Float.MAX_VALUE;
        for ( Shop shop : shops.values()) {
            float current = shop.getGoodsPrice(name);
            if (current != -1)
                if (cheapest > current)  {
                    cheapest = current;
                    shopName = shop.getName();
                }
        }
        return shopName;
    }

    public String getGoodsByBudget(int shopId, float cash) {
        if (shops.get(shopId) != null)
            return shops.get(shopId).getGoodsByBudget(cash);
        return null;
    }

    public float getShipment(int shopId, HashMap<String,Integer> shipment) {
         if (shops.get(shopId) != null)
            return shops.get(shopId).getShipment(shipment);
        return -1;
    }

    public int getAverageCheapest(HashMap<String,Integer> shipment) {
        float minPrice = Float.MAX_VALUE;
        int Id = -1;
        for (Shop shop : shops.values()) {
           float current = shop.getShipment(shipment);
           if (current != -1)
               if (minPrice > current) {
                   minPrice = current;
                   Id = shop.getId();
               }
        }
        return Id;
    }
}