package com;


import com.sun.javafx.image.impl.IntArgb;

import java.util.ArrayList;
import java.util.Collection;

interface UnaryPredicate<T> {
    public boolean test(T obj);
}

class OddPredicate implements UnaryPredicate<Integer> {
    public boolean test(Integer i) { return i % 2 != 0; }
}
class PolindromPredicate implements UnaryPredicate<String> {
    public boolean test(String s) {
        boolean is = true;
        for(int i = 0, b = s.length() - 1; i < b; i++, b--){
            if(s.charAt(i) != s.charAt(b)){
                return false;
            }
        }
        return true;
    }
}

class Checker <T>{

    public static<T> int check(Collection<T> c, UnaryPredicate<T> p){
        int count = 0;
        for(T el: c){
           if(p.test(el)){
               count++;
           }
        }
        return count;
    }

}

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<String> sList = new ArrayList<String>();
        ArrayList<Integer> iList = new ArrayList<Integer>();
        sList.add("lol");
        sList.add("river");
        sList.add("oko");

        System.out.println(Checker.check(sList, new PolindromPredicate()));

        iList.add(1);
        iList.add(2);
        iList.add(3);
        iList.add(4);
        iList.add(5);
        System.out.println(Checker.check(iList, new OddPredicate()));
    }
}
