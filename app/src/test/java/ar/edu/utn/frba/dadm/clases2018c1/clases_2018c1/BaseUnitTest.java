package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

public class BaseUnitTest {

    protected TestDamApplicationComponent component;


    @Before
    public void setUp() {
        component = DaggerTestDamApplicationComponent.builder()
                .damApplicationModule(new TestDamApplicationModule())
                .build();

        DamApplication.setComponent(component);

        MockitoAnnotations.initMocks(this);
    }


}
