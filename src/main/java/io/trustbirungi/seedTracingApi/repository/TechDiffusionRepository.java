package io.trustbirungi.seedTracingApi.repository;

import java.util.List;

import io.trustbirungi.seedTracingApi.entity.SeedMultipliers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TechDiffusionRepository extends CrudRepository<SeedMultipliers,
		String> {
	@Query(value = "SELECT trainer_org FROM seed_multipliers", nativeQuery = true)
	List<String> getTrainingOrgs();

	@Query(value = "SELECT trainer_org_other FROM seed_multipliers WHERE "
			+ "trainer_org_other IS NOT NULL",
			nativeQuery =
			true)
	List<String> getOtherTrainingOrgs();

	@Query(value = "SELECT COUNT(trained_other_farmers) FROM seed_multipliers"
			+ " WHERE trained_other_farmers = 'Yes'", nativeQuery = true)
	int getFarmersWhoTrainedOthersCount();

	@Query(value = "SELECT COUNT(meta_instance_id) FROM seed_multipliers", nativeQuery = true)
	int getTotalFarmersCount();

	@Query(value = "SELECT COUNT(trained_other_groups) FROM seed_multipliers"
			+ " WHERE trained_other_groups = 'Yes'", nativeQuery = true)
	int getFarmersWhoTrainedOtherGroupsCount();

	@Query(value = "SELECT COUNT(*) FROM trainee_repeat WHERE trainee_sex = "
			+ "'Yes' OR trainee_sex = 'female'", nativeQuery = true)
	int getTrainedFarmersWhoAreFemaleCount();

	@Query(value = "SELECT COUNT(*) FROM trainee_repeat WHERE trainee_sex = "
			+ "'No' OR trainee_sex = 'male'", nativeQuery = true)
	int getTrainedFarmersWhoAreMaleCount();

	@Query(value = "SELECT COUNT(*) FROM trainee_repeat", nativeQuery = true)
	int getTrainedFarmersTotalCount();

	@Query(value = "SELECT COUNT(*) FROM seed_multipliers WHERE "
			+ "trained_group_trained_others = 'Yes'", nativeQuery = true)
	int getFarmersThatTrainedOtherFarmersCount();

	@Query(value = "SELECT technology_utilization_rating FROM "
			+ "seed_multipliers WHERE technology_utilization_rating IS NOT "
			+ "NULL", nativeQuery = true)
	List<Integer> getTrainedFarmersRankings();

	@Query(value = "SELECT trainee_district FROM trainee_repeat", nativeQuery = true)
	List<String> getTraineeDistricts();

	@Query(value = "SELECT group_trainee_district FROM group_trainee_repeat",
			nativeQuery = true)
	List<String> getTraineeGroupsDistricts();
}
