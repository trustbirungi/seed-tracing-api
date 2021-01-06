package io.trustbirungi.seedTracingApi.repository;

import javax.print.attribute.IntegerSyntax;
import java.util.List;

import io.trustbirungi.seedTracingApi.entity.SeedMultipliers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TechUptakeRepository extends CrudRepository<SeedMultipliers,
		String> {
	@Query(value = "SELECT seed_multiplier_planting_materials_type from seed_multipliers", nativeQuery = true)
	List<String> getPlantingMaterials();

	@Query(value = "SELECT seed_multiplier_varieties from seed_multipliers", nativeQuery = true)
	List<String> getPlantingVarieties();

	@Query(value = "SELECT seed_multiplier_varieties_banana_other from seed_multipliers", nativeQuery = true)
	List<String> getOtherBananaVarieties();

	@Query(value = "SELECT seed_multiplier_varieties_potatoes_other from seed_multipliers", nativeQuery = true)
	List<String> getOtherPotatoVarieties();

	@Query(value = "SELECT seed_multiplier_planting_materials_tech FROM seed_multipliers", nativeQuery = true)
	List<String> getPresetPlantingTech();

	@Query(value = "SELECT seed_multiplier_planting_materials_tech_other FROM seed_multipliers", nativeQuery = true)
	List<String> getOtherPlantingTech();

	@Query(value = "SELECT AVG(banana_planting_materials_produced) AS average_banana_planting_materials_produced FROM seed_multipliers", nativeQuery = true)
	double getAverageBananaPlantingMaterialsProduced();

	@Query(value = "SELECT banana_planting_materials_produced FROM seed_multipliers", nativeQuery = true)
	List<Integer> getBananaPlantingMaterialsProduced();

	@Query(value = "SELECT AVG(potatoes_planting_materials_produced) AS average_banana_planting_materials_produced FROM seed_multipliers", nativeQuery = true)
	double getAveragePotatoPlantingMaterialsProduced();

	@Query(value = "SELECT potatoes_planting_materials_produced FROM seed_multipliers", nativeQuery = true)
	List<Integer> getPotatoPlantingMaterialsProduced();

	@Query(value = "SELECT AVG(number_of_production_times) as average_production_times FROM seed_multipliers", nativeQuery = true)
	double getAverageNumberOfProductionTimes();

	@Query(value = "SELECT number_of_production_times FROM seed_multipliers", nativeQuery = true)
	List<Integer> getProductionTimes();

	@Query(value = "SELECT AVG(individual_buyers_sold_to_per_season) as average_individual_buyers_sold_to_per_season FROM seed_multipliers", nativeQuery = true)
	double getAverageIndividualBuyersQuantityPerSeason();

	@Query(value = "SELECT individual_buyers_sold_to_per_season FROM seed_multipliers", nativeQuery = true)
	List<Integer> getIndividualBuyersQuantityPerSeason();

	@Query(value = "SELECT AVG(female_buyers_percentage) as average_female_buyers_percentage FROM seed_multipliers", nativeQuery = true)
	double getFemaleBuyersAverageAge();

	@Query(value = "SELECT female_buyers_percentage FROM seed_multipliers", nativeQuery = true)
	List<Integer> getFemaleBuyersAges();

	@Query(value = "SELECT AVG(male_buyers_percentage) as average_male_buyers_percentage FROM seed_multipliers", nativeQuery = true)
	double getMaleBuyersAverageAge();

	@Query(value = "SELECT male_buyers_percentage FROM seed_multipliers", nativeQuery = true)
	List<Integer> getMaleBuyersAges();

	@Query(value = "SELECT selling_points FROM seed_multipliers", nativeQuery = true)
	List<String> getSellingPoints();

	@Query(value = "SELECT AVG(annual_production_capacity) as average_annual_production_capacity FROM seed_multipliers", nativeQuery = true)
	double getAverageAnnualProductionCapacity();

	@Query(value = "SELECT annual_production_capacity FROM seed_multipliers", nativeQuery = true)
	List<Integer> getAnnualProductionCapacities();

	@Query(value = "SELECT AVG(annual_production_sold) as average_annual_production_sold FROM seed_multipliers", nativeQuery = true)
	double getAverageAnnualProductionSold();

	@Query(value = "SELECT annual_production_sold FROM seed_multipliers", nativeQuery = true)
	List<Integer> getAnnualProductionSold();

	@Query(value = "SELECT AVG(annual_production_given_away) as average_annual_production_given_away FROM seed_multipliers", nativeQuery = true)
	double getAverageAnnualProductionGivenAway();

	@Query(value = "SELECT annual_production_given_away FROM seed_multipliers", nativeQuery = true)
	List<Integer> getAnnualProductionGivenAway();

	@Query(value = "SELECT AVG(annual_production_lost) as "
			+ "average_annual_production_lost FROM seed_multipliers",
			nativeQuery = true)
	double getAverageAnnualProductionLost();

	@Query(value = "SELECT annual_production_lost FROM seed_multipliers",
			nativeQuery = true)
	List<Integer> getAnnualProductionLost();

	@Query(value = "SELECT AVG(current_planting_materials_stock) as average_current_planting_materials_stock FROM seed_multipliers", nativeQuery = true)
	double getAverageCurrentPlantingMaterialsStock();

	@Query(value = "SELECT current_planting_materials_stock FROM seed_multipliers", nativeQuery = true)
	List<Integer> getCurrentPlantingMaterialsStock();
}
