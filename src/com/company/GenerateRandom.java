package com.company;

import java.util.Random;

/**
 * Class use for RNG game elements
 */
public class GenerateRandom {
    public static int getRandomNumberUsingNextInt(int min, int exclusiveMax) {
        Random random = new Random();
        return random.nextInt(exclusiveMax - min) + min;
    }
}
