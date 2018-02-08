package com;

/**
 * Created by MAX on 22.01.2018.
 */
public class GoldFeather extends  ProductDecorator{
    GoldFeather(Product decoratedProduct){
        super(decoratedProduct);
    }

    @Override
    public void productDescribtion(){
        _decoratedProduct.productDescribtion();
        addFoldFeather();
    }

    public void addFoldFeather(){
        System.out.println("Add gold feather");
        _decoratedProduct.setPrice(_decoratedProduct.getPrice() + 10000.0);
    }
}
