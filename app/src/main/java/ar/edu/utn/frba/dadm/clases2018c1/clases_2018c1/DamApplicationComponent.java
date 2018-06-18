package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;

import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = DamApplicationModule.class)
@Singleton
public interface DamApplicationComponent {

    VideoService getVideoService();

    Picasso getPicasso();
    void inject (DamApplication damApplication);

}
