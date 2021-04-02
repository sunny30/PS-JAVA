package tekion;

import javax.swing.text.html.parser.Entity;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TekionOnLineQuestion {

    private Integer logicalTimeStamp = 0;

    class Entity {
        String entityPerson;
        String sellingType;
        String stockName;
        Integer units;
        Integer pricePerStocks;

        Entity(String entityPerson, String sellingType, String stockName, Integer units, Integer pricePerStocks) {
            this.entityPerson = entityPerson;
            this.sellingType = sellingType;
            this.stockName = stockName;
            this.units = units;
            this.pricePerStocks = pricePerStocks;
        }
    }

    class Buyer {
        Integer value;
        Entity buyer;

        Buyer(Integer value, Entity entity) {
            this.value = value;
            this.buyer = entity;
        }
    }


    Map<String, PriorityQueue<Entity>> sellersMap = new HashMap<String, PriorityQueue<Entity>>();
    Map<String, PriorityQueue<Buyer>> buyersMap = new HashMap<String, PriorityQueue<Buyer>>();


    class SellCriterion implements Comparator<Entity> {

        @Override
        public int compare(Entity o1, Entity o2) {
            return o1.pricePerStocks.compareTo(o2.pricePerStocks);
        }
    }


    class BuyerCriterion implements Comparator<Buyer> {
        @Override
        public int compare(Buyer o1, Buyer o2) {
            return o1.value.compareTo(o2.value);
        }
    }


    public void warmUpSellCache(Entity a) {

        if (sellersMap.containsKey(a.stockName)) {
            sellersMap.get(a.stockName).add(a);
        } else {

            PriorityQueue<Entity> pq = new PriorityQueue<Entity>(2, new SellCriterion());
            pq.add(a);
            sellersMap.put(a.stockName, pq);


        }

        if(buyersMap.containsKey(a.stockName) && !buyersMap.get(a.stockName).isEmpty()){
            Buyer b = buyersMap.get(a.stockName).poll();
            doTrade(b.buyer);
        }
    }

    public void warmupBuyerCache(Integer timeStamp, Entity a) {

        if (buyersMap.containsKey(a.stockName)) {
            buyersMap.get(a.stockName).add(new Buyer(timeStamp, a));
        } else {
            Buyer buyer = new Buyer(timeStamp, a);
            PriorityQueue<Buyer> pq = new PriorityQueue<Buyer>(2, new BuyerCriterion());
            pq.add(buyer);
            buyersMap.put(a.stockName, pq);

        }


    }


    public void doTrade(Entity buyer) {
        if (sellersMap.containsKey(buyer.stockName) && !sellersMap.get(buyer.stockName).isEmpty()) {

            Entity seller = sellersMap.get(buyer.stockName).poll();

            if (buyer.pricePerStocks >= seller.pricePerStocks) {

                if (buyer.units <= seller.units) {
                    Entity remainingSeller = new Entity(seller.entityPerson, seller.entityPerson, seller.stockName, seller.units - buyer.units, seller.pricePerStocks);
                    System.out.println(seller.entityPerson + " " + "sells" + buyer.units + " to " + buyer.entityPerson+" "+seller.pricePerStocks);
                    warmUpSellCache(remainingSeller);
                    return;
                } else {
                    Entity sameBuyer = new Entity(buyer.entityPerson, buyer.entityPerson, buyer.stockName, buyer.units - seller.units, buyer.pricePerStocks);
                    System.out.println(seller.entityPerson + " " + "sells" + buyer.units + " to " + buyer.entityPerson+" "+seller.pricePerStocks);
                    doTrade(sameBuyer);
                }

            }else{
                warmUpSellCache(seller);
                warmupBuyerCache(this.logicalTimeStamp,buyer);
            }


        }else{
            warmupBuyerCache(logicalTimeStamp,buyer);
        }
    }


    public void parseInput(String input) {
        logicalTimeStamp++;
        String[] array = input.split(" ");
        if (array[1].equalsIgnoreCase("sell")) {
            Entity entity = new Entity(array[0], array[1], array[2], Integer.parseInt(array[3]), Integer.parseInt(array[4]));
            warmUpSellCache(entity);
        } else {
            if (array[1].equalsIgnoreCase("Buy")) {
                if (!sellersMap.containsKey(array[2])) {
                    Entity entity = new Entity(array[0], array[1], array[2], Integer.parseInt(array[3]), Integer.parseInt(array[4]));
                    warmupBuyerCache(logicalTimeStamp, entity);
                } else {
                    Entity entity = new Entity(array[0], array[1], array[2], Integer.parseInt(array[3]), Integer.parseInt(array[4]));
                    doTrade(entity);
                }
            }
        }


    }


    public static void main(String[] args) {
        TekionOnLineQuestion onLineQuestion = new TekionOnLineQuestion() ;
        String[] inputArray = {"p1 sell s1 1500 200",
                "p2 buy s2 900 500",
                "p3 buy s1 600 250",
                "p4 buy s1 1200 270",
                "p10 sell s2 1000 400",
                "p5 sell s3 300 800",
                "p6 sell s3 100 750",
                "p7 buy s3 500 900",
                "p20 sell s4 200 100",
                "p21 sell s4 200 150",
                "p22 buy s4 200 300"} ;

        for(int i=0;i<inputArray.length;i++){
            onLineQuestion.parseInput(inputArray[i]);
        }
    }




}
