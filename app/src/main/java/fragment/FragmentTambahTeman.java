package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapps.R;
import com.example.myapps.RealmHelper;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import model.Teman;

/**
 * A simple {@link Fragment} subclass.
 */

//5-8-2019, 10116333, CHANDRA SEPTIAN, IF - 8

public class FragmentTambahTeman extends Fragment implements View.OnClickListener {

    EditText etName, etNIM, etClass, etPhone, etEmail, etIG;
    String nim, nama, kelas, email, sosmed, telp;
    Button btnTambah;
    Realm realm;
    RealmHelper realmHelper;
    Teman teman;


    public FragmentTambahTeman() {
        // Required empty public constructor
    }

    public static FragmentTambahTeman newInstance(){
        return new FragmentTambahTeman();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tambah_teman, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState){

        etNIM = view.findViewById(R.id.etNIM);
        etName = view.findViewById(R.id.etName);
        etClass = view.findViewById(R.id.etClass);
        etEmail = view.findViewById(R.id.etEmail);
        etIG = view.findViewById(R.id.etIG);
        etPhone = view.findViewById(R.id.etPhone);
        btnTambah = view.findViewById(R.id.btnTambah);

        Realm.init(view.getContext());
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);

        btnTambah.setOnClickListener(this);
    }

    public void onClick(View v){
        if(v == btnTambah){
            nim = etNIM.getText().toString();
            nama = etName.getText().toString();
            kelas = etClass.getText().toString();
            email = etEmail.getText().toString();
            sosmed = etIG.getText().toString();
            telp = etPhone.getText().toString();

            if(!nim.isEmpty() && !nama.isEmpty() && !kelas.isEmpty() && !email.isEmpty() && !sosmed.isEmpty() && !telp.isEmpty()){
                teman = new Teman();
                teman.setNim(nim);
                teman.setNama(nama);
                teman.setKelas(kelas);
                teman.setEmail(email);
                teman.setSosmed(sosmed);
                teman.setTelp(telp);

                realmHelper = new RealmHelper(realm);
                realmHelper.save(teman);

                Toast.makeText(getContext(), "Berhasil Disimpan", Toast.LENGTH_SHORT).show();

                etNIM.setText("");
                etName.setText("");
                etClass.setText("");
                etEmail.setText("");
                etIG.setText("");
                etPhone.setText("");
            } else {
                Toast.makeText(getContext(), "Terdapat Inputan Kosong", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
