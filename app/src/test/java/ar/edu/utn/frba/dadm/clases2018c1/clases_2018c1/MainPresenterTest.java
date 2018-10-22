package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import javax.inject.Inject;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class MainPresenterTest extends BaseUnitTest {

    @Mock private MainContract.View view;
    @Inject VideoService videoService;

    private MainContract.Presenter presenter;

    @Before
    public void setUp() {
        super.setUp();
        component.inject(this);
        createPresenter();
    }

    private void createPresenter() {
        presenter = new MainPresenter(view, videoService);
    }

    @Test
    public void sayHi() {

    }

    @Test
    public void loadVideo(){

    }

}

