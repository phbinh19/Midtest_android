package com.example.thi_gk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.PhepChiaAdapter;
import com.example.model.PhepChia;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    EditText txtA, txtB;
    TextView txtKetQua;
    Button btnChia;
    ListView lvKetQua;
    ArrayList<PhepChia> dsCacso;
    PhepChiaAdapter dsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {

        lvKetQua.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dsCacso.remove(position);
                dsAdapter.notifyDataSetChanged();

            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhepChia cacSo = new PhepChia(
                        txtA.getText().toString(),
                        txtB.getText().toString(),
                        txtKetQua.getText().toString()
                );
                dsCacso.add(cacSo);
                dsAdapter.notifyDataSetChanged();

                if(
                        !TextUtils.isEmpty(txtA.getText().toString() ) && !TextUtils.isEmpty(txtB.getText().toString() )
                ){
                    if(!TextUtils.isDigitsOnly(txtA.getText().toString()) || !TextUtils.isDigitsOnly(txtB.getText().toString())){
                      Toast.makeText(MainActivity.this,"Vui long nhap so!",Toast.LENGTH_LONG).show();
                    }else {
                        float a = Integer.parseInt(txtA.getText().toString());
                        float b = Integer.parseInt(txtB.getText().toString());
                        float kq = a / b;
                        txtKetQua.setText(String.valueOf(a) + "/" + String.valueOf(b) + "=" + String.valueOf(kq));
                    }
                }
                else{
                    Toast.makeText(MainActivity.this,"Vui long nhap day du",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void addControls() {
        txtA = (EditText) findViewById(R.id.txtA);
        txtB = (EditText) findViewById(R.id.txtB);
        btnChia = (Button) findViewById(R.id.btnChia);
        txtKetQua = (TextView) findViewById(R.id.txtKetQua);
        lvKetQua = (ListView) findViewById(R.id.lvKetQua);
        dsCacso = new ArrayList<>();
        dsAdapter = new PhepChiaAdapter(MainActivity.this, R.layout.item, dsCacso);
        lvKetQua.setAdapter(dsAdapter);
    }
}
