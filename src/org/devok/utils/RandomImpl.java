package org.devok.utils;

import java.util.Random;

public class RandomImpl {
    private static Random INSTANCE;
    private RandomImpl(){}
    public static Random getRandom(){
        if (INSTANCE == null) INSTANCE = new Random();
        return INSTANCE;
    }
}
