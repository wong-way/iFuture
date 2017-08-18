package dto;

import java.util.Random;

/**
 * Created by DELL on 2017-08-18.
 */
public class Token {
    private String tokenStr;

    private static String getATokenStr(){
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        String token;

        for (int i = 0; i < 16; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }

        token = sb.toString();

        return token;
    }

    public Token(String token) {
        this.tokenStr=token;
    }

    public Token() {
        this.tokenStr=this.getATokenStr();
    }

    public String getTokenStr() {
        return tokenStr;
    }

    public void setTokenStr(String tokenStr) {
        this.tokenStr = tokenStr;
    }

}