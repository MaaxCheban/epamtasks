
class Cmatrix{
    private Integer matrix[][];
    private int summAbove = 0, summBelove = 0;
    Cmatrix(){
        matrix = new Integer[4][4];
    }
    public void createMatrix(){
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                matrix[i][j] = new Integer ((int)(Math.random() * 10) + 1);
                summAbove += matrix[i][j];
            }
        }
        for (int i = 3; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                matrix[i][j] = new Integer((int) (Math.random() * 10) + 1);
                summBelove += matrix[i][j];
            }
        }

        for(int i = 0, j = 0; i < 4; i++, j++){
            matrix[i][j] = 0;
        }
    }

    public int summAboveDiagonal(){
        return summAbove;
    }
    public int summBelowDiagonal(){
        return summBelove;
    }

    public void printMatrix(){
        for(int i = 0; i < 4; i++){
            for(int b = 0; b < 4; b++){
                System.out.print(matrix[i][b] + " ");
            }
            System.out.println();
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Cmatrix m = new Cmatrix();
        m.createMatrix();
        System.out.println("Summ above diagonal = " + m.summAboveDiagonal());
        System.out.println("Summ below diagonal = " + m.summBelowDiagonal());
        m.printMatrix();
    }
}
