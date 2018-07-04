package com.exam.gallardomarinjoseezequielspacemission.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by J. Ezequiel Gallardo on 3/7/2018
 */

public class RetrofitInstance {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api.nasa.gov/";

    //If null creates an instance else returns the existing instance
    //This prevents redundant instances
    public static Retrofit getRetrofitInstance(){

        if(retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }


}
