package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;

import dagger.Component;

@ActivityScoped
@Component(dependencies = DamApplicationComponent.class, modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}