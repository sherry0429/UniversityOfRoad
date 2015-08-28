package com.example.universityofroad;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.Toast;

public class StudentNeedKnow extends Activity {

	private MyTouchListener myTouchListener = new MyTouchListener();
	
	private void InitWidget(){
		Button button1 = (Button)findViewById(R.id.Tips);
		Button button2 = (Button)findViewById(R.id.StudentBook);
		Button button3 = (Button)findViewById(R.id.where);
		Button button4 = (Button)findViewById(R.id.Laboratory_and_Excellent_class);
		button1.setOnTouchListener(myTouchListener);
		button2.setOnTouchListener(myTouchListener);
		button3.setOnTouchListener(myTouchListener);
		button4.setOnTouchListener(myTouchListener);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_need_know);
        InitWidget();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.student_need_know, menu);
		return true;
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
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
	
	class MyTouchListener implements OnTouchListener {

		Intent next;
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				switch (v.getId()) {
				case R.id.Tips:
//					v.setBackgroundResource(R.color.black);
					break;
				case R.id.StudentBook:
//					v.setBackgroundResource(R.color.Cantsee);
					break;
				case R.id.where:
//					v.setBackgroundResource(R.color.lightskyblue);
					break;
				case R.id.Laboratory_and_Excellent_class:
//					v.setBackgroundResource(R.color.whitesmoke);
					break;
				default:
					break;
				}

			} 
			else if (event.getAction() == MotionEvent.ACTION_UP) {
				switch (v.getId()) {
				case R.id.Tips:
//					v.setBackgroundResource(R.drawable.tips);
					next = new Intent(StudentNeedKnow.this,
							ShowList.class);
					next.putExtra("LoadWay", 1);
					startActivity(next);
					break;
				case R.id.StudentBook:
//					v.setBackgroundResource(R.color.Cantsee);
					next = new Intent(StudentNeedKnow.this,
							ShowList.class);
					next.putExtra("LoadWay", 2);
					startActivity(next);
					break;
				case R.id.where:
//					v.setBackgroundResource(R.color.Cantsee);
					next = new Intent(StudentNeedKnow.this,
							LookMap.class);
					startActivity(next);
					break;
				case R.id.Laboratory_and_Excellent_class:
//					v.setBackgroundResource(R.color.Cantsee);
					next = new Intent(StudentNeedKnow.this,
							ShowList.class);
					next.putExtra("LoadWay", 3);
					startActivity(next);
					break;
				default:
					break;
				}

			}
			return false;
		}

	}
}
