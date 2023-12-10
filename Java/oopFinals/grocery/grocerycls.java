
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class c {
    private String[] productCodes;
    private double[] productPrice;
    private String codeUser;
    private int qtyUser;
    private double pricePerCode;

    public grocerycls(String fileName) {
        try {
            File myFile = new File(fileName);
            Scanner readFile = new Scanner(myFile);

            int size = 1000; // Assuming a maximum of 1000 products
            productCodes = new String[size];
            productPrice = new double[size];

            int index = 0;

            while (readFile.hasNextLine()) {
                String line = readFile.nextLine();
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    productCodes[index] = parts[0];
                    productPrice[index] = Double.parseDouble(parts[1]);
                    index++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found.");
            e.printStackTrace();
        }
    }

    public void setCodeQty(String inputCode, int inputQty) {
        codeUser = inputCode;
        qtyUser = inputQty;
    }

    public String getCode() {
        return codeUser;
    }

    public int getQty() {
        return qtyUser;
    }

    public boolean setPrice() {
        for (int i = 0; i < productCodes.length; i++) {
            if (productCodes[i] != null && productCodes[i].equals(codeUser)) {
                pricePerCode = productPrice[i];
                return true;
            }
        }
        System.out.println("PRODUCT NOT FOUND.");
        pricePerCode = 0; // Set the price to 0 if not found
        return false;
    }

    public double getPrice() {
        return pricePerCode;
    }

    public double subTotal() {
        return getPrice() * getQty();
    }
}
Changes m