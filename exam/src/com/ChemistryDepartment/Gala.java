package com.ChemistryDepartment;

/**
 * Created by MAX on 26.02.2018.
 */
public class Gala extends ChemistryProduct implements KitchenChemistry {
    public Gala(double _weight){
        super(_weight);
        tasks.replace("kitchen", true);
    }

    @Override
    public String toString(){
        return new String("Gala");
    }
}