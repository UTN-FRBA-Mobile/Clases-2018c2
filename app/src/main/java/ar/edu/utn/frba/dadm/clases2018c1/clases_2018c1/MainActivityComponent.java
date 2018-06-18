package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;

import dagger.Component;

@ActivityScoped
@Component(dependencies = DamApplicationComponent.class, modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}