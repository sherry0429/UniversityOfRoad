package com.example.universityofroad;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class AppDataBase extends SQLiteOpenHelper {

	private Context mContext;

	public static final String CREATE_TABLE_VIDEO = "create table video ("
			+ "id integer primary key autoincrement, " + "VideoName text, "
			+ "VideoUrl text)";

	public AppDataBase(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		mContext = context;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_TABLE_VIDEO);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	}

	//数据库名,要查询的表名
	public boolean tabbleIsExist(String dataBaseName, String tableName) {
		boolean result = false;
		if (tableName == null) {
			return false;
		}
		SQLiteDatabase db = null;
		Cursor cursor = null;
		try {
			db = this.getReadableDatabase();

			String sql = "select count(*) as c from " + dataBaseName
					+ " where type ='id' and name ='" + tableName + "' ";
			cursor = db.rawQuery(sql, null);
			if (cursor.moveToNext()) {
				int count = cursor.getInt(0);
				if (count > 0) {
					result = true;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

}
