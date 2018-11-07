package com.rebels.f1levier.db.dao;

import com.rebels.f1levier.db.entities.Participant;
import com.rebels.f1levier.db.entities.TeamMemberJoin;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface TeamMemberJoinDao {

    @Query("SELECT * FROM participant p INNER JOIN team_member_join j ON" +
            "p.id = j.member_id WHERE j.team_id = :teamId")
    List<Participant> getMembersByTeam(final int teamId);

    @Insert
    void insertAll(TeamMemberJoin teamMemberJoins);
}
