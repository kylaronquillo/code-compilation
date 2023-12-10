/*import java.util.Scanner;

public class HackIngress{
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt() + 1000;
        }

        int count = 1, tries = 1, cycle = arr[0] + 400;
        int prevHack = arr[0];

        for(int i = 1; i < n; i++){
            if (arr[i] <= (arr[i-1]) || arr[i] >= cycle) {
                count++;
                tries = 1;
                cycle = arr[i] + 400;
                prevHack = arr[i];
            }else if (arr[i] - prevHack >= 5 && tries < 4 && arr[i] < cycle){
                count++;
                prevHack = arr[i];
                tries++;
            }
        }
        System.out.println(count);
        input.close();
    }
}
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HackIngress {
    public static void main(String[] args) {
        try {
            Scanner fileScanner = new Scanner(new File("hackIngress.in"));

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                Scanner lineScanner = new Scanner(line);

                int n = lineScanner.nextInt();

                int[] arr = new int[n];

                for (int i = 0; i < n; i++) {
                    arr[i] = lineScanner.nextInt() + 1000;
                }

                int count = 1, tries = 1, cycle = arr[0] + 400, prevHack = arr[0];

                for (int i = 1; i < n; i++) {
                    if (arr[i] <= (arr[i - 1]) || arr[i] >= cycle) {
                        count++;
                        tries = 1;
                        cycle = arr[i] + 400;
                        prevHack = arr[i];
                    } else if (arr[i] - prevHack >= 5 && tries < 4 && arr[i] < cycle) {
                        count++;
                        prevHack = arr[i];
                        tries++;
                    }
                }
                System.out.println(count);

                lineScanner.close();
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
