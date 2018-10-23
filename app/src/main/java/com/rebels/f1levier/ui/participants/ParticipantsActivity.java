package com.rebels.f1levier.ui.participants;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.rebels.f1levier.R;
import com.rebels.f1levier.model.Participant;
import com.rebels.f1levier.repository.ParticipantRepository;

import java.util.ArrayList;

import io.realm.Realm;

public class ParticipantsActivity extends AppCompatActivity {

    private InteractionListener mListener;

    private Realm mRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participants);

        mListener = new ParticipantsListener(this);

        mRealm  = Realm.getDefaultInstance();
        ParticipantRepository mRepository = new ParticipantRepository(mRealm);

        // Set the layout and the adapter
        RecyclerView mRecyclerView = findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        final ParticipantsRecyclerViewAdapter adapter = new ParticipantsRecyclerViewAdapter(mRepository.getAll(), mListener);
        mRecyclerView.setAdapter(adapter);

        // Set the divider
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        // Set the fab listener
        FloatingActionButton fabNext= findViewById(R.id.fab_next);
        fabNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onNextClicked(adapter.getCheckedParticipantsIds());
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_participants, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_new_participant:
                mListener.onAddClicked();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mRealm.close();
    }

    public interface InteractionListener {
        void onItemClicked(Participant participant);
        void onAddClicked();
        void onNextClicked(final ArrayList<String> checkedParticipantsIds);
    }

}
