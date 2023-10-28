package com.kundan.jp;
import java.util.ArrayList;
import java.util.List;


public class MapReduceTest {

    static final ThreadLocal<String> holder = new InheritableThreadLocal<>();
    
    public static void main(String[] args) throws InterruptedException {
        
        List<String> offerIds = new ArrayList<>(4);
        offerIds.add("20014293");
        offerIds.add("20014294");
        offerIds.add("20014295");
        
        String str = offerIds.stream().map(each -> each.substring(0)).reduce(",",String::concat);
        System.out.println(str);
        /*
        String entitlementIsPaycycleFeatureSet = "abc";
        String logEntitlementIsPaycycleFeatureSet = entitlementIsPaycycleFeatureSet;
        entitlementIsPaycycleFeatureSet = "def";
        
        System.out.println("entitlementIsPaycycleFeatureSet="+entitlementIsPaycycleFeatureSet+" logEntitlementIsPaycycleFeatureSet="+logEntitlementIsPaycycleFeatureSet);
        
        //ZonedDateTimeExample ex = new ZonedDateTimeExample();
        Test t = new Test();
        System.out.println("getClass().getName()="+t.getClass().getName());
        System.out.println("getClass().getCanonicalName()="+t.getClass().getCanonicalName());
        System.out.println("getClass().getSimpleName()="+t.getClass().getSimpleName());
        return;
        
        Set<String> mySet = new HashSet<>();
        mySet.add("A");
        mySet.add("B");
        mySet.add("C");
        mySet.add("D");
        String[] arr = mySet.toArray(new String[0]);
        System.out.println(arr[0]+ arr[1]+arr[2]+arr[3]);
        
        
         * tableTest();
        tableTestSet();
        System.out.println(Boolean.valueOf(null));
        Map<String, String> map = new HashMap<>();
        map.put(null, "Kundan");
        System.out.println(map.get(null));
        
        
        holder.set("Original-Main-Thread");
        System.out.println("In Main Thread: "+holder.get());
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("In Child Thread before setting: "+holder.get());
                holder.set("Child-Thread");
                System.out.println("In Child Thread after setting: "+holder.get());
            }
        };        
        t.start();
        //System.out.println("Back-To-Main-Thread: "+holder.get());
        t.join();
        System.out.println("Back-To-Main-Thread-waited for child thread to complete. Now exiting: "+holder.get());
        */
    }
    /*
    private static String m1() {
        List<String> names = Arrays.asList("QBOA","QBO","QBOP");
        Collections.sort(names);
        //System.out.println(names);
        JSONObject responseJson = new JSONObject();
        responseJson.put("offer-cache-status" , "OK");
        String buildTime = null;
        responseJson.put("buildtime" , buildTime  == null ? "" : buildTime);
        System.out.println(responseJson.toString());
        return responseJson.toString();
        
    }
    
    private static void tableTest() {
        Table<String, String, int[]> table = HashBasedTable.create();
        int[] us_base_offerids = {1,6,3,4};
        table.put("US", "BASE", us_base_offerids);
        
        int[] us_addon_offerids = {2,5};
        table.put("US", "ADDON", us_addon_offerids);
        
        int[] gb_base_offerids = {7,9,10,12};
        table.put("GB", "BASE", gb_base_offerids);
        
        int[] gb_addon_offerids = {8,11};
        table.put("GB", "ADDON", gb_addon_offerids);
        
        int[] au_base_offerids = {13,15,16,18};
        table.put("AU", "BASE", au_base_offerids);
        
        int[] au_addon_offerids = {14,17};
        table.put("AU", "ADDON", au_addon_offerids);
        
        System.out.println(table.row("GB").values());
        
        System.out.println(table.column("BASE").values());
        
        System.out.println(table.row("GB").get("ADDON"));
    }
    
    static final Table<String, String, Set<String>> tableSet = HashBasedTable.create();
    
    static class Offer {
        String region, level, offerId;

        public Offer(String region, String level, String offerId) {
            super();
            this.region = region;
            this.level = level;
            this.offerId = offerId;
        }

        public String getRegion() {
            return region;
        }

        public String getLevel() {
            return level;
        }

        public String getOfferId() {
            return offerId;
        }
        
    }
    
    private static List<Offer> populateOffers() {
        List<Offer> offers = new ArrayList<Offer>();
        offers.add(new Offer("US", "BASE", "1"));
        offers.add(new Offer("US", "ADDON", "2"));
        offers.add(new Offer("US", "BASE", "3"));
        offers.add(new Offer("US", "BASE", "4"));
        offers.add(new Offer("US", "ADDON", "5"));
        offers.add(new Offer("US", "BASE", "6"));
        offers.add(new Offer("GB", "BASE", "7"));
        offers.add(new Offer("GB", "BASE", "8"));
        offers.add(new Offer("GB", "ADDON", "9"));
        offers.add(new Offer("GB", "BASE", "10"));
        offers.add(new Offer("GB", "ADDON", "11"));
        offers.add(new Offer("GB", "BASE", "12"));
        offers.add(new Offer("AU", "BASE", "13"));
        offers.add(new Offer("AU", "ADDON", "14"));
        offers.add(new Offer("AU", "BASE", "15"));
        offers.add(new Offer("AU", "BASE", "16"));
        offers.add(new Offer("AU", "ADDON", "17"));
        offers.add(new Offer("AU", "BASE", "18"));
        return offers;
    }
    
    private static void tableTestSet() {
        
        List<Offer> offers = populateOffers();
        
        for(Offer offer:offers) {
            Map<String, Set<String>> rowByRegion = tableSet.row(offer.getRegion());
            if (rowByRegion.get(offer.getLevel()) == null) {
                tableSet.put(offer.getRegion(), offer.getLevel(), new HashSet<String>());
            } 
            tableSet.row(offer.getRegion()).get(offer.getLevel()).add(offer.getOfferId());
        };
        
        
        System.out.println(tableSet.row("GB").values());
        
        System.out.println(tableSet.column("BASE").values());
        
        System.out.println(tableSet.row("GB").get("ADDON"));
    }*/
}
