package com.rebels.f1levier.ui.levels;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rebels.f1levier.R;
import com.rebels.f1levier.model.Level;
import com.rebels.f1levier.ui.levels.LevelsFragment.FragmentInteractionListener;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Level} and makes a call to the
 * specified {@link FragmentInteractionListener}.
 */
public class LevelsRecyclerViewAdapter extends RecyclerView.Adapter<LevelsRecyclerViewAdapter.ViewHolder> {

    private final List<Level> mLevels;

    private final FragmentInteractionListener mListener;

    LevelsRecyclerViewAdapter(List<Level> levels, FragmentInteractionListener listener) {
        mLevels = levels;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_level, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.mLevel = mLevels.get(position);
        holder.mTextViewName.setText(holder.mLevel.getName());
        holder.mTextViewEchelon.setText(String.valueOf(holder.mLevel.getEchelon()));

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onItemClicked(holder.mLevel);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mLevels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView mTextViewName;
        final TextView mTextViewEchelon;
        public Level mLevel;

        ViewHolder(View view) {
            super(view);
            mView = view;
            mTextViewName = view.findViewById(R.id.text_view_level_name);
            mTextViewEchelon = view.findViewById(R.id.text_view_level_echelon);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTextViewEchelon.getText() + "'";
        }
    }
}
