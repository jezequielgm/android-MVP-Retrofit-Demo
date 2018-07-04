package com.exam.gallardomarinjoseezequielspacemission.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.exam.gallardomarinjoseezequielspacemission.R;
import com.exam.gallardomarinjoseezequielspacemission.main.RecyclerItemClickListener;
import com.exam.gallardomarinjoseezequielspacemission.model.MarsPhotos;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by J. Ezequiel Gallardo on 3/7/2018
 */

public class MarsPhotosAdapter extends RecyclerView.Adapter<MarsPhotosAdapter.MarsPhotosViewHolder>{

    private ArrayList<MarsPhotos> marsPhotosArrayList;
    private RecyclerItemClickListener recyclerItemClickListener;

    public MarsPhotosAdapter(ArrayList<MarsPhotos> marsPhotosArrayList, RecyclerItemClickListener recyclerItemClickListener ){
        this.marsPhotosArrayList = marsPhotosArrayList;
        this.recyclerItemClickListener = recyclerItemClickListener;
    }

    @Override
    public MarsPhotosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_mars_photo, parent, false);
        return new MarsPhotosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MarsPhotosAdapter.MarsPhotosViewHolder holder, int position) {
        holder.textViewEarthDate.setText(marsPhotosArrayList.get(position).getEarthDate());
        holder.textViewCameraFullName.setText(marsPhotosArrayList.get(position).getCamera());
        Picasso.get()
                .load(marsPhotosArrayList.get(position).getImgSrc())
                .into(holder.imageViewMarsPhoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerItemClickListener.onItemClick(holder.imageViewMarsPhoto);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(marsPhotosArrayList != null)
            return marsPhotosArrayList.size();
        else
            return 0;
    }

    class MarsPhotosViewHolder extends RecyclerView.ViewHolder{
        TextView textViewEarthDate, textViewCameraFullName;
        ImageView imageViewMarsPhoto;

        MarsPhotosViewHolder(View view){
            super(view);
            textViewEarthDate = view.findViewById(R.id.textViewEarthDate);
            textViewCameraFullName = view.findViewById(R.id.textViewCameraFullName);
            imageViewMarsPhoto = view.findViewById(R.id.imageViewMarsPhoto);
        }
    }

}
