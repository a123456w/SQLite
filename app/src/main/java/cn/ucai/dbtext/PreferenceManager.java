package cn.ucai.dbtext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2017/6/17 0017.
 */

public class PreferenceManager {
    public static final String PREFERENCE_NAME = "saveInfo";
    private static PreferenceManager mPreferencemManager;
    private static SharedPreferences mSharedPreferences;
    private static SharedPreferences.Editor editor;

    private static String SHARED_KEY_CURRENTUSER_ID = "SHARED_KEY_CURRENTUSER_ID";

    public synchronized static PreferenceManager getInstance(Context cxt) {
        if (mPreferencemManager == null) {
            mPreferencemManager = new PreferenceManager(cxt);
        }
        return mPreferencemManager;
    }

    public void setID(String id){
        editor.putString(SHARED_KEY_CURRENTUSER_ID, id);
        editor.apply();
    }

    public String getId(){
        return mSharedPreferences.getString(SHARED_KEY_CURRENTUSER_ID, null);
    }
    @SuppressLint("CommitPrefEdits")
    private PreferenceManager(Context cxt) {
        mSharedPreferences = cxt.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();
    }

}
