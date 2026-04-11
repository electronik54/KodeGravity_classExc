package apr07;

import java.util.*;

/*
 * - SET: # data is always unique
 *   - HASHSET: # allows 1 <null> since data has to be unique, data is never ordered and it produces data in random order everytime its requested
 *   - LINKEDHASHSET: # data is linked, allows 1 <null> since data has to be unique, data is ordered as inserted
 *   - TREESET: # null not allowed as null cannot be sorted, data is naturally ordered
 * - ITERATOR (DO LIST ITERATOR)
 * */

public class apr07 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int userIn;
        boolean continueLoop = false;

        System.out.println("--COLLECTION: SET--");
        System.out.println();

        List<String> lstColors = new ArrayList(Arrays.asList("gray", "red", "blue", "green", "yellow", "purple", "orange", "brown"));
        List<Integer> lstInts = new ArrayList(Arrays.asList(9999, 1, -4, 543, 64542, 982));
        System.out.println("DEFAULT LIST:" + lstColors);
        Collections.sort(lstColors);
        System.out.println("SORTED LIST:" + lstColors);

        System.out.println();
        do {
            System.out.println();
            System.out.println("<lstInts> DEFAULT VALUES: " + lstInts);

            System.out.println("TreeSet<Integer> MIN VALUE: " + Collections.min(lstInts));
            System.out.println("TreeSet<Integer> MAX VALUE: " + Collections.max(lstInts));

            System.out.print("select the number you want to remove: ");
            int numberToRemove = sc.nextInt();
            boolean found = false;

            System.out.println("PRESS (1) TO TRY REMOVING WITH <Iterator>");
            System.out.print("PRESS (2) TO TRY REMOVING WITH <for> : ");
            int method = sc.nextInt();

            switch (method) {
                case 1:
                    System.out.println("ATTEMPTING TO REMOVE WITH <Iterator>");
                    Iterator itr = lstInts.iterator();
                    int itrCount = 0;
                    while (itr.hasNext()) {
                        int next = (int) itr.next();
                        if (next == numberToRemove) {
                            found = true;
                            System.out.println("ELEMENT FOUND. REMOVING...");
                            lstInts.remove(itrCount);
                            break;
                        }
                        itrCount++;
                    }
                    break;

                case 2:
                    for (Integer i : lstInts) {
                        if (i == numberToRemove) {
                            found = true;
                            System.out.println("-ELEMENT FOUND. REMOVING...-");
                            try {
                                lstInts.remove(i);
                                break;      //THIS AVOIDS EXCEPTION!!
                            } catch (ConcurrentModificationException e) {
                                System.out.println("CANNOT MODIFY THIS COLLECTION");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    break;
            }
            if (!found) System.out.println("--ELEMENT NOT FOUND--");
            System.out.println("TreeSet<Integer> now has:" + lstInts);
            continueLoop = false;
            if (lstInts.size() > 0) {
                System.out.print("TRY AGAIN TO REMOVE THE NUMBER FROM THE LIST? (1)>YES (ELSE)>NO : ");
                if (sc.nextInt() == 1) continueLoop = true;
            } else System.out.println("EXITING LOOP AS THE <lstInts> IS EMPTY");
            System.out.println("--------------------------------------------------------------------");

        } while (continueLoop);


//        Set<String> lstColors = new HashSet<>(Arrays.asList("gray", "red", "blue", "green", "yellow", "purple", "orange", "brown"));
//        TreeSet<Integer> trsInts = new TreeSet(Arrays.asList(9999, 1, -4, 543, 64542, 982)); // find min, max and remove the user provided element using both for & iterator separately
//
//        TreeSet tstColors = new TreeSet();
//        tstColors.addAll(lstColors);
//        System.out.println("SORTED LIST:" + tstColors);
//        System.out.println();
//
//        System.out.println("TreeSet<Integer> has:" + trsInts);
//        System.out.println("TreeSet<Integer> MIN VALUE: " + trsInts.first());
//        System.out.println("TreeSet<Integer> MAX VALUE: " + trsInts.last());
//        System.out.print("select the number you want to remove:");
//        int numberToRemove = sc.nextInt();
//        boolean found = false;
//
//        System.out.println("PRESS (1) TO TRY REMOVING WITH <Iterator>");
//        System.out.print("PRESS (2) TO TRY REMOVING WITH <for> : ");
//        int method = sc.nextInt();
//
//        switch (method) {
//            case 1:
//                System.out.println("ATTEMPTING TO REMOVE WITH <Iterator>");
//                Iterator itr = trsInts.iterator();
//                while (itr.hasNext()) {
//                    int next = (int) itr.next();
//                    if (next == numberToRemove) {
//                        found = true;
//                        System.out.println("ELEMENT FOUND. REMOVING...");
//                        trsInts.remove(next);
//                        break;
//                    }
//                }
//                break;
//
//            case 2:
//                for (Integer i : trsInts) {
//                    if (i == numberToRemove) {
//                        found = true;
//                        System.out.println("ELEMENT FOUND. REMOVING...");
//                        try {
//                            trsInts.remove(i);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                        break;
//                    }
//                }
//                break;
//        }
//        if (!found) System.out.println("ELEMENT NOT FOUND");
//        System.out.println("TreeSet<Integer> now has:" + trsInts);


        System.out.println();
        System.out.print("CONTINUE WITH HASHSET? (1)>YES (ELSE)>NO:");
        userIn = sc.nextInt();
        while (userIn == 1) {
            Set<Integer> setInt = new HashSet<>();
            setInt.add(100);
            setInt.add(101);
            setInt.add(102);
            setInt.add(103);
            setInt.add(104);

            Set<Integer> setInt2 = new HashSet<>();
            setInt2.add(103);
            setInt2.add(104);
            setInt2.add(105);
            setInt2.add(106);

            System.out.println("INITIAL VALUES <setInt>:" + setInt);
            System.out.println("INITIAL VALUES <setInt2>:" + setInt2);

            System.out.println("ADDING <1010> to <setInt>");
            setInt.add(1010);
            System.out.println("<setInt>:" + setInt);

            System.out.println("CHECKING IF <setInt> CONTAINS ALL ELEMENTS OF <setInt2>:" + setInt.containsAll(setInt2));

            System.out.println("CHECK IF <setInt> & <setInt2> ARE EQUAL:" + setInt.equals(setInt2));

            userIn = 0;
        }


        System.out.println();
        System.out.print("CONTINUE WITH TREESET? (1)>YES (ELSE)>NO:");
        userIn = sc.nextInt();
        while (userIn == 1) {

        }


        System.out.println();
        System.out.print("CONTINUE WITH LINKEDHASHSET? (1)>YES (ELSE)>NO:");
        userIn = sc.nextInt();
        while (userIn == 1) {

        }


    }
}
