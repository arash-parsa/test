package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements ContactAdaptor.ItemEventListener {

    private ContactAdaptor adaptor;
    private int edittingItemPosition = -1;
    private EditText fullNaemEt;
    private ImageView addNewContactBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.rv_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        adaptor =new ContactAdaptor(this);
        recyclerView.setAdapter(adaptor);

        fullNaemEt = findViewById(R.id.et_main_contactFullName);
        addNewContactBtn = findViewById(R.id.iv_main_addNewContact);

        addNewContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fullNaemEt.length()>0){
                    if(edittingItemPosition> -1){
                        adaptor.updateContact(fullNaemEt.getText().toString(),edittingItemPosition);
                        edittingItemPosition = -1;
                        addNewContactBtn.setImageResource(R.drawable.ic_add_white_24dp);
                    }else {
                        adaptor.addNewContact(fullNaemEt.getText().toString());
                        recyclerView.scrollToPosition(0);
                    }
                    fullNaemEt.setText("");


                }
            }
        });

    }

    @Override
    public void onItemClick(String fullName, int position) {
        edittingItemPosition = position ;
        fullNaemEt.setText(fullName);
        addNewContactBtn.setImageResource(R.drawable.ic_done_white_24dp);

    }
}
