package com.rebels.f1levier.ui.participants;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.rebels.f1levier.R;
import com.rebels.f1levier.model.Level;
import com.rebels.f1levier.model.Participant;
import com.rebels.f1levier.repository.LevelRepository;
import com.rebels.f1levier.repository.ParticipantRepository;

import java.util.List;
import java.util.Objects;

import io.realm.Realm;

public class NewParticipantDialog extends AppCompatDialogFragment {

    private EditText editTextName;
    private Spinner spinnerLevel;

    private Realm mRealm;
    private ParticipantRepository mRepository;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRealm = Realm.getDefaultInstance();
        mRepository = new ParticipantRepository(mRealm);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_participants_new, null);

        editTextName = view.findViewById(R.id.edit_text_participant_name);
        spinnerLevel = view.findViewById(R.id.spinner_participant_level);

        List<Level> levels = mRealm.copyFromRealm(new LevelRepository(mRealm).getAll());
        ArrayAdapter<Level> adapter = new ArrayAdapter<>(Objects.requireNonNull(getContext()), R.layout.support_simple_spinner_dropdown_item, levels);
        spinnerLevel.setAdapter(adapter);

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
                        final String participantName = editTextName.getText().toString().trim();
                        final Level participantLevel = (Level) spinnerLevel.getSelectedItem();

                        // TODO : Validate form

                        mRepository.add(new Participant(participantName, participantLevel));
                    }
                });

        return builder.create();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mRealm.close();
    }
}
