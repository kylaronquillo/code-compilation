import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class grocerymain {
    public static void main(String[] args) {
        grocerycls grocery = new grocerycls("pricelist.txt");
        Scanner input = new Scanner(System.in);
        String codeInput;
        int qtyInput;

        do {
            System.out.println("Enter product code and quantity (or 0 0 to exit): ");
            codeInput = input.next();
            qtyInput = input.nextInt();

            if (!(codeInput.equals("0") && qtyInput == 0)) {
                grocery.setCodeQty(codeInput, qtyInput);
                grocery.setPrice();
                System.out.println("Php " + grocery.subTotal());
            }
        } while (!(codeInput.equals("0") && qtyInput == 0));
    }
}