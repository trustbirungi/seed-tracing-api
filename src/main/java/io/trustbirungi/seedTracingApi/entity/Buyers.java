package io.trustbirungi.seedTracingApi.entity;

import jakarta.persistence.*;

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

    // Getters and Setters
    public String getMetaInstanceId() {
        return metaInstanceId;
    }

    public void setMetaInstanceId(String metaInstanceId) {
        this.metaInstanceId = metaInstanceId;
    }

    public String getMetaModelVersion() {
        return metaModelVersion;
    }

    public void setMetaModelVersion(String metaModelVersion) {
        this.metaModelVersion = metaModelVersion;
    }

    public String getMetaUiVersion() {
        return metaUiVersion;
    }

    public void setMetaUiVersion(String metaUiVersion) {
        this.metaUiVersion = metaUiVersion;
    }

    public String getMetaSubmissionDate() {
        return metaSubmissionDate;
    }

    public void setMetaSubmissionDate(String metaSubmissionDate) {
        this.metaSubmissionDate = metaSubmissionDate;
    }

    public String getMetaIsComplete() {
        return metaIsComplete;
    }

    public void setMetaIsComplete(String metaIsComplete) {
        this.metaIsComplete = metaIsComplete;
    }

    public String getMetaDateMarkedAsComplete() {
        return metaDateMarkedAsComplete;
    }

    public void setMetaDateMarkedAsComplete(String metaDateMarkedAsComplete) {
        this.metaDateMarkedAsComplete = metaDateMarkedAsComplete;
    }

    public String getBiodataNote() {
        return biodataNote;
    }

    public void setBiodataNote(String biodataNote) {
        this.biodataNote = biodataNote;
    }

    public String getConsent() {
        return consent;
    }

    public void setConsent(String consent) {
        this.consent = consent;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBuyerSex() {
        return buyerSex;
    }

    public void setBuyerSex(String buyerSex) {
        this.buyerSex = buyerSex;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFarmerGroup() {
        return farmerGroup;
    }

    public void setFarmerGroup(String farmerGroup) {
        this.farmerGroup = farmerGroup;
    }

    public Integer getFemaleMembersQuantity() {
        return femaleMembersQuantity;
    }

    public void setFemaleMembersQuantity(Integer femaleMembersQuantity) {
        this.femaleMembersQuantity = femaleMembersQuantity;
    }

    public Integer getMaleMembersQuantity() {
        return maleMembersQuantity;
    }

    public void setMaleMembersQuantity(Integer maleMembersQuantity) {
        this.maleMembersQuantity = maleMembersQuantity;
    }

    public String getBuyerDistrict() {
        return buyerDistrict;
    }

    public void setBuyerDistrict(String buyerDistrict) {
        this.buyerDistrict = buyerDistrict;
    }

    public String getBuyerCounty() {
        return buyerCounty;
    }

    public void setBuyerCounty(String buyerCounty) {
        this.buyerCounty = buyerCounty;
    }

    public String getBuyerSubcounty() {
        return buyerSubcounty;
    }

    public void setBuyerSubcounty(String buyerSubcounty) {
        this.buyerSubcounty = buyerSubcounty;
    }

    public String getBuyerParish() {
        return buyerParish;
    }

    public void setBuyerParish(String buyerParish) {
        this.buyerParish = buyerParish;
    }

    public String getBuyerVillage() {
        return buyerVillage;
    }

    public void setBuyerVillage(String buyerVillage) {
        this.buyerVillage = buyerVillage;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }
}
