package com.android.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * This class provides the basic utilities related to the device network connectivity, etc
 * 
 * @author Sanjib
 *
 */
public class UtililiyManager {

	//	Global variables declaration
	boolean connectivityFlag;
	ProgressDialog progressDialog;
	AlertDialog builder;

	/**
	 * This method is used for getting the device network connectivity.This checks if the device has the network up or not
	 * @param activity
	 * @return true if the connectivity is ok or else false
	 */
	public boolean getDeviceConnectivity(Activity activity){

		try {
			ConnectivityManager connectivityManager = (ConnectivityManager)activity. getSystemService(Activity.CONNECTIVITY_SERVICE);

			NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

			if (networkInfo != null && networkInfo.isConnected()) {

				connectivityFlag = true;

			}
			else {

				connectivityFlag = false;

			}
		}
		catch(Exception e) {

			CoreLog.logErrorMessage("CHECK NETWORK CONNECTION ");

		}

		return connectivityFlag;
	}

	/**
	 * This method is used for displaying the dialog in the UI
	 * @param activity
	 * @param title
	 * @param message
	 * @param buttonMessage
	 */
	public void showDialog(Activity activity,String title, String message,String buttonMessage) {

		AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);
		alertDialog.setTitle(title);
		alertDialog.setMessage(message);
		alertDialog.setPositiveButton(buttonMessage, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

				dialog.dismiss();

			}
		});

		alertDialog.setCancelable(false);
		builder = alertDialog.create();

		if (!builder.isShowing()) {

			builder.show();

		}

	}

	/**
	 * This method is used to cancel the dialog from the UI
	 */
	public void cancelDialog() {

		// Close the dialog
		builder.cancel();
		builder.dismiss();

	}

	/**
	 * This method is used for displaying the progress dialog in the UI
	 * @param activity
	 * @param title
	 * @param message
	 * @param flag
	 */
	public void showProgressDialog(Activity activity,String title, String message, boolean flag) {

		// Create a progress dialog
		progressDialog = new ProgressDialog(activity);
		// Set progress dialog title
		progressDialog.setTitle(title);
		// Set progress dialog message
		progressDialog.setMessage(message);
		progressDialog.setIndeterminate(flag);
		// Show progress dialog
		progressDialog.show();

	}

	/**
	 * This method is used to cancel the progress dialog from the UI
	 */
	public void cancelProgressDialog() {

		// Close the progress dialog
		progressDialog.dismiss();

	}

}
