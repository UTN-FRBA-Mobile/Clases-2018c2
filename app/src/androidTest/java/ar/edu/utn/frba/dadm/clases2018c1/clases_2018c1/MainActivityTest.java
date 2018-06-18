package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;

import android.content.Intent;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest extends BaseActivityTest<MainActivity> {

    @Override
    public void setUp() {
        super.setUp();
        component.inject(this);
    }

    @Test(timeout = 10000)
    public void layout(){
        launchActivity(new Intent());
        onView(withId(R.id.text_view)).check(matches(withText("Guille")));
    }

}
