package lesson1;
import java.util.Scanner;

class Operations{
    static void getNumbers(int arr[]){
        System.out.println("Print 5 numbers");
        Scanner scanInt = new Scanner(System.in);
        for(int i = 0; i < 5; i++){
            int tmp = scanInt.nextInt();
            if(tmp < 10000){
                System.out.println("Number should have 5+ digits");
                i--;
                continue;
            }

            arr[i] = tmp;
        }
    }
    static void sort(int arr[]){
        for(int i = 0; i < arr.length; i++){
            for(int b = i; b < arr.length; b++){
                if(arr[i] > arr[b]){
                    int tmp;
                    tmp = arr[i];
                    arr[i] = arr[b];
                    arr[b] = tmp;
                }
            }
        }
        System.out.println("Sorted: ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void withSortedDigits(int arr[]){
        System.out.println("Numbers with sorted digits: ");
        for(int i = 0; i < arr.length; i++){
            int prevDigit = arr[i] % 10;
            int c = 10;
            boolean is = true;
            while(arr[i] / c >= 1){
                int curDigit = arr[i] / c % 10;
                if(prevDigit < curDigit){
                    is = false;
                    break;
                }
                prevDigit = curDigit;

                c*=10;
            }

            if(is){
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    static boolean isDigitSimple(int num){
        if(num <= 2 && num > 0) {
            return true;
        }
        for (int i = 2; i < Math.sqrt(num); i++) {
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    static void withSimpleDigits(int arr[]){
        boolean is = true;
        System.out.println("Number with simple digits");
        for(int i = 0; i < arr.length; i++){

            int c = 1;

            while(arr[i] / c >= 1){
                int curDigit = arr[i] / c % 10;
                if(!isDigitSimple(curDigit)){
                    is = false;
                }
                c*=10;
            }
            if(is){
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();

    }

    static void printNumsDivadableToPrev(int arr[]){
        System.out.println("Numbers that can be divided by previous number: ");
        for(int i = 1; i < arr.length; i++){
            if(arr[i] % arr[i - 1] == 0){
                System.out.print(arr[i] + " ");
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
        int arr[] = new int[5];

        Operations.getNumbers(arr);

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        Operations.sort(arr);
        Operations.withSortedDigits(arr);
        Operations.withSimpleDigits(arr);
        Operations.printNumsDivadableToPrev(arr);
    }
}
