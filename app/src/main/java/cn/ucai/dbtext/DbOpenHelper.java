package cn.ucai.dbtext;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/6/17 0017.
 */

public class DbOpenHelper extends SQLiteOpenHelper {
    private static DbOpenHelper instance;
    private static final String USERNAME_TABLE_CREATE = "CREATE TABLE "
            + Dao.TABLE_NAME + " ("
            + Dao.COLUMN_VALUE + " TEXT, "
            + Dao.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT);";
    private DbOpenHelper(Context context) {
        super(context, "text_demo.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USERNAME_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public static DbOpenHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DbOpenHelper(context.getApplicationContext());
        }
        return instance;
    }
    public void closeDB() {
        if (instance != null) {
            try {
                SQLiteDatabase db = instance.getWritableDatabase();
                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            instance = null;
        }
    }
}
