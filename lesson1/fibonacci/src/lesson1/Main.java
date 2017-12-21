package lesson1;


class F{

    static void printFibonacci(int count){
        int p1 = 0, p2 = 1;

        for(int i = 0; i < count; i++){
            int tmp = p2;
            p2 += p1;
            p1 = tmp;
            System.out.print(p1 + " ");
        }
    }

}

public class Main {

    public static void main(String[] args) {

        F.printFibonacci(10);

    }
}
