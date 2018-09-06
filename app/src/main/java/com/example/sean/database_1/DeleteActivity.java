package com.example.sean.database_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

public class DeleteActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        Button delete_1 = (Button) findViewById(R.id.delete);
        Button deleteAll = (Button) findViewById(R.id.delete_all);
        editText = (EditText) findViewById(R.id.text6);

        //int gh_2 = Integer.parseInt(gh_1);
        delete_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_1 = editText.getText().toString();//获取输入的工号
                DataSupport.deleteAll(Staff.class,"name = ?",name_1);
                Toast.makeText(DeleteActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
                Intent back = new Intent(DeleteActivity.this,MainActivity.class);
                startActivity(back);
            }
        });

        deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataSupport.deleteAll(Staff.class);
                Toast.makeText(DeleteActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
                Intent back = new Intent(DeleteActivity.this,MainActivity.class);
                startActivity(back);
            }
        });
    }
}
