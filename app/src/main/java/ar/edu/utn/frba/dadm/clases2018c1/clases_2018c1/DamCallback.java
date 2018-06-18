package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class DamCallback<T> implements Callback<T> {

    public abstract void onSuccess(T response);
    public abstract void onError(String message);
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            onSuccess(response.body());
        }
        else {
            onError("Error!");
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onError("Error!");
    }
}
