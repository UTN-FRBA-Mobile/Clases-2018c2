package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;

import android.support.annotation.NonNull;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private final VideoService videoService;

    public MainPresenter(@NonNull MainContract.View view, VideoService videoService){
        this.view = view;
        this.videoService = videoService;
    }

    @Override
    public void loadVideo() {
        view.progress(true);
        videoService.getVideo(new DamCallback<Video>() {
            @Override
            public void onSuccess(Video response) {
                view.progress(false);
                view.showVideo(response.getName(), response.getDescription(), response.getPreview());
            }

            @Override
            public void onError(String message) {
                view.progress(false);
                view.showError(message);
            }
        });
    }

    public void sayHi(String name) {
        view.showGreeting(name);
    }
}
