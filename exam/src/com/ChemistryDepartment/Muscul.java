package com.ChemistryDepartment;

/**
 * Created by MAX on 26.02.2018.
 */
public class Muscul extends ChemistryProduct implements GardenChemistry {
    public Muscul(double _weight){
        super(_weight);
        tasks.replace("garden", true);
        tasks.replace("livingRoom", true);
    }

    @Override
    public String toString(){
        return new String("Muscul");
    }
}
