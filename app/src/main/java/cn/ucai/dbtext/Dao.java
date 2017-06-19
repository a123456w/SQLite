package cn.ucai.dbtext;

import java.util.Map;

/**
 * Created by Administrator on 2017/6/17 0017.
 */
public class Dao {
    public static final String TABLE_NAME = "Text";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_VALUE = "value";

    public void saveValue(String str){
        TextDbManager.getInstance().saveValues(str);
    }
    public Map<Integer, Value> getValue(){
       return TextDbManager.getInstance().getValue();
    }
}
