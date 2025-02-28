package utility;

import java.util.Base64;

public final class DecodeUtils {

    private DecodeUtils() {}

    public static String getdecodedString(String encodedString){
        return new String(Base64.getDecoder().decode(encodedString.getBytes()));
    }

}
