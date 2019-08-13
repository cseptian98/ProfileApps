package model;

//5-8-2019, 10116333, CHANDRA SEPTIAN, IF - 8


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Teman extends RealmObject {

    @PrimaryKey
    private Integer id;

    private String nim, nama, kelas, email, sosmed, telp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSosmed() {
        return sosmed;
    }

    public void setSosmed(String sosmed) {
        this.sosmed = sosmed;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

}
