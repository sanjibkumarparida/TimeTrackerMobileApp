package com.android.util;

import android.util.Log;


/**
 * This class contains all the log related information used by the application
 * 
 * @author Sanjib
 *
 */
public class CoreLog {

    /**
     * This methods logs only message of type info and adds a unique tag-name which is used for filtering the log
     * messages.
     * 
     * @param logMessage
     *            - message to be added to log
     * 
     * @return void
     */
    public static void logInfoMessage(String logMessage) {
        Log.i("XMLJSONURL", logMessage);
    }

    /**
     * This methods logs only message of type debug and adds a unique tag-name which is used for filtering the log
     * messages.
     * 
     * @param logMessage
     *            - message to be added to log
     * 
     * @return void
     */
    public static void logDebugMessage(String logMessage) {
        Log.d("XMLJSONURL", logMessage);
    }

    /**
     * This methods logs only message of type error and adds a unique tag-name which is used for filtering the log
     * messages.
     * 
     * @param logMessage
     *            - message to be added to log
     * @param exceptionObject
     *            - sql exception object
     * 
     * @return void
     */
    public static void logErrorMessage(String logMessage, Exception exceptionObject) {
        Log.e("XMLJSONURL", logMessage, exceptionObject);
    }

    /**
     * This methods logs only message of type error
     * 
     * @param logMessage
     */
    public static void logErrorMessage(String logMessage) {
        Log.e("XMLJSONURL", logMessage);
    }

    /**
     * This methods logs only message and error message of type error
     * 
     * @param logMessage
     */
    public static void logErrorMessage(String logMessage, String errorMessage) {
        Log.e("XMLJSONURL", logMessage);
    }

    /**
     * This methods logs only message and round value of type error
     * 
     * @param logMessage
     */
    public static void logErrorMessage(String logMessage, int round) {
        Log.e("XMLJSONURL", logMessage);
    }
}
