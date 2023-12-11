import java.util.Scanner;

public class seatplanmakerv2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        layout l = new layout();
        
        // keep asking for layout until valid input
        while (!setupLayout(l)) {}

        // display the layout
        l.displayLayout(); 

        seat[] s = new seat[l.getRowNum() * (l.getLeftCol() + l.getRightCol())];

        for (int i = 0; i < s.length; i++) {
            s[i] = new seat();
            s[i].setStatus(false);
        }

        while (true) {
            System.out.print("Enter seat number to reserve (enter 0 to exit): ");
            int wantSeat = input.nextInt();

            if (wantSeat == 0) {
                break;
            }

            if (wantSeat > 0 && wantSeat <= s.length) {
                if (!s[wantSeat - 1].getStatus()) {
                    s[wantSeat - 1].setStatus(true);
                    //System.out.println("Seat " + wantSeat + " reserved!");
                    l.displayLayout(s);
                } else {
                    System.out.println("SEAT TAKEN!"); System.out.println();
                }
            } else {
                System.out.println("Invalid Seat Number!"); System.out.println();
            }
        }

        input.close();
    }

    public static boolean setupLayout(layout l) {
        Scanner input = new Scanner(System.in);

        // get input for row, left column, and right column
        System.out.print("Enter row#, left column#, right column#, separated by space: ");
        int row = input.nextInt();
        int leftC = input.nextInt();
        int rightC = input.nextInt();

        int sumCol = leftC + rightC;

        // total number of seats must not exceed 99
        if (row * sumCol > 99) {
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

    public int getRowNum() {
        return rowNum;
    }

    //getters
    public int getRightCol() {
        return rightCol;
    }

    public int getLeftCol() {
        return leftCol;
    }

    //display initial layout
    public void displayLayout() {
        int number = 1;
        for (int i = 0; i < rowNum; i++) {
            // for left column
            for (int j = 0; j < leftCol; j++) {
                System.out.print("[" + formatNumber(number) + "] ");
                number++;
            }

            // put space in between to separate the 2 columns
            System.out.print("   ");

            // for right column
            for (int k = 0; k < rightCol; k++) {
                System.out.print("[" + formatNumber(number) + "] ");
                number++;
            }
            System.out.println();
        }
        System.out.println();
    }

    //display layout for reservation
    public void displayLayout(seat[] seats) {
        int number = 1;
        int seatIndex = 0;

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < leftCol; j++) {
                System.out.print("[" + (seats[seatIndex++].getStatus() ? "XX" : formatNumber(number)) + "] ");
                number++;
            }
            System.out.print("   ");

            for (int k = 0; k < rightCol; k++) {
                System.out.print("[" + (seats[seatIndex++].getStatus() ? "XX" : formatNumber(number)) + "] ");
                number++;
            }
            System.out.println();
        }
        System.out.println();
    }

    // to avoid repetitive if else
    public String formatNumber(int number) {
        return (number < 10) ? "0" + number : String.valueOf(number);
    }
}

// for seat reservation
class seat {
    private boolean status;

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }
}
