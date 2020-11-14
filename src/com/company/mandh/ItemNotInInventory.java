package com.company.mandh;

/**
 *Custom excpetion for when looking a item not in a inventory
 */

public class ItemNotInInventory extends RuntimeException{

    public ItemNotInInventory(String errorMessage, Throwable err){
        super(errorMessage,err);
    }
    public ItemNotInInventory(String errorMessage){
        super(errorMessage);
    }
}
