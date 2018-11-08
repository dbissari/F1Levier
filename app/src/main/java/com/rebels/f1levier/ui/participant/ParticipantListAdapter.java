package com.rebels.f1levier.ui.participant;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rebels.f1levier.R;
import com.rebels.f1levier.db.entity.ParticipantEntity;

import java.util.Collections;
import java.util.List;

public class ParticipantListAdapter extends RecyclerView.Adapter<ParticipantListAdapter.ViewHolder> {

    private List<ParticipantEntity> mParticipants = Collections.emptyList();

    ParticipantListAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_participant_list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final ParticipantEntity currentParticipant = mParticipants.get(position);
        holder.nameTextView.setText(currentParticipant.name);
        holder.echelonTextView.setText(String.valueOf(currentParticipant.echelon));
    }

    void setParticipants(List<ParticipantEntity> participants) {
        mParticipants = participants;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mParticipants.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameTextView;
        private final TextView echelonTextView;

        private ViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.text_view_participant_name);
            echelonTextView = view.findViewById(R.id.text_view_participant_echelon);
        }
    }
}
