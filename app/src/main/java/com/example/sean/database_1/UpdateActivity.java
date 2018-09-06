package com.example.sean.database_1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.BaseKeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.PriorityQueue;

public class UpdateActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        editText1 = (EditText) findViewById(R.id.text7);
        editText2 = (EditText) findViewById(R.id.text8);
        editText3 = (EditText) findViewById(R.id.text9);
        editText4 = (EditText) findViewById(R.id.text10);
        editText5 = (EditText) findViewById(R.id.text11);

        Button update = (Button) findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText1.getText().toString();  //姓名
                String sex = editText2.getText().toString();  //性别
                String gh = editText3.getText().toString();  //工号
                String post = editText4.getText().toString(); //岗位
                String school = editText5.getText().toString();  //学校

                if(sex.equals("男")  || sex.equals("女")) {  //限制输入性别为男或女
                int gh_1 = Integer.parseInt(gh);
                Staff staff = new Staff();
                staff.setSex(sex);
                staff.setGh(gh_1);
                staff.setPost(post);
                staff.setSchool(school);
                staff.updateAll("name = ?",name);
                Toast.makeText(UpdateActivity.this,"更新成功",Toast.LENGTH_SHORT).show();
                Intent back = new Intent(UpdateActivity.this,MainActivity.class);
                startActivity(back);
                }
                else {
                    // 创建弹框
                    AlertDialog.Builder localBuilder = new AlertDialog.Builder(UpdateActivity.this)
                            .setTitle("警告")
                            .setIcon(R.drawable.warning)
                            .setMessage("性别只能为男或女")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                                    //确定操作
                                }
                            });

                    /***
                             * 设置点击返回键不会消失
                             * */
                    localBuilder.setCancelable(false).create();

                    localBuilder.show();
                }
            }
        });
    }
}
