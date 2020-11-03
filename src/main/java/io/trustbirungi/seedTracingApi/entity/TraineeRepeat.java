package io.trustbirungi.seedTracingApi.entity;

import javax.persistence.*;

@Entity
@Table(name = "trainee_repeat")
public class TraineeRepeat {
    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "parent_uid")
    private String parentUid;

    @Column(name = "trainee_first_name")
    private String traineeFirstName;

    @Column(name = "trainee_last_name")
    private String traineeLastName;

    @Column(name = "trainee_sex")
    private String traineeSex;

    @Column(name = "trainee_training_date")
    private java.sql.Date traineeTrainingDate;

    @Column(name = "trainee_district")
    private String traineeDistrict;
}
