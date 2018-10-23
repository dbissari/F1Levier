package com.rebels.f1levier.ui.runs;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;

import com.rebels.f1levier.ui.participants.ParticipantsActivity;

public class RunsListener implements RunsFragment.FragmentInteractionListener {

    private FragmentActivity mActivity;

    RunsListener(FragmentActivity activity) {
        mActivity = activity;
    }

    @Override
    public void onButtonNewRunClicked() {
        Intent newRunIntent = new Intent(mActivity, ParticipantsActivity.class);
        mActivity.startActivity(newRunIntent);
    }

}
