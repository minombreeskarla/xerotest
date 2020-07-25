package utilities;
import java.security.SecureRandom;

public class Utilities {

    public static String createRandomString(int lengthOfString) {
        String randomStringComponents = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(lengthOfString);
        for (int i = 0; i < lengthOfString; i++)
            sb.append(randomStringComponents.charAt(rnd.nextInt(randomStringComponents.length())));
        return sb.toString();
    }

    public static String createRandomNumber(int lengthOfString) {
        String randomNumberComponents = "0123456789";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(lengthOfString);
        for (int i = 0; i < lengthOfString; i++)
            sb.append(randomNumberComponents.charAt(rnd.nextInt(randomNumberComponents.length())));
        return sb.toString();
    }
}
