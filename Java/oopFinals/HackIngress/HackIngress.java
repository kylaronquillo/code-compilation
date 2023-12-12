import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HackIngress {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "hackIngress.in";
        Scanner fileScanner = new Scanner(new File(fileName));

        // process each line in the file
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(line);

            // read the number of elements in the array
            int n = lineScanner.nextInt();
            // create an array to store the values
            int[] arr = new int[n];

            // add values in the array from the line
            for (int i = 0; i < n; i++) {
                int num = lineScanner.nextInt();
                arr[i] = num + 1000;
            }

            int count = 1, tries = 1, cycle = arr[0] + 400, prevHack = arr[0];

            // loop the array starting from the second element
            for (int i = 1; i < n; i++) {
                if (arr[i] <= arr[i - 1] || arr[i] >= cycle) {
                    count++;
                    tries = 1;
                    cycle = arr[i] + 400;
                    prevHack = arr[i];
                    //if the time difference between hacks is at least 5
                } else if (arr[i] - prevHack >= 5 && tries < 4 && arr[i] < cycle) {
                    count++;
                    prevHack = arr[i];
                    tries++;
                }
            }
            // peint count per line
            System.out.println(count);
            lineScanner.close();
        }

        fileScanner.close();
    }
}
