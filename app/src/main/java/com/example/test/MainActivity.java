package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ContactAdaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.rv_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        adaptor =new ContactAdaptor();
        recyclerView.setAdapter(adaptor);

        final EditText fullNaemEt = findViewById(R.id.et_main_contactFullName);
        ImageView addNewContactBtn = findViewById(R.id.iv_main_addNewContact);

        addNewContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fullNaemEt.length()>0){
                    adaptor.addNewContact(fullNaemEt.getText().toString());
                    recyclerView.scrollToPosition(0);
                }
            }
        });

    }
}
