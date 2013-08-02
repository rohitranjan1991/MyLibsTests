package com.mylibstests;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.dropbox.sync.android.DbxAccountManager;
import com.vmff.dropbox.DropBox;

public class MainActivity extends Activity {

	private int REQUEST_LINK_TO_DBX=0;
	private DropBox db;
	private DbxAccountManager dbxManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		dropbox();
		
	}

	private void dropbox() {
		db=new DropBox(0,getApplicationContext(),MainActivity.this,"omj2nyrnfrq7cwz","qjj98xgds6u3zed");
		dbxManager=db.connectToDropBox();
	}
	

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_LINK_TO_DBX) {
			if (resultCode == Activity.RESULT_OK) {
				Toast.makeText(MainActivity.this, "Connected to the User Account", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(MainActivity.this, "Could not connect to the User Account!! Try Again Later!!", Toast.LENGTH_SHORT).show();
			}
		} else {
			super.onActivityResult(requestCode, resultCode, data);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
