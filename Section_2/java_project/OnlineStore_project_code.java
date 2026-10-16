import java.util.*;

class OnlineStore3
{
    static void displayProducts(ArrayList<String> products,
                                ArrayList<Double> prices)
    {
        System.out.println("\n========== AVAILABLE PRODUCTS ==========");

        for (int i = 0; i < products.size(); i++)
        {
            System.out.println((i + 1) + ". " + products.get(i)
                               + " - Rs." + prices.get(i));
        }
    }


    static void addToCart(int productNumber, int quantity,
                          ArrayList<Integer> cart)
    {
        cart.set(productNumber - 1,
                 cart.get(productNumber - 1) + quantity);

        System.out.println("Product added to cart successfully!");
    }


    // UPDATE QUANTITY USING CART ITEM NUMBER
    static void updateQuantity(int cartItemNumber, int quantity,
                               ArrayList<Integer> cart,
                               ArrayList<Integer> cartIndexes)
    {
        int productIndex = cartIndexes.get(cartItemNumber - 1);

        cart.set(productIndex, quantity);

        System.out.println("Cart quantity updated successfully!");
    }


    // REMOVE PRODUCT USING CART ITEM NUMBER
    static void removeProduct(int cartItemNumber,
                              ArrayList<Integer> cart,
                              ArrayList<Integer> cartIndexes)
    {
        int productIndex = cartIndexes.get(cartItemNumber - 1);

        cart.set(productIndex, 0);

        System.out.println("Product removed from cart successfully!");
    }


    static void displayCart(ArrayList<String> products,
                            ArrayList<Double> prices,
                            ArrayList<Integer> cart,
                            ArrayList<Integer> cartIndexes)
    {
        double total = 0;
        boolean empty = true;

        // Clear old cart indexes
        cartIndexes.clear();

        System.out.println("\n========== YOUR CART ==========");

        int cartItemNumber = 1;

        for (int i = 0; i < products.size(); i++)
        {
            if (cart.get(i) > 0)
            {
                double itemTotal = prices.get(i) * cart.get(i);

                System.out.println(cartItemNumber + ". "
                                   + products.get(i) + " x "
                                   + cart.get(i) + " = Rs." + itemTotal);

                total += itemTotal;
                empty = false;

                // Store original product index
                cartIndexes.add(i);

                cartItemNumber++;
            }
        }

        if (empty)
        {
            System.out.println("Your cart is empty.");
        }
        else
        {
            System.out.println("Total Amount: Rs." + total);
        }
    }


    static boolean placeOrder(ArrayList<Integer> cart)
    {
        boolean empty = true;

        for (int i = 0; i < cart.size(); i++)
        {
            if (cart.get(i) > 0)
            {
                empty = false;
                break;
            }
        }

        if (empty)
        {
            System.out.println("\nCannot place order. Your cart is empty.");
            return false;
        }
        else
        {
            System.out.println("\n========== ORDER ==========");
            System.out.println("Order placed successfully!");
            System.out.println("Order Status: Placed");

            return true;
        }
    }


    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> products = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();
        ArrayList<Integer> cart = new ArrayList<>();

        // Stores the original product index of each cart item
        ArrayList<Integer> cartIndexes = new ArrayList<>();


        // PRODUCTS
        products.add("Laptop");
        prices.add(50000.0);
        cart.add(0);

        products.add("Mobile");
        prices.add(20000.0);
        cart.add(0);

        products.add("Headphones");
        prices.add(2000.0);
        cart.add(0);

        products.add("Keyboard");
        prices.add(1500.0);
        cart.add(0);

        products.add("Mouse");
        prices.add(800.0);
        cart.add(0);

        products.add("iPad");
        prices.add(200000.0);
        cart.add(0);


        int choice;

        do
        {
            System.out.println("\n========== ONLINE STORE ==========");
            System.out.println("1. Display Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Update Quantity");
            System.out.println("4. Display Cart");
            System.out.println("5. Remove Product from Cart");
            System.out.println("6. Place Order");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();


            switch (choice)
            {

                // DISPLAY PRODUCTS
                case 1:

                    displayProducts(products, prices);

                    break;


                // ADD MULTIPLE PRODUCTS TO CART
                case 2:

                    displayProducts(products, prices);

                    System.out.print("How many different products do you want to add? ");
                    int numberOfProducts = sc.nextInt();

                    for (int i = 0; i < numberOfProducts; i++)
                    {
                        System.out.print("Enter product number: ");
                        int productNumber = sc.nextInt();

                        System.out.print("Enter quantity: ");
                        int quantity = sc.nextInt();

                        if (productNumber >= 1 &&
                            productNumber <= products.size() &&
                            quantity > 0)
                        {
                            addToCart(productNumber, quantity, cart);
                        }
                        else
                        {
                            System.out.println("Invalid product number or quantity.");
                        }
                    }

                    break;


                // UPDATE QUANTITY USING CART NUMBER
                case 3:

                    displayCart(products, prices, cart, cartIndexes);

                    if (!cartIndexes.isEmpty())
                    {
                        System.out.print("Enter cart item number: ");
                        int updateItem = sc.nextInt();

                        System.out.print("Enter new quantity: ");
                        int newQuantity = sc.nextInt();

                        if (updateItem >= 1 &&
                            updateItem <= cartIndexes.size() &&
                            newQuantity >= 0)
                        {
                            updateQuantity(updateItem, newQuantity,
                                           cart, cartIndexes);
                        }
                        else
                        {
                            System.out.println("Invalid cart item number or quantity.");
                        }
                    }

                    break;


                // DISPLAY CART
                case 4:

                    displayCart(products, prices, cart, cartIndexes);

                    break;


                // REMOVE PRODUCT USING CART NUMBER
                case 5:

                    displayCart(products, prices, cart, cartIndexes);

                    if (!cartIndexes.isEmpty())
                    {
                        System.out.print("Enter cart item number to remove: ");
                        int removeItem = sc.nextInt();

                        if (removeItem >= 1 &&
                            removeItem <= cartIndexes.size())
                        {
                            removeProduct(removeItem, cart, cartIndexes);
                        }
                        else
                        {
                            System.out.println("Invalid cart item number.");
                        }
                    }

                    break;


                // PLACE ORDER
                case 6:

                    placeOrder(cart);

                    break;


                // EXIT
                case 7:

                    System.out.println("Thank you for shopping!");

                    break;


                default:

                    System.out.println("Invalid choice. Please try again.");
            }

        }
        while (choice != 7);


        sc.close();
    }
}