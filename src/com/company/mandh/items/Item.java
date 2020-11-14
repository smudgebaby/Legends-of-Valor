package com.company.mandh.items;

import com.company.mandh.Namable;

public abstract class Item implements Namable {
    //Members
        //name
        //cost
        //required level

    protected String name;
    protected int cost;
    protected int requiredLevel;

    public Item(String name, int cost, int requiredLevel) {
        this.name = name;
        this.cost = cost;
        this.requiredLevel = requiredLevel;
    }

    public Item(){
        this.name = null;
        this.cost = 0;
        this.requiredLevel =0;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }
}
