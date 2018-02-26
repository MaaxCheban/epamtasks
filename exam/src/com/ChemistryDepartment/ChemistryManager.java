package com.ChemistryDepartment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAX on 26.02.2018.
 */
public class ChemistryManager {
    List<ChemistryProduct> chemistryProducts;
    ChemistryManager(){
        chemistryProducts = new ArrayList<>();
        chemistryProducts.add(new Gala(800));
        chemistryProducts.add(new Muscul(1000));
        chemistryProducts.add(new MrProper(1200));
    }

    public void addProduct(ChemistryProduct product){
        chemistryProducts.add(product);
    }

    public void removeProduct(int index){
        chemistryProducts.remove(index);
    }

    public ChemistryProduct[] findProducts(String task){
        List<ChemistryProduct> products = new ArrayList<>();
        for(ChemistryProduct product : chemistryProducts){
            if(product.findTask(task)){
                products.add(product);
            }
        }

        ChemistryProduct[] result = sortProductsByWeight(products);

        return result;
    }

    public ChemistryProduct[] sortProductsByWeight(List<ChemistryProduct> products){
        ChemistryProduct [] productsRes = new ChemistryProduct[products.size()];
        for(int i = 0; i < products.size(); i++){
            productsRes[i] = products.get(i);
        }

        for(int i = 0; i < productsRes.length; i++){

            for(int j = i + 1; j < productsRes.length; j++){

                if(productsRes[i].getWeight() <= productsRes[j].getWeight()){
                    ChemistryProduct tmp = productsRes[i];
                    productsRes[i] = productsRes[j];
                    productsRes[j] = tmp;
                }
            }

        }

        return productsRes;
    }
}
