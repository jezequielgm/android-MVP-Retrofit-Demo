package com.exam.gallardomarinjoseezequielspacemission.main;

import com.exam.gallardomarinjoseezequielspacemission.model.MarsPhotos;

import java.util.ArrayList;

/**
 * Created by J. Ezequiel Gallardo on 3/7/2018
 */

public class MainPresenterImpl implements MainContract.Presenter, MainContract.Intractor.OnFinishedListener {

    private MainContract.MainView mainView;
    private MainContract.Intractor intractor;

    public MainPresenterImpl(MainContract.MainView mainView, MainContract.Intractor intractor){
        this.mainView = mainView;
        this.intractor = intractor;
    }


    @Override
    public void onDestroy() {
        this.mainView = null;
    }

    @Override
    public void requestDataFromServer() {
        intractor.getMarsPhotosArrayList(this);
    }

    @Override
    public void onFinished(ArrayList<MarsPhotos> marsPhotosArrayList) {
        if(this.mainView != null){
            mainView.setDataToRecyclerView(marsPhotosArrayList);
            mainView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if(this.mainView != null){
            mainView.onResponseFailure(t);
            mainView.hideProgress();
        }
    }
}
