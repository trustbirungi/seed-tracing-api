package io.trustbirungi.seedTracingApi.entity;

import javax.persistence.*;

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
}
