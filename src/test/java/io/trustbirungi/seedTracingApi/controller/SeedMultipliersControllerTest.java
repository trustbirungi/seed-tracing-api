package io.trustbirungi.seedTracingApi.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import io.trustbirungi.seedTracingApi.dto.SeedMultipliersAnalysisDto;
import io.trustbirungi.seedTracingApi.entity.SeedMultipliers;
import io.trustbirungi.seedTracingApi.service.SeedMultipliersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName("SeedMultipliersController Unit Tests")
class SeedMultipliersControllerTest {

	@Mock
	private SeedMultipliersService seedMultipliersService;

	private SeedMultipliersController seedMultipliersController;

	@BeforeEach
	void setUp() {
		seedMultipliersController = new SeedMultipliersController(seedMultipliersService);
	}

	@Nested
	@DisplayName("GetSeedMultipliers Method Tests")
	class GetSeedMultipliersTests {

		@Test
		@DisplayName("Should return list of seed multipliers successfully")
		void testGetSeedMultipliersSuccess() {
			// Arrange
			List<SeedMultipliers> expectedMultipliers = new ArrayList<>();
			SeedMultipliers multiplier1 = new SeedMultipliers();
			multiplier1.setMetaInstanceId("multiplier1");
			multiplier1.setFirstName("John");
			multiplier1.setLastName("Doe");
			multiplier1.setSeedMultiplierSex("Male");
			expectedMultipliers.add(multiplier1);

			SeedMultipliers multiplier2 = new SeedMultipliers();
			multiplier2.setMetaInstanceId("multiplier2");
			multiplier2.setFirstName("Jane");
			multiplier2.setLastName("Smith");
			multiplier2.setSeedMultiplierSex("Female");
			expectedMultipliers.add(multiplier2);

			when(seedMultipliersService.getSeedMultipliers()).thenReturn(expectedMultipliers);

			// Act
			List<SeedMultipliers> result = seedMultipliersController.getSeedMultipliers();

			// Assert
			assertNotNull(result, "Seed multipliers list should not be null");
			assertEquals(2, result.size(), "Should return 2 seed multipliers");
			assertEquals("John", result.get(0).getFirstName(), "First multiplier's name should be John");
			assertEquals("Jane", result.get(1).getFirstName(), "Second multiplier's name should be Jane");
			verify(seedMultipliersService, times(1)).getSeedMultipliers();
		}

		@Test
		@DisplayName("Should return empty list when no seed multipliers exist")
		void testGetSeedMultipliersEmptyList() {
			// Arrange
			List<SeedMultipliers> expectedMultipliers = new ArrayList<>();
			when(seedMultipliersService.getSeedMultipliers()).thenReturn(expectedMultipliers);

			// Act
			List<SeedMultipliers> result = seedMultipliersController.getSeedMultipliers();

			// Assert
			assertNotNull(result, "Seed multipliers list should not be null");
			assertTrue(result.isEmpty(), "Seed multipliers list should be empty");
			assertEquals(0, result.size(), "Size should be 0");
			verify(seedMultipliersService, times(1)).getSeedMultipliers();
		}

		@Test
		@DisplayName("Should return list with single seed multiplier")
		void testGetSeedMultipliersSingleMultiplier() {
			// Arrange
			List<SeedMultipliers> expectedMultipliers = new ArrayList<>();
			SeedMultipliers multiplier = new SeedMultipliers();
			multiplier.setMetaInstanceId("multiplier1");
			multiplier.setFirstName("John");
			expectedMultipliers.add(multiplier);

			when(seedMultipliersService.getSeedMultipliers()).thenReturn(expectedMultipliers);

			// Act
			List<SeedMultipliers> result = seedMultipliersController.getSeedMultipliers();

			// Assert
			assertNotNull(result, "Seed multipliers list should not be null");
			assertEquals(1, result.size(), "Should return 1 seed multiplier");
			assertEquals("John", result.get(0).getFirstName());
			verify(seedMultipliersService, times(1)).getSeedMultipliers();
		}

		@Test
		@DisplayName("Should return large list of seed multipliers")
		void testGetSeedMultipliersLargeList() {
			// Arrange
			List<SeedMultipliers> expectedMultipliers = new ArrayList<>();
			for (int i = 0; i < 1000; i++) {
				SeedMultipliers multiplier = new SeedMultipliers();
				multiplier.setMetaInstanceId("multiplier" + i);
				multiplier.setFirstName("FirstName" + i);
				expectedMultipliers.add(multiplier);
			}
			when(seedMultipliersService.getSeedMultipliers()).thenReturn(expectedMultipliers);

			// Act
			List<SeedMultipliers> result = seedMultipliersController.getSeedMultipliers();

			// Assert
			assertNotNull(result, "Seed multipliers list should not be null");
			assertEquals(1000, result.size(), "Should return 1000 seed multipliers");
			verify(seedMultipliersService, times(1)).getSeedMultipliers();
		}

		@Test
		@DisplayName("Should handle seed multipliers with null fields")
		void testGetSeedMultipliersWithNullFields() {
			// Arrange
			List<SeedMultipliers> expectedMultipliers = new ArrayList<>();
			SeedMultipliers multiplier = new SeedMultipliers();
			multiplier.setMetaInstanceId("multiplier1");
			multiplier.setFirstName(null);
			multiplier.setLastName(null);
			multiplier.setSeedMultiplierSex(null);
			expectedMultipliers.add(multiplier);

			when(seedMultipliersService.getSeedMultipliers()).thenReturn(expectedMultipliers);

			// Act
			List<SeedMultipliers> result = seedMultipliersController.getSeedMultipliers();

			// Assert
			assertNotNull(result, "Seed multipliers list should not be null");
			assertEquals(1, result.size(), "Should return 1 seed multiplier");
			assertNull(result.get(0).getFirstName(), "FirstName should be null");
			assertNull(result.get(0).getLastName(), "LastName should be null");
			verify(seedMultipliersService, times(1)).getSeedMultipliers();
		}

		@Test
		@DisplayName("Should return seed multipliers with special characters in names")
		void testGetSeedMultipliersWithSpecialCharacters() {
			// Arrange
			List<SeedMultipliers> expectedMultipliers = new ArrayList<>();
			SeedMultipliers multiplier = new SeedMultipliers();
			multiplier.setMetaInstanceId("multiplier1");
			multiplier.setFirstName("Jean-Pierre");
			multiplier.setLastName("O'Brien");
			expectedMultipliers.add(multiplier);

			when(seedMultipliersService.getSeedMultipliers()).thenReturn(expectedMultipliers);

			// Act
			List<SeedMultipliers> result = seedMultipliersController.getSeedMultipliers();

			// Assert
			assertNotNull(result, "Seed multipliers list should not be null");
			assertEquals(1, result.size(), "Should return 1 seed multiplier");
			assertEquals("Jean-Pierre", result.get(0).getFirstName());
			assertEquals("O'Brien", result.get(0).getLastName());
			verify(seedMultipliersService, times(1)).getSeedMultipliers();
		}

		@Test
		@DisplayName("Should handle service exception gracefully")
		void testGetSeedMultipliersServiceThrowsException() {
			// Arrange
			when(seedMultipliersService.getSeedMultipliers()).thenThrow(new RuntimeException("Database connection failed"));

			// Act & Assert
			assertThrows(RuntimeException.class, () -> seedMultipliersController.getSeedMultipliers(),
					"Should throw RuntimeException when service fails");
			verify(seedMultipliersService, times(1)).getSeedMultipliers();
		}

	}

	@Nested
	@DisplayName("GetSeedMultipliersAnalysis Method Tests")
	class GetSeedMultipliersAnalysisTests {

		@Test
		@DisplayName("Should return seed multipliers analysis with valid data")
		void testGetSeedMultipliersAnalysisSuccess() {
			// Arrange
			Map<String, Integer> maleAgeCohorts = new HashMap<>();
			maleAgeCohorts.put("18-25", 50);
			maleAgeCohorts.put("26-35", 75);

			Map<String, Integer> femaleAgeCohorts = new HashMap<>();
			femaleAgeCohorts.put("18-25", 40);
			femaleAgeCohorts.put("26-35", 65);

			Map<String, Integer> multipliersDistricts = new HashMap<>();
			multipliersDistricts.put("Kampala", 80);
			multipliersDistricts.put("Mukono", 60);

			Map<String, Integer> plantingMaterialsFreq = new HashMap<>();
			plantingMaterialsFreq.put("Banana", 100);
			plantingMaterialsFreq.put("Potato", 80);

			Map<String, Integer> varietiesFreq = new HashMap<>();
			varietiesFreq.put("Local", 120);
			varietiesFreq.put("Improved", 60);

			Map<String, Integer> bananaVarietiesFreq = new HashMap<>();
			bananaVarietiesFreq.put("Matooke", 80);
			bananaVarietiesFreq.put("Musa", 40);

			Map<String, Integer> potatoVarietiesFreq = new HashMap<>();
			potatoVarietiesFreq.put("Irish", 50);
			potatoVarietiesFreq.put("Sweet", 30);

			Map<String, Integer> plantingMethodsFreq = new HashMap<>();
			plantingMethodsFreq.put("Traditional", 90);
			plantingMethodsFreq.put("Modern", 90);

			when(seedMultipliersService.getMalePercent()).thenReturn(55.5);
			when(seedMultipliersService.getFemalePercent()).thenReturn(44.5);
			when(seedMultipliersService.getMaleAverageAge()).thenReturn(35);
			when(seedMultipliersService.getFemaleAverageAge()).thenReturn(32);
			when(seedMultipliersService.getMaleMedianAge()).thenReturn(34);
			when(seedMultipliersService.getFemaleMedianAge()).thenReturn(31);
			when(seedMultipliersService.getMaleAgeCohorts()).thenReturn(maleAgeCohorts);
			when(seedMultipliersService.getFemaleAgeCohorts()).thenReturn(femaleAgeCohorts);
			when(seedMultipliersService.getIndividualMultipliersPercent()).thenReturn(60.0);
			when(seedMultipliersService.getGroupMultipliersPercent()).thenReturn(40.0);
			when(seedMultipliersService.getAverageGroupSize()).thenReturn(12);
			when(seedMultipliersService.getMedianGroupSize()).thenReturn(10);
			when(seedMultipliersService.getAverageFemaleMembersPerGroup()).thenReturn(6);
			when(seedMultipliersService.getAverageMaleMembersPerGroup()).thenReturn(6);
			when(seedMultipliersService.getMultipliersDistricts()).thenReturn(multipliersDistricts);
			when(seedMultipliersService.getPlantingMaterialsFrequency()).thenReturn(plantingMaterialsFreq);
			when(seedMultipliersService.getPlantingMaterialsVarietiesFrequency()).thenReturn(varietiesFreq);
			when(seedMultipliersService.getBananaVarietiesFrequency()).thenReturn(bananaVarietiesFreq);
			when(seedMultipliersService.getPotatoVarietiesFrequency()).thenReturn(potatoVarietiesFreq);
			when(seedMultipliersService.getPlantingMethodsFrequency()).thenReturn(plantingMethodsFreq);

			// Act
			SeedMultipliersAnalysisDto result = seedMultipliersController.getSeedMultipliersAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertEquals(55.5, result.getMalePercent(), "Male percent should be 55.5");
			assertEquals(44.5, result.getFemalePercent(), "Female percent should be 44.5");
			assertEquals(35, result.getMaleAverageAge(), "Male average age should be 35");
			assertEquals(32, result.getFemaleAverageAge(), "Female average age should be 32");
			assertEquals(34, result.getMaleMedianAge(), "Male median age should be 34");
			assertEquals(31, result.getFemaleMedianAge(), "Female median age should be 31");
			assertEquals(2, result.getMaleAgeCohorts().size(), "Should have 2 male age cohorts");
			assertEquals(2, result.getFemaleAgeCohorts().size(), "Should have 2 female age cohorts");
			assertEquals(60.0, result.getIndividualMultipliersPercent(), "Individual multipliers percent should be 60.0");
			assertEquals(40.0, result.getGroupMultipliersPercent(), "Group multipliers percent should be 40.0");
			assertEquals(12, result.getAverageGroupSize(), "Average group size should be 12");
			assertEquals(10, result.getMedianGroupSize(), "Median group size should be 10");
			assertEquals(6, result.getAverageFemaleMembersPerGroup(), "Average female members per group should be 6");
			assertEquals(6, result.getAverageMaleMembersPerGroup(), "Average male members per group should be 6");
			assertEquals(2, result.getMultipliersDistricts().size(), "Should have 2 districts");
			assertEquals(2, result.getPlantingMaterialsFrequency().size(), "Should have 2 planting materials");
			assertEquals(2, result.getPlantingMaterialsVarietiesFrequency().size(), "Should have 2 varieties");
			assertEquals(2, result.getBananaPlantingVarietiesFrequency().size(), "Should have 2 banana varieties");
			assertEquals(2, result.getPotatoPlantingVarietiesFrequency().size(), "Should have 2 potato varieties");
			assertEquals(2, result.getPlantingMethodsFrequency().size(), "Should have 2 planting methods");

			// Verify all service methods were called
			verify(seedMultipliersService, times(1)).getMalePercent();
			verify(seedMultipliersService, times(1)).getFemalePercent();
			verify(seedMultipliersService, times(1)).getMaleAverageAge();
			verify(seedMultipliersService, times(1)).getFemaleAverageAge();
			verify(seedMultipliersService, times(1)).getMaleMedianAge();
			verify(seedMultipliersService, times(1)).getFemaleMedianAge();
			verify(seedMultipliersService, times(1)).getMaleAgeCohorts();
			verify(seedMultipliersService, times(1)).getFemaleAgeCohorts();
			verify(seedMultipliersService, times(1)).getIndividualMultipliersPercent();
			verify(seedMultipliersService, times(1)).getGroupMultipliersPercent();
			verify(seedMultipliersService, times(1)).getAverageGroupSize();
			verify(seedMultipliersService, times(1)).getMedianGroupSize();
			verify(seedMultipliersService, times(1)).getAverageFemaleMembersPerGroup();
			verify(seedMultipliersService, times(1)).getAverageMaleMembersPerGroup();
			verify(seedMultipliersService, times(1)).getMultipliersDistricts();
			verify(seedMultipliersService, times(1)).getPlantingMaterialsFrequency();
			verify(seedMultipliersService, times(1)).getPlantingMaterialsVarietiesFrequency();
			verify(seedMultipliersService, times(1)).getBananaVarietiesFrequency();
			verify(seedMultipliersService, times(1)).getPotatoVarietiesFrequency();
			verify(seedMultipliersService, times(1)).getPlantingMethodsFrequency();
		}

		@Test
		@DisplayName("Should handle zero percent values")
		void testGetSeedMultipliersAnalysisZeroPercent() {
			// Arrange
			when(seedMultipliersService.getMalePercent()).thenReturn(0.0);
			when(seedMultipliersService.getFemalePercent()).thenReturn(100.0);
			when(seedMultipliersService.getMaleAverageAge()).thenReturn(0);
			when(seedMultipliersService.getFemaleAverageAge()).thenReturn(30);
			when(seedMultipliersService.getMaleMedianAge()).thenReturn(0);
			when(seedMultipliersService.getFemaleMedianAge()).thenReturn(29);
			when(seedMultipliersService.getMaleAgeCohorts()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getFemaleAgeCohorts()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getIndividualMultipliersPercent()).thenReturn(0.0);
			when(seedMultipliersService.getGroupMultipliersPercent()).thenReturn(100.0);
			when(seedMultipliersService.getAverageGroupSize()).thenReturn(0);
			when(seedMultipliersService.getMedianGroupSize()).thenReturn(0);
			when(seedMultipliersService.getAverageFemaleMembersPerGroup()).thenReturn(0);
			when(seedMultipliersService.getAverageMaleMembersPerGroup()).thenReturn(0);
			when(seedMultipliersService.getMultipliersDistricts()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getPlantingMaterialsFrequency()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getPlantingMaterialsVarietiesFrequency()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getBananaVarietiesFrequency()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getPotatoVarietiesFrequency()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getPlantingMethodsFrequency()).thenReturn(new HashMap<>());

			// Act
			SeedMultipliersAnalysisDto result = seedMultipliersController.getSeedMultipliersAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertEquals(0.0, result.getMalePercent(), "Male percent should be 0.0");
			assertEquals(100.0, result.getFemalePercent(), "Female percent should be 100.0");
			assertEquals(0, result.getMaleAverageAge(), "Male average age should be 0");
			assertEquals(0.0, result.getIndividualMultipliersPercent(), "Individual multipliers percent should be 0.0");
			assertEquals(100.0, result.getGroupMultipliersPercent(), "Group multipliers percent should be 100.0");
			assertEquals(0, result.getAverageGroupSize(), "Average group size should be 0");
			assertTrue(result.getMaleAgeCohorts().isEmpty(), "Male age cohorts should be empty");
			assertTrue(result.getFemaleAgeCohorts().isEmpty(), "Female age cohorts should be empty");
			assertTrue(result.getMultipliersDistricts().isEmpty(), "Districts should be empty");
		}

		@Test
		@DisplayName("Should handle empty maps for all frequency data")
		void testGetSeedMultipliersAnalysisEmptyMaps() {
			// Arrange
			Map<String, Integer> emptyMaleCohorts = new HashMap<>();
			Map<String, Integer> emptyFemaleCohorts = new HashMap<>();
			Map<String, Integer> emptyDistricts = new HashMap<>();
			Map<String, Integer> emptyPlantingMaterials = new HashMap<>();
			Map<String, Integer> emptyVarieties = new HashMap<>();
			Map<String, Integer> emptyBananaVarieties = new HashMap<>();
			Map<String, Integer> emptyPotatoVarieties = new HashMap<>();
			Map<String, Integer> emptyPlantingMethods = new HashMap<>();

			when(seedMultipliersService.getMalePercent()).thenReturn(50.0);
			when(seedMultipliersService.getFemalePercent()).thenReturn(50.0);
			when(seedMultipliersService.getMaleAverageAge()).thenReturn(30);
			when(seedMultipliersService.getFemaleAverageAge()).thenReturn(30);
			when(seedMultipliersService.getMaleMedianAge()).thenReturn(30);
			when(seedMultipliersService.getFemaleMedianAge()).thenReturn(30);
			when(seedMultipliersService.getMaleAgeCohorts()).thenReturn(emptyMaleCohorts);
			when(seedMultipliersService.getFemaleAgeCohorts()).thenReturn(emptyFemaleCohorts);
			when(seedMultipliersService.getIndividualMultipliersPercent()).thenReturn(50.0);
			when(seedMultipliersService.getGroupMultipliersPercent()).thenReturn(50.0);
			when(seedMultipliersService.getAverageGroupSize()).thenReturn(10);
			when(seedMultipliersService.getMedianGroupSize()).thenReturn(8);
			when(seedMultipliersService.getAverageFemaleMembersPerGroup()).thenReturn(5);
			when(seedMultipliersService.getAverageMaleMembersPerGroup()).thenReturn(5);
			when(seedMultipliersService.getMultipliersDistricts()).thenReturn(emptyDistricts);
			when(seedMultipliersService.getPlantingMaterialsFrequency()).thenReturn(emptyPlantingMaterials);
			when(seedMultipliersService.getPlantingMaterialsVarietiesFrequency()).thenReturn(emptyVarieties);
			when(seedMultipliersService.getBananaVarietiesFrequency()).thenReturn(emptyBananaVarieties);
			when(seedMultipliersService.getPotatoVarietiesFrequency()).thenReturn(emptyPotatoVarieties);
			when(seedMultipliersService.getPlantingMethodsFrequency()).thenReturn(emptyPlantingMethods);

			// Act
			SeedMultipliersAnalysisDto result = seedMultipliersController.getSeedMultipliersAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertNotNull(result.getMaleAgeCohorts(), "Male age cohorts map should not be null");
			assertNotNull(result.getFemaleAgeCohorts(), "Female age cohorts map should not be null");
			assertNotNull(result.getMultipliersDistricts(), "Districts map should not be null");
			assertNotNull(result.getPlantingMaterialsFrequency(), "Planting materials frequency should not be null");
			assertNotNull(result.getPlantingMaterialsVarietiesFrequency(), "Varieties frequency should not be null");
			assertNotNull(result.getBananaPlantingVarietiesFrequency(), "Banana varieties frequency should not be null");
			assertNotNull(result.getPotatoPlantingVarietiesFrequency(), "Potato varieties frequency should not be null");
			assertNotNull(result.getPlantingMethodsFrequency(), "Planting methods frequency should not be null");

			assertTrue(result.getMaleAgeCohorts().isEmpty(), "Male age cohorts should be empty");
			assertTrue(result.getFemaleAgeCohorts().isEmpty(), "Female age cohorts should be empty");
			assertTrue(result.getMultipliersDistricts().isEmpty(), "Districts should be empty");
			assertTrue(result.getPlantingMaterialsFrequency().isEmpty(), "Planting materials frequency should be empty");
			assertTrue(result.getPlantingMaterialsVarietiesFrequency().isEmpty(), "Varieties frequency should be empty");
			assertTrue(result.getBananaPlantingVarietiesFrequency().isEmpty(), "Banana varieties frequency should be empty");
			assertTrue(result.getPotatoPlantingVarietiesFrequency().isEmpty(), "Potato varieties frequency should be empty");
			assertTrue(result.getPlantingMethodsFrequency().isEmpty(), "Planting methods frequency should be empty");
		}

		@Test
		@DisplayName("Should handle large frequency data sets")
		void testGetSeedMultipliersAnalysisLargeData() {
			// Arrange
			Map<String, Integer> maleAgeCohorts = new HashMap<>();
			for (int i = 0; i < 100; i++) {
				maleAgeCohorts.put("Cohort" + i, i * 10);
			}

			Map<String, Integer> femaleAgeCohorts = new HashMap<>();
			for (int i = 0; i < 80; i++) {
				femaleAgeCohorts.put("FemaleCohort" + i, i * 8);
			}

			Map<String, Integer> districts = new HashMap<>();
			for (int i = 0; i < 50; i++) {
				districts.put("District" + i, i * 5);
			}

			Map<String, Integer> plantingMaterials = new HashMap<>();
			for (int i = 0; i < 20; i++) {
				plantingMaterials.put("Material" + i, i * 10);
			}

			Map<String, Integer> varieties = new HashMap<>();
			for (int i = 0; i < 30; i++) {
				varieties.put("Variety" + i, i * 7);
			}

			Map<String, Integer> bananaVarieties = new HashMap<>();
			for (int i = 0; i < 15; i++) {
				bananaVarieties.put("Banana" + i, i * 12);
			}

			Map<String, Integer> potatoVarieties = new HashMap<>();
			for (int i = 0; i < 12; i++) {
				potatoVarieties.put("Potato" + i, i * 9);
			}

			Map<String, Integer> plantingMethods = new HashMap<>();
			for (int i = 0; i < 8; i++) {
				plantingMethods.put("Method" + i, i * 15);
			}

			when(seedMultipliersService.getMalePercent()).thenReturn(50.0);
			when(seedMultipliersService.getFemalePercent()).thenReturn(50.0);
			when(seedMultipliersService.getMaleAverageAge()).thenReturn(35);
			when(seedMultipliersService.getFemaleAverageAge()).thenReturn(35);
			when(seedMultipliersService.getMaleMedianAge()).thenReturn(34);
			when(seedMultipliersService.getFemaleMedianAge()).thenReturn(34);
			when(seedMultipliersService.getMaleAgeCohorts()).thenReturn(maleAgeCohorts);
			when(seedMultipliersService.getFemaleAgeCohorts()).thenReturn(femaleAgeCohorts);
			when(seedMultipliersService.getIndividualMultipliersPercent()).thenReturn(50.0);
			when(seedMultipliersService.getGroupMultipliersPercent()).thenReturn(50.0);
			when(seedMultipliersService.getAverageGroupSize()).thenReturn(15);
			when(seedMultipliersService.getMedianGroupSize()).thenReturn(12);
			when(seedMultipliersService.getAverageFemaleMembersPerGroup()).thenReturn(7);
			when(seedMultipliersService.getAverageMaleMembersPerGroup()).thenReturn(8);
			when(seedMultipliersService.getMultipliersDistricts()).thenReturn(districts);
			when(seedMultipliersService.getPlantingMaterialsFrequency()).thenReturn(plantingMaterials);
			when(seedMultipliersService.getPlantingMaterialsVarietiesFrequency()).thenReturn(varieties);
			when(seedMultipliersService.getBananaVarietiesFrequency()).thenReturn(bananaVarieties);
			when(seedMultipliersService.getPotatoVarietiesFrequency()).thenReturn(potatoVarieties);
			when(seedMultipliersService.getPlantingMethodsFrequency()).thenReturn(plantingMethods);

			// Act
			SeedMultipliersAnalysisDto result = seedMultipliersController.getSeedMultipliersAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertEquals(100, result.getMaleAgeCohorts().size(), "Should have 100 male age cohorts");
			assertEquals(80, result.getFemaleAgeCohorts().size(), "Should have 80 female age cohorts");
			assertEquals(50, result.getMultipliersDistricts().size(), "Should have 50 districts");
			assertEquals(20, result.getPlantingMaterialsFrequency().size(), "Should have 20 planting materials");
			assertEquals(30, result.getPlantingMaterialsVarietiesFrequency().size(), "Should have 30 varieties");
			assertEquals(15, result.getBananaPlantingVarietiesFrequency().size(), "Should have 15 banana varieties");
			assertEquals(12, result.getPotatoPlantingVarietiesFrequency().size(), "Should have 12 potato varieties");
			assertEquals(8, result.getPlantingMethodsFrequency().size(), "Should have 8 planting methods");
		}

		@Test
		@DisplayName("Should handle decimal values for percentages")
		void testGetSeedMultipliersAnalysisDecimalPercentages() {
			// Arrange
			when(seedMultipliersService.getMalePercent()).thenReturn(33.3333);
			when(seedMultipliersService.getFemalePercent()).thenReturn(66.6667);
			when(seedMultipliersService.getIndividualMultipliersPercent()).thenReturn(45.6789);
			when(seedMultipliersService.getGroupMultipliersPercent()).thenReturn(54.3211);
			when(seedMultipliersService.getMaleAverageAge()).thenReturn(28);
			when(seedMultipliersService.getFemaleAverageAge()).thenReturn(29);
			when(seedMultipliersService.getMaleMedianAge()).thenReturn(27);
			when(seedMultipliersService.getFemaleMedianAge()).thenReturn(28);
			when(seedMultipliersService.getAverageGroupSize()).thenReturn(11);
			when(seedMultipliersService.getMedianGroupSize()).thenReturn(9);
			when(seedMultipliersService.getAverageFemaleMembersPerGroup()).thenReturn(5);
			when(seedMultipliersService.getAverageMaleMembersPerGroup()).thenReturn(6);
			when(seedMultipliersService.getMaleAgeCohorts()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getFemaleAgeCohorts()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getMultipliersDistricts()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getPlantingMaterialsFrequency()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getPlantingMaterialsVarietiesFrequency()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getBananaVarietiesFrequency()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getPotatoVarietiesFrequency()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getPlantingMethodsFrequency()).thenReturn(new HashMap<>());

			// Act
			SeedMultipliersAnalysisDto result = seedMultipliersController.getSeedMultipliersAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertEquals(33.3333, result.getMalePercent(), 0.0001, "Male percent should be 33.3333");
			assertEquals(66.6667, result.getFemalePercent(), 0.0001, "Female percent should be 66.6667");
			assertEquals(45.6789, result.getIndividualMultipliersPercent(), 0.0001, "Individual multipliers percent should be 45.6789");
			assertEquals(54.3211, result.getGroupMultipliersPercent(), 0.0001, "Group multipliers percent should be 54.3211");
		}

		@Test
		@DisplayName("Should handle special characters in district and material names")
		void testGetSeedMultipliersAnalysisSpecialCharacterNames() {
			// Arrange
			Map<String, Integer> districts = new HashMap<>();
			districts.put("North-West", 50);
			districts.put("South-East", 60);
			districts.put("Central/Urban", 70);

			Map<String, Integer> plantingMaterials = new HashMap<>();
			plantingMaterials.put("Banana (Musa)", 80);
			plantingMaterials.put("Sweet Potato", 60);
			plantingMaterials.put("Irish Potato", 40);

			Map<String, Integer> varieties = new HashMap<>();
			varieties.put("Local/Traditional", 100);
			varieties.put("Improved-Modern", 80);

			when(seedMultipliersService.getMalePercent()).thenReturn(50.0);
			when(seedMultipliersService.getFemalePercent()).thenReturn(50.0);
			when(seedMultipliersService.getMaleAverageAge()).thenReturn(30);
			when(seedMultipliersService.getFemaleAverageAge()).thenReturn(30);
			when(seedMultipliersService.getMaleMedianAge()).thenReturn(30);
			when(seedMultipliersService.getFemaleMedianAge()).thenReturn(30);
			when(seedMultipliersService.getMaleAgeCohorts()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getFemaleAgeCohorts()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getIndividualMultipliersPercent()).thenReturn(50.0);
			when(seedMultipliersService.getGroupMultipliersPercent()).thenReturn(50.0);
			when(seedMultipliersService.getAverageGroupSize()).thenReturn(10);
			when(seedMultipliersService.getMedianGroupSize()).thenReturn(8);
			when(seedMultipliersService.getAverageFemaleMembersPerGroup()).thenReturn(5);
			when(seedMultipliersService.getAverageMaleMembersPerGroup()).thenReturn(5);
			when(seedMultipliersService.getMultipliersDistricts()).thenReturn(districts);
			when(seedMultipliersService.getPlantingMaterialsFrequency()).thenReturn(plantingMaterials);
			when(seedMultipliersService.getPlantingMaterialsVarietiesFrequency()).thenReturn(varieties);
			when(seedMultipliersService.getBananaVarietiesFrequency()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getPotatoVarietiesFrequency()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getPlantingMethodsFrequency()).thenReturn(new HashMap<>());

			// Act
			SeedMultipliersAnalysisDto result = seedMultipliersController.getSeedMultipliersAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertEquals(3, result.getMultipliersDistricts().size(), "Should have 3 districts");
			assertEquals(3, result.getPlantingMaterialsFrequency().size(), "Should have 3 planting materials");
			assertEquals(2, result.getPlantingMaterialsVarietiesFrequency().size(), "Should have 2 varieties");
			assertTrue(result.getMultipliersDistricts().containsKey("North-West"), "Should contain North-West district");
			assertTrue(result.getPlantingMaterialsFrequency().containsKey("Banana (Musa)"), "Should contain Banana (Musa)");
			assertTrue(result.getPlantingMaterialsVarietiesFrequency().containsKey("Local/Traditional"), "Should contain Local/Traditional variety");
		}

		@Test
		@DisplayName("Should handle very high age and group size values")
		void testGetSeedMultipliersAnalysisHighValues() {
			// Arrange
			when(seedMultipliersService.getMalePercent()).thenReturn(50.0);
			when(seedMultipliersService.getFemalePercent()).thenReturn(50.0);
			when(seedMultipliersService.getMaleAverageAge()).thenReturn(120);
			when(seedMultipliersService.getFemaleAverageAge()).thenReturn(110);
			when(seedMultipliersService.getMaleMedianAge()).thenReturn(115);
			when(seedMultipliersService.getFemaleMedianAge()).thenReturn(105);
			when(seedMultipliersService.getIndividualMultipliersPercent()).thenReturn(50.0);
			when(seedMultipliersService.getGroupMultipliersPercent()).thenReturn(50.0);
			when(seedMultipliersService.getAverageGroupSize()).thenReturn(500);
			when(seedMultipliersService.getMedianGroupSize()).thenReturn(450);
			when(seedMultipliersService.getAverageFemaleMembersPerGroup()).thenReturn(250);
			when(seedMultipliersService.getAverageMaleMembersPerGroup()).thenReturn(250);
			when(seedMultipliersService.getMaleAgeCohorts()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getFemaleAgeCohorts()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getMultipliersDistricts()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getPlantingMaterialsFrequency()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getPlantingMaterialsVarietiesFrequency()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getBananaVarietiesFrequency()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getPotatoVarietiesFrequency()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getPlantingMethodsFrequency()).thenReturn(new HashMap<>());

			// Act
			SeedMultipliersAnalysisDto result = seedMultipliersController.getSeedMultipliersAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertEquals(120, result.getMaleAverageAge(), "Male average age should be 120");
			assertEquals(110, result.getFemaleAverageAge(), "Female average age should be 110");
			assertEquals(500, result.getAverageGroupSize(), "Average group size should be 500");
			assertEquals(450, result.getMedianGroupSize(), "Median group size should be 450");
			assertEquals(250, result.getAverageFemaleMembersPerGroup(), "Average female members per group should be 250");
			assertEquals(250, result.getAverageMaleMembersPerGroup(), "Average male members per group should be 250");
		}

		@Test
		@DisplayName("Should handle negative percentage values (edge case)")
		void testGetSeedMultipliersAnalysisNegativePercentages() {
			// Arrange
			when(seedMultipliersService.getMalePercent()).thenReturn(-10.0);
			when(seedMultipliersService.getFemalePercent()).thenReturn(110.0);
			when(seedMultipliersService.getIndividualMultipliersPercent()).thenReturn(-5.0);
			when(seedMultipliersService.getGroupMultipliersPercent()).thenReturn(105.0);
			when(seedMultipliersService.getMaleAverageAge()).thenReturn(30);
			when(seedMultipliersService.getFemaleAverageAge()).thenReturn(30);
			when(seedMultipliersService.getMaleMedianAge()).thenReturn(30);
			when(seedMultipliersService.getFemaleMedianAge()).thenReturn(30);
			when(seedMultipliersService.getAverageGroupSize()).thenReturn(10);
			when(seedMultipliersService.getMedianGroupSize()).thenReturn(8);
			when(seedMultipliersService.getAverageFemaleMembersPerGroup()).thenReturn(5);
			when(seedMultipliersService.getAverageMaleMembersPerGroup()).thenReturn(5);
			when(seedMultipliersService.getMaleAgeCohorts()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getFemaleAgeCohorts()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getMultipliersDistricts()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getPlantingMaterialsFrequency()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getPlantingMaterialsVarietiesFrequency()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getBananaVarietiesFrequency()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getPotatoVarietiesFrequency()).thenReturn(new HashMap<>());
			when(seedMultipliersService.getPlantingMethodsFrequency()).thenReturn(new HashMap<>());

			// Act
			SeedMultipliersAnalysisDto result = seedMultipliersController.getSeedMultipliersAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertEquals(-10.0, result.getMalePercent(), "Should handle negative male percent");
			assertEquals(110.0, result.getFemalePercent(), "Should handle female percent > 100");
			assertEquals(-5.0, result.getIndividualMultipliersPercent(), "Should handle negative individual percent");
			assertEquals(105.0, result.getGroupMultipliersPercent(), "Should handle group percent > 100");
		}

		@Test
		@DisplayName("Should handle service exception when fetching analysis")
		void testGetSeedMultipliersAnalysisServiceThrowsException() {
			// Arrange
			when(seedMultipliersService.getMalePercent())
					.thenThrow(new RuntimeException("Database error"));

			// Act & Assert
			assertThrows(RuntimeException.class, () -> seedMultipliersController.getSeedMultipliersAnalysis(),
					"Should throw RuntimeException when service fails");
		}

		@Test
		@DisplayName("Should handle null maps returned from service")
		void testGetSeedMultipliersAnalysisNullMaps() {
			// Arrange
			when(seedMultipliersService.getMalePercent()).thenReturn(50.0);
			when(seedMultipliersService.getFemalePercent()).thenReturn(50.0);
			when(seedMultipliersService.getMaleAverageAge()).thenReturn(30);
			when(seedMultipliersService.getFemaleAverageAge()).thenReturn(30);
			when(seedMultipliersService.getMaleMedianAge()).thenReturn(30);
			when(seedMultipliersService.getFemaleMedianAge()).thenReturn(30);
			when(seedMultipliersService.getMaleAgeCohorts()).thenReturn(null);
			when(seedMultipliersService.getFemaleAgeCohorts()).thenReturn(null);
			when(seedMultipliersService.getIndividualMultipliersPercent()).thenReturn(50.0);
			when(seedMultipliersService.getGroupMultipliersPercent()).thenReturn(50.0);
			when(seedMultipliersService.getAverageGroupSize()).thenReturn(10);
			when(seedMultipliersService.getMedianGroupSize()).thenReturn(8);
			when(seedMultipliersService.getAverageFemaleMembersPerGroup()).thenReturn(5);
			when(seedMultipliersService.getAverageMaleMembersPerGroup()).thenReturn(5);
			when(seedMultipliersService.getMultipliersDistricts()).thenReturn(null);
			when(seedMultipliersService.getPlantingMaterialsFrequency()).thenReturn(null);
			when(seedMultipliersService.getPlantingMaterialsVarietiesFrequency()).thenReturn(null);
			when(seedMultipliersService.getBananaVarietiesFrequency()).thenReturn(null);
			when(seedMultipliersService.getPotatoVarietiesFrequency()).thenReturn(null);
			when(seedMultipliersService.getPlantingMethodsFrequency()).thenReturn(null);

			// Act
			SeedMultipliersAnalysisDto result = seedMultipliersController.getSeedMultipliersAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertNull(result.getMaleAgeCohorts(), "Male age cohorts can be null");
			assertNull(result.getFemaleAgeCohorts(), "Female age cohorts can be null");
			assertNull(result.getMultipliersDistricts(), "Districts can be null");
			assertNull(result.getPlantingMaterialsFrequency(), "Planting materials frequency can be null");
			assertNull(result.getPlantingMaterialsVarietiesFrequency(), "Varieties frequency can be null");
			assertNull(result.getBananaPlantingVarietiesFrequency(), "Banana varieties frequency can be null");
			assertNull(result.getPotatoPlantingVarietiesFrequency(), "Potato varieties frequency can be null");
			assertNull(result.getPlantingMethodsFrequency(), "Planting methods frequency can be null");
		}

		@Test
		@DisplayName("Should return complete analysis data structure")
		void testGetSeedMultipliersAnalysisCompleteStructure() {
			// Arrange
			Map<String, Integer> maleAgeCohorts = new HashMap<>();
			maleAgeCohorts.put("18-25", 100);
			maleAgeCohorts.put("26-35", 150);

			Map<String, Integer> femaleAgeCohorts = new HashMap<>();
			femaleAgeCohorts.put("18-25", 80);
			femaleAgeCohorts.put("26-35", 120);

			Map<String, Integer> districts = new HashMap<>();
			districts.put("Kampala", 120);
			districts.put("Wakiso", 130);

			Map<String, Integer> plantingMaterials = new HashMap<>();
			plantingMaterials.put("Banana", 150);
			plantingMaterials.put("Potato", 100);

			Map<String, Integer> varieties = new HashMap<>();
			varieties.put("Local", 180);
			varieties.put("Improved", 70);

			Map<String, Integer> bananaVarieties = new HashMap<>();
			bananaVarieties.put("Matooke", 120);
			bananaVarieties.put("Musa", 30);

			Map<String, Integer> potatoVarieties = new HashMap<>();
			potatoVarieties.put("Irish", 70);
			potatoVarieties.put("Sweet", 30);

			Map<String, Integer> plantingMethods = new HashMap<>();
			plantingMethods.put("Traditional", 140);
			plantingMethods.put("Modern", 110);

			when(seedMultipliersService.getMalePercent()).thenReturn(60.0);
			when(seedMultipliersService.getFemalePercent()).thenReturn(40.0);
			when(seedMultipliersService.getMaleAverageAge()).thenReturn(32);
			when(seedMultipliersService.getFemaleAverageAge()).thenReturn(28);
			when(seedMultipliersService.getMaleMedianAge()).thenReturn(31);
			when(seedMultipliersService.getFemaleMedianAge()).thenReturn(27);
			when(seedMultipliersService.getMaleAgeCohorts()).thenReturn(maleAgeCohorts);
			when(seedMultipliersService.getFemaleAgeCohorts()).thenReturn(femaleAgeCohorts);
			when(seedMultipliersService.getIndividualMultipliersPercent()).thenReturn(65.0);
			when(seedMultipliersService.getGroupMultipliersPercent()).thenReturn(35.0);
			when(seedMultipliersService.getAverageGroupSize()).thenReturn(14);
			when(seedMultipliersService.getMedianGroupSize()).thenReturn(11);
			when(seedMultipliersService.getAverageFemaleMembersPerGroup()).thenReturn(7);
			when(seedMultipliersService.getAverageMaleMembersPerGroup()).thenReturn(7);
			when(seedMultipliersService.getMultipliersDistricts()).thenReturn(districts);
			when(seedMultipliersService.getPlantingMaterialsFrequency()).thenReturn(plantingMaterials);
			when(seedMultipliersService.getPlantingMaterialsVarietiesFrequency()).thenReturn(varieties);
			when(seedMultipliersService.getBananaVarietiesFrequency()).thenReturn(bananaVarieties);
			when(seedMultipliersService.getPotatoVarietiesFrequency()).thenReturn(potatoVarieties);
			when(seedMultipliersService.getPlantingMethodsFrequency()).thenReturn(plantingMethods);

			// Act
			SeedMultipliersAnalysisDto result = seedMultipliersController.getSeedMultipliersAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertNotNull(result.getMaleAgeCohorts(), "Male age cohorts should not be null");
			assertNotNull(result.getFemaleAgeCohorts(), "Female age cohorts should not be null");
			assertNotNull(result.getMultipliersDistricts(), "Districts should not be null");
			assertNotNull(result.getPlantingMaterialsFrequency(), "Planting materials frequency should not be null");
			assertNotNull(result.getPlantingMaterialsVarietiesFrequency(), "Varieties frequency should not be null");
			assertNotNull(result.getBananaPlantingVarietiesFrequency(), "Banana varieties frequency should not be null");
			assertNotNull(result.getPotatoPlantingVarietiesFrequency(), "Potato varieties frequency should not be null");
			assertNotNull(result.getPlantingMethodsFrequency(), "Planting methods frequency should not be null");

			assertEquals(100, result.getMaleAgeCohorts().get("18-25"), "Male age cohort 18-25 should have 100 multipliers");
			assertEquals(80, result.getFemaleAgeCohorts().get("18-25"), "Female age cohort 18-25 should have 80 multipliers");
			assertEquals(120, result.getMultipliersDistricts().get("Kampala"), "Kampala should have 120 multipliers");
			assertEquals(150, result.getPlantingMaterialsFrequency().get("Banana"), "Banana should have 150 frequency");
			assertEquals(180, result.getPlantingMaterialsVarietiesFrequency().get("Local"), "Local variety should have 180 frequency");
			assertEquals(120, result.getBananaPlantingVarietiesFrequency().get("Matooke"), "Matooke should have 120 frequency");
			assertEquals(70, result.getPotatoPlantingVarietiesFrequency().get("Irish"), "Irish potato should have 70 frequency");
			assertEquals(140, result.getPlantingMethodsFrequency().get("Traditional"), "Traditional method should have 140 frequency");
		}

	}

	@Nested
	@DisplayName("Controller Initialization Tests")
	class ControllerInitializationTests {

		@Test
		@DisplayName("Should initialize controller with non-null service")
		void testControllerInitialization() {
			// Assert
			assertNotNull(seedMultipliersController, "Controller should not be null");
			assertNotNull(seedMultipliersService, "Service mock should not be null");
		}

		@Test
		@DisplayName("Should handle multiple calls sequentially")
		void testMultipleSequentialCalls() {
			// Arrange
			when(seedMultipliersService.getSeedMultipliers()).thenReturn(new ArrayList<>());

			// Act
			List<SeedMultipliers> result1 = seedMultipliersController.getSeedMultipliers();
			List<SeedMultipliers> result2 = seedMultipliersController.getSeedMultipliers();
			List<SeedMultipliers> result3 = seedMultipliersController.getSeedMultipliers();

			// Assert
			assertNotNull(result1);
			assertNotNull(result2);
			assertNotNull(result3);
			verify(seedMultipliersService, times(3)).getSeedMultipliers();
		}

	}

}

