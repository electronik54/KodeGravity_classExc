package apr07;

import java.util.*;

/*
* SET
*       # data is always unique
* - HASHSET
*       # allows 1 <null> since data has to be unique, data is never ordered and it produces data in random order everytime its requested
* - LINKEDHASHSET
*       # data is linked, allows 1 <null> since data has to be unique, data is naturally ordered
* - TREESET
*       # null not allowed as null cannot be sorted, data is naturally ordered
* ITERATOR (DO LIST ITERATOR)
* */

public class apr07 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int userIn;

        System.out.println("--COLLECTION: SET--");

        Set<String> lstColors = new HashSet<>();
        lstColors.add("gray");
        lstColors.add("red");
        lstColors.add("blue");
        lstColors.add("green");
        lstColors.add("yellow");
        lstColors.add("black");

        TreeSet tstColors = new TreeSet();
        tstColors.addAll(lstColors);
        System.out.println("SORTED LIST:"+tstColors);

        System.out.println();
        TreeSet<Integer> trsInts = new TreeSet(Arrays.asList(9999,1,-4,543,64542,982));
        System.out.println("TreeSet<Integer> has:" + trsInts);
        System.out.print("select the number you want to remove:");
        userIn = sc.nextInt();

//        Iterator<Integer> itr = trsInts








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

            userIn =0;
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
