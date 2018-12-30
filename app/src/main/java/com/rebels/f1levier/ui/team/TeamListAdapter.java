package com.rebels.f1levier.ui.team;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rebels.f1levier.R;
import com.rebels.f1levier.db.entity.Team;

import java.util.Collections;
import java.util.List;

public class TeamListAdapter extends RecyclerView.Adapter<TeamListAdapter.ViewHolder> {

    private List<Team> mTeams = Collections.emptyList();

    TeamListAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_team_list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Team currentTeam = mTeams.get(position);
        holder.nameTextView.setText(currentTeam.name);
        //holder.membersCountTextView.setText(String.valueOf(count));
    }

    void setTeams(List<Team> teams) {
        mTeams = teams;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mTeams.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameTextView;
        //private final TextView membersCountTextView;

        private ViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.text_view_team_name);
            //membersCountTextView = view.findViewById(R.id.text_view_members_count);
        }
    }
}
