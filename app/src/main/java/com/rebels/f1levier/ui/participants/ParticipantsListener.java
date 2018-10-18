package com.rebels.f1levier.ui.participants;

import android.support.v4.app.FragmentActivity;

import com.rebels.f1levier.model.Participant;

public class ParticipantsListener implements ParticipantsFragment.FragmentInteractionListener {

    private FragmentActivity mActivity;

    ParticipantsListener(FragmentActivity activity) {
        mActivity = activity;
    }

    @Override
    public void onItemClicked(Participant participant) {

    }

    @Override
    public void onFabClicked() {
        NewParticipantDialog newParticipantDialog = new NewParticipantDialog();
        newParticipantDialog.show(mActivity.getSupportFragmentManager(), null);
    }
}
