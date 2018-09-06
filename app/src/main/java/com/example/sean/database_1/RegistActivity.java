package com.example.sean.database_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        Button regist = (Button) findViewById(R.id.regist);

        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1 = (EditText) findViewById(R.id.edittext1);
                editText2 = (EditText) findViewById(R.id.edittext2);
                String name = editText1.getText().toString();
                int password = Integer.parseInt(editText2.getText().toString());

                User user = new User();
                user.setName(name);
                user.setPassword(password);
                user.save();

                Toast.makeText(RegistActivity.this,"注册成功！",Toast.LENGTH_SHORT).show();
                Intent toMain = new Intent(RegistActivity.this,LoginActivity.class);
                startActivity(toMain);
            }
        });
    }
}
