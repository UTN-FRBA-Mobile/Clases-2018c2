package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;

import android.content.Intent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import javax.inject.Inject;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    public void sayHi(){
        String name = "Guille";

        presenter.sayHi(name);
        verify(view).showGreeting(name);
    }

    @Test//(timeout = 10000)
    public void loadVideo(){
        final Video video = new Video("description", 0d, 0d, "name", "");

        when(videoService.getVideo(any(DamCallback.class))).thenAnswer(invocation -> {
            ((DamCallback) invocation.getArguments()[0]).onSuccess(video);
            return true;
        });

        presenter.loadVideo();
        verify(view).showVideo(eq(video.getName()), eq(video.getDescription()), eq(video.getPreview()));
    }

}
