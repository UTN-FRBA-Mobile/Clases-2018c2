package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class MainActivityPresenterTest extends BaseUnitTest {

    @Mock private MainActivityContract.View view;

    private MainActivityContract.Presenter presenter;

    @Before
    public void setUp() {
        super.setUp();
        component.inject(this);
        createPresenter();
    }

    private void createPresenter() {
        presenter = new MainActivityPresenter(view);
    }

    @Test
    public void init(){
        presenter.loadData();
        verify(view).initView("Guille");
    }

}
