package com.rebels.f1levier.ui.participants;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.rebels.f1levier.R;
import com.rebels.f1levier.model.Participant;
import com.rebels.f1levier.ui.participants.ParticipantsActivity.InteractionListener;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Participant} and makes a call to the
 * specified {@link InteractionListener}.
 */
public class ParticipantsRecyclerViewAdapter extends RecyclerView.Adapter<ParticipantsRecyclerViewAdapter.ViewHolder> {

    private final List<Participant> mParticipants;
    private final InteractionListener mListener;

    private final ArrayList<String> mCheckedParticipantsIds = new ArrayList<>();

    ParticipantsRecyclerViewAdapter(List<Participant> participants, InteractionListener listener) {
        mParticipants = participants;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_participant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.mParticipant = mParticipants.get(position);
        holder.mTextViewName.setText(holder.mParticipant.getName());
        holder.mTextViewLevel.setText(holder.mParticipant.getLevel().getName());
        holder.mCheckBox.setChecked(holder.mParticipant.isChecked());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onItemClicked(holder.mParticipant);
                    holder.mCheckBox.setChecked(holder.mParticipant.isChecked());
                    if (holder.mParticipant.isChecked())
                        mCheckedParticipantsIds.add(holder.mParticipant.getId());
                    else
                        mCheckedParticipantsIds.remove(holder.mParticipant.getId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mParticipants.size();
    }

    public final ArrayList<String> getCheckedParticipantsIds() {
        return mCheckedParticipantsIds;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView mTextViewName;
        final TextView mTextViewLevel;
        final CheckBox mCheckBox;
        public Participant mParticipant;

        ViewHolder(View view) {
            super(view);
            mView = view;
            mTextViewName = view.findViewById(R.id.text_view_participant_name);
            mTextViewLevel = view.findViewById(R.id.text_view_participant_level);
            mCheckBox = view.findViewById(R.id.check_box);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTextViewLevel.getText() + "'";
        }
    }
}
