package com.exam.gallardomarinjoseezequielspacemission.network;

import com.exam.gallardomarinjoseezequielspacemission.model.MarsPhotosList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by J. Ezequiel Gallardo on 3/7/2018
 */

public interface MarsPhotosDataService {

    @GET("mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY")
    Call<MarsPhotosList> getMarsPhotoListCall();
}
