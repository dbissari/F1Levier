package com.rebels.f1levier.ui.levels;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rebels.f1levier.R;
import com.rebels.f1levier.model.Level;
import com.rebels.f1levier.ui.levels.LevelsFragment.OnListFragmentInteractionListener;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Level} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */
public class LevelsRecyclerViewAdapter extends RecyclerView.Adapter<LevelsRecyclerViewAdapter.ViewHolder> {

    private final List<Level> mLevels;

    private final OnListFragmentInteractionListener mListener;

    public LevelsRecyclerViewAdapter(List<Level> levels, OnListFragmentInteractionListener listener) {
        mLevels = levels;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_level, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mLevel = mLevels.get(position);
        holder.mTextViewName.setText(mLevels.get(position).getName());
        holder.mTextViewEchelon.setText(mLevels.get(position).getEchelon());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mLevel);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mLevels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTextViewName;
        public final TextView mTextViewEchelon;
        public Level mLevel;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTextViewName = (TextView) view.findViewById(R.id.text_view_name);
            mTextViewEchelon = (TextView) view.findViewById(R.id.text_view_echelon);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTextViewEchelon.getText() + "'";
        }
    }
}
