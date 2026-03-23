package io.trustbirungi.seedTracingApi.entity;

import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "seed_multipliers")
public class SeedMultipliers {
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

    @Column(name = "seed_multiplier_sex")
    private String seedMultiplierSex;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "farmer_group")
    private String farmerGroup;

    @Column(name = "female_members_quantity")
    private Integer femaleMembersQuantity;

    @Column(name = "male_members_quantity")
    private Integer maleMembersQuantity;

    @Column(name = "seed_multiplier_district")
    private String seedMultiplierDistrict;

    @Column(name = "seed_multiplier_county")
    private String seedMultiplierCounty;

    @Column(name = "seed_multiplier_subcounty")
    private String seedMultiplierSubcounty;

    @Column(name = "seed_multiplier_parish")
    private String seedMultiplierParish;

    @Column(name = "seed_multiplier_village")
    private String seedMultiplierVillage;

    @Column(name = "seed_multiplier_planting_materials_type")
    private String seedMultiplierPlantingMaterialsType;

    @Column(name = "seed_multiplier_varieties")
    private String seedMultiplierVarieties;

    @Column(name = "seed_multiplier_varieties_banana_other")
    private String seedMultiplierVarietiesBananaOther;

    @Column(name = "seed_multiplier_varieties_potatoes_other")
    private String seedMultiplierVarietiesPotatoesOther;

    @Column(name = "seed_multiplier_planting_materials_tech")
    private String seedMultiplierPlantingMaterialsTech;

    @Column(name = "seed_multiplier_planting_materials_tech_other")
    private String seedMultiplierPlantingMaterialsTechOther;

    @Column(name = "tech_diffusion")
    private String techDiffusion;

    @Column(name = "trainer_org")
    private String trainerOrg;

    @Column(name = "trainer_org_other")
    private String trainerOrgOther;

    @Column(name = "training_date")
    private String trainingDate;

    @Column(name = "trained_other_farmers")
    private String trainedOtherFarmers;

    @Column(name = "trainee_repeat")
    private String traineeRepeat;

    @Column(name = "trained_other_groups")
    private String trainedOtherGroups;

    @Column(name = "group_trainee_repeat")
    private String groupTraineeRepeat;

    @Column(name = "trained_group_trained_others")
    private String trainedGroupTrainedOthers;

    @Column(name = "group_trained_others_repeat")
    private String groupTrainedOthersRepeat;

    @Column(name = "technology_utilization_rating")
    private Integer technologyUtilizationRating;

    @Column(name = "technology_utilization_rating_reason")
    private String technologyUtilizationRatingReason;

    @Column(name = "tech_uptake")
    private String techUptake;

    @Column(name = "banana_planting_materials_produced")
    private Integer bananaPlantingMaterialsProduced;

    @Column(name = "potatoes_planting_materials_produced")
    private Integer potatoesPlantingMaterialsProduced;

    @Column(name = "number_of_production_times")
    private Integer numberOfProductionTimes;

    @Column(name = "individual_buyers_sold_to_per_season")
    private Integer individualBuyersSoldToPerSeason;

    @Column(name = "average_planting_materials_bought_per_individual")
    private String averagePlantingMaterialsBoughtPerIndividual;

    @Column(name = "female_buyers_percentage")
    private Integer femaleBuyersPercentage;

    @Column(name = "female_buyers_average_age")
    private Integer femaleBuyersAverageAge;

    @Column(name = "male_buyers_average_age")
    private Integer maleBuyersAverageAge;

    @Column(name = "male_buyers_percentage")
    private Integer maleBuyersPercentage;

    @Column(name = "selling_points")
    private String sellingPoints;

    @Column(name = "annual_production_capacity")
    private Integer annualProductionCapacity;

    @Column(name = "annual_production_sold")
    private Integer annualProductionSold;

    @Column(name = "annual_production_given_away")
    private Integer annualProductionGivenAway;

    @Column(name = "annual_production_lost")
    private Integer annualProductionLost;

    @Column(name = "current_planting_materials_stock")
    private Integer currentPlantingMaterialsStock;

    @Column(name = "instance_id")
    private String instanceId;

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

    public String getSeedMultiplierSex() {
        return seedMultiplierSex;
    }

    public void setSeedMultiplierSex(String seedMultiplierSex) {
        this.seedMultiplierSex = seedMultiplierSex;
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

    public String getSeedMultiplierDistrict() {
        return seedMultiplierDistrict;
    }

    public void setSeedMultiplierDistrict(String seedMultiplierDistrict) {
        this.seedMultiplierDistrict = seedMultiplierDistrict;
    }

    public String getSeedMultiplierCounty() {
        return seedMultiplierCounty;
    }

    public void setSeedMultiplierCounty(String seedMultiplierCounty) {
        this.seedMultiplierCounty = seedMultiplierCounty;
    }

    public String getSeedMultiplierSubcounty() {
        return seedMultiplierSubcounty;
    }

    public void setSeedMultiplierSubcounty(String seedMultiplierSubcounty) {
        this.seedMultiplierSubcounty = seedMultiplierSubcounty;
    }

    public String getSeedMultiplierParish() {
        return seedMultiplierParish;
    }

    public void setSeedMultiplierParish(String seedMultiplierParish) {
        this.seedMultiplierParish = seedMultiplierParish;
    }

    public String getSeedMultiplierVillage() {
        return seedMultiplierVillage;
    }

    public void setSeedMultiplierVillage(String seedMultiplierVillage) {
        this.seedMultiplierVillage = seedMultiplierVillage;
    }

    public String getSeedMultiplierPlantingMaterialsType() {
        return seedMultiplierPlantingMaterialsType;
    }

    public void setSeedMultiplierPlantingMaterialsType(String seedMultiplierPlantingMaterialsType) {
        this.seedMultiplierPlantingMaterialsType = seedMultiplierPlantingMaterialsType;
    }

    public String getSeedMultiplierVarieties() {
        return seedMultiplierVarieties;
    }

    public void setSeedMultiplierVarieties(String seedMultiplierVarieties) {
        this.seedMultiplierVarieties = seedMultiplierVarieties;
    }

    public String getSeedMultiplierVarietiesBananaOther() {
        return seedMultiplierVarietiesBananaOther;
    }

    public void setSeedMultiplierVarietiesBananaOther(String seedMultiplierVarietiesBananaOther) {
        this.seedMultiplierVarietiesBananaOther = seedMultiplierVarietiesBananaOther;
    }

    public String getSeedMultiplierVarietiesPotatoesOther() {
        return seedMultiplierVarietiesPotatoesOther;
    }

    public void setSeedMultiplierVarietiesPotatoesOther(String seedMultiplierVarietiesPotatoesOther) {
        this.seedMultiplierVarietiesPotatoesOther = seedMultiplierVarietiesPotatoesOther;
    }

    public String getSeedMultiplierPlantingMaterialsTech() {
        return seedMultiplierPlantingMaterialsTech;
    }

    public void setSeedMultiplierPlantingMaterialsTech(String seedMultiplierPlantingMaterialsTech) {
        this.seedMultiplierPlantingMaterialsTech = seedMultiplierPlantingMaterialsTech;
    }

    public String getSeedMultiplierPlantingMaterialsTechOther() {
        return seedMultiplierPlantingMaterialsTechOther;
    }

    public void setSeedMultiplierPlantingMaterialsTechOther(String seedMultiplierPlantingMaterialsTechOther) {
        this.seedMultiplierPlantingMaterialsTechOther = seedMultiplierPlantingMaterialsTechOther;
    }

    public String getTechDiffusion() {
        return techDiffusion;
    }

    public void setTechDiffusion(String techDiffusion) {
        this.techDiffusion = techDiffusion;
    }

    public String getTrainerOrg() {
        return trainerOrg;
    }

    public void setTrainerOrg(String trainerOrg) {
        this.trainerOrg = trainerOrg;
    }

    public String getTrainerOrgOther() {
        return trainerOrgOther;
    }

    public void setTrainerOrgOther(String trainerOrgOther) {
        this.trainerOrgOther = trainerOrgOther;
    }

    public String getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(String trainingDate) {
        this.trainingDate = trainingDate;
    }

    public String getTrainedOtherFarmers() {
        return trainedOtherFarmers;
    }

    public void setTrainedOtherFarmers(String trainedOtherFarmers) {
        this.trainedOtherFarmers = trainedOtherFarmers;
    }

    public String getTraineeRepeat() {
        return traineeRepeat;
    }

    public void setTraineeRepeat(String traineeRepeat) {
        this.traineeRepeat = traineeRepeat;
    }

    public String getTrainedOtherGroups() {
        return trainedOtherGroups;
    }

    public void setTrainedOtherGroups(String trainedOtherGroups) {
        this.trainedOtherGroups = trainedOtherGroups;
    }

    public String getGroupTraineeRepeat() {
        return groupTraineeRepeat;
    }

    public void setGroupTraineeRepeat(String groupTraineeRepeat) {
        this.groupTraineeRepeat = groupTraineeRepeat;
    }

    public String getTrainedGroupTrainedOthers() {
        return trainedGroupTrainedOthers;
    }

    public void setTrainedGroupTrainedOthers(String trainedGroupTrainedOthers) {
        this.trainedGroupTrainedOthers = trainedGroupTrainedOthers;
    }

    public String getGroupTrainedOthersRepeat() {
        return groupTrainedOthersRepeat;
    }

    public void setGroupTrainedOthersRepeat(String groupTrainedOthersRepeat) {
        this.groupTrainedOthersRepeat = groupTrainedOthersRepeat;
    }

    public Integer getTechnologyUtilizationRating() {
        return technologyUtilizationRating;
    }

    public void setTechnologyUtilizationRating(Integer technologyUtilizationRating) {
        this.technologyUtilizationRating = technologyUtilizationRating;
    }

    public String getTechnologyUtilizationRatingReason() {
        return technologyUtilizationRatingReason;
    }

    public void setTechnologyUtilizationRatingReason(String technologyUtilizationRatingReason) {
        this.technologyUtilizationRatingReason = technologyUtilizationRatingReason;
    }

    public String getTechUptake() {
        return techUptake;
    }

    public void setTechUptake(String techUptake) {
        this.techUptake = techUptake;
    }

    public Integer getBananaPlantingMaterialsProduced() {
        return bananaPlantingMaterialsProduced;
    }

    public void setBananaPlantingMaterialsProduced(Integer bananaPlantingMaterialsProduced) {
        this.bananaPlantingMaterialsProduced = bananaPlantingMaterialsProduced;
    }

    public Integer getPotatoesPlantingMaterialsProduced() {
        return potatoesPlantingMaterialsProduced;
    }

    public void setPotatoesPlantingMaterialsProduced(Integer potatoesPlantingMaterialsProduced) {
        this.potatoesPlantingMaterialsProduced = potatoesPlantingMaterialsProduced;
    }

    public Integer getNumberOfProductionTimes() {
        return numberOfProductionTimes;
    }

    public void setNumberOfProductionTimes(Integer numberOfProductionTimes) {
        this.numberOfProductionTimes = numberOfProductionTimes;
    }

    public Integer getIndividualBuyersSoldToPerSeason() {
        return individualBuyersSoldToPerSeason;
    }

    public void setIndividualBuyersSoldToPerSeason(Integer individualBuyersSoldToPerSeason) {
        this.individualBuyersSoldToPerSeason = individualBuyersSoldToPerSeason;
    }

    public String getAveragePlantingMaterialsBoughtPerIndividual() {
        return averagePlantingMaterialsBoughtPerIndividual;
    }

    public void setAveragePlantingMaterialsBoughtPerIndividual(String averagePlantingMaterialsBoughtPerIndividual) {
        this.averagePlantingMaterialsBoughtPerIndividual = averagePlantingMaterialsBoughtPerIndividual;
    }

    public Integer getFemaleBuyersPercentage() {
        return femaleBuyersPercentage;
    }

    public void setFemaleBuyersPercentage(Integer femaleBuyersPercentage) {
        this.femaleBuyersPercentage = femaleBuyersPercentage;
    }

    public Integer getFemaleBuyersAverageAge() {
        return femaleBuyersAverageAge;
    }

    public void setFemaleBuyersAverageAge(Integer femaleBuyersAverageAge) {
        this.femaleBuyersAverageAge = femaleBuyersAverageAge;
    }

    public Integer getMaleBuyersAverageAge() {
        return maleBuyersAverageAge;
    }

    public void setMaleBuyersAverageAge(Integer maleBuyersAverageAge) {
        this.maleBuyersAverageAge = maleBuyersAverageAge;
    }

    public Integer getMaleBuyersPercentage() {
        return maleBuyersPercentage;
    }

    public void setMaleBuyersPercentage(Integer maleBuyersPercentage) {
        this.maleBuyersPercentage = maleBuyersPercentage;
    }

    public String getSellingPoints() {
        return sellingPoints;
    }

    public void setSellingPoints(String sellingPoints) {
        this.sellingPoints = sellingPoints;
    }

    public Integer getAnnualProductionCapacity() {
        return annualProductionCapacity;
    }

    public void setAnnualProductionCapacity(Integer annualProductionCapacity) {
        this.annualProductionCapacity = annualProductionCapacity;
    }

    public Integer getAnnualProductionSold() {
        return annualProductionSold;
    }

    public void setAnnualProductionSold(Integer annualProductionSold) {
        this.annualProductionSold = annualProductionSold;
    }

    public Integer getAnnualProductionGivenAway() {
        return annualProductionGivenAway;
    }

    public void setAnnualProductionGivenAway(Integer annualProductionGivenAway) {
        this.annualProductionGivenAway = annualProductionGivenAway;
    }

    public Integer getAnnualProductionLost() {
        return annualProductionLost;
    }

    public void setAnnualProductionLost(Integer annualProductionLost) {
        this.annualProductionLost = annualProductionLost;
    }

    public Integer getCurrentPlantingMaterialsStock() {
        return currentPlantingMaterialsStock;
    }

    public void setCurrentPlantingMaterialsStock(Integer currentPlantingMaterialsStock) {
        this.currentPlantingMaterialsStock = currentPlantingMaterialsStock;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }
}
