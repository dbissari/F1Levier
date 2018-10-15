package com.rebels.f1levier.ui.participants;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rebels.f1levier.R;
import com.rebels.f1levier.model.Participant;
import com.rebels.f1levier.ui.participants.ParticipantsFragment.OnListFragmentInteractionListener;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Participant} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */
public class ParticipantsRecyclerViewAdapter extends RecyclerView.Adapter<ParticipantsRecyclerViewAdapter.ViewHolder> {

    private final List<Participant> mParticipants;
    private final OnListFragmentInteractionListener mListener;

    public ParticipantsRecyclerViewAdapter(List<Participant> participants, OnListFragmentInteractionListener listener) {
        mParticipants = participants;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_participant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mParticipant = mParticipants.get(position);
        holder.mTextViewName.setText(mParticipants.get(position).getName());
        holder.mTextViewLevel.setText(mParticipants.get(position).getLevel().getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mParticipant);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mParticipants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTextViewName;
        public final TextView mTextViewLevel;
        public Participant mParticipant;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTextViewName = (TextView) view.findViewById(R.id.text_view_name);
            mTextViewLevel = (TextView) view.findViewById(R.id.text_view_level);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTextViewLevel.getText() + "'";
        }
    }
}
