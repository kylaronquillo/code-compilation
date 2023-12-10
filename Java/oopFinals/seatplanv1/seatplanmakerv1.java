import java.util.Scanner;

public class seatplanmakerv1 {
    public static void main(String[] args) {
        layout l = new layout();
        
        while (!setupLayout(l)) {
            // Continue looping until setupLayout returns true
        }

        l.displayLayout();
    }

    public static boolean setupLayout(layout l) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter row#, left column#, right column#, separated by space: ");
        int row = input.nextInt();
        int leftC = input.nextInt();
        int rightC = input.nextInt();

        int sumCol = leftC + rightC;

        if (row * sumCol > 99) {
            System.out.println("Total number of seats exceeds 99. Please follow the rule.");
            return false;
        } else {
            l.setRowNum(row);
            l.setLeftCol(leftC);
            l.setRightCol(rightC);
            return true;
        }
    }
}

class layout {
    private int rowNum;
    private int rightCol;
    private int leftCol;

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public void setRightCol(int rightCol) {
        this.rightCol = rightCol;
    }

    public void setLeftCol(int leftCol) {
        this.leftCol = leftCol;
    }

    public int getRowNum() {
        return rowNum;
    }

    public int getRightCol() {
        return rightCol;
    }

    public int getLeftCol() {
        return leftCol;
    }

    public void displayLayout() {
        int number = 1;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < leftCol; j++) {
                System.out.print("[" + formatNumber(number) + "] ");
                number++;
            }
            System.out.print("   ");

            for (int k = 0; k < rightCol; k++) {
                System.out.print("[" + formatNumber(number) + "] ");
                number++;
            }
            System.out.println();
        }
    }

    public String formatNumber(int number) {
        return (number < 10) ? "0" + number : String.valueOf(number);
    }
}
