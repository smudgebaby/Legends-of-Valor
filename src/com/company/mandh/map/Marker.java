package com.company.mandh.map;

import com.company.mandh.Namable;

public class Marker implements Cloneable, Namable {
    private String name;
    private char display;

    public Marker(String name, char display){
        this.name = name;
        this.display = display;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.valueOf(display);
    }

    //Members
        //Name
        //Marker type
        //Display

    //Methods
        //constructor only
        //

}
