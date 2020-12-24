package io.trustbirungi.seedTracingApi.repository;

import java.util.List;

import io.trustbirungi.seedTracingApi.entity.Buyers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BuyersRepository extends CrudRepository<Buyers, String> {
	@Query(value = "SELECT COUNT(*) FROM buyers WHERE buyer_sex = 'No'", nativeQuery = true)
	int getMaleBuyersCount();

	@Query(value = "SELECT COUNT(*) FROM buyers WHERE buyer_sex = 'No'", nativeQuery = true)
	int getFemaleBuyersCount();

	@Query(value = "SELECT AVG( YEAR(now()) - YEAR(STR_TO_DATE(date_of_birth,"
			+ " '%d/%m/%Y'))) as average_age  FROM buyers WHERE buyer_sex = "
			+ "'No'", nativeQuery = true)
	int getMaleBuyersAverageAge();

	@Query(value = "SELECT AVG( YEAR(now()) - YEAR(STR_TO_DATE(date_of_birth,"
			+ " '%d/%m/%Y'))) as average_age  FROM buyers WHERE buyer_sex = "
			+ "'Yes'", nativeQuery = true)
	int getFemaleBuyersAverageAge();

	@Query(value = "SELECT YEAR(now()) - YEAR(STR_TO_DATE(date_of_birth, "
			+ "'%d/%m/%Y')) as age FROM buyers WHERE buyer_sex = 'No'",
			nativeQuery =	true)
	List<Integer> getMaleBuyersAges();

	@Query(value = "SELECT YEAR(now()) - YEAR(STR_TO_DATE(date_of_birth, "
			+ "'%d/%m/%Y')) as age FROM buyers WHERE buyer_sex = 'Yes'",
			nativeQuery =	true)
	List<Integer> getFemaleBuyersAges();

	@Query(value = "SELECT YEAR(now()) - YEAR(STR_TO_DATE(date_of_birth, "
			+ "'%d/%m/%Y')) as age FROM buyers",
			nativeQuery =	true)
	List<Integer> getBuyersAges();

	@Query(value = "SELECT buyer_district FROM buyers", nativeQuery = true)
	List<String> getBuyersDistricts();
}
