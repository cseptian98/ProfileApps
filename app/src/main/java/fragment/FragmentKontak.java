package fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.myapps.R;

import presenter.PresenterKontak;
import view.ViewKontak;

//5-8-2019, 10116333, CHANDRA SEPTIAN, IF - 8

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentKontak extends Fragment implements ViewKontak, View.OnClickListener {

    RelativeLayout layPhone, layEmail, layIg, layTwitter;
    PresenterKontak presenter;


    public FragmentKontak() {
        // Required empty public constructor
    }

    public static FragmentKontak newInstance(){
        return new FragmentKontak();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kontak, container, false);

        layPhone = view.findViewById(R.id.layPhone);
        layEmail = view.findViewById(R.id.layEmail);
        layIg = view.findViewById(R.id.layIg);
        layTwitter = view.findViewById(R.id.layTwitter);

        layPhone.setOnClickListener(this);
        layEmail.setOnClickListener(this);
        layIg.setOnClickListener(this);
        layTwitter.setOnClickListener(this);

        presenter = new PresenterKontak(this);
        return view;
    }

    public void doCall() {
        Intent a = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "0895339871333", null));
        startActivity(a);
    }

    public void sendEmail() {
        Intent a = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:cseptian48@gmail.com"));
        startActivity(a);
    }

    public void openInstagram() {
        Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/cseptian_"));
        startActivity(a);
    }

    public void openTwitter() {
        Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.twitter.com/CSeptian98"));
        startActivity(a);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.layPhone:
                presenter.makeCall();
                break;
            case R.id.layEmail:
                presenter.sendEmail();
                break;
            case R.id.layIg:
                presenter.openInstagram();
                break;
            case R.id.layTwitter:
                presenter.openTwitter();
                break;
        }
    }
}
