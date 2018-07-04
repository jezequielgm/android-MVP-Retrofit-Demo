package com.exam.gallardomarinjoseezequielspacemission.main;

import android.util.Log;

import com.exam.gallardomarinjoseezequielspacemission.model.MarsPhotosList;
import com.exam.gallardomarinjoseezequielspacemission.network.MarsPhotosDataService;
import com.exam.gallardomarinjoseezequielspacemission.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by J. Ezequiel Gallardo on 3/7/2018
 */

public class IntractorImpl implements MainContract.Intractor {
    @Override
    public void getMarsPhotosArrayList(final OnFinishedListener onFinishedListener) {

        MarsPhotosDataService dataService = RetrofitInstance.getRetrofitInstance().create(MarsPhotosDataService.class);

        Call<MarsPhotosList> marsPhotosListCall = dataService.getMarsPhotoListCall();
        String msg = marsPhotosListCall.request().url().toString();
        Log.d("Retrofit: ", msg);

        marsPhotosListCall.enqueue(new Callback<MarsPhotosList>() {
            @Override
            public void onResponse(Call<MarsPhotosList> call, Response<MarsPhotosList> response) {
                String msg = response.body().getMarsPhotosList().toString();
                Log.d("Retrofit body: ", msg);
                onFinishedListener.onFinished(response.body().getMarsPhotosList());

            }

            @Override
            public void onFailure(Call<MarsPhotosList> call, Throwable error) {
                Log.d("Retrofit: ", "Something went wrong");
                onFinishedListener.onFailure(error);

            }
        });
    }

}
