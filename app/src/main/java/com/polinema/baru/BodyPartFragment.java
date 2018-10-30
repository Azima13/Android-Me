package com.polinema.baru;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {
    //membuat variabel TAG
    public static  final String IMAGE_ID_LIST= "image_ids";
    public static final String LIST_INDEX = "list_index";
    private static final String TAG = "BodyPartFragment";
    private List<Integer> mImageIds;
    private int mListIndex;
    public BodyPartFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //membuat setting proses
        if(savedInstanceState != null){
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        //inisialisasi layout fragment
        View rootView = inflater.inflate(R.layout.body_part_layout_fragment, container, false);
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.imageview_body_part_layout_fragment);


        if(mImageIds != null){
            imageView.setImageResource(mImageIds.get(mListIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override

                //mengubah gambar untuk mengubah image kepala, body dan kaki
                public void onClick(View view) {
                    if(mListIndex < mImageIds.size()-1){
                        mListIndex++;
                    }else {
                        mListIndex = 0;
                    }
                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            });
        } else {
            Log.v(TAG, "This fragment has a null list of image id's");
        }
        return rootView;
    }

    //membuat setter untuk gambar kaki, badan dan kaki
    public  void  setmImageIds(List<Integer> imageIds){
        mImageIds = imageIds;
    }


    public void setmListIndex(int index){
        mListIndex = index;
    }

    //membaut method untuk mengabil image dari asset image dalam berbentuk array
    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
        currentState.putInt(LIST_INDEX,mListIndex);
    }
}
