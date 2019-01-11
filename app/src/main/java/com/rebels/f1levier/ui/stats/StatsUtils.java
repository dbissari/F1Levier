package com.rebels.f1levier.ui.stats;

import android.os.AsyncTask;

import com.rebels.f1levier.db.dao.QueryResult.ParticipantStat;
import com.rebels.f1levier.db.dao.QueryResult.TeamStat;
import com.rebels.f1levier.viewmodel.StatsViewModel;

import java.util.List;

public class StatsUtils {

    interface TeamStatsGetHandler {
        void onTeamStatsGetPostExecute(List<TeamStat> teamStats);
    }


    static class getTeamStatsAsyncTask extends AsyncTask<Integer, Void, List<TeamStat>> {

        private StatsViewModel statsViewModel;

        private TeamStatsGetHandler handler;

        getTeamStatsAsyncTask(StatsViewModel statsViewModel, TeamStatsGetHandler handler) {
            this.statsViewModel = statsViewModel;
            this.handler = handler;
        }

        @Override
        protected List<TeamStat> doInBackground(Integer... params) {
            return statsViewModel.getTeamStatsByRaceId(params[0]);
        }

        @Override
        protected void onPostExecute(List<TeamStat> teamStats) {
            handler.onTeamStatsGetPostExecute(teamStats);
        }
    }

    interface ParticipantStatsGetHandler {
        void onParticipantStatsGetPostExecute(List<ParticipantStat> participantStats);
    }


    static class getParticipantStatsAsyncTask extends AsyncTask<Integer, Void, List<ParticipantStat>> {

        private StatsViewModel statsViewModel;

        private ParticipantStatsGetHandler handler;

        getParticipantStatsAsyncTask(StatsViewModel statsViewModel, ParticipantStatsGetHandler handler) {
            this.statsViewModel = statsViewModel;
            this.handler = handler;
        }

        @Override
        protected List<ParticipantStat> doInBackground(Integer... params) {
            return statsViewModel.getParticipantStatsByRaceId(params[0]);
        }

        @Override
        protected void onPostExecute(List<ParticipantStat> participantStats) {
            handler.onParticipantStatsGetPostExecute(participantStats);
        }
    }
}
