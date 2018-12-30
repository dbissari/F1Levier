package com.rebels.f1levier.ui.team;

import android.app.AlertDialog;
import android.app.Dialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.rebels.f1levier.R;
import com.rebels.f1levier.db.entity.Team;
import com.rebels.f1levier.viewmodel.TeamViewModel;

import java.lang.ref.WeakReference;
import java.util.Objects;

public class NewTeamDialog extends AppCompatDialogFragment {

    private static final String ARG_RACE_ID = "race-id";

    private EditText nameEditText;
    private TeamViewModel teamViewModel;
    private int raceId = -1;

    public NewTeamDialog() {
    }

    @SuppressWarnings("unused")
    public static NewTeamDialog newInstance(int raceId) {
        NewTeamDialog fragment = new NewTeamDialog();
        Bundle args = new Bundle();
        args.putInt(ARG_RACE_ID, raceId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            raceId = getArguments().getInt(ARG_RACE_ID);
        }

        if (raceId == -1) {
            dismiss();
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_new_team, null);

        nameEditText = view.findViewById(R.id.edit_text_team_name);

        teamViewModel = ViewModelProviders.of(this).get(TeamViewModel.class);

        builder.setView(view)
                .setTitle(R.string.title_new_team)
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton(R.string.submit, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Team team = new Team(nameEditText.getText().toString().trim(), raceId);

                        // TODO : Validate form

                        TeamInsertAsyncTack asyncTack = new TeamInsertAsyncTack(teamViewModel,
                                getContext());
                        asyncTack.execute(team);
                    }
                });

        return builder.create();
    }

    private static class TeamInsertAsyncTack extends AsyncTask<Team, Void, Long> {

        private TeamViewModel teamViewModel;

        private WeakReference<Context> contextWeakReference;

        TeamInsertAsyncTack(TeamViewModel teamViewModel, Context context) {
            this.teamViewModel = teamViewModel;
            this.contextWeakReference = new WeakReference<>(context);
        }

        @Override
        protected Long doInBackground(Team... params) {
            return teamViewModel.insertSync(params[0]);
        }

        @Override
        protected void onPostExecute(Long id) {
            Context context = contextWeakReference.get();
            if (context != null) {
                // TODO : Start a new team members selection dialog
            }
            else {
                // TODO : Find a way to resolve the context reference lost problem
            }
        }
    }
}
