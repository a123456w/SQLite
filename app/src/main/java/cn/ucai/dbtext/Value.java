package cn.ucai.dbtext;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/17 0017.
 */

public class Value implements Serializable{
    private int id ;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String value;



}
