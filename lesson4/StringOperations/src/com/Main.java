package com;

import java.util.Scanner;

class  ExpandedString {
    StringBuilder string;
    private static final int MAXROWLEN = 180;

    ExpandedString(String string) {
        this.string = new StringBuilder();
        this.string.append(string);
    }

    public void shortString() {

        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i - 1) == string.charAt(i)) {
                string.deleteCharAt(i - 1);
                i--;
            }
        }

    }

    public void printRightAlign() {
        int lineLength = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '\n') {
                int offset = MAXROWLEN - lineLength;
                offset = offset >= 0 ? offset : 0;
                for (int b = 0; b < offset; b++) {
                    System.out.print(' ');
                }
                System.out.println(string.substring(i - lineLength, i));

                lineLength = 0;
                continue;
            }
            lineLength++;

        }

    }

    public String BWconvertion(){
        String matrix[] = new String[string.length()];
        for(int i = 0; i < matrix.length; i++){
            matrix[i] = string.append(string.charAt(0)).deleteCharAt(0).toString();
        }
        for (int i = 0; i < matrix.length; i++) {
            String minString = matrix[i];
            int minIndex = i;
            for (int k = i+1; k < matrix.length; k++) {
                for (int j = 0; j < minString.length() || j < matrix[i].length(); j++) {
                    if (matrix[k].charAt(j) < minString.charAt(j)) {
                        minString = matrix[k];
                        minIndex = k;
                        break;
                    }
                    if(matrix[k].charAt(j) > minString.charAt(j)){
                        break;
                    }
                }
            }
            String tmp = matrix[i];
            matrix[i] = minString;
            matrix[minIndex] = tmp;
        }
        string.delete(0, string.length());
        for(int i = 0; i < matrix.length; i++){
            string.append(matrix[i].charAt(matrix[i].length() - 1));
        }
        return string.toString();

    }
    public void printString(){
        System.out.println(string);
    }
}

public class Main {

    public static void main(String[] args) {
        // write your code here

        String string = new String();
        Scanner  scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            string += scanner.nextLine();
            string += "\n";
        }


        ExpandedString estring = new ExpandedString(string);
        estring.shortString();
        estring.printString();
        estring.printRightAlign();
        System.out.println(estring.BWconvertion());

    }
}