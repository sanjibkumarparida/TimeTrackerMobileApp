package com.android.listviewalphabaticalsideindexproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;







import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends Activity implements OnClickListener {

	Map<String, Integer> mapIndex;
	ListView fruitList;
	String[] fruits;
	String[] alphabetIndex;
	List<String> indexList ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		fruits = getResources().getStringArray(R.array.fruits_array);
		alphabetIndex = getResources().getStringArray(R.array.alphabetindex);

		Arrays.asList(fruits);
		Arrays.sort(fruits);
		Collections.sort(Arrays.asList(fruits));

		fruitList = (ListView) findViewById(R.id.list_fruits);
		fruitList.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, fruits));

		getIndexList(fruits);

		displayIndex();
		
		listitemClickEvent();
		
	}

	private void listitemClickEvent() {

		fruitList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int pos,
					long id) {
				
				Toast.makeText(MainActivity.this, adapterView.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();
				
			}
		});
		
	}

	private void getIndexList(String[] fruits) {
		mapIndex = new LinkedHashMap<String, Integer>();
		for (int i = 0; i < fruits.length; i++) {
			String fruit = fruits[i];
			String index = fruit.substring(0, 1);

			if (mapIndex.get(index) == null)
				mapIndex.put(index, i);
		}
	}

	private void displayIndex() {
		LinearLayout indexLayout = (LinearLayout) findViewById(R.id.side_index);

		try {
		TextView textView;
		// List<String> indexList = new ArrayList<String>(mapIndex.keySet()); // This only displays the alphabet index whatever list items are available
		indexList = new ArrayList<String>(Arrays.asList(alphabetIndex)); // This displays all the alphabet index
		for (String index : indexList) {
			textView = (TextView) getLayoutInflater().inflate(
					R.layout.side_index_item, null);
			textView.setText(index);
			textView.setOnClickListener(this);
			indexLayout.addView(textView);
		}
		}
		catch(Exception e) {
           e.printStackTrace();
		}
	}

	public void onClick(View view) {
		TextView selectedIndex = null;
		try {
		selectedIndex = (TextView) view;
		fruitList.setSelection(mapIndex.get(selectedIndex.getText()));
		} catch(Exception e) {
			e.printStackTrace();
			Log.d("MESSAGE", "List Elements not available based on"+ selectedIndex.getText());
			Toast.makeText(MainActivity.this, "List Elements not available based on "+ selectedIndex.getText(), Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
