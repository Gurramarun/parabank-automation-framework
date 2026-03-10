package utils;

import java.util.Random;

public class RandomDataUtil {

    public static String generateUsername() {

        Random random = new Random();

        int number = random.nextInt(100000);

        return "user" + number;
    }
}