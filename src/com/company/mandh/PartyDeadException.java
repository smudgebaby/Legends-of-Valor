package com.company.mandh;

/**
 * Custom exception for when a fight action is attempted while one faction is already dead
 *
 */

public class PartyDeadException extends RuntimeException{
    public PartyDeadException(String errorMessage){
        super(errorMessage);
    }
}
