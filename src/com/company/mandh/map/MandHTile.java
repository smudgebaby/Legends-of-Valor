package com.company.mandh.map;

import java.util.ArrayList;

public class MandHTile {
    private Marker rootMarker;
    private Marker currentMarker;
    private ArrayList<String> display;
    private final int MARKER_ROW =1;

    private TileAction tileAction;


    public MandHTile(Marker rootMarker, TileAction tileAction){
        this.rootMarker = rootMarker;
        this.currentMarker =rootMarker;
        this.display = new ArrayList<String>();
        display.add("+---+");
        display.add("| " + currentMarker.toString() +" |");
        display.add("+---+");

        this.tileAction = tileAction;
    }

    public MandHTile() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("No default constructor");
    }

    public TileAction getTileAction() {
        return tileAction;
    }

    public Marker getCurrentMarker() {
        return currentMarker;
    }

    public void setCurrentMarker(Marker currentMarker) {
        this.currentMarker = currentMarker;
        updateDisplay();
    }

    public void revertToRootMarker(){
        this.currentMarker = rootMarker;
        updateDisplay();
    }

    private void updateDisplay(){
        display.set(MARKER_ROW,"| " + currentMarker.toString() +" |");
    }



    public ArrayList<String> getDisplay() {
        return display;
    }
}
