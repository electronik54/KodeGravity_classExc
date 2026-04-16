package apr11;

import Utils.Utils;

import java.util.*;

/*
 *  - PREPARE 3 PRESENTATION ON ANY 3 TOPICS, Link:https://docs.google.com/spreadsheets/d/12GwKxQrauBcHv4vAYZLTZ3mpl551_YssxL6qKZBe1wM/edit?gid=0#gid=0
 *  - MAP # ITS A KEY VALUE PAIR. KEY HAS TO BE UNIQUE & VALUES CAN BE DUPLICATE.
 *      - HashMap.
 *          # NO ARG CONSTRUCTOR, CONSTRUCTOR WITH INITIAL CAPACITY OF 16 AND LOAD FACTOR 0.75
 *          # CONSTRUCTOR CAN ACCEPT LOAD CAPACITY
 *          # CONSTRUCTOR CAN ACCEPT LOAD CAPACITY AND LOAD FACTOR
 *          # try <remove>, <putAll>
 *          # STORES VALUES AT RANDOM (not ordered)
 *      - TreeMap > try all the methods
 *          # <null> IS NOT ALLOWED
 *      - LinkedTreeMap > try all the methods
 *          # <null> IS NOT ALLOWED
 *  - Arrays, Collections class > try all methods
 *  - touched concept of LooseCoupling
 */

public class Apr11 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String userInString;

//        List<String> lstName = new ArrayList(Arrays.asList("Alice", "Bob", "John", "Mike", "Mark", "Peter", "Bob", "John", "John", "alice"));
//        System.out.println("ORIGINAL LIST: " + lstName);
//
//        HashSet hasUniqueName = new HashSet(lstName);
//        System.out.println("hasUniqueName: " + hasUniqueName);
//
//        List lstUniqueName = new ArrayList();
//        for (String name : lstName) {
//            if (!lstUniqueName.contains(name)) {
//                lstUniqueName.add(name);
//            }
//        }
//        System.out.println("ArrayList: " + lstUniqueName);

        System.out.println("--MAP--");

        //HOMEWORK: find the frequency of the user specified word in a sentence using hashMap
        System.out.println();
        System.out.print("CONTINUE WITH WORK COUNT HOME-TAKE ASSIGNMENT? (Y)>YES (N)>NO? :");
        userInString = String.valueOf(sc.nextLine().charAt(0)).toLowerCase();
        if (userInString.equals("y")) {
            String sentence = "hello Java , I am learning Java to become Java developer and Proficient in Java? More Java";
            Map<String, Integer> wordCountHam = new HashMap<>();
            System.out.println("SENTENCE IS: " + sentence);

            for (String word : sentence.split(" ")) {
                if (wordCountHam.containsKey(word)) {
                    wordCountHam.put(word, wordCountHam.get(word) + 1);
                } else {
                    wordCountHam.put(word, 1);
                }
            }
            System.out.println("WORD COUNT: " + wordCountHam);
        }

        System.out.println();
        System.out.print("CONTINUE WITH <HashMap> METHODS? (y)>YES (n)>NO ? : ");
        userInString = String.valueOf(sc.nextLine().charAt(0)).toLowerCase();
        if (userInString.equals("y")) {

            double maxValue = Double.MIN_VALUE;
            double total = maxValue;
            double threshHoldPrice = 500.0;

            Map<String, Double> prodPriseMap = new HashMap<>();
            prodPriseMap.put("Charger", 28.99);
            prodPriseMap.put("Case", 22.99);
            prodPriseMap.put("Mobile", 799.0);
            prodPriseMap.put("Screen Cover", 5.99);
            prodPriseMap.put("Laptop", 3499.00);
            prodPriseMap.put("Laptop Warranty", 500.00);
            System.out.println("DEFAULT VALUE <prodPriseMap>:" + prodPriseMap);

            System.out.println();
            Set<Map.Entry<String, Double>> itemsEntry = prodPriseMap.entrySet();
            for (Map.Entry<String, Double> entry : itemsEntry) {
                System.out.println("CHECKING '" + entry.getKey() + "' VALUE ($" + entry.getValue() + ")");
                if (maxValue < entry.getValue()) {
                    maxValue = entry.getValue();
                    System.out.println("NEW MAX VALUE $" + maxValue);
                }
                total += entry.getValue();
            }
            System.out.println("(1.) MOST EXPENSIVE PRODUCT IS OF VALUE: $" + maxValue);

            System.out.println();
            System.out.println("(2.) AVERAGE VALUE: $" + Utils.roundNumber(total / itemsEntry.size(), 2));

            System.out.println();
            Iterator<Map.Entry<String, Double>> itr = prodPriseMap.entrySet().iterator();
            while (itr.hasNext()) {
                Map.Entry<String, Double> entry = itr.next();
                double entryPrice = entry.getValue();
                String entryname = entry.getKey();

                System.out.println("CHECK " + entryname + " PRICE $" + entryPrice);
                if (threshHoldPrice >= entryPrice) {
                    System.out.println("REMOVING " + entryname);
                    itr.remove();
                }
            }
            System.out.println("(3.) REMOVE ITEMS WITH VALUE LESS THAN $500: " + prodPriseMap);
        }

        System.out.println();
        System.out.print("CONTINUE WITH <HashMap> METHODS EXC 2? (y)>YES (n)>NO ?");
        userInString = String.valueOf(sc.nextLine().charAt(0)).toLowerCase();
        if (userInString.equals("y")) {

            System.out.println();
            Map<String, String> userDetailsMap = new HashMap<>();
            userDetailsMap.put("name", "Alice");
            userDetailsMap.put("id", "101");
            userDetailsMap.put("city", "Toronto");
            userDetailsMap.put("country", "Canada");
            userDetailsMap.put("nickname", "Alice");
            userDetailsMap.put(null, "NULL_KEY_VALUE");
            userDetailsMap.put("email", null);
            userDetailsMap.put("role", "Developer");
            System.out.println("DEFAULT VALUES IN <userDetailsMap>: " + userDetailsMap);

            Map<String, String> workDetailsMap = new HashMap<>();
            workDetailsMap.put("Company", "XYZ");
            workDetailsMap.put("WORK ADDRESS", "Whitby");
            workDetailsMap.put("SALARY", "123456");
            System.out.println("DEFAULT VALUES IN <workDetailsMap>: " + workDetailsMap);
            System.out.println();


            System.out.println("SIZE OF <userDetailsMap>: " + userDetailsMap.size());
            System.out.print("ADD <workDetailsMap> TO <userDetailsMap>? (y)>YES (n)>NO : ");
            userInString = String.valueOf(sc.nextLine().charAt(0)).toLowerCase();
            if (userInString.equals("y")) {
                System.out.println("ADDING...");
                userDetailsMap.putAll(workDetailsMap);
                System.out.println("SIZE OF <userDetailsMap>: " + userDetailsMap.size());
            } else System.out.println("SKIPPED ADDING...");
            System.out.println("VALUES IN <userDetailsMap>: " + userDetailsMap);
            System.out.println();

//        Set<Map.Entry<String, String>> entries = userDetailsMap.entrySet();
//        System.out.println(entries);


            System.out.print("GET ALL VALUES AS <Set> IN <userDetailsMap>: (y)>YES (n)>NO : ");
            userInString = String.valueOf(sc.nextLine().charAt(0)).toLowerCase();
            if (userInString.equals("y")) {
                System.out.println("<userDetailsMap.values()>" + userDetailsMap.values());
            } else System.out.println("SKIPPED <keySet>...");
            System.out.println();

            System.out.print("(keySet) GET ALL KEYS AS <Set> IN <userDetailsMap>: (y)>YES (n)>NO : ");
            userInString = String.valueOf(sc.nextLine().charAt(0)).toLowerCase();
            if (userInString.equals("y")) {
                System.out.println(userDetailsMap.keySet());
            } else System.out.println("SKIPPED <keySet>...");
            System.out.println();

            System.out.print("ENTER KEY TO GET FROM <userDetailsMap>:");
            userInString = sc.nextLine();
            System.out.println("userInString(" + userInString + "):" + userDetailsMap.get(userInString));
            System.out.println();

            System.out.println("DEFAULT VALUES IN <userDetailsMap>: " + userDetailsMap);
            System.out.print("ENTER KEY TO DELETE FROM <userDetailsMap>:");
            userInString = sc.nextLine();
            userDetailsMap.remove(userInString);
            System.out.println("VALUES IN <userDetailsMap>: " + userDetailsMap);
            System.out.println();

            System.out.print("ENTER KEY TO REPLACE FROM <userDetailsMap>:");
            userInString = sc.nextLine();
            System.out.print("ENTER VALUE TO REPLACE in <" + userInString + ">:");
            userDetailsMap.replace(userInString, sc.nextLine());
            System.out.println("VALUES IN <userDetailsMap>: " + userDetailsMap);
            System.out.println();

            System.out.print("ENTER KEY TO CHECK IF EXISTS IN <userDetailsMap>:");
            userInString = sc.nextLine();
            System.out.println("EXISTS?: " + userDetailsMap.containsKey(userInString));
            System.out.println();

            System.out.print("ENTER VALUE TO CHECK IF EXISTS IN <userDetailsMap>:");
            userInString = sc.nextLine();
            System.out.println("EXISTS?: " + userDetailsMap.containsValue(userInString));
            System.out.println();

            System.out.print("CLEAR <userDetailsMap>? (y)>YES (n)>NO : ");
            userInString = String.valueOf(sc.nextLine().charAt(0)).toLowerCase();
            if (userInString.equals("y")) {
                System.out.println("CLEARING...");
                userDetailsMap.clear();
            } else System.out.println("SKIPPED ADDING...");
            System.out.println("VALUES IN <userDetailsMap>: " + userDetailsMap);
            System.out.println();
        }

    }
}
