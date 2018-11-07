package com.rebels.f1levier.db.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(primaryKeys = { "teamId", "memberId" },
        foreignKeys = {
                @ForeignKey(entity = Team.class,
                        parentColumns = "id",
                        childColumns = "teamId"),
                @ForeignKey(entity = Participant.class,
                        parentColumns = "id",
                        childColumns = "memberId")
        })
public class TeamMemberJoin {

    public final int teamId;

    public final int memberId;

    public TeamMemberJoin(final int teamId, final int memberId) {
        this.teamId = teamId;
        this.memberId = memberId;
    }
}
