package com.company.mandh;


import com.company.*;
import com.company.mandh.map.*;

import java.util.Scanner;
/**
 * CORE GAME LOOP FUNCTION
 */
public class GameLoop {

    public static void gameLoop(){
        PlayerPartyStarterFactory chracterfactory = new PlayerPartyStarterFactory();
        DataFileMarketFactory marketFactory = new DataFileMarketFactory();

        System.out.println("Welcome to Legends: Monsters and Heros!");
        System.out.println("Follow the instructions to play the game!");

        MAHParty party =  chracterfactory.createParty();
        Marketplace marketplace = marketFactory.createMarket();
        boolean playing = true;

        while(playing){
            int action = PInput.getIntegerBounded(new Scanner(System.in),0,2,"What would you like to do next?\n 0 to fight, 1 to go to market, 2 quit");
            switch(action) {
                case 0:
                    Fight fight = new Fight(party);
                    fight.handleFight();
                    break;
                case 1:
                    marketplace.doPartyMarketVisit(party);
                    break;
                case 2:
                    playing = false;
                    break;
                default:
                    throw new RuntimeException("Should never get here");
            }
        }
    }
    public static void gameLoop2() {
        GameBoard gameBoard1 = new MandHMapFactory().createGameBoard();
        MAHParty party = new PlayerPartyStarterFactory().createParty();

        System.out.println("Current Map");
        System.out.println(gameBoard1.toString());
        boolean playing = true;
        while (playing) {
            System.out.println("Press enter to continue");
            String userComamnd = PInput.getString(new Scanner(System.in), "Enter action: WASD to move around, i to display party info, m to display updated map, q to quit");
            switch (userComamnd) {
                case "w":
                    System.out.println("PartyMoves up");
                    gameBoard1.movePlayer(new MoveUpCommand(), party);
                    break;
                case "s":
                    System.out.println("PartyMoves down");
                    gameBoard1.movePlayer(new MoveDownCommand(), party);
                    break;
                case "d":
                    System.out.println("PartyMoves right");
                    gameBoard1.movePlayer(new MoveRightCommand(), party);
                    break;
                case "a":
                    System.out.println("PartyMoves left");
                    gameBoard1.movePlayer(new MoveLeftCommand(), party);
                    break;
                case "i":
                    System.out.println("Character Info");
                    party.displayInfo();
                    break;
                case "m":
                    System.out.println("Map: ");
                    System.out.println(gameBoard1.toString());
                    break;
                case "q":
                    playing = false;
                    break;

            }
        }
    }
}
