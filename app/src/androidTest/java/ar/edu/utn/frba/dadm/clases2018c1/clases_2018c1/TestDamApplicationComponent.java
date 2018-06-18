package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DamApplicationModule.class)
public interface TestDamApplicationComponent extends DamApplicationComponent {
    void inject(MainActivityTest mainActivityTest);


}
