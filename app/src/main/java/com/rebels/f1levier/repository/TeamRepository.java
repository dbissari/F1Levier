package com.rebels.f1levier.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.rebels.f1levier.db.AppDatabase;
import com.rebels.f1levier.db.dao.QueryResult.TeamDetail;
import com.rebels.f1levier.db.dao.TeamDao;
import com.rebels.f1levier.db.dao.QueryResult.TeamMember;
import com.rebels.f1levier.db.dao.TeamMemberJoinDao;
import com.rebels.f1levier.db.entity.Team;
import com.rebels.f1levier.db.entity.TeamMemberJoin;

import java.util.List;

public class TeamRepository {

    private TeamDao mTeamDao;
    private TeamMemberJoinDao mTeamMemberJoinDao;

    public TeamRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mTeamDao = db.teamDao();
        mTeamMemberJoinDao = db.teamMemberJoinDao();
    }

    public LiveData<List<TeamDetail>> getAllDetailedTeamsByRaceId(int raceId) {
        return mTeamDao.getAllDetailedByRaceId(raceId);
    }

    public LiveData<List<TeamMember>> getOtherMembersNotPickedByRaceId(int teamId, int raceId) {
        return mTeamMemberJoinDao.getOtherMembersNotPickedByRaceId(teamId, raceId);
    }

    public Long insertSync(Team team) {
        return mTeamDao.insert(team);
    }

    public void insertTeamMemberAsync(TeamMemberJoin teamMemberJoin) {
        new insertTeamMemberAsyncTask(mTeamMemberJoinDao).execute(teamMemberJoin);
    }

    public void deleteTeamMemberAsync(int teamId, int memberId) {
        new deleteTeamMembersAsyncTask(mTeamMemberJoinDao).execute(teamId, memberId);
    }

    private static class insertTeamMemberAsyncTask extends AsyncTask<TeamMemberJoin, Void, Void> {

        private TeamMemberJoinDao mAsyncTaskDao;

        insertTeamMemberAsyncTask(TeamMemberJoinDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final TeamMemberJoin... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class deleteTeamMembersAsyncTask extends AsyncTask<Integer, Void, Void> {

        private TeamMemberJoinDao mAsyncTaskDao;

        deleteTeamMembersAsyncTask(TeamMemberJoinDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Integer... params) {
            mAsyncTaskDao.delete(params[0], params[1]);
            return null;
        }
    }
}
