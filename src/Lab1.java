import java.util.ArrayList; //import ArrayList

public class Lab1 {

    public static void main (String[] args) {

        /*if (args.length == 0) {
            //end program
        }

       for (int i = 0; i < args.length; i++) {
            Integer.parseInt(args[i]);
       }*/

        Item [] store = setUpStore();

        ArrayList<Item> cart = createCart(args, store);

        printReceiptInOrder(cart);

        emptyCartReverseOrder(cart);

    }
    public static Item [] setUpStore () {
        Item [] store = new Item [5];
        store [0] = new Item ("Bananas" , 1.5);
        store [1] = new Item ("Apple" , 0.5);
        store [2] = new Item ("Bread" , 2.0);
        store [3] = new Item ("Milk" , 3.0);
        store [4] = new Item ("Eggs" , 2.5);
        return store;
    }

    public static void printReceiptInOrder (ArrayList<Item> cart) {
        double subTotal = 0.0;

        System.out.println("Receipt");
        System.out.println("=====================");
        System.out.println("Item\t\t\tPrice");

        for (int i = 0; i < cart.size(); i++) {
            String name = cart.get(i).getItemName();
            double price = cart.get(i).getItemPrice();
            System.out.println(name + "\t\t\t" + price);
            subTotal = subTotal + price;
        }

        System.out.println("=====================");
        System.out.println("Subtotal: " + subTotal);
        System.out.println("Sales Tax: 5%");
        System.out.printf("Total: %.2f\n", (subTotal * 1.05));
        System.out.println();
    }

    public static void emptyCartReverseOrder (ArrayList<Item>emptyItems) {
        String name;
        System.out.println("Removing all items from the cart in 'Last in First out' order...");
        for (int i = emptyItems.size()-1; i >= 0; i--) {
            name = emptyItems.get(i).getItemName();
            System.out.println("Removing: " + name);
        }
        System.out.println("Cart has been emptied");
    }

    public static ArrayList<Item> createCart (String[] orders, Item [] store) {
        ArrayList<Item> cart = new ArrayList<Item>();
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].equals ("0") || orders[i].equals ("1") || orders[i].equals ("2") || orders[i].equals ("3") || orders[i].equals ("4")) {
                int index = Integer.parseInt(orders[i]);
                cart.add(store[index]);
            }
            else if (orders[i].equals ("5") || orders[i].equals ("6") || orders[i].equals ("7") || orders[i].equals ("8") || orders[i].equals ("9")) {
                System.out.println("The store does not have an item of index " + orders[i] + ".");
            }
            else {
                System.out.println(i + " is not a valid integer.");
            }
        }
        return cart;
    }
}