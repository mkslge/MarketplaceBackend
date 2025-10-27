package org.example.marketplacebackend.Utility;

import org.mindrot.jbcrypt.BCrypt;
import java.util.Random;

public final class LoginUtility {
    private static final int PASSWORD_TOKEN_LENGTH = 30;
    private static final int SESSION_ID_LENGTH = 30;
    private static final String TOKEN_CHARACTER_SET = "abcdefghijklmnopqrstuvwxyz1234567890";
    private static final Random  randomSeed = new Random();


    /*Generates a password token for changing a password*/
    public static String generatePasswordToken() {
        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i < PASSWORD_TOKEN_LENGTH;i++) {
            sb.append(LoginUtility.getRandomCharacter());
        }
        return sb.toString();
    }

    public static String generateSessionID() {
        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i < SESSION_ID_LENGTH;i++) {
            sb.append(LoginUtility.getRandomCharacter());
        }
        return sb.toString();
    }

    private static char getRandomCharacter() {

        return TOKEN_CHARACTER_SET.charAt(randomSeed.nextInt(PASSWORD_TOKEN_LENGTH));
    }


    public static String hash(String plainText) {
        return BCrypt.hashpw(plainText, BCrypt.gensalt());
    }


}
