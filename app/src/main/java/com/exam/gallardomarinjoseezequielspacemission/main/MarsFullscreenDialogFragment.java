package com.exam.gallardomarinjoseezequielspacemission.main;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.exam.gallardomarinjoseezequielspacemission.R;
import com.squareup.picasso.Picasso;

public class MarsFullscreenDialogFragment extends DialogFragment{
    String imgSrc;

    static MarsFullscreenDialogFragment newInstance(String imgSrc){
        MarsFullscreenDialogFragment  marsFullscreenDialogFragment = new MarsFullscreenDialogFragment();

        Bundle args = new Bundle();
        args.putString("img_src", imgSrc);
        marsFullscreenDialogFragment.setArguments(args);

        return marsFullscreenDialogFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         imgSrc = getArguments().getString("img_src");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_fragment_picture_fullscreen, container, false);

        final ImageView imageViewFullscreen = v.findViewById(R.id.imageViewFullscreen);

        if(imgSrc != null)
            Picasso.get().load(imgSrc).into(imageViewFullscreen);

        return v;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);

        // request a window without the title
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }
}
