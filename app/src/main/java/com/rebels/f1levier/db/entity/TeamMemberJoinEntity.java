package com.rebels.f1levier.db.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

@Entity(tableName = "team_member",
        primaryKeys = { "team_id", "member_id" },
        foreignKeys = {
                @ForeignKey(entity = TeamEntity.class,
                        parentColumns = "id",
                        childColumns = "team_id"),
                @ForeignKey(entity = ParticipantEntity.class,
                        parentColumns = "id",
                        childColumns = "member_id")
        })
public class TeamMemberJoinEntity {

    @ColumnInfo(name="team_id")
    public final int teamId;

    @ColumnInfo(name="member_id")
    public final int memberId;

    public TeamMemberJoinEntity(final int teamId, final int memberId) {
        this.teamId = teamId;
        this.memberId = memberId;
    }
}
