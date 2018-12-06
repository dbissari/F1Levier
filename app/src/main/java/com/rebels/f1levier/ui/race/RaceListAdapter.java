package com.rebels.f1levier.ui.race;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rebels.f1levier.R;
import com.rebels.f1levier.db.entity.Race;

import java.util.Collections;
import java.util.List;

public class RaceListAdapter extends RecyclerView.Adapter<RaceListAdapter.ViewHolder> {

    private List<Race> mRaces = Collections.emptyList();

    RaceListAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_race_list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Race currentRace = mRaces.get(position);
        holder.nameTextView.setText(currentRace.name);
    }

    void setRaces(List<Race> races) {
        mRaces = races;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mRaces.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameTextView;

        private ViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.text_view_race_name);
        }
    }
}
