package com.ChemistryDepartment;

/**
 * Created by MAX on 26.02.2018.
 */
public class MrProper extends ChemistryProduct implements AfterRepairChemistry, KitchenChemistry {
    public MrProper(double _weight){
        super(_weight);
        tasks.replace("washingRoomAfterRepair", true);
        tasks.replace("kitchen", true);
    }

    @Override
    public String toString(){
        return new String("Mr Proper");
    }
}
