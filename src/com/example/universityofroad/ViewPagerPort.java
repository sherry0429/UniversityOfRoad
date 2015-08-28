package com.example.universityofroad;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import android.R.bool;
import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class ViewPagerPort extends Activity {

	private View view1, view2, view3;
	private List<View> viewList;// view����
	private ViewPager viewPager; // ��Ӧ��viewPager
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_pager_port);

		viewPager = (ViewPager) findViewById(R.id.viewpager);
		LayoutInflater inflater = getLayoutInflater();
		view1 = inflater.inflate(R.layout.port_1, null);
		view2 = inflater.inflate(R.layout.port_2, null);
		view3 = inflater.inflate(R.layout.port_3, null);
		
		button = (Button)view3.findViewById(R.id.JumpToMain);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ViewPagerPort.this,MainActivity.class);
				startActivity(intent);
				finish();
				
			}
		});
		viewList = new ArrayList<View>();// ��Ҫ��ҳ��ʾ��Viewװ��������
		viewList.add(view1);
		viewList.add(view2);
		viewList.add(view3);

		PagerAdapter pagerAdapter = new PagerAdapter() {

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO Auto-generated method stub
				return arg0 == arg1;
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return viewList.size();
			}

			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				// TODO Auto-generated method stub
				container.removeView(viewList.get(position));
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				// TODO Auto-generated method stub
				container.addView(viewList.get(position));

				return viewList.get(position);
			}
		};

		viewPager.setAdapter(pagerAdapter);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
//				Toast.makeText(MainActivity.this, "Selected", Toast.LENGTH_SHORT).show();
//				Log.i("onPageSelected","arg0:"+arg0);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
//				Toast.makeText(MainActivity.this, "Scroll", Toast.LENGTH_SHORT).show();
//				Log.i("onPageScrolled","arg0:"+arg0+" arg1:"+arg1+" arg2:"+arg2);

			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
//				Toast.makeText(MainActivity.this, "Change", Toast.LENGTH_SHORT).show();
//				Log.i("onPageScrollStateChanged","arg0:"+arg0);
			}
		});

	}

}