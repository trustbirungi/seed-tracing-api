package io.trustbirungi.seedTracingApi.entity;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "group_trained_others_repeat")
public class GroupTrainedOthersRepeat {
    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "parent_uid")
    private SeedMultipliers parentUid;

    @Column(name = "trained_group_that_has_trained_others")
    private String trainedGroupThatHasTrainedOthers;
}
