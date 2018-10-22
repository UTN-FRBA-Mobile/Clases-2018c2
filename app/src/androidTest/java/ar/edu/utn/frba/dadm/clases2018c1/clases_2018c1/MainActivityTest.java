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

    }

    @Test(timeout = 10000)
    public void sayHi(){

    }


    @Test(timeout = 10000)
    public void service(){

    }
}