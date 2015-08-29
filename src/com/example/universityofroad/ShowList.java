package com.example.universityofroad;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ClipData.Item;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.StatusUpdates;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ShowList extends Activity {

	private static final int LoadError=0;//����ʧ��
	private static final int TIPS=1;//Tips����
	private static final int STUDENT_BOOK=2;//ѧ���ֲ�����
	private static final int EXCELLENT=3;//ʵ�������
	private int CurrentWay;
	private MyselfListItemAdapter adapter;
	private List<ListItem> list = new ArrayList<ListItem>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_list);
		InitListItem();
		adapter = new MyselfListItemAdapter(
				ShowList.this, R.layout.listitem_layout, list);
		ListView listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				// �õ���ǰ���ŵ�Item
				ListItem item = list.get(position);
				String txtName = item.getFileName();
				Intent intent = new Intent(ShowList.this, ReadText.class);
				intent.putExtra("Name", txtName);
				startActivity(intent);
			}
		});

	}

	public void InitListItem(){
		Intent intent = getIntent();
		CurrentWay = intent.getIntExtra("LoadWay", 0);
		ListItem item;
		switch(CurrentWay){
		case TIPS:
			item = new ListItem("У԰����������~", R.drawable.ic_launcher, "swustcard");
			list.add(item);
			item = new ListItem("ѧλ֤�ͱ�ҵ֤�Ķ�Թ���", R.drawable.ic_launcher, "biye");
			list.add(item);
			item = new ListItem("�Ҳ�����Ӿ����", R.drawable.ic_launcher, "swimming");
			list.add(item);
			item = new ListItem("У԰����������~", R.drawable.ic_launcher, "swustcard");
			list.add(item);
			item = new ListItem("У԰����������~", R.drawable.ic_launcher, "swustcard");
			list.add(item);
			item = new ListItem("У԰����������~", R.drawable.ic_launcher, "swustcard");
			list.add(item);
			item = new ListItem("У԰����������~", R.drawable.ic_launcher, "swustcard");
			list.add(item);
			item = new ListItem("У԰����������~", R.drawable.ic_launcher, "swustcard");
			list.add(item);
			item = new ListItem("У԰����������~", R.drawable.ic_launcher, "swustcard");
			list.add(item);
			item = new ListItem("У԰����������~", R.drawable.ic_launcher, "swustcard");
			list.add(item);
			item = new ListItem("У԰����������~", R.drawable.ic_launcher, "swustcard");
			list.add(item);
			item = new ListItem("У԰����������~", R.drawable.ic_launcher, "swustcard");
			list.add(item);
			item = new ListItem("У԰����������~", R.drawable.ic_launcher, "swustcard");
			list.add(item);
			break;
		case STUDENT_BOOK:
			break;
		case EXCELLENT:
			break;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_list, menu);
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
}
