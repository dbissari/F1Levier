package com.rebels.f1levier.ui.race;

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
import android.widget.Toast;

import com.rebels.f1levier.R;
import com.rebels.f1levier.db.entity.Race;
import com.rebels.f1levier.viewmodel.RaceViewModel;

import java.lang.ref.WeakReference;
import java.util.Objects;

public class NewRaceDialog extends AppCompatDialogFragment {
    private EditText nameEditText;
    private RaceViewModel raceViewModel;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_new_race, null);

        nameEditText = view.findViewById(R.id.edit_text_race_name);

        raceViewModel = ViewModelProviders.of(this).get(RaceViewModel.class);

        builder.setView(view)
                .setTitle(R.string.title_new_participant)
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton(R.string.submit, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Race race = new Race(nameEditText.getText().toString().trim());

                        // TODO : Validate form

                        RaceInsertAsyncTack asyncTask = new RaceInsertAsyncTack(raceViewModel, getContext());
                        asyncTask.execute(race);
                    }
                });

        return builder.create();
    }

    private static class RaceInsertAsyncTack extends AsyncTask<Race, Void, Long> {

        private RaceViewModel raceViewModel;

        private WeakReference<Context> context;

        RaceInsertAsyncTack(RaceViewModel raceViewModel, Context context) {
            this.raceViewModel = raceViewModel;
            this.context = new WeakReference<>(context);
        }

        @Override
        protected Long doInBackground(Race... params) {
            return raceViewModel.insertSync(params[0]);
        }

        @Override
        protected void onPostExecute(Long id) {
            Toast.makeText(context.get(), id.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
