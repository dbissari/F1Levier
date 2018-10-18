package com.rebels.f1levier.ui.levels;

import android.support.v4.app.FragmentActivity;

import com.rebels.f1levier.model.Level;

public class LevelsListener implements LevelsFragment.FragmentInteractionListener {

    private FragmentActivity mActivity;

    LevelsListener(FragmentActivity activity) {
        this.mActivity = activity;
    }

    @Override
    public void onItemClicked(Level level) {

    }

    @Override
    public void onFabClicked() {
        NewLevelDialog newLevelDialog = new NewLevelDialog();
        newLevelDialog.show(mActivity.getSupportFragmentManager(), "New Level Dialog");
    }
}
