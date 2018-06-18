package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.squareup.picasso.Picasso;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

import java.lang.reflect.ParameterizedType;

import javax.inject.Singleton;

import dagger.Provides;
import okhttp3.OkHttpClient;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(AndroidJUnit4.class)
public abstract class BaseActivityTest<T extends Activity> {

    protected Instrumentation instrumentation;
    protected T activity;
    private Class<T> activityClass;

    protected TestDamApplicationComponent component;

    @Rule
    public IntentsTestRule<T> activityTestRule = new IntentsTestRule<>(getActivityClass(), true, false);

    protected Class<T> getActivityClass() {
        if (activityClass == null) {
            activityClass = ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        }
        return activityClass;
    }

    /**
     * Subclasses that need to do setUp should override internalSetup.
     * That is where Dagger inject call should be made.
     */
    @Before
    public void setUp() {
        instrumentation = InstrumentationRegistry.getInstrumentation();

        component = DaggerTestDamApplicationComponent.builder()
                .damApplicationModule(new TestDamApplicationModule())
                .build();

        DamApplication.setComponent(component);

    }

    /**
     * Subclasses that need to do cleanup should override internalCleanUp
     */
    @After
    public final void cleanUp() {

    }

    public void launchActivity(Intent intent) {
        activity = activityTestRule.launchActivity(intent);
    }
}
