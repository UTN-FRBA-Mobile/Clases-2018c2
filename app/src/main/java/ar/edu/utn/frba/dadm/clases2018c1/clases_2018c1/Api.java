package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("Videos/-KlfO-2-3Z_uhQa8Q1Pd.json")
    Call<Video> getVideo();
}
