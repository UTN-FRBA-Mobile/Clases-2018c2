package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    @Inject MainActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerMainActivityComponent.builder()
                .damApplicationComponent(DamApplication.getComponent())
                .mainActivityModule(new MainActivityModule(this))
                .build()
                .inject(this);

        setContentView(R.layout.activity_main);
        presenter.loadData();
    }

    @Override
    public void initView(String name) {
        ((TextView)findViewById(R.id.text_view)).setText(name);
    }
}
