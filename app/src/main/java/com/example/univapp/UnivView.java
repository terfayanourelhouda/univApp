package com.example.univapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.studioidan.httpagent.HttpAgent;
import com.studioidan.httpagent.JsonCallback;

import org.json.JSONObject;

import es.dmoral.toasty.Toasty;

public class UnivView extends AppCompatActivity {

    private TextView id, lname, fname, sp, lavel, univ, promo;
    private Button next;
    Students student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HttpAgent.get(Urls.UNIV_URL + Urls.ONE_UNIV_URL)
                .goJson(new JsonCallback() {
                    @Override
                    protected void onDone(boolean success, JSONObject jsonResults) {
                        if (success){
                            student = new Gson().fromJson(jsonResults.toString(),Students.class);
                        }
                    }
                });
        setContentView(R.layout.activity_univ_view);
        id = findViewById(R.id.IDstd);
        fname = findViewById(R.id.lastname);
        lname = findViewById(R.id.Name);
        sp = findViewById(R.id.spec);
        lavel = findViewById(R.id.lavel);
        promo = findViewById(R.id.prom);
        univ = findViewById(R.id.univ_g);
        next = findViewById(R.id.next_univ);

        if (student != null){
            id.setText(student.getId());
            fname.setText(student.getFamlyname());
            lname.setText(student.getName());
            sp.setText(student.getSp());
            lavel.setText(student.getLavel());
            promo.setText(student.getPromotion());
            univ.setText(student.getUniv());
        }
        //student = new Gson().fromJson(UnivImp.dataJson, Students.class);


        Toasty.success(getApplicationContext(), "connection Successfully !", Toast.LENGTH_SHORT).show();


    }


}