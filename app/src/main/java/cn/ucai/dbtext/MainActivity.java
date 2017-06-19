package cn.ucai.dbtext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private Dao dao;
    @BindView(R.id.et_Save)
    EditText etSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        dao=new Dao();
    }

    @OnClick(R.id.btn_save)
    public void onViewClicked() {
        String s = etSave.getText().toString();
        String id = PreferenceManager.getInstance(this).getId();
        int i=0;
        if(id!=null){
            i = Integer.parseInt(id);
            Map<Integer, Value> value = dao.getValue();
            if(value.get(i).equals(s)){
                dao.saveValue(s);
                Map<Integer, Value> value1 = dao.getValue();
                Set<Integer> keySet = value1.keySet();
                Iterator<Integer> iterator = keySet.iterator();
                while (iterator.hasNext()){
                    Integer next = iterator.next();
                    Value value2 = value1.get(next);
                    if(value2.getValue().equals(s)){
                        int id1 = value2.getId();
                        PreferenceManager.getInstance(this).setID(String.valueOf(id1));
                    }
                }
            }
            id = PreferenceManager.getInstance(this).getId();
            if(id!=null){
                i = Integer.parseInt(id);
                Map<Integer, Value> v = dao.getValue();
                Value ve= value.get(i);
                Toast.makeText(this, "ve.id="+ve.getId()+",ve.getValue:"+ve.getValue(), Toast.LENGTH_SHORT).show();
            }
        }else {
            dao.saveValue(s);
            Map<Integer, Value> value = dao.getValue();
            Set<Integer> keySet = value.keySet();
            Iterator<Integer> key = keySet.iterator();
            Integer ids = key.next();
            PreferenceManager.getInstance(this).setID(String.valueOf(ids));
            Toast.makeText(this, "存储到PreferenceManager中", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}
