package com.exam.gallardomarinjoseezequielspacemission.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.exam.gallardomarinjoseezequielspacemission.R;
import com.exam.gallardomarinjoseezequielspacemission.adapter.MarsPhotosAdapter;
import com.exam.gallardomarinjoseezequielspacemission.model.MarsPhotos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainContract.MainView{

    private ProgressBar progressBar;
    private RecyclerView recyclerView;

    MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewAndToolbarInit();
        progressBarInit();

        presenter = new MainPresenterImpl(this, new IntractorImpl());
        presenter.requestDataFromServer();
    }


    private void recyclerViewAndToolbarInit(){
        recyclerView = this.findViewById(R.id.recyclerViewMarsPhoto);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void progressBarInit(){
        progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);

        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setGravity(Gravity.CENTER);
        relativeLayout.addView(progressBar);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        );

        progressBar.setVisibility(View.VISIBLE);

        this.addContentView(relativeLayout, params);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    private RecyclerItemClickListener recyclerItemClickListener = new RecyclerItemClickListener() {
        @Override
        public void onItemClick(ImageView marsPhoto) {

        }
    };

    @Override
    public void setDataToRecyclerView(ArrayList<MarsPhotos> marsPhotoArrayList) {
        MarsPhotosAdapter marsPhotosAdapter = new MarsPhotosAdapter(marsPhotoArrayList, recyclerItemClickListener);
        recyclerView.setAdapter(marsPhotosAdapter);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(MainActivity.this,
                "Connection Error" + throwable.getMessage(),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        presenter.onDestroy();
    }
}
