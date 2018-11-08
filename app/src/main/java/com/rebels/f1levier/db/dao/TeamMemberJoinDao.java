package com.rebels.f1levier.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.rebels.f1levier.db.entity.ParticipantEntity;
import com.rebels.f1levier.db.entity.TeamMemberJoinEntity;

import java.util.List;

@Dao
public interface TeamMemberJoinDao {

    @Query("SELECT * FROM participant INNER JOIN team_member ON " +
            "participant.id = team_member.member_id WHERE team_member.team_id = :teamId")
    List<ParticipantEntity> getMembersByTeamId(final int teamId);

    @Insert
    void insertAll(TeamMemberJoinEntity teamMemberJoinsEntity);
}
