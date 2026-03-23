package io.trustbirungi.seedTracingApi.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import io.trustbirungi.seedTracingApi.dto.TechDiffusionAnalysisDto;
import io.trustbirungi.seedTracingApi.entity.SeedMultipliers;
import io.trustbirungi.seedTracingApi.service.TechDiffusionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName("TechDiffusionController Unit Tests")
class TechDiffusionControllerTest {

	@Mock
	private TechDiffusionService techDiffusionService;

	private TechDiffusionController techDiffusionController;

	@BeforeEach
	void setUp() {
		techDiffusionController = new TechDiffusionController(techDiffusionService);
	}

	@Nested
	@DisplayName("GetAll Method Tests")
	class GetAllTests {

		@Test
		@DisplayName("Should return list of seed multipliers successfully")
		void testGetAllSuccess() {
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

			when(techDiffusionService.getSeedMultipliers()).thenReturn(expectedMultipliers);

			// Act
			List<SeedMultipliers> result = techDiffusionController.getAll();

			// Assert
			assertNotNull(result, "Seed multipliers list should not be null");
			assertEquals(2, result.size(), "Should return 2 seed multipliers");
			assertEquals("John", result.get(0).getFirstName(), "First multiplier's name should be John");
			assertEquals("Jane", result.get(1).getFirstName(), "Second multiplier's name should be Jane");
			verify(techDiffusionService, times(1)).getSeedMultipliers();
		}

		@Test
		@DisplayName("Should return empty list when no seed multipliers exist")
		void testGetAllEmptyList() {
			// Arrange
			List<SeedMultipliers> expectedMultipliers = new ArrayList<>();
			when(techDiffusionService.getSeedMultipliers()).thenReturn(expectedMultipliers);

			// Act
			List<SeedMultipliers> result = techDiffusionController.getAll();

			// Assert
			assertNotNull(result, "Seed multipliers list should not be null");
			assertTrue(result.isEmpty(), "Seed multipliers list should be empty");
			assertEquals(0, result.size(), "Size should be 0");
			verify(techDiffusionService, times(1)).getSeedMultipliers();
		}

		@Test
		@DisplayName("Should return list with single seed multiplier")
		void testGetAllSingleMultiplier() {
			// Arrange
			List<SeedMultipliers> expectedMultipliers = new ArrayList<>();
			SeedMultipliers multiplier = new SeedMultipliers();
			multiplier.setMetaInstanceId("multiplier1");
			multiplier.setFirstName("John");
			expectedMultipliers.add(multiplier);

			when(techDiffusionService.getSeedMultipliers()).thenReturn(expectedMultipliers);

			// Act
			List<SeedMultipliers> result = techDiffusionController.getAll();

			// Assert
			assertNotNull(result, "Seed multipliers list should not be null");
			assertEquals(1, result.size(), "Should return 1 seed multiplier");
			assertEquals("John", result.get(0).getFirstName());
			verify(techDiffusionService, times(1)).getSeedMultipliers();
		}

		@Test
		@DisplayName("Should return large list of seed multipliers")
		void testGetAllLargeList() {
			// Arrange
			List<SeedMultipliers> expectedMultipliers = new ArrayList<>();
			for (int i = 0; i < 1000; i++) {
				SeedMultipliers multiplier = new SeedMultipliers();
				multiplier.setMetaInstanceId("multiplier" + i);
				multiplier.setFirstName("FirstName" + i);
				expectedMultipliers.add(multiplier);
			}
			when(techDiffusionService.getSeedMultipliers()).thenReturn(expectedMultipliers);

			// Act
			List<SeedMultipliers> result = techDiffusionController.getAll();

			// Assert
			assertNotNull(result, "Seed multipliers list should not be null");
			assertEquals(1000, result.size(), "Should return 1000 seed multipliers");
			verify(techDiffusionService, times(1)).getSeedMultipliers();
		}

		@Test
		@DisplayName("Should handle seed multipliers with null fields")
		void testGetAllWithNullFields() {
			// Arrange
			List<SeedMultipliers> expectedMultipliers = new ArrayList<>();
			SeedMultipliers multiplier = new SeedMultipliers();
			multiplier.setMetaInstanceId("multiplier1");
			multiplier.setFirstName(null);
			multiplier.setLastName(null);
			multiplier.setSeedMultiplierSex(null);
			expectedMultipliers.add(multiplier);

			when(techDiffusionService.getSeedMultipliers()).thenReturn(expectedMultipliers);

			// Act
			List<SeedMultipliers> result = techDiffusionController.getAll();

			// Assert
			assertNotNull(result, "Seed multipliers list should not be null");
			assertEquals(1, result.size(), "Should return 1 seed multiplier");
			assertNull(result.get(0).getFirstName(), "FirstName should be null");
			assertNull(result.get(0).getLastName(), "LastName should be null");
			verify(techDiffusionService, times(1)).getSeedMultipliers();
		}

		@Test
		@DisplayName("Should return seed multipliers with special characters in names")
		void testGetAllWithSpecialCharacters() {
			// Arrange
			List<SeedMultipliers> expectedMultipliers = new ArrayList<>();
			SeedMultipliers multiplier = new SeedMultipliers();
			multiplier.setMetaInstanceId("multiplier1");
			multiplier.setFirstName("Jean-Pierre");
			multiplier.setLastName("O'Brien");
			expectedMultipliers.add(multiplier);

			when(techDiffusionService.getSeedMultipliers()).thenReturn(expectedMultipliers);

			// Act
			List<SeedMultipliers> result = techDiffusionController.getAll();

			// Assert
			assertNotNull(result, "Seed multipliers list should not be null");
			assertEquals(1, result.size(), "Should return 1 seed multiplier");
			assertEquals("Jean-Pierre", result.get(0).getFirstName());
			assertEquals("O'Brien", result.get(0).getLastName());
			verify(techDiffusionService, times(1)).getSeedMultipliers();
		}

		@Test
		@DisplayName("Should handle service exception gracefully")
		void testGetAllServiceThrowsException() {
			// Arrange
			when(techDiffusionService.getSeedMultipliers()).thenThrow(new RuntimeException("Database connection failed"));

			// Act & Assert
			assertThrows(RuntimeException.class, () -> techDiffusionController.getAll(),
					"Should throw RuntimeException when service fails");
			verify(techDiffusionService, times(1)).getSeedMultipliers();
		}

	}

	@Nested
	@DisplayName("GetTechDiffusionAnalysis Method Tests")
	class GetTechDiffusionAnalysisTests {

		@Test
		@DisplayName("Should return tech diffusion analysis with valid data")
		void testGetTechDiffusionAnalysisSuccess() {
			// Arrange
			Map<String, Integer> trainingOrgTraineesCount = new HashMap<>();
			trainingOrgTraineesCount.put("NGO A", 50);
			trainingOrgTraineesCount.put("Government", 75);
			trainingOrgTraineesCount.put("Private Company", 25);

			Map<Integer, Integer> trainedFarmersRankings = new HashMap<>();
			trainedFarmersRankings.put(1, 10);
			trainedFarmersRankings.put(2, 8);
			trainedFarmersRankings.put(3, 6);

			Map<String, Integer> trainedFarmersDistricts = new HashMap<>();
			trainedFarmersDistricts.put("Kampala", 80);
			trainedFarmersDistricts.put("Mukono", 60);
			trainedFarmersDistricts.put("Jinja", 40);

			Map<String, Integer> trainedGroupsDistricts = new HashMap<>();
			trainedGroupsDistricts.put("Kampala", 15);
			trainedGroupsDistricts.put("Mukono", 12);
			trainedGroupsDistricts.put("Jinja", 8);

			when(techDiffusionService.getTrainingOrgTraineesCount()).thenReturn(trainingOrgTraineesCount);
			when(techDiffusionService.getFarmersWhoTrainedOthersPercent()).thenReturn(65.5);
			when(techDiffusionService.getFarmersWhoTrainedOtherGroupsPercent()).thenReturn(45.2);
			when(techDiffusionService.getFemaleTrainedFarmersPercent()).thenReturn(55.0);
			when(techDiffusionService.getMaleTrainedFarmersPercent()).thenReturn(45.0);
			when(techDiffusionService.getTrainedFarmersThatTrainedOtherFarmersPercent()).thenReturn(78.3);
			when(techDiffusionService.getTrainedFarmersRankings()).thenReturn(trainedFarmersRankings);
			when(techDiffusionService.getTrainedFarmersDistricts()).thenReturn(trainedFarmersDistricts);
			when(techDiffusionService.getTrainedGroupsDistricts()).thenReturn(trainedGroupsDistricts);

			// Act
			TechDiffusionAnalysisDto result = techDiffusionController.getTechDiffusionAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertEquals(65.5, result.getFarmersWhoTrainedOthersPercent(), "Farmers who trained others percent should be 65.5");
			assertEquals(45.2, result.getFarmersWhoTrainedOtherGroupsPercent(), "Farmers who trained other groups percent should be 45.2");
			assertEquals(55.0, result.getFemaleTrainedFarmersPercent(), "Female trained farmers percent should be 55.0");
			assertEquals(45.0, result.getMaleTrainedFarmersPercent(), "Male trained farmers percent should be 45.0");
			assertEquals(78.3, result.getTrainedFarmersThatTrainedOtherFarmersPercent(), "Trained farmers that trained other farmers percent should be 78.3");
			assertEquals(3, result.getTrainingOrgTraineesCount().size(), "Should have 3 training organizations");
			assertEquals(3, result.getTrainedFarmersRankings().size(), "Should have 3 ranking levels");
			assertEquals(3, result.getTrainedFarmersDistricts().size(), "Should have 3 farmer districts");
			assertEquals(3, result.getTrainedGroupsDistricts().size(), "Should have 3 group districts");

			// Verify all service methods were called
			verify(techDiffusionService, times(1)).getTrainingOrgTraineesCount();
			verify(techDiffusionService, times(1)).getFarmersWhoTrainedOthersPercent();
			verify(techDiffusionService, times(1)).getFarmersWhoTrainedOtherGroupsPercent();
			verify(techDiffusionService, times(1)).getFemaleTrainedFarmersPercent();
			verify(techDiffusionService, times(1)).getMaleTrainedFarmersPercent();
			verify(techDiffusionService, times(1)).getTrainedFarmersThatTrainedOtherFarmersPercent();
			verify(techDiffusionService, times(1)).getTrainedFarmersRankings();
			verify(techDiffusionService, times(1)).getTrainedFarmersDistricts();
			verify(techDiffusionService, times(1)).getTrainedGroupsDistricts();
		}

		@Test
		@DisplayName("Should handle zero percent values")
		void testGetTechDiffusionAnalysisZeroPercent() {
			// Arrange
			when(techDiffusionService.getTrainingOrgTraineesCount()).thenReturn(new HashMap<>());
			when(techDiffusionService.getFarmersWhoTrainedOthersPercent()).thenReturn(0.0);
			when(techDiffusionService.getFarmersWhoTrainedOtherGroupsPercent()).thenReturn(0.0);
			when(techDiffusionService.getFemaleTrainedFarmersPercent()).thenReturn(0.0);
			when(techDiffusionService.getMaleTrainedFarmersPercent()).thenReturn(100.0);
			when(techDiffusionService.getTrainedFarmersThatTrainedOtherFarmersPercent()).thenReturn(0.0);
			when(techDiffusionService.getTrainedFarmersRankings()).thenReturn(new HashMap<>());
			when(techDiffusionService.getTrainedFarmersDistricts()).thenReturn(new HashMap<>());
			when(techDiffusionService.getTrainedGroupsDistricts()).thenReturn(new HashMap<>());

			// Act
			TechDiffusionAnalysisDto result = techDiffusionController.getTechDiffusionAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertEquals(0.0, result.getFarmersWhoTrainedOthersPercent(), "Farmers who trained others percent should be 0.0");
			assertEquals(0.0, result.getFarmersWhoTrainedOtherGroupsPercent(), "Farmers who trained other groups percent should be 0.0");
			assertEquals(0.0, result.getFemaleTrainedFarmersPercent(), "Female trained farmers percent should be 0.0");
			assertEquals(100.0, result.getMaleTrainedFarmersPercent(), "Male trained farmers percent should be 100.0");
			assertEquals(0.0, result.getTrainedFarmersThatTrainedOtherFarmersPercent(), "Trained farmers that trained other farmers percent should be 0.0");
			assertTrue(result.getTrainingOrgTraineesCount().isEmpty(), "Training org trainees count should be empty");
			assertTrue(result.getTrainedFarmersRankings().isEmpty(), "Trained farmers rankings should be empty");
			assertTrue(result.getTrainedFarmersDistricts().isEmpty(), "Trained farmers districts should be empty");
			assertTrue(result.getTrainedGroupsDistricts().isEmpty(), "Trained groups districts should be empty");
		}

		@Test
		@DisplayName("Should handle empty maps for all data")
		void testGetTechDiffusionAnalysisEmptyMaps() {
			// Arrange
			Map<String, Integer> emptyTrainingOrgCount = new HashMap<>();
			Map<Integer, Integer> emptyRankings = new HashMap<>();
			Map<String, Integer> emptyFarmersDistricts = new HashMap<>();
			Map<String, Integer> emptyGroupsDistricts = new HashMap<>();

			when(techDiffusionService.getTrainingOrgTraineesCount()).thenReturn(emptyTrainingOrgCount);
			when(techDiffusionService.getFarmersWhoTrainedOthersPercent()).thenReturn(50.0);
			when(techDiffusionService.getFarmersWhoTrainedOtherGroupsPercent()).thenReturn(50.0);
			when(techDiffusionService.getFemaleTrainedFarmersPercent()).thenReturn(50.0);
			when(techDiffusionService.getMaleTrainedFarmersPercent()).thenReturn(50.0);
			when(techDiffusionService.getTrainedFarmersThatTrainedOtherFarmersPercent()).thenReturn(50.0);
			when(techDiffusionService.getTrainedFarmersRankings()).thenReturn(emptyRankings);
			when(techDiffusionService.getTrainedFarmersDistricts()).thenReturn(emptyFarmersDistricts);
			when(techDiffusionService.getTrainedGroupsDistricts()).thenReturn(emptyGroupsDistricts);

			// Act
			TechDiffusionAnalysisDto result = techDiffusionController.getTechDiffusionAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertNotNull(result.getTrainingOrgTraineesCount(), "Training org trainees count map should not be null");
			assertNotNull(result.getTrainedFarmersRankings(), "Trained farmers rankings map should not be null");
			assertNotNull(result.getTrainedFarmersDistricts(), "Trained farmers districts map should not be null");
			assertNotNull(result.getTrainedGroupsDistricts(), "Trained groups districts map should not be null");

			assertTrue(result.getTrainingOrgTraineesCount().isEmpty(), "Training org trainees count should be empty");
			assertTrue(result.getTrainedFarmersRankings().isEmpty(), "Trained farmers rankings should be empty");
			assertTrue(result.getTrainedFarmersDistricts().isEmpty(), "Trained farmers districts should be empty");
			assertTrue(result.getTrainedGroupsDistricts().isEmpty(), "Trained groups districts should be empty");
		}

		@Test
		@DisplayName("Should handle large data sets")
		void testGetTechDiffusionAnalysisLargeData() {
			// Arrange
			Map<String, Integer> trainingOrgTraineesCount = new HashMap<>();
			for (int i = 0; i < 50; i++) {
				trainingOrgTraineesCount.put("Organization" + i, i * 10);
			}

			Map<Integer, Integer> trainedFarmersRankings = new HashMap<>();
			for (int i = 1; i <= 10; i++) {
				trainedFarmersRankings.put(i, 100 - i * 5);
			}

			Map<String, Integer> trainedFarmersDistricts = new HashMap<>();
			for (int i = 0; i < 30; i++) {
				trainedFarmersDistricts.put("District" + i, i * 15);
			}

			Map<String, Integer> trainedGroupsDistricts = new HashMap<>();
			for (int i = 0; i < 25; i++) {
				trainedGroupsDistricts.put("GroupDistrict" + i, i * 8);
			}

			when(techDiffusionService.getTrainingOrgTraineesCount()).thenReturn(trainingOrgTraineesCount);
			when(techDiffusionService.getFarmersWhoTrainedOthersPercent()).thenReturn(50.0);
			when(techDiffusionService.getFarmersWhoTrainedOtherGroupsPercent()).thenReturn(50.0);
			when(techDiffusionService.getFemaleTrainedFarmersPercent()).thenReturn(50.0);
			when(techDiffusionService.getMaleTrainedFarmersPercent()).thenReturn(50.0);
			when(techDiffusionService.getTrainedFarmersThatTrainedOtherFarmersPercent()).thenReturn(50.0);
			when(techDiffusionService.getTrainedFarmersRankings()).thenReturn(trainedFarmersRankings);
			when(techDiffusionService.getTrainedFarmersDistricts()).thenReturn(trainedFarmersDistricts);
			when(techDiffusionService.getTrainedGroupsDistricts()).thenReturn(trainedGroupsDistricts);

			// Act
			TechDiffusionAnalysisDto result = techDiffusionController.getTechDiffusionAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertEquals(50, result.getTrainingOrgTraineesCount().size(), "Should have 50 training organizations");
			assertEquals(10, result.getTrainedFarmersRankings().size(), "Should have 10 ranking levels");
			assertEquals(30, result.getTrainedFarmersDistricts().size(), "Should have 30 farmer districts");
			assertEquals(25, result.getTrainedGroupsDistricts().size(), "Should have 25 group districts");
		}

		@Test
		@DisplayName("Should handle decimal values for percentages")
		void testGetTechDiffusionAnalysisDecimalPercentages() {
			// Arrange
			when(techDiffusionService.getTrainingOrgTraineesCount()).thenReturn(new HashMap<>());
			when(techDiffusionService.getFarmersWhoTrainedOthersPercent()).thenReturn(33.3333);
			when(techDiffusionService.getFarmersWhoTrainedOtherGroupsPercent()).thenReturn(66.6667);
			when(techDiffusionService.getFemaleTrainedFarmersPercent()).thenReturn(45.6789);
			when(techDiffusionService.getMaleTrainedFarmersPercent()).thenReturn(54.3211);
			when(techDiffusionService.getTrainedFarmersThatTrainedOtherFarmersPercent()).thenReturn(78.9012);
			when(techDiffusionService.getTrainedFarmersRankings()).thenReturn(new HashMap<>());
			when(techDiffusionService.getTrainedFarmersDistricts()).thenReturn(new HashMap<>());
			when(techDiffusionService.getTrainedGroupsDistricts()).thenReturn(new HashMap<>());

			// Act
			TechDiffusionAnalysisDto result = techDiffusionController.getTechDiffusionAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertEquals(33.3333, result.getFarmersWhoTrainedOthersPercent(), 0.0001, "Farmers who trained others percent should be 33.3333");
			assertEquals(66.6667, result.getFarmersWhoTrainedOtherGroupsPercent(), 0.0001, "Farmers who trained other groups percent should be 66.6667");
			assertEquals(45.6789, result.getFemaleTrainedFarmersPercent(), 0.0001, "Female trained farmers percent should be 45.6789");
			assertEquals(54.3211, result.getMaleTrainedFarmersPercent(), 0.0001, "Male trained farmers percent should be 54.3211");
			assertEquals(78.9012, result.getTrainedFarmersThatTrainedOtherFarmersPercent(), 0.0001, "Trained farmers that trained other farmers percent should be 78.9012");
		}

		@Test
		@DisplayName("Should handle special characters in organization and district names")
		void testGetTechDiffusionAnalysisSpecialCharacterNames() {
			// Arrange
			Map<String, Integer> trainingOrgTraineesCount = new HashMap<>();
			trainingOrgTraineesCount.put("NGO A & B", 50);
			trainingOrgTraineesCount.put("Gov't Agency", 75);
			trainingOrgTraineesCount.put("Private Co.", 25);

			Map<String, Integer> trainedFarmersDistricts = new HashMap<>();
			trainedFarmersDistricts.put("North-West", 80);
			trainedFarmersDistricts.put("South-East", 60);
			trainedFarmersDistricts.put("Central/Urban", 40);

			Map<String, Integer> trainedGroupsDistricts = new HashMap<>();
			trainedGroupsDistricts.put("North-West", 15);
			trainedGroupsDistricts.put("South-East", 12);
			trainedGroupsDistricts.put("Central/Urban", 8);

			when(techDiffusionService.getTrainingOrgTraineesCount()).thenReturn(trainingOrgTraineesCount);
			when(techDiffusionService.getFarmersWhoTrainedOthersPercent()).thenReturn(50.0);
			when(techDiffusionService.getFarmersWhoTrainedOtherGroupsPercent()).thenReturn(50.0);
			when(techDiffusionService.getFemaleTrainedFarmersPercent()).thenReturn(50.0);
			when(techDiffusionService.getMaleTrainedFarmersPercent()).thenReturn(50.0);
			when(techDiffusionService.getTrainedFarmersThatTrainedOtherFarmersPercent()).thenReturn(50.0);
			when(techDiffusionService.getTrainedFarmersRankings()).thenReturn(new HashMap<>());
			when(techDiffusionService.getTrainedFarmersDistricts()).thenReturn(trainedFarmersDistricts);
			when(techDiffusionService.getTrainedGroupsDistricts()).thenReturn(trainedGroupsDistricts);

			// Act
			TechDiffusionAnalysisDto result = techDiffusionController.getTechDiffusionAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertEquals(3, result.getTrainingOrgTraineesCount().size(), "Should have 3 training organizations");
			assertEquals(3, result.getTrainedFarmersDistricts().size(), "Should have 3 farmer districts");
			assertEquals(3, result.getTrainedGroupsDistricts().size(), "Should have 3 group districts");
			assertTrue(result.getTrainingOrgTraineesCount().containsKey("NGO A & B"), "Should contain NGO A & B");
			assertTrue(result.getTrainedFarmersDistricts().containsKey("North-West"), "Should contain North-West district");
			assertTrue(result.getTrainedGroupsDistricts().containsKey("Central/Urban"), "Should contain Central/Urban district");
		}

		@Test
		@DisplayName("Should handle negative percentage values (edge case)")
		void testGetTechDiffusionAnalysisNegativePercentages() {
			// Arrange
			when(techDiffusionService.getTrainingOrgTraineesCount()).thenReturn(new HashMap<>());
			when(techDiffusionService.getFarmersWhoTrainedOthersPercent()).thenReturn(-10.0);
			when(techDiffusionService.getFarmersWhoTrainedOtherGroupsPercent()).thenReturn(110.0);
			when(techDiffusionService.getFemaleTrainedFarmersPercent()).thenReturn(-5.0);
			when(techDiffusionService.getMaleTrainedFarmersPercent()).thenReturn(105.0);
			when(techDiffusionService.getTrainedFarmersThatTrainedOtherFarmersPercent()).thenReturn(-15.0);
			when(techDiffusionService.getTrainedFarmersRankings()).thenReturn(new HashMap<>());
			when(techDiffusionService.getTrainedFarmersDistricts()).thenReturn(new HashMap<>());
			when(techDiffusionService.getTrainedGroupsDistricts()).thenReturn(new HashMap<>());

			// Act
			TechDiffusionAnalysisDto result = techDiffusionController.getTechDiffusionAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertEquals(-10.0, result.getFarmersWhoTrainedOthersPercent(), "Should handle negative farmers who trained others percent");
			assertEquals(110.0, result.getFarmersWhoTrainedOtherGroupsPercent(), "Should handle farmers who trained other groups percent > 100");
			assertEquals(-5.0, result.getFemaleTrainedFarmersPercent(), "Should handle negative female trained farmers percent");
			assertEquals(105.0, result.getMaleTrainedFarmersPercent(), "Should handle male trained farmers percent > 100");
			assertEquals(-15.0, result.getTrainedFarmersThatTrainedOtherFarmersPercent(), "Should handle negative trained farmers that trained other farmers percent");
		}

		@Test
		@DisplayName("Should handle service exception when fetching analysis")
		void testGetTechDiffusionAnalysisServiceThrowsException() {
			// Arrange
			when(techDiffusionService.getTrainingOrgTraineesCount())
					.thenThrow(new RuntimeException("Database error"));

			// Act & Assert
			assertThrows(RuntimeException.class, () -> techDiffusionController.getTechDiffusionAnalysis(),
					"Should throw RuntimeException when service fails");
		}

		@Test
		@DisplayName("Should handle null maps returned from service")
		void testGetTechDiffusionAnalysisNullMaps() {
			// Arrange
			when(techDiffusionService.getTrainingOrgTraineesCount()).thenReturn(null);
			when(techDiffusionService.getFarmersWhoTrainedOthersPercent()).thenReturn(50.0);
			when(techDiffusionService.getFarmersWhoTrainedOtherGroupsPercent()).thenReturn(50.0);
			when(techDiffusionService.getFemaleTrainedFarmersPercent()).thenReturn(50.0);
			when(techDiffusionService.getMaleTrainedFarmersPercent()).thenReturn(50.0);
			when(techDiffusionService.getTrainedFarmersThatTrainedOtherFarmersPercent()).thenReturn(50.0);
			when(techDiffusionService.getTrainedFarmersRankings()).thenReturn(null);
			when(techDiffusionService.getTrainedFarmersDistricts()).thenReturn(null);
			when(techDiffusionService.getTrainedGroupsDistricts()).thenReturn(null);

			// Act
			TechDiffusionAnalysisDto result = techDiffusionController.getTechDiffusionAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertNull(result.getTrainingOrgTraineesCount(), "Training org trainees count can be null");
			assertNull(result.getTrainedFarmersRankings(), "Trained farmers rankings can be null");
			assertNull(result.getTrainedFarmersDistricts(), "Trained farmers districts can be null");
			assertNull(result.getTrainedGroupsDistricts(), "Trained groups districts can be null");
		}

		@Test
		@DisplayName("Should return complete analysis data structure")
		void testGetTechDiffusionAnalysisCompleteStructure() {
			// Arrange
			Map<String, Integer> trainingOrgTraineesCount = new HashMap<>();
			trainingOrgTraineesCount.put("NGO A", 100);
			trainingOrgTraineesCount.put("Government", 150);

			Map<Integer, Integer> trainedFarmersRankings = new HashMap<>();
			trainedFarmersRankings.put(1, 50);
			trainedFarmersRankings.put(2, 40);

			Map<String, Integer> trainedFarmersDistricts = new HashMap<>();
			trainedFarmersDistricts.put("Kampala", 120);
			trainedFarmersDistricts.put("Wakiso", 80);

			Map<String, Integer> trainedGroupsDistricts = new HashMap<>();
			trainedGroupsDistricts.put("Kampala", 25);
			trainedGroupsDistricts.put("Wakiso", 15);

			when(techDiffusionService.getTrainingOrgTraineesCount()).thenReturn(trainingOrgTraineesCount);
			when(techDiffusionService.getFarmersWhoTrainedOthersPercent()).thenReturn(60.0);
			when(techDiffusionService.getFarmersWhoTrainedOtherGroupsPercent()).thenReturn(40.0);
			when(techDiffusionService.getFemaleTrainedFarmersPercent()).thenReturn(55.0);
			when(techDiffusionService.getMaleTrainedFarmersPercent()).thenReturn(45.0);
			when(techDiffusionService.getTrainedFarmersThatTrainedOtherFarmersPercent()).thenReturn(70.0);
			when(techDiffusionService.getTrainedFarmersRankings()).thenReturn(trainedFarmersRankings);
			when(techDiffusionService.getTrainedFarmersDistricts()).thenReturn(trainedFarmersDistricts);
			when(techDiffusionService.getTrainedGroupsDistricts()).thenReturn(trainedGroupsDistricts);

			// Act
			TechDiffusionAnalysisDto result = techDiffusionController.getTechDiffusionAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertNotNull(result.getTrainingOrgTraineesCount(), "Training org trainees count should not be null");
			assertNotNull(result.getTrainedFarmersRankings(), "Trained farmers rankings should not be null");
			assertNotNull(result.getTrainedFarmersDistricts(), "Trained farmers districts should not be null");
			assertNotNull(result.getTrainedGroupsDistricts(), "Trained groups districts should not be null");

			assertEquals(100, result.getTrainingOrgTraineesCount().get("NGO A"), "NGO A should have 100 trainees");
			assertEquals(50, result.getTrainedFarmersRankings().get(1), "Rank 1 should have 50 farmers");
			assertEquals(120, result.getTrainedFarmersDistricts().get("Kampala"), "Kampala should have 120 trained farmers");
			assertEquals(25, result.getTrainedGroupsDistricts().get("Kampala"), "Kampala should have 25 trained groups");
		}

	}

	@Nested
	@DisplayName("Controller Initialization Tests")
	class ControllerInitializationTests {

		@Test
		@DisplayName("Should initialize controller with non-null service")
		void testControllerInitialization() {
			// Assert
			assertNotNull(techDiffusionController, "Controller should not be null");
			assertNotNull(techDiffusionService, "Service mock should not be null");
		}

		@Test
		@DisplayName("Should handle multiple calls sequentially")
		void testMultipleSequentialCalls() {
			// Arrange
			when(techDiffusionService.getSeedMultipliers()).thenReturn(new ArrayList<>());

			// Act
			List<SeedMultipliers> result1 = techDiffusionController.getAll();
			List<SeedMultipliers> result2 = techDiffusionController.getAll();
			List<SeedMultipliers> result3 = techDiffusionController.getAll();

			// Assert
			assertNotNull(result1);
			assertNotNull(result2);
			assertNotNull(result3);
			verify(techDiffusionService, times(3)).getSeedMultipliers();
		}

	}

}

