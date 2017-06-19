package cn.ucai.dbtext;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/17 0017.
 */

public class TextDbManager {
    static private TextDbManager dbMgr = new TextDbManager();
    private DbOpenHelper dbHelper;

    private TextDbManager() {
        dbHelper = DbOpenHelper.getInstance(TextDbApplication.getInstance().getApplicationContext());
    }

    public static synchronized TextDbManager getInstance() {
        if (dbMgr == null) {
            dbMgr = new TextDbManager();
        }
        return dbMgr;
    }
    synchronized public void saveValues(String  str) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        if (db.isOpen()) {
            db.delete(Dao.TABLE_NAME, null, null);
                ContentValues values = new ContentValues();
                values.put(Dao.COLUMN_VALUE, str);
                db.insertOrThrow(Dao.TABLE_NAME,null, values);
        }
    }
    synchronized public Map<Integer, Value> getValue() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Map<Integer, Value> users = new Hashtable<Integer, Value>();
        if (db.isOpen()) {
            Cursor cursor = db.rawQuery("select * from " + Dao.TABLE_NAME /* + " desc" */, null);
            while (cursor.moveToNext()) {
                int  id = cursor.getInt(cursor.getColumnIndex(Dao.COLUMN_ID));
                String value = cursor.getString(cursor.getColumnIndex(Dao.COLUMN_VALUE));
                Value v=new Value();
                v.setId(id);
                v.setValue(value);
                users.put(id, v);
            }
            cursor.close();
        }
        return users;
    }

}
