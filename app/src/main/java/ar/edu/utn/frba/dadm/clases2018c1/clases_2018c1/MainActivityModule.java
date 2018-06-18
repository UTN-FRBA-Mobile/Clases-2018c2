package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    private MainActivity mainActivity;

    MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @ActivityScoped
    MainActivityContract.Presenter provideMainActivityPresenter() {
        return new MainActivityPresenter(mainActivity);

    }
}
