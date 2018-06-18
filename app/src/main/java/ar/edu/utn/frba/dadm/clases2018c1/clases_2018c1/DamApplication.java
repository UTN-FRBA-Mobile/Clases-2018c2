package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;

import android.app.Application;

public class DamApplication extends Application{

    public static DamApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = createComponent();
        component.inject(this);
    }

    private DamApplicationComponent createComponent() {
        return DaggerDamApplicationComponent.builder()
                .damApplicationModule(new DamApplicationModule())
                .build();
    }

    public static DamApplicationComponent getComponent() {
        return component;
    }
}
