package com.exam.gallardomarinjoseezequielspacemission.main;

import com.exam.gallardomarinjoseezequielspacemission.model.MarsPhotos;

import java.util.ArrayList;

/**
 * Created by J. Ezequiel Gallardo on 3/7/2018
 */

public interface MainContract {

    interface Presenter{

        void onDestroy();

        void requestDataFromServer();

    }

    interface MainView {

        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(ArrayList<MarsPhotos> noticeArrayList);

        void onResponseFailure(Throwable throwable);

    }

    /**
     * This is for fetching data from data source.
     **/
    interface Intractor {

        interface OnFinishedListener {
            void onFinished(ArrayList<MarsPhotos> marsPhotosArrayList);
            void onFailure(Throwable t);
        }

        void getMarsPhotosArrayList(OnFinishedListener onFinishedListener);
    }
}
