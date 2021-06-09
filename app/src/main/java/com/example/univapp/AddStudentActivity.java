package com.example.univapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.studioidan.httpagent.HttpAgent;
import com.studioidan.httpagent.SuccessCallback;

import es.dmoral.toasty.Toasty;

public class AddStudentActivity extends AppCompatActivity {
    private TextView id, lname, fname, sp, lavel, univ, promo;
    private Button next,btn_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        id = findViewById(R.id.IDstd);
        fname = findViewById(R.id.lastname);
        lname = findViewById(R.id.Name);
        sp = findViewById(R.id.spec);
        lavel = findViewById(R.id.lavel);
        promo = findViewById(R.id.prom);
        univ = findViewById(R.id.univ_g);
        next = findViewById(R.id.next_univ);
        btn_view = findViewById(R.id.btn_view);
        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),UnivView.class));
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Students students = new Students();
                students.setId(id.getText().toString());
                students.setFamlyname(fname.getText().toString());
                students.setName(lname.getText().toString());
                students.setSp(sp.getText().toString());
                students.setLavel(lavel.getText().toString());
                students.setPromotion(promo.getText().toString());
                students.setUniv(univ.getText().toString());
                Gson gson = new Gson();
                HttpAgent.put(Urls.UNIV_URL+Urls.ADD_UNIV_URL)
                        .withBody(gson.toJson(students))
                        .go(new SuccessCallback() {
                            @Override
                            protected void onDone(boolean success) {
                                if(success)
                                    Toasty.info(getApplicationContext(),"Done",Toasty.LENGTH_LONG);
                            }
                        });
            }
        });


    }
}