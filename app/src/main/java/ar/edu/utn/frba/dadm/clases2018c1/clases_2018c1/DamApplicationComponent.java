package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = DamApplicationModule.class)
@Singleton
public interface DamApplicationComponent {

    VideoService getVideoService();

    void inject (DamApplication damApplication);

}
