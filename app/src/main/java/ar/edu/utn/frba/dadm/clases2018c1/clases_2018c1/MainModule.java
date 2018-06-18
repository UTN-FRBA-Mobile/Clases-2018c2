package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    private MainActivity mainActivity;

    MainModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @ActivityScoped
    MainContract.Presenter provideMainActivityPresenter(@NonNull VideoService videoService) {
        return new MainPresenter(mainActivity, videoService);

    }
}
