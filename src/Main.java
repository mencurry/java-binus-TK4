import java.util.Scanner;

public class Main {
    // import Scanner class
    private static final Scanner in = new Scanner(System.in);
    // establish the array with dummy value of 0,1,2,3,4
    private static final int[] arr = {0, 1, 2, 3, 4};
    // establish the variables will be used
    private static int userInput;
    private static int randomMin;
    private static int randomMax;
    private static boolean status = true;

    public static void main(String[] args) {
        // print welcome notice
        System.out.println("Selamat datang di Program Simulasi");
        System.out.println("Menu");
        System.out.println("1. Random Data");
        System.out.println("2. Simulasi Bubble Sort - Ascending");
        System.out.println("3. Simulasi Selection Sort - Ascending");
        System.out.println("4. Simulasi Bubble Sort - Descending");
        System.out.println("5. Simulasi Selection Sort - Descending");
        System.out.println("6. Keluar");
        System.out.print("Masukkan Pilihan Anda: ");
        userInput = in.nextInt();

        // run program while the status is true
        while (status) {
            // ask the user for batas bawah and batas atas, it will correlate with generateNum
            System.out.print("Batas bawah = ");
            randomMin = in.nextInt();
            System.out.print("Batas atas = ");
            randomMax = in.nextInt();
            generateNum(arr, randomMax, randomMin);

            // brancing if to check what kind of number they input, 1 = random numbers, 2 = bubble sort-ascending, etc.
            if (userInput == 1) {
                printArray(arr);
                status = false;
            } else if (userInput == 2 || userInput == 4) {
                bubbleSort(arr, arr.length, userInput);
                printArray(arr);
                status = false;
            } else if (userInput == 3 || userInput == 5) {
                selectionSort(arr, arr.length, userInput);
                printArray(arr);
                status = false;
            } else {
                status = false;
            }
        }
    }

    // generate random numbers from randomMin to randomMax
    public static void generateNum(int[] arr, int randomMax, int randomMin) {
        for (int i = 0; i < 5; i++) {
            int rand = (int) (Math.random() * (randomMax - randomMin)) + randomMin;
            if (rand == arr[i]) {
                int randNew = (int) (Math.random() * (randomMax - randomMin)) + randomMin;
                arr[i] = randNew;
            } else {
                arr[i] = rand;
            }
        }
    }

    // bubble sort, has two types which is ascending and descending depending on userInput
    public static void bubbleSort(int[] arr, int n, int userInput) {
        if (n == 0 || n == 1) {
            return;
        }
        switch (userInput) {
            case 2:
                for (int i = 0; i < n - 1; i++) {
                    if (arr[i] > arr[i + 1]) {
                        printArray(arr);
                        swap(arr, i, i + 1);
                    }
                }
                break;
            case 4:
                for (int i = 0; i < n - 1; i++) {
                    if (arr[i] < arr[i + 1]) {
                        printArray(arr);
                        swap(arr, i, i + 1);
                    }
                }
                break;
        }
    }

    // selection sort, has two types which is ascending and descending depending on userInput
    public static void selectionSort(int[] arr, int n, int userInput) {
        if (n == 0 || n == 1) {
            return;
        }
        switch (userInput) {
            case 3:
                for (int i = 0; i < n - 1; i++) {
                    for (int j = i + 1; j < n; j++) {
                        if (arr[j] < arr[i]) {
                            printArray(arr);
                            swap(arr, i, j);
                        }
                    }
                }
                break;
            case 5:
                for (int i = 0; i < n - 1; i++) {
                    for (int j = i + 1; j < n; j++) {
                        if (arr[j] > arr[i]) {
                            printArray(arr);
                            swap(arr, i, j);
                        }
                    }
                }
                break;
        }
    }

    // swap method to swap the numbers within an array
    public static void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // printArray method to print all values within an array
    public static void printArray(int[] arr) {
        int currentIdx = 0;
        while (currentIdx < arr.length) {
            for (int i = 0; i < 10 && currentIdx < arr.length; i++) {
                System.out.print(arr[currentIdx] + " ");
                currentIdx++;
            }
            System.out.println();
        }
    }
}
