package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;

import javax.inject.Inject;

public class VideoService {

    @Inject DamApplication application;

    public VideoService() {
    }

    public boolean getVideo(DamCallback<Video> callback){
        application.getApi().getVideo().enqueue(callback);
        return true;
    }
}
