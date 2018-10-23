package com.rebels.f1levier.ui.participants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.rebels.f1levier.R;
import com.rebels.f1levier.model.Participant;
import com.rebels.f1levier.ui.run.RunActivity;

import java.util.ArrayList;

public class ParticipantsListener implements ParticipantsActivity.InteractionListener {

    private AppCompatActivity mActivity;

    ParticipantsListener(AppCompatActivity activity) {
        mActivity = activity;
    }

    @Override
    public void onItemClicked(Participant participant) {
        participant.setChecked(!participant.isChecked());
    }

    @Override
    public void onAddClicked() {
        NewParticipantDialog newParticipantDialog = new NewParticipantDialog();
        newParticipantDialog.show(mActivity.getSupportFragmentManager(), null);
    }

    @Override
    public void onNextClicked(final ArrayList<String> checkedParticipantsIds) {
        if (checkedParticipantsIds.isEmpty()) {
            Toast toast = Toast.makeText(mActivity, R.string.pick_minimum_participants, Toast.LENGTH_LONG);
            toast.show();
        }
        else {
            Intent newRunIntent = new Intent(mActivity, RunActivity.class);
            newRunIntent.putStringArrayListExtra("checkedParticipantsIds", checkedParticipantsIds);
            mActivity.startActivity(newRunIntent);
        }
    }
}
