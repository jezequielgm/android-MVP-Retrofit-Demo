package com.exam.gallardomarinjoseezequielspacemission.main;

import com.exam.gallardomarinjoseezequielspacemission.model.MarsPhotos;

import java.util.ArrayList;

/**
 * Created by J. Ezequiel Gallardo on 3/7/2018
 */

public interface MainContract {

    /**
     * Call when user interacts with the view and other when view OnDestroy()
     * */
    interface Presenter{

        void onDestroy();

        void onRefreshButtonClick();

        void requestDataFromServer();

    }

    /**
     * showProgress() and hideProgress() would be used for displaying and hiding the progressBar
     * while the setDataToRecyclerView and onResponseFailure is fetched from the GetNoticeInteractorImpl class
     **/
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
