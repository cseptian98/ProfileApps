package presenter;

import view.ViewTentang;

//5-8-2019, 10116333, CHANDRA SEPTIAN, IF - 8

public class PresenterAbout {
    private ViewTentang view;

    public PresenterAbout(ViewTentang view) {
        this.view = view;
    }

    public void selectionView(int tab) {
        if (tab == 0) {
            view.showInfo();
        } else {
            view.showAuthor();
        }
    }
}
