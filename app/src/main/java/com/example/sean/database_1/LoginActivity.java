package com.example.sean.database_1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private EditText accountEdit;

    private EditText passwordEdit;

    private Button login;
    private Button regist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        accountEdit = (EditText) findViewById(R.id.account);    //获取控件实例
        passwordEdit = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        regist = (Button) findViewById(R.id.regist);

        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reIntent = new Intent(LoginActivity.this, RegistActivity.class);
                startActivity(reIntent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();  //获取输入框里的内容
                String password_1 = passwordEdit.getText().toString();
                if (account.equals(" ")  || password_1.equals("")) {
                    // 创建弹框
                    AlertDialog.Builder localBuilder = new AlertDialog.Builder(LoginActivity.this)
                    .setTitle("警告")
                    .setIcon(R.drawable.warning)
                    .setMessage("账号或者密码未填")
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

                } else {
                    try {
                        int password_2 = Integer.parseInt(password_1);
                        //与数据库中的数据进行比较
                        List<User> userlist = DataSupport.where("name = ?", account).find(User.class);//根据账号查找密码

                        for (User user : userlist) {
                            if(user.getName().equals("")) {
                                Toast.makeText(LoginActivity.this,"账户不存在",Toast.LENGTH_SHORT).show();
                            }
                             else if (user.getPassword() == password_2) {
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class); //跳转到mainActivity
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(LoginActivity.this, "密码输入错误", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
