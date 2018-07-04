package com.exam.gallardomarinjoseezequielspacemission.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by J. Ezequiel Gallardo on 3/7/2018
 */

public class MarsPhotosList {

    @SerializedName("photos")
    private ArrayList<MarsPhotos> marsPhotosList;

    public ArrayList<MarsPhotos> getMarsPhotosList(){
        return marsPhotosList;
    }

    public void setMarsPhotosList(ArrayList<MarsPhotos> marsPhotosList){
        this.marsPhotosList = marsPhotosList;
    }
}
