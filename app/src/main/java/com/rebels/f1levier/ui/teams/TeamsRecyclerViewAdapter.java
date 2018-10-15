package com.rebels.f1levier.ui.teams;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rebels.f1levier.R;
import com.rebels.f1levier.model.Team;
import com.rebels.f1levier.ui.teams.TeamsFragment.OnListFragmentInteractionListener;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Team} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */
public class TeamsRecyclerViewAdapter extends RecyclerView.Adapter<TeamsRecyclerViewAdapter.ViewHolder> {

    private final List<Team> mTeams;

    private final OnListFragmentInteractionListener mListener;

    public TeamsRecyclerViewAdapter(List<Team> teams, OnListFragmentInteractionListener listener) {
        mTeams = teams;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_team, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mTeam = mTeams.get(position);
        holder.mTextViewName.setText(mTeams.get(position).getName());
        holder.mTextViewMembers.setText(mTeams.get(position).getMembers().size());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mTeam);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTeams.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTextViewName;
        public final TextView mTextViewMembers;
        public Team mTeam;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTextViewName = (TextView) view.findViewById(R.id.text_view_name);
            mTextViewMembers = (TextView) view.findViewById(R.id.text_view_members);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTextViewMembers.getText() + "'";
        }
    }
}
