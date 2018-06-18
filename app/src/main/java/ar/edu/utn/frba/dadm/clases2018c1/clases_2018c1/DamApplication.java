package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;

import android.app.Application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DamApplication extends Application{

    public static DamApplicationComponent component;
    private static Api api;

    @Override
    public void onCreate() {
        super.onCreate();
        component = createComponent();
        component.inject(this);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://geoscene-c3d56.firebaseio.com/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()))
                .build();

        api = retrofit.create(Api.class);
    }

    private DamApplicationComponent createComponent() {
        final DamApplicationComponent component = DaggerDamApplicationComponent.builder()
                .damApplicationModule(new DamApplicationModule())
                .build();
        component.inject(this);

        return component;
    }

    public static DamApplicationComponent getComponent() {
        return component;
    }

    public static Api getApi() {
        return api;
    }
}
