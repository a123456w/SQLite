package cn.ucai.dbtext;

import android.app.Application;

/**
 * Created by Administrator on 2017/6/17 0017.
 */
public class TextDbApplication extends Application{
    private static TextDbApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }
    public static TextDbApplication getInstance() {
        return instance;
    }
}
