package com.joseonline.example.simpletodo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends Activity {

	private EditText etEditItem;
	private String item;
	private int pos;
	private int code;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_item);
		
		etEditItem = (EditText) findViewById(R.id.etEditItem);
		
		item = getIntent().getStringExtra("item");
		pos = getIntent().getIntExtra("pos", 0);
		code = getIntent().getIntExtra("code", 0);
		
		etEditItem.setText(item);
		etEditItem.setSelection(item.length());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_item, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void editTodoItem(View v) {
        Intent data = new Intent();
        
        data.putExtra("item", etEditItem.getText().toString());
        data.putExtra("pos", pos);
        
        setResult(RESULT_OK, data);
        finish();
    }

}
