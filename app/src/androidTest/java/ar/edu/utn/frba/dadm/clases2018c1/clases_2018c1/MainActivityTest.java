package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;

import android.content.Intent;

import org.junit.Test;

import javax.inject.Inject;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class MainActivityTest extends BaseActivityTest<MainActivity> {

    @Inject VideoService videoService;

    @Override
    public void setUp() {
        super.setUp();
        component.inject(this);
    }

    @Test(timeout = 10000)
    public void layout(){
        launchActivity(new Intent());
        onView(withId(R.id.button_send)).check(matches(isDisplayed()));
        onView(withId(R.id.progress_bar)).check(matches(not(isDisplayed())));
        onView(withText(R.string.whats_your_name)).check(matches(isDisplayed()));
    }


    @Test(timeout = 10000)
    public void sayHi(){
        String name = "pepe";
        launchActivity(new Intent());
        onView(withId(R.id.edit_text_name)).perform(typeText(name));
        onView(withId(R.id.button_name)).perform(click());

        onView(withId(R.id.text_view)).check(matches(withText(activity.getString(R.string.hello, name))));
    }


    @Test//(timeout = 10000)
    public void service(){
        launchActivity(new Intent());
        final Video video = new Video("description", 0d, 0d, "name", "");

        when(videoService.getVideo(any(DamCallback.class))).thenAnswer(invocation -> {
            ((DamCallback) invocation.getArguments()[0]).onSuccess(video);
            return true;
        });

        onView(withId(R.id.button_send)).perform(click());

        onView(withId(R.id.text_view_title)).check(matches(withText(video.getName())));
        onView(withId(R.id.text_view_description)).check(matches(withText(video.getDescription())));
    }


}
