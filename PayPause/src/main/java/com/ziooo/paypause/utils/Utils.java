package com.ziooo.paypause.utils;

/**
 * Created by mbelhadj on 13/09/13.
 */
public class Utils {

    public static String concatString(Object... argz) {
        StringBuilder sb = new StringBuilder("");
        for (Object s : argz) {
            sb.append(s);
        }
        return sb.toString();
    }
}
