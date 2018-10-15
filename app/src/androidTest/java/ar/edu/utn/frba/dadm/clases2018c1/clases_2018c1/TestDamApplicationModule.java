package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class TestDamApplicationModule extends DamApplicationModule {

    @Override
    public VideoService provideVideoService() {
        return Mockito.mock(VideoService.class);
    }

    @Override
    public Picasso providePicasso() {
        Picasso picasso = Mockito.mock(Picasso.class);

        RequestCreator requestCreator = Mockito.mock(RequestCreator.class);
        when(requestCreator.placeholder(anyInt())).thenReturn(requestCreator);
        when(requestCreator.placeholder(any(Drawable.class))).thenReturn(requestCreator);
        when(requestCreator.error(anyInt())).thenReturn(requestCreator);
        when(requestCreator.error(any(Drawable.class))).thenReturn(requestCreator);
        when(requestCreator.resize(anyInt(), anyInt())).thenReturn(requestCreator);
        when(requestCreator.memoryPolicy(any(MemoryPolicy.class))).thenReturn(requestCreator);
        when(requestCreator.networkPolicy(any(NetworkPolicy.class))).thenReturn(requestCreator);

        when(picasso.load(anyInt())).thenReturn(requestCreator);
        when(picasso.load(anyString())).thenReturn(requestCreator);
        when(picasso.load((String) eq(null))).thenReturn(requestCreator);
        return picasso;
    }

}
