import java.util.Scanner;

public class grocerymain {
    public static void main(String[] args) {
        grocerycls grocery = new grocerycls("pricelist.txt");
        Scanner input = new Scanner(System.in);
        String codeInput;
        int qtyInput;
        double total = 0;
        System.out.println("Enter 0 0 to quit and compute total.");

        do {
            System.out.print("Enter Product Code and Quantity: ");
            codeInput = input.next();
            qtyInput = input.nextInt();

            if (!codeInput.equals("0") && qtyInput != 0) {
                grocery.setCodeQty(codeInput, qtyInput);
                grocery.setPrice();
                double subtotal = grocery.subTotal();
                System.out.println("Php " + subtotal);
                total += subtotal;
            } else if (qtyInput == 0) {
                System.out.println("Quantity must be greater than 0. Please enter again.");
            }
        } while (!codeInput.equals("0"));

        System.out.println("Total Price: Php " + total);
    }
}
