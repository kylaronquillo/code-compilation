import java.util.Scanner;

public class seatplanmakerv1 {
    public static void main(String[] args) {
        layout l = new layout();
        
        // keep asking for layout until valid input
        while (!setupLayout(l)) {}

        // display the layout
        l.displayLayout(); 
    }

    public static boolean setupLayout(layout l) {
        Scanner input = new Scanner(System.in);
        
        // get input for row, left column, and right column
        System.out.print("Enter row#, left column#, right column#, separated by space: ");
        int row = input.nextInt();
        int leftC = input.nextInt();
        int rightC = input.nextInt();

        // total number of seats must not exceed 99
        if (row * (leftC + rightC) > 99) {
            System.out.println("Total number of seats should not exceed 99.");
            return false;
        } else {
            // for the setter functions
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

    // settters
    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public void setRightCol(int rightCol) {
        this.rightCol = rightCol;
    }

    public void setLeftCol(int leftCol) {
        this.leftCol = leftCol;
    }

    //getters
    public int getRowNum() {
        return rowNum;
    }

    public int getRightCol() {
        return rightCol;
    }

    public int getLeftCol() {
        return leftCol;
    }

    //display layout
    public void displayLayout() {
        int number = 1;
        for (int i = 0; i < rowNum; i++) {
            // for left column
            for (int j = 0; j < leftCol; j++) {
                if (number < 10){
                    System.out.print("[0" + number + "] ");
                    number++;
                }
                else{
                    System.out.print("[" + number + "] ");
                    number++;
                }
            }   
            
            // put space in between to separate the 2 columns
            System.out.print("   ");

            // for right column
            for (int k = 0; k < rightCol; k++) {
                if (number < 10){
                    System.out.print("[0" + number + "] ");
                    number++;
                }
                else{
                    System.out.print("[" + number + "] ");
                    number++;
                }
            }
            System.out.println();
        }
    }
}
