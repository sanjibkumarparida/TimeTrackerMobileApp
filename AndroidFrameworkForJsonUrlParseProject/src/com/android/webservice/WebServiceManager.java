package com.android.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.util.Base64;

import com.android.util.CoreLog;


/**
 *  This class provides all the web related services for this application
 *  
 * 
 * @author Sanjib
 *
 */
public class WebServiceManager {

	// Data type Variables declaration
	public static String response;

	// Connection Variables declaration
	HttpURLConnection urlConnection;

	/**
	 * This method is used for reading the user details from the server url
	 * @param serverUrl
	 * @param userDetailsUrl
	 * @param userName
	 * @param password
	 * @return
	 */
	public String getUserDetails(String serverUrl, String userDetailsUrl) {

		// set the url value and initialize the url
		URL mUrl = null;

		try {
			mUrl = new URL(serverUrl + userDetailsUrl);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}

		CoreLog.logInfoMessage("mUrl" + mUrl);

		// open the url connection and set the username and password
		try {
			if(mUrl != null) {
				urlConnection = (HttpURLConnection) mUrl.openConnection();

				CoreLog.logInfoMessage("urlConnection" + urlConnection);
			}

		} catch (IOException e1) {

			CoreLog.logErrorMessage("CHECK URL NOT NULL ");

		}

		try {

			// Opens the stream to the server
			BufferedReader bufReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

			CoreLog.logInfoMessage("bufReader" + bufReader);

			if(bufReader != null) {
				String current;
				StringBuilder  stringBuilder = new StringBuilder();
				while((current = bufReader.readLine()) != null) {
					stringBuilder.append(current + "\n");
				}

				response = stringBuilder.toString();

				CoreLog.logInfoMessage("response" + response);

			}

		} catch(Exception e) {

			CoreLog.logErrorMessage("ERROR READING USERDETAILS ");

		}
		return response;

	}

}
