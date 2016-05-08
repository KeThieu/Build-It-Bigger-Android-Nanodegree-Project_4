package com.udacity.gradle.builditbigger.jokedisplay;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//for Ads from Google Play Services
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * A placeholder fragment containing a simple view.
 */
public class JokeActivityFragment extends Fragment {

    public JokeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_joke, container, false);
        Intent receivedIntent = getActivity().getIntent();
        if(receivedIntent != null) {
            String joke_message = receivedIntent.getStringExtra(JokeActivity.TAG);
            if(joke_message != null) {
                TextView jokeTextview = (TextView) root.findViewById(R.id.joke_display_textview);
                jokeTextview.setText(joke_message);
            }
        }

        return root;
    }
}
