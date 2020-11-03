package io.trustbirungi.seedTracingApi.entity;

import javax.persistence.*;

@Entity
@Table(name = "group_trainee_repeat")
public class GroupTraineeRepeat {
    @Id
    @Column(name = "id")
    private Integer id;

    @SuppressWarnings("JpaAttributeTypeInspection")
    @ManyToOne
    @JoinColumn(name = "parent_uid")
    private String parentUid;

    @Column(name = "group_trainee_name")
    private String groupTraineeName;

    @Column(name = "group_trainee_training_date")
    private java.sql.Date groupTraineeTrainingDate;

    @Column(name = "group_trainee_district")
    private String groupTraineeDistrict;
}
