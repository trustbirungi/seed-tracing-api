package io.trustbirungi.seedTracingApi.entity;

import javax.persistence.*;

@Entity
@Table(name = "group_trained_others_repeat")
public class GroupTrainedOthersRepeat {
    @Id
    @Column(name = "id")
    private Integer id;

    @SuppressWarnings("JpaAttributeTypeInspection")
    @ManyToOne
    @JoinColumn(name = "parent_uid")
    private String parentUid;

    @Column(name = "trained_group_that_has_trained_others")
    private String trainedGroupThatHasTrainedOthers;
}
