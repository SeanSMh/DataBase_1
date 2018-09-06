package com.example.sean.database_1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddActivity extends AppCompatActivity {

  private EditText ed1;
  private EditText ed2;
  private EditText ed3;
  private EditText ed4;
  private EditText ed5;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add);

    ed1 = (EditText) findViewById(R.id.input1);
    ed1.addTextChangedListener(new MaxLengthWatcher(10, ed1));  //最大输入字符串长度为10

    ed2 = (EditText) findViewById(R.id.input2);  //性别只能输入一个字符
    ed2.addTextChangedListener(new MaxLengthWatcher(1, ed2));

    ed3 = (EditText) findViewById(R.id.input3);
    ed3.setInputType( InputType.TYPE_CLASS_NUMBER);    //设置只能输入数字
    ed3.addTextChangedListener(new MaxLengthWatcher(10,ed3));

    ed4 = (EditText) findViewById(R.id.input4);
    ed4.addTextChangedListener(new MaxLengthWatcher(10, ed4));

    ed5 = (EditText) findViewById(R.id.input5);
    ed5.addTextChangedListener(new MaxLengthWatcher(10, ed5));

    Button addData = (Button) findViewById(R.id.record);
    addData.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        String name = ed1.getText().toString();  //获取姓名
        String sex = ed2.getText().toString();  //获取性别
        String gh_1 = ed3.getText().toString(); //获取工号
        int gh_2 = Integer.parseInt(gh_1);
        String post = ed4.getText().toString();  //获取岗位
        String school = ed5.getText().toString();  //获取学校

        if(sex.equals("男") || sex.equals("女")) {
          Staff staff = new Staff();
          staff.setName(name);
          staff.setSex(sex);
          staff.setGh(gh_2);
          staff.setPost(post);
          staff.setSchool(school);
          staff.save();

          Toast.makeText(AddActivity.this, "录入成功", Toast.LENGTH_SHORT).show();
          Intent back = new Intent(AddActivity.this, MainActivity.class);
          startActivity(back);
        }
        else {
          // 创建弹框
          AlertDialog.Builder localBuilder = new AlertDialog.Builder(AddActivity.this)
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
