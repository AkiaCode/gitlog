package org.catry.gitlog;

/**
 * @package log.java
 * @author Catry
 * @version 1.0
 * Git logs
 */

public class log {

    private static String prevHash = new String(); // 0000000000000000000000000000000000000000
    private static String hash = new String(); // 24c0c155733950c71feb7546b63fa85a50dc61ca
    private static String name = new String(); // Akiacode
    private static String email = new String(); // <catry.me@gmail.com>
    private static int time = new Integer(0); // 1613178827
    private static String timeZone = new String(); // +0900
    private static String action = new String(); // clone
    private static String message = new String(); // from https://github.com/AkiaCode/boba.git

    public static void setLog(String setPrevHash, String setHash, String setName, String setEmail, int setTime, String setTimeZone, String setAction, String setMessage) {
        prevHash = setPrevHash;
        hash = setHash;
        name = setName;
        email = setEmail;
        time = setTime;
        timeZone = setTimeZone;
        action = setAction;
        message = setMessage;
    }

    public static String getPrevHash() {
        return prevHash;
    }

    public static String getHash() {
        return hash;
    }

    public static String getName() {
        return name;
    }

    public static String getEmail() {
        return email;
    }

    public static int getTime() {
        return time;
    }

    public static String getTimeZone() {
        return timeZone;
    }

    public static String getAction() {
        return action;
    }

    public static String getMessage() {
        return message;
    }
}
