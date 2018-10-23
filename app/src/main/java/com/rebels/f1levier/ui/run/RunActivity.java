package com.rebels.f1levier.ui.run;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rebels.f1levier.R;
import com.rebels.f1levier.model.Participant;
import com.rebels.f1levier.repository.ParticipantRepository;

import java.util.List;

import io.realm.Realm;

public class RunActivity extends AppCompatActivity {

    private Realm mRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run);

        mRealm  = Realm.getDefaultInstance();

        final List<String> participantsIdsArrayList = getIntent()
                .getStringArrayListExtra("checkedParticipantsIds");
        String[] participantsIdsArray = new String[participantsIdsArrayList.size()];
        participantsIdsArray = participantsIdsArrayList.toArray(participantsIdsArray);
        List<Participant> participants  = mRealm
                .copyFromRealm(new ParticipantRepository(mRealm)
                .getAllByIds(participantsIdsArray));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mRealm.close();
    }
}
