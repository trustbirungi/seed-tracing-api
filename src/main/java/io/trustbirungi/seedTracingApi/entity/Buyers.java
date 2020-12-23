package io.trustbirungi.seedTracingApi.entity;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "buyers")
public class Buyers {
    @Id
    @Column(name = "meta_instance_id")
    private String metaInstanceId;

    @Column(name = "meta_model_version")
    private String metaModelVersion;

    @Column(name = "meta_ui_version")
    private String metaUiVersion;

    @Column(name = "meta_submission_date")
    private String metaSubmissionDate;

    @Column(name = "meta_is_complete")
    private String metaIsComplete;

    @Column(name = "meta_date_marked_as_complete")
    private String metaDateMarkedAsComplete;

    @Column(name = "biodata_note")
    private String biodataNote;

    @Column(name = "consent")
    private String consent;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "buyer_sex")
    private String buyerSex;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "farmer_group")
    private String farmerGroup;

    @Column(name = "female_members_quantity")
    private Integer femaleMembersQuantity;

    @Column(name = "male_members_quantity")
    private Integer maleMembersQuantity;

    @Column(name = "buyer_district")
    private String buyerDistrict;

    @Column(name = "buyer_county")
    private String buyerCounty;

    @Column(name = "buyer_subcounty")
    private String buyerSubcounty;

    @Column(name = "buyer_parish")
    private String buyerParish;

    @Column(name = "buyer_village")
    private String buyerVillage;

    @Column(name = "instance_id")
    private String instanceId;
}
