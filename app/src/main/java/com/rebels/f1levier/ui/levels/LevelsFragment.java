package com.rebels.f1levier.ui.levels;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rebels.f1levier.R;
import com.rebels.f1levier.model.Level;
import com.rebels.f1levier.repository.LevelRepository;

import java.util.Objects;

import io.realm.Realm;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link FragmentInteractionListener}
 * interface.
 */
public class LevelsFragment extends Fragment {

    private int mColumnCount = 1;

    private FragmentInteractionListener mListener;

    private Realm mRealm;
    private LevelRepository mRepository;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public LevelsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRealm = Realm.getDefaultInstance();
        mRepository = new LevelRepository(mRealm);
        mListener = new LevelsListener(getActivity());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_levels, container, false);

        // Set the adapter
        Context context = view.getContext();
        RecyclerView recyclerView = view.findViewById(R.id.list);
        if (mColumnCount <= 1) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }
        recyclerView.setAdapter(new LevelsRecyclerViewAdapter(mRepository.getAll(), mListener));

        DividerItemDecoration itemDecoration = new DividerItemDecoration(
                Objects.requireNonNull(getContext()), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        // Set the fab listener
        FloatingActionButton fab = view.findViewById(R.id.fab_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onFabClicked();
            }
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mRealm.close();
    }

    public interface FragmentInteractionListener {
        void onItemClicked(Level level);
        void onFabClicked();
    }
}
