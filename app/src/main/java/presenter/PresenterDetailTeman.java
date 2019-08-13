package presenter;

import view.ViewDetailTeman;

//5-8-2019, 10116333, CHANDRA SEPTIAN, IF - 8

public class PresenterDetailTeman {
    private ViewDetailTeman view;

    public PresenterDetailTeman(ViewDetailTeman view) {
        this.view = view;
    }

    public void doCall() {
        view.doCall();
    }

    public void sendEmail() {
        view.sendEmail();
    }

    public void openInstagram() {
        view.openInstagram();
    }
}
