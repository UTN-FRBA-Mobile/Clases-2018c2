package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;

import android.support.annotation.NonNull;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    MainActivityContract.View mainActivity;

    public MainActivityPresenter(@NonNull MainActivityContract.View mainActivity){
        this.mainActivity = mainActivity;
    }

    @Override
    public void loadData() {
        mainActivity.initView("Guille");
    }
}
