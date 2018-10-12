package com.rebels.f1levier.ui.home;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rebels.f1levier.R;
import com.rebels.f1levier.model.Participant;

import java.util.List;

public class ParticipantsAdapter extends RecyclerView.Adapter<ParticipantsAdapter.ViewHolder> {

    private List<Participant> mDataSet;

    public ParticipantsAdapter(List<Participant> dataSet) {
        mDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_participant, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.nameTextView.setText(mDataSet.get(position).getName());
        viewHolder.descriptionTextView.setText(mDataSet.get(position).toString());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView nameTextView, descriptionTextView;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("Participant", "Element " + getAdapterPosition() + " clicked.");
                }
            });

            nameTextView = v.findViewById(R.id.text_view_name);
            descriptionTextView = v.findViewById(R.id.text_view_description);
        }

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

}
