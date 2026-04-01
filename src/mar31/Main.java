package mar31;

/*
 * [1]TRY with resources (maybe:Java9)
 * [2]Interface class > default and static methods
 * [3]List
 * - ArrayList (backed by array)
 * - LinkedList (stores the data in linked format)
 *  -- singly linkedList (stores the address of next data)
 *  -- doubly linkedList (stores the address of next & previous data)
 */

import Utils.Err.Err;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Product> listProducts;
    static Scanner s = new Scanner(System.in);
    static boolean continueLoop = false;
    static int userIn;


    public static void main(String[] args) {


        /*HOMEWORK
         * list of products with name, price, sku
         * implement add, remove, delete, edit
         */
        System.out.println("--HOMEWORK: PRODUCT STORE--");
        System.out.print("(1)>CONTINUE (ELSE)>SKIP:");
        userIn = s.nextInt();
        System.out.println();

        if (userIn == 1) {
            listProducts = new ArrayList<>();
            listProducts.add(new Product("product1", 1231234));
            listProducts.add(new Product("product2", 99.9912));
            listProducts.add(new Product("product3", 0.9911223123));
            listProducts.add(new Product("product4", 0));
//            listProducts.add(new Product("prod1", 10.99));
//            listProducts.add(new Product("prod2", 187.99));
//            listProducts.add(new Product("prod3", 0.99));

            do {
                System.out.println("-CHOOSE YOU OPERATION-");
                System.out.println("PRESS (1) TO LIST ALL PRODUCTS");
                System.out.println("PRESS (2) TO ADD PRODUCT");
                System.out.println("PRESS (3) TO REMOVE PRODUCT");
                System.out.print("PRESS (4) TO EDIT PRODUCT : ");

                userIn = s.nextInt();
                switch (userIn) {
                    case 1: {
                        Product[] arrProducts = listProducts.toArray(new Product[0]);
                        System.out.println("--------------");
                        System.out.println("-ALL PRODUCTS-");
                        if (listProducts.isEmpty()) {
                            System.out.println("-NO PRODUCTS IN STORE-");
                        } else
                            for (Product p : arrProducts) {
                                System.out.println(p);
                            }
                    }
                    break;

                    case 2:
                        do {
                            String name;
                            double price;
                            try {
                                System.out.println("------------------------------");
                                System.out.print("ENTER THE NAME OF THE PRODUCT:");
                                s.nextLine();
                                name = s.nextLine();

                                System.out.print("ENTER THE PRICE THE PRODUCT:$");
                                price = s.nextDouble();

                                listProducts.add(new Product(name, price));

//                                System.out.println(listProducts);

                                continueLoop = true;
                            } catch (InputMismatchException e) {
//                                e.printStackTrace();
                                System.out.println("-INVALID INPUT. ENTER THE DETAILS AGAIN-");
                            } catch (Err e) {
                                System.out.println(e);
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                if (!continueLoop) {
                                    System.out.print("-PRODUCT NOT ADDED. TRY AGAIN?- (1)>YES (ELSE)>SKIP:");
                                    s.nextLine();
                                    try {
                                        userIn = s.nextInt();
                                        if (userIn != 1) {
                                            continueLoop = true;
                                        }
                                    } catch (InputMismatchException e) {
//                                e.printStackTrace();
                                        System.out.println("-INVALID INPUT. SKIPPING PRODUCT ADDITION...-");
                                        s.nextLine();
                                        continueLoop = true;
                                    }
                                }
                            }
                        } while (!continueLoop);
                        break;

                    case 3:
                        System.out.println("------------------------------");
                        if (listProducts.isEmpty()) {
                            System.out.println("-NO PRODUCTS IN STORE-");
                        } else {
//                            for (Product p : arrProducts) {
//                                System.out.println(p);
//                            }
                            System.out.print("ENTER THE SKU-ID OF THE PRODUCT TO REMOVE:");
                            s.nextLine();
                            String skuId = s.nextLine().trim();

                            int index = getIndexOfProductWithSku(skuId);
                            if (index != -1) {
                                listProducts.remove(index);
                                System.out.println("-PRODUCT REMOVED-");
                            } else {
                                System.out.println("-PRODUCT NOT FOUND-");
                            }
                        }
                        break;


                    case 4:
                        System.out.println("----------------------------");
                        if (listProducts.isEmpty()) {
                            System.out.println("-NO PRODUCTS IN STORE-");
                        } else {
                            System.out.print("ENTER THE SKU-ID OF THE PRODUCT TO EDIT:");
                            s.nextLine();
                            String skuId = s.nextLine().trim();

                            int index = getIndexOfProductWithSku(skuId);
                            if (index != -1) {
                                Product product = listProducts.get(index);

                                do {
                                    String name;
                                    double price;
                                    try {
                                        System.out.println("------------------------------");
                                        System.out.print("ENTER THE NEW NAME OF THE PRODUCT:");
                                        name = s.nextLine();
                                        product.setProductName(name);

                                        System.out.print("ENTER THE NEW PRICE THE PRODUCT:$");
                                        price = s.nextDouble();
                                        product.setProductPrice(price);

                                        System.out.println("-NAME UPDATED-" + product);

//                                System.out.println(listProducts);

                                        continueLoop = true;
                                    } catch (InputMismatchException e) {
//                                e.printStackTrace();
                                        System.out.println("-INVALID INPUT. ENTER THE DETAILS AGAIN-");
                                    } catch (Err e) {
                                        System.out.println(e);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        if (!continueLoop) {
                                            System.out.print("-PRODUCT NOT ADDED. TRY AGAIN?- (1)>YES (ELSE)>SKIP:");
                                            s.nextLine();
                                            try {
                                                userIn = s.nextInt();
                                                if (userIn != 1) {
                                                    continueLoop = true;
                                                }
                                            } catch (InputMismatchException e) {
//                                e.printStackTrace();
                                                System.out.println("-INVALID INPUT. SKIPPING PRODUCT ADDITION...-");
                                                s.nextLine();
                                                continueLoop = true;
                                            }
                                        }
                                    }
                                } while (!continueLoop);

                                System.out.println("-PRODUCT UPDATED-");
                            } else {
                                System.out.println("-PRODUCT NOT FOUND-");
                            }
                        }
                        break;

                    default:
                }


                System.out.print("PERFORM MORE OPERATION? (1)>YES (ELSE)>NO : ");
                userIn = s.nextInt();
                System.out.println();
            } while (userIn == 1);
        }

        System.out.print("--COLLECTIONS--");
        System.out.println("(1)>CONTINUE (ELSE)>SKIP: ");
        userIn = s.nextInt();
        System.out.println();

        while (userIn == 1) {
            List<String> listFruit = new ArrayList<>();
            listFruit.add("apples");
            listFruit.add("banana");
            listFruit.add("coconut");

            System.out.print("<listFruit> NOW : ");
            System.out.println(listFruit);

            listFruit.add(0, "lemon");
            System.out.print("listFruit AFTER <listFruit.add(0, \"lemon\");> : ");
            System.out.println(listFruit);
            System.out.println();

//            String[] arrFruit = listFruit.toArray();

            List<Integer> listNumber = new ArrayList<>();
            listNumber.add(1342);
            listNumber.add(1);
            listNumber.add(901283127);

            List<Double> listDouble = new ArrayList<>();
            listDouble.add(0.01);
            listDouble.add(0.0001);
            listDouble.add(1000.0001);

            List listAll = new ArrayList<>();

            listAll.addAll(listFruit);
            listAll.addAll(1, listDouble);
            listAll.addAll(listAll.toArray().length, listDouble);

            System.out.print("COLLECTION<listAll> : ");
            System.out.println(listAll);
            System.out.println();

            System.out.print("ARRAY<arrAll> : ");
            Object[] arrAll = listAll.toArray();
            for (Object o : arrAll) {
                System.out.println(o);
            }

            System.out.print("RETRY? (1)>YES (ELSE)>NO : ");
            userIn = s.nextInt();
        }


        System.out.println("BYE!!!");
    }


    public static int getIndexOfProductWithSku(String skuId) {
        for (int index = 0; index < listProducts.size(); index++) {
            Product product = listProducts.get(index);
            if (product.getProductSku().equals(skuId)) {
                return index;
            }
        }
        return -1;
    }

}
