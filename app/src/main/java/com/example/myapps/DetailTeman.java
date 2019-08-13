package com.example.myapps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import fragment.FragmentTambahTeman;
import fragment.FragmentTeman;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import model.Teman;
import presenter.PresenterDetailTeman;
import view.ViewDetailTeman;

//10-8-2019, 10116333, CHANDRA SEPTIAN, IF - 8

public class DetailTeman extends AppCompatActivity implements ViewDetailTeman, View.OnClickListener {

    EditText tvName, tvNIM, tvClass, tvPhone, tvEmail, tvIg;
    Button btnUpdate, btnDelete;
    Integer id;
    String nim, nama, kelas, email, sosmed, telp;
    RealmHelper realmHelper;
    Realm realm;
    PresenterDetailTeman presenter;
    Teman teman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_teman);

        presenter = new PresenterDetailTeman(this);

        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);
        realmHelper = new RealmHelper(realm);

        tvName = findViewById(R.id.tvNamaTeman);
        tvNIM = findViewById(R.id.tvNIMTeman);
        tvClass = findViewById(R.id.tvKelasTeman);
        tvPhone = findViewById(R.id.tvTelpTeman);
        tvEmail = findViewById(R.id.tvEmailTeman);
        tvIg = findViewById(R.id.tvIgTeman);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);


        btnDelete.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);

        id = Integer.parseInt(getIntent().getStringExtra("id"));
        nim = getIntent().getStringExtra("nim");
        nama = getIntent().getStringExtra("nama");
        kelas = getIntent().getStringExtra("kelas");
        email = getIntent().getStringExtra("email");
        sosmed = getIntent().getStringExtra("sosmed");
        telp = getIntent().getStringExtra("telp");

        tvNIM.setText(nim);
        tvName.setText(nama);
        tvClass.setText(kelas);
        tvEmail.setText(email);
        tvIg.setText(sosmed);
        tvPhone.setText(telp);
    }

    @Override
    public void doCall() {
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", telp, null));
        startActivity(i);
    }

    @Override
    public void sendEmail() {
        Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + email));
        startActivity(i);
    }

    @Override
    public void openInstagram() {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/" + sosmed.replace("@", "")));
        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layPhone:
                presenter.doCall();
                break;
            case R.id.layEmail:
                presenter.sendEmail();
                break;
            case R.id.layIg:
                presenter.openInstagram();
                break;
        }
        if(v == btnUpdate){
            realmHelper.update(id, tvNIM.getText().toString(), tvName.getText().toString(), tvClass.getText().toString(),
                    tvEmail.getText().toString(), tvIg.getText().toString(), tvPhone.getText().toString());
            Toast.makeText(DetailTeman.this, "Update Success", Toast.LENGTH_SHORT).show();
            tvNIM.setText("");
            tvName.setText("");
            tvEmail.setText("");
            tvClass.setText("");
            tvIg.setText("");
            tvPhone.setText("");
            finish();
        } else if(v == btnDelete){
            realmHelper.delete(id);
            Toast.makeText(DetailTeman.this,"Delete Success", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
