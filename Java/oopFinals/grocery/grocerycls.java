
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class grocerycls{
    private String[] productCode;
    private double[] productPrice;
    private String code;
    private int qty;
    private double price;

    public grocerycls(String fileName) {
        try {

            // read the file
            File myFile = new File(fileName);
            Scanner readFile = new Scanner(myFile);

            int size = 1000; //assuming a maximum of 1000 products
            productCode = new String[size];
            productPrice = new double[size];

            int index = 0;

            // store parts in each line in arrays
            while (readFile.hasNextLine()) {
                String line = readFile.nextLine();
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    productCode[index] = parts[0];
                    productPrice[index] = Double.parseDouble(parts[1]);
                    index++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found.");
            e.printStackTrace();
        }
    }

    // method to set product code and quantity
    public void setCodeQty(String inputCode, int inputQty) {
        code = inputCode;
        qty = inputQty;
    }

    // getters
    public String getCode() {
        return code;
    }

    public int getQty() {
        return qty;
    }

    // set price, check if it exists
    public boolean setPrice() {
        for (int i = 0; i < productCode.length; i++) {
            if (productCode[i] != null && productCode[i].equals(code)) {
                price = productPrice[i];
                return true;
            }
        }
        System.out.println("PRODUCT NOT FOUND.");
        price = 0; 
        return false;
    }

    // getter for price
    public double getPrice() {
        return price;
    }   

    // qty * price of product
    public double subTotal() {
        return getPrice() * getQty();
    }

}