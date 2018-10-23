package com.rebels.f1levier.ui.levels;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.rebels.f1levier.R;
import com.rebels.f1levier.model.Level;
import com.rebels.f1levier.repository.LevelRepository;

import java.util.Objects;

import io.realm.Realm;

public class NewLevelDialog extends AppCompatDialogFragment {

    private EditText editTextName;
    private EditText editTextEchelon;

    private Realm mRealm;
    private LevelRepository mRepository;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRealm = Realm.getDefaultInstance();
        mRepository = new LevelRepository(mRealm);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_levels_new, null);

        editTextName = view.findViewById(R.id.edit_text_level_name);
        editTextEchelon = view.findViewById(R.id.edit_text_level_echelon);

        builder.setView(view)
                .setTitle(R.string.title_new_level)
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton(R.string.submit, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final String levelName = editTextName.getText().toString().trim();
                        final String levelEchelon = editTextEchelon.getText().toString().trim();

                        // TODO : Validate form

                        mRepository.add(new Level(levelName, Integer.valueOf(levelEchelon)));
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
