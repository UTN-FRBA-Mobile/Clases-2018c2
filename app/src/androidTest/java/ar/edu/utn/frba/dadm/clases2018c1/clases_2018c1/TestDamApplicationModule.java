package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;


import org.mockito.Mockito;

public class TestDamApplicationModule extends DamApplicationModule {

    @Override
    public VideoService provideVideoService() {
        return Mockito.mock(VideoService.class);
    }
}
