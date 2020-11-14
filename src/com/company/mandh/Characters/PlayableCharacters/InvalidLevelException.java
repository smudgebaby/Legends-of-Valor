package com.company.mandh.Characters.PlayableCharacters;

/**
 * The purpose of this exception is to be thrown when a users attempts to use an item
 * for which they are not the proper level
 */

public class InvalidLevelException extends RuntimeException {
    public InvalidLevelException(String message) {
        super(message);
    }
}
