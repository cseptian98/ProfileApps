package com.example.myapps;

import android.util.Log;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import model.Teman;

//10-8-2019, 10116333, CHANDRA SEPTIAN, IF - 8

public class RealmHelper {
    Realm realm;

    public RealmHelper(Realm realm){
        this.realm = realm;
    }

    public void save(final Teman teman){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (realm != null){
                    Log.e("Created", "Database Created");
                    Number currentId = realm.where(Teman.class).max("id");
                    int nextId;
                    if (currentId == null){
                        nextId = 1;
                    } else {
                        nextId = currentId.intValue() + 1;
                    }
                    teman.setId(nextId);
                    Teman model = realm.copyToRealm(teman);
                } else {
                    Log.e("ppp", "Execute : Database Not Exist");
                }
            }
        });
    }

    public List<Teman> getAllTeman(){
        RealmResults<Teman> results = realm.where(Teman.class).findAll();
        return results;
    }

    public void update(final Integer id, final String nim, final String nama,
                       final String kelas, final String email, final String sosmed, final String telp){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Teman model = realm.where(Teman.class)
                        .equalTo("id", id)
                        .findFirst();
                model.setNim(nim);
                model.setNama(nama);
                model.setKelas(kelas);
                model.setEmail(email);
                model.setSosmed(sosmed);
                model.setTelp(telp);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.e("ppp", "on Succes : Update Success");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                error.printStackTrace();
            }
        });
    }

    public void delete(Integer id){
        final RealmResults<Teman> model = realm.where(Teman.class).equalTo("id", id).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                model.deleteFromRealm(0);
            }
        });
    }
}
