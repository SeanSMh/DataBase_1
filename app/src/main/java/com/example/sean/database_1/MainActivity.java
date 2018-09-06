package com.example.sean.database_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LitePal.getDatabase(); //默认创建数据库
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        Button delete = (Button) findViewById(R.id.delete);  //删除数据按钮
        Button query = (Button) findViewById(R.id.query);  //查询数据按钮
        Button update = (Button) findViewById(R.id.update);  //更新数据按钮
        Button addData = (Button) findViewById(R.id.add_data);  //添加数据按钮

        query.setOnClickListener(this);
        delete.setOnClickListener(this);
        update.setOnClickListener(this);
        addData.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.add_data:
                Intent intent_1 = new Intent(MainActivity.this,AddActivity.class);
                startActivity(intent_1);     //跳转到增加数据界面
                break;

            case R.id.query:
                List<Staff> staffList = DataSupport.findAll(Staff.class);  //查找所有数据
                Log.d("tag","size = "+staffList.size());
                int a = 0; //记载数组长度
                for (Staff staff1:staffList) {
                    a++;
                }

                String[] data_1 = new String[a];
                String[] data_2 = new String[a];
                int b = 0;
                for (Staff staff1:staffList) {
                    String name = staff1.getName();        //获取名字
                    String sex = staff1.getSex();          //获取性别
                    int id_id = staff1.getGh();             //获取工号
                    //String id_2 = String.valueOf(id_1);
                    String post = staff1.getPost();    //获取岗位
                    String school = staff1.getSchool();    //获取学校
                    data_1[b] = name + " " + sex + " "+ id_id + " " + post
                            + " " + school;
                    data_2[b] = name + "     " +  id_id;
                    b++;
                }

                Intent send_data = new Intent(MainActivity.this,DisplayActivity.class);  //传送数据给要展示的界面
                Bundle bundle = new Bundle();
                bundle.putStringArray("extra_data",data_1);  //将数组封装到bundle中
                bundle.putStringArray("extra_data2",data_2);
                String str = Integer.toString(a);  //数组长度转化为string以便于传送
                send_data.putExtra("int",str);
                send_data.putExtras(bundle);   //传送数组和数组长度
                startActivity(send_data);   //跳转到展示界面
                break;

            case R.id.delete:
                //DataSupport.deleteAll(Staff.class,null,null); //删除所有数据
                Intent delete_intent = new Intent(MainActivity.this,DeleteActivity.class); //跳转到删除界面
                startActivity(delete_intent);
                break;

            case R.id.update:
                Intent update_intent = new Intent(MainActivity.this,UpdateActivity.class); //跳转到删除界面
                startActivity(update_intent);
                break;

                default:
                    break;
        }
    }

}
