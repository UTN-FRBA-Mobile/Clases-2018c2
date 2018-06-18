package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DamApplicationModule {

    @Provides
    @Singleton
    public VideoService provideVideoService() {
        return new VideoService();
    }
}
