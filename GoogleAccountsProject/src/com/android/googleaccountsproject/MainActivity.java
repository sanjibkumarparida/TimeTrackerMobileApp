package com.android.googleaccountsproject;

import android.net.Uri;
import android.os.Bundle;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.googleplusLink)));
        startActivity(intent);
        
        Account[] accounts = AccountManager.get(MainActivity.this).getAccounts();
        for (Account account : accounts) {
                String possibleEmail = account.name;
                Log.i("Account name = ", possibleEmail);
        }
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
