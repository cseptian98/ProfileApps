package presenter;

import model.Teman;
import view.ViewTambahTeman;

//5-8-2019, 10116333, CHANDRA SEPTIAN, IF - 8

public class PresenterTambahTeman {

    private ViewTambahTeman view;

    public PresenterTambahTeman(ViewTambahTeman view){
        this.view = view;
    }

    public void tambahTeman(Teman teman){
        view.saveData(teman);
    }
}
