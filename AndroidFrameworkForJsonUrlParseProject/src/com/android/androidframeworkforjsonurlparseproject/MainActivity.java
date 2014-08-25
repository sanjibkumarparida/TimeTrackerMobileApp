package com.android.androidframeworkforjsonurlparseproject;

import com.android.util.CoreLog;
import com.android.util.UtililiyManager;
import com.android.util.Parser;
import com.android.webservice.WebServiceManager;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;


/**
 * This is the test application used to test the web service utility
 * This also tests the JSON parser utility and simply displays the same
 * 
 * @author Sanjib
 *
 */
public class MainActivity extends Activity {
	
	// Widget Variables declaration
	TextView userTextview;
	
	// Data type Variables declaration
	boolean connectivityValue;
	
	MainActivity mContext;
	
	// Utilitiy manager is used to check the network connectivity	
	UtililiyManager utililiyManager = new UtililiyManager();
	WebServiceManager webServiceManager = new WebServiceManager();
	Parser parser = new Parser();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mContext = this;
		
		// getting the widget id
		getWidgetId();
		
		// getting the network connection
		connectivityValue = utililiyManager.getDeviceConnectivity(mContext);
		
		CoreLog.logInfoMessage("NETWORKCONNECTION" + connectivityValue);

		if(connectivityValue == true) {
			
		// Execute DownloadServerData AsyncTask
		new DownloadServerData().execute();
		
		}
		else {

			utililiyManager.showDialog(mContext,"Network Error","Check NetWork Connection","Ok");
			
		}
		
	}
	
    /**
     * This method is used for getting the widget id
     */
	private void getWidgetId() {

		userTextview = (TextView)findViewById(R.id.textView1);

	}
	
	/**
	 * DownloadServerData class is used
	 * For doing the network based background operation
	 * 
	 * @author Sanjib
	 * 
 	 */
	private class DownloadServerData extends AsyncTask<Void, Void, Void> {

		/* (non-Javadoc)
		 * @see android.os.AsyncTask#onPreExecute()
		 */
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			
			utililiyManager.showProgressDialog(mContext, " Server Data Parsing ", "Loading...",false);

		}

		/* (non-Javadoc)
		 * @see android.os.AsyncTask#doInBackground(java.lang.Object[])
		 */
		@Override
		protected Void doInBackground(Void... params) {

			// process url data when network is available
			if(connectivityValue == true) {
				
				parser.getWebServiceManagerUserDetails();
						
			}
			else {
				
				utililiyManager.showDialog(mContext,"Network Error","Check NetWork Connection","Ok");
				
			}
			
			return null;
		}

		/* (non-Javadoc)
		 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
		 */
		@Override
		protected void onPostExecute(Void args) {

			// Close the progressdialog
			utililiyManager.cancelProgressDialog();
            displayJsonData();

		}
	}
	
	/**
	 * This method used to display the output
	 */
	public void displayJsonData() {

		try {
		
		// display data
		userTextview.setText(parser.getUserDetails_id() + "\n" + parser.getUserDetails_firstName() );
		
		} catch(Exception e) {

			CoreLog.logErrorMessage("ERROR GETTING USERDETAILS DATA ");
			
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
