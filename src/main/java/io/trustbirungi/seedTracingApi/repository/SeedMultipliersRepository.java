package io.trustbirungi.seedTracingApi.repository;

import java.util.List;
import java.util.Map;

import io.trustbirungi.seedTracingApi.entity.SeedMultipliers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SeedMultipliersRepository extends CrudRepository<SeedMultipliers, String> {
	@Query(value = "SELECT COUNT(*) FROM seed_multipliers WHERE "
			+ "seed_multiplier_sex = 'No' OR seed_multiplier_sex = 'male'",
			nativeQuery = true)
	int getMaleMultipliersCount();

	@Query(value = "SELECT COUNT(*) FROM seed_multipliers WHERE "
			+ "seed_multiplier_sex = 'Yes' OR seed_multiplier_sex = 'female'",
			nativeQuery = true)
	int getFemaleMultipliersCount();

	@Query(value = "SELECT AVG( YEAR(now()) - YEAR(STR_TO_DATE(date_of_birth,"
			+ " '%d/%m/%Y'))) AS average_age  FROM seed_multipliers WHERE "
			+ "seed_multiplier_sex = "
			+ "'No' OR seed_multiplier_sex = 'male'", nativeQuery = true)
	double getMaleAverageAge();

	@Query(value = "SELECT AVG( YEAR(now()) - YEAR(STR_TO_DATE(date_of_birth,"
			+ " '%d/%m/%Y'))) AS average_age  FROM seed_multipliers WHERE "
			+ "seed_multiplier_sex = "
			+ "'Yes' OR seed_multiplier_sex = 'female'", nativeQuery = true)
	double getFemaleAverageAge();

	@Query(value = "SELECT YEAR(now()) - YEAR(STR_TO_DATE(date_of_birth, "
			+ "'%d/%m/%Y')) AS age FROM seed_multipliers WHERE "
			+ "seed_multiplier_sex = 'No' OR seed_multiplier_sex = 'male'",
			nativeQuery =	true)
	List<Integer> getMaleMultipliersAges();

	@Query(value = "SELECT YEAR(now()) - YEAR(STR_TO_DATE(date_of_birth, "
			+ "'%d/%m/%Y')) AS age FROM seed_multipliers WHERE "
			+ "seed_multiplier_sex = 'Yes' OR seed_multiplier_sex = 'female'",
			nativeQuery =	true)
	List<Integer> getFemaleMultipliersAges();

	@Query(value = "SELECT YEAR(now()) - YEAR(STR_TO_DATE(date_of_birth, "
			+ "'%d/%m/%Y')) AS age FROM seed_multipliers",
			nativeQuery =	true)
	List<Integer> getMultipliersAges();

	@Query(value = "SELECT COUNT(*) FROM seed_multipliers WHERE farmer_group LIKE 'N/A%' OR farmer_group LIKE 'NA%' OR farmer_group LIKE 'None%' OR farmer_group LIKE 'Not applicable%'",
			nativeQuery = true)
	int getIndividualMultipliersCount();

	@Query(value = "SELECT COUNT(*) FROM seed_multipliers WHERE farmer_group "
			+ "NOT LIKE 'N/A%' OR farmer_group NOT LIKE 'NA%' OR farmer_group "
			+ "NOT LIKE 'None%' OR farmer_group NOT LIKE 'Not applicable%'",
			nativeQuery = true)
	int getGroupMultipliersCount();

	@Query(value = "SELECT AVG(female_members_quantity + "
			+ "male_members_quantity) as average_group_size  FROM "
			+ "seed_multipliers", nativeQuery = true)
	double getAverageGroupSize();

	@Query(value = "SELECT (female_members_quantity + male_members_quantity) "
			+ "AS group_size  FROM seed_multipliers", nativeQuery = true)
	List<Integer> getGroupSizes();

	@Query(value = "SELECT AVG(female_members_quantity) AS average_female_size"
			+ "  FROM seed_multipliers", nativeQuery = true)
	double getAverageFemaleMembersPerGroup();

	@Query(value = "SELECT AVG(male_members_quantity) AS average_male_size  "
			+ "FROM seed_multipliers", nativeQuery = true)
	double getAverageMaleMembersPerGroup();

	@Query(value = "SELECT seed_multiplier_district FROM seed_multipliers", nativeQuery =
			true)
	List<String> getMultipliersDistricts();

	@Query(value = "SELECT seed_multiplier_planting_materials_type FROM seed_multipliers", nativeQuery =
			true)
	List<String> getPlantingMaterials();

	@Query(value = "SELECT seed_multiplier_varieties FROM seed_multipliers",
			nativeQuery =
			true)
	List<String> getPlantingMaterialsVarieties();

	@Query(value = "SELECT seed_multiplier_varieties FROM seed_multipliers "
			+ "WHERE seed_multiplier_varieties LIKE 'banana%' OR "
			+ "seed_multiplier_varieties LIKE '%banana%' OR "
			+ "seed_multiplier_varieties LIKE '%banana'",
			nativeQuery =
			true)
	List<String> getBananaPlantingMaterialsVarieties();

	@Query(value = "SELECT seed_multiplier_varieties FROM seed_multipliers WHERE seed_multiplier_varieties LIKE 'potato%' OR seed_multiplier_varieties LIKE '%potato%' OR seed_multiplier_varieties LIKE '%potato'",
			nativeQuery =
					true)
	List<String> getPotatoPlantingMaterialsVarieties();

	@Query(value = "SELECT seed_multiplier_planting_materials_tech FROM "
			+ "seed_multipliers", nativeQuery = true)
	List<String> getPlantingMethods();
}
