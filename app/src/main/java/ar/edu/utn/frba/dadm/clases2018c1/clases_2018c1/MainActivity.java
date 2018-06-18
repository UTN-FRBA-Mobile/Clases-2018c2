package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements MainContract.View {

    @Inject MainContract.Presenter presenter;
    private ProgressDialog progressDialog;

    @BindView(R.id.text_view) TextView textView;
    @BindView(R.id.text_view_title) TextView textViewTitle;
    @BindView(R.id.text_view_description) TextView textViewDescription;
    @BindView(R.id.image_view) ImageView imageView;
    @BindView(R.id.edit_text_name) EditText nameEditText;
    @BindView(R.id.button_send) Button sendButton;
    @BindView(R.id.button_name) Button nameButton;
    @BindView(R.id.progress_bar) ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerMainComponent.builder()
                .damApplicationComponent(DamApplication.getComponent())
                .mainModule(new MainModule(this))
                .build()
                .inject(this);


        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        progress(false);
    }

    @Override
    public void showGreeting(String name) {
        textView.setText(getString(R.string.hello,  name));
    }

    @Override
    public void showVideo(String name, String description, String preview) {
        textViewTitle.setText(name);
        textViewDescription.setText(description);
        Picasso.get().load(preview).into(imageView);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void progress(boolean isShow) {
        if (isShow) {
            sendButton.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        }
        else {
            sendButton.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.button_send)
    void onSendClick(){
        presenter.loadVideo();
    }

    @OnClick(R.id.button_name)
    void onNameClicl(){
        presenter.sayHi(nameEditText.getText().toString());
    }
}
