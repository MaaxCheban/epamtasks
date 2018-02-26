package com.ChemistryDepartment;

/**
 * Created by MAX on 26.02.2018.
 */
public interface AfterRepairChemistry {
    default void washAfterRepair(){
        System.out.println("Washing room after repair");
    }
}
