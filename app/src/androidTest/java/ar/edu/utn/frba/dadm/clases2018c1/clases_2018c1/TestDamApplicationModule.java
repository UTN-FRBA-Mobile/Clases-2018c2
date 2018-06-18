package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;


import android.content.Context;
import android.support.annotation.NonNull;

import com.squareup.picasso.Picasso;

import org.mockito.Mockito;

public class TestDamApplicationModule extends DamApplicationModule {

    @Override
    public VideoService provideVideoService() {
        return Mockito.mock(VideoService.class);
    }

    @Override
    public Picasso providePicasso() {
        return Mockito.mock(Picasso.class);
    }

}
