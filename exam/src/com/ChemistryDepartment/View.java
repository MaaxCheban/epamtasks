package com.ChemistryDepartment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by MAX on 26.02.2018.
 */
public class View {
    private Map<String, String> menu;
    private Scanner scanner;
    public View(){
        scanner = new Scanner(System.in);
        menu = new HashMap<>();
        menu.put("1", "kitchen");
        menu.put("2", "garden");
        menu.put("3", "livingRoom");
        menu.put("4", "washingRoomAfterRepair");
        menu.put("Q", "Quit");
    }


    public void printMenu(){
        for(Map.Entry<String, String> entrySet: menu.entrySet()){
            System.out.println(entrySet.getKey() + " " + entrySet.getValue());
        }
    }

    public void findProducts(String task){
        ChemistryManager chemistryManager = new ChemistryManager();

        ChemistryProduct[] result  = chemistryManager.findProducts(task);

        System.out.println("Found products");
        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }

    }

    public void showMenu(){
        printMenu();
        String choice = scanner.nextLine();

        while(!choice.equals("Q")){
            findProducts(menu.get(choice));
            printMenu();
            choice = scanner.nextLine();
        }

    }

}
