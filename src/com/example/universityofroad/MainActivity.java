package com.example.universityofroad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

	private Button left;
	private Button right;
	private Intent GoNext;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        left = (Button)findViewById(R.id.StudentNeedKnow);
        right = (Button)findViewById(R.id.WaittingDevelop);
        left.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				GoNext = new Intent(MainActivity.this,StudentNeedKnow.class);
				startActivity(GoNext);
			}
		});
        right.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				GoNext = new Intent(MainActivity.this,UnverSityRoad.class);
				startActivity(GoNext);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    
//	class Mylistener implements OnClickListener {
//		@Override
//		public void onClick(View v) {
//			// TODO Auto-generated method stub
//			
//		}
//
//	}

}
