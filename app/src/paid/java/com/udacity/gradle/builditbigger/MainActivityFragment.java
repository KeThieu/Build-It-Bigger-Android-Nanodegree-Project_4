package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import com.udacity.gradle.builditbigger.JokeSmith;
import com.udacity.gradle.builditbigger.jokedisplay.JokeActivity;

public class MainActivityFragment extends Fragment implements EndpointsAsyncTask.mCallback{

    private ProgressBar mProgressBar;
    public MainActivityFragment() {
    }

    public void getJokeFromTask() {
        Context context = getActivity();
        new EndpointsAsyncTask(this).execute(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mProgressBar = (ProgressBar) root.findViewById(R.id.loading_spinner);
        Button jokeButton = (Button) root.findViewById(R.id.joke_telling_button);
        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start AsyncTask to get the Joke
                mProgressBar.setVisibility(View.VISIBLE);
                getJokeFromTask();
            }
        });

        return root;
    }

    public void onCallbackResult(String result) {
        //retrievedJoke = result;
        Intent sendIntent = new Intent(getActivity(), JokeActivity.class);
        sendIntent.putExtra(JokeActivity.TAG, result);
        mProgressBar.setVisibility(View.INVISIBLE);
        startActivity(sendIntent);
    }
}
