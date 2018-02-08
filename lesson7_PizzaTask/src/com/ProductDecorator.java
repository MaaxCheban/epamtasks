package com;

/**
 * Created by MAX on 22.01.2018.
 */
abstract public class ProductDecorator extends Product {
    protected Product _decoratedProduct;

    public ProductDecorator(Product decoratedProduct){
        _decoratedProduct = decoratedProduct;
    }

    public void productDescribtion(){
        _decoratedProduct.productDescribtion();
    }
}