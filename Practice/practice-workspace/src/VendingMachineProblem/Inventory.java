package VendingMachineProblem;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private final Map<String,Integer> stockMap = new HashMap<>();
    private final Map<String,Item> itemMap = new HashMap<>() ;

    public void addItem(String code, Item item, int quantity){
        stockMap.put(code,quantity);
        itemMap.put(code,item);
    }

    public void reduceStock(String code){
        stockMap.put(code,stockMap.getOrDefault(code,0) - 1);
        if(stockMap.get(code) < 0){
            stockMap.put(code,0);
        }
    }

    public Item getItem(String code){
        return itemMap.get(code);
    }

    public boolean isAvailable(String code){
        return stockMap.get(code) > 0;
    }

    public Map<String, Integer> getStockMap() {
        return stockMap;
    }

    public Map<String, Item> getItemMap() {
        return itemMap;
    }
}
