import java.util.Scanner;

public class grocerymain {
    public static void main(String[] args) {
        grocerycls grocery = new grocerycls("pricelist.txt");
        Scanner input = new Scanner(System.in);
        String codeInput;
        int qtyInput;   
        double total = 0;

        // instruction to user
        System.out.println("Enter 0 0 to quit and compute total.");
        System.out.println("------------------------------------");

        // loop to input product code and quantity
        do {
            System.out.print("Enter Product Code and Quantity: ");
            codeInput = input.next();

            if (!codeInput.equals("0")) {
                qtyInput = input.nextInt();
                grocery.setCodeQty(codeInput, qtyInput);

                // if price is set successfully, calculate subtotal and update total
                if (grocery.setPrice()){
                    double subtotal = grocery.subTotal();
                    System.out.print(qtyInput + " @ Php " + grocery.getPrice() + " = ");
                    System.out.println("Php " + subtotal);
                    total += subtotal;
                }
            }
        } while (!codeInput.equals("0")); // loop until user types 0 0

        System.out.println("TOTAL PRICE: Php " + total); // show total grocery 
        System.out.println();
        System.out.println("------------------------------------");
    }
}