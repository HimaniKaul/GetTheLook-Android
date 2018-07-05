package com.example.admin.designandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class BodyFragment extends Fragment {

    public static String ImageIdList="image id";
    public static String ListIndex="list_index";


    private List<Integer> mImageId;
    private int mListIndex;

    //instantiating the constructor

    public BodyFragment(){}

    //inflating the fragment layout and set any image resource

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInst)
    {
        if(savedInst!=null)
        {
            mImageId=savedInst.getIntegerArrayList(ImageIdList);
            mListIndex=savedInst.getInt(ListIndex);

        }


        View rootview=inflater.inflate(R.layout.fragment_body, container, false);
        final ImageView imageView=(ImageView) rootview.findViewById(R.id.body_body);
        if(mImageId!=null)
        {
            imageView.setImageResource(mImageId.get(mListIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (mListIndex < mImageId.size() - 1) {
                        mListIndex++;
                    }
                    else {
                        mListIndex=0;
                    }
                    imageView.setImageResource(mImageId.get(mListIndex));
                }
            });


        }

        //return root view
        return rootview;

    }

    public void setImageId(List<Integer> imageId)
    {
        mImageId=imageId;
    }
    public void setListIndex(int index)
    {
        mListIndex=index;
    }

    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putIntegerArrayList(ImageIdList,(ArrayList<Integer>) mImageId);
        currentState.putInt(ListIndex,mListIndex);

    }
}
