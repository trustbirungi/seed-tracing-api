package io.trustbirungi.seedTracingApi.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import io.trustbirungi.seedTracingApi.dto.TechUptakeAnalysisDto;
import io.trustbirungi.seedTracingApi.entity.SeedMultipliers;
import io.trustbirungi.seedTracingApi.service.TechUptakeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName("TechUptakeController Unit Tests")
class TechUptakeControllerTest {

	@Mock
	private TechUptakeService techUptakeService;

	private TechUptakeController techUptakeController;

	@BeforeEach
	void setUp() {
		techUptakeController = new TechUptakeController(techUptakeService);
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

			when(techUptakeService.getSeedMultipliers()).thenReturn(expectedMultipliers);

			// Act
			List<SeedMultipliers> result = techUptakeController.getSeedMultipliers();

			// Assert
			assertNotNull(result, "Seed multipliers list should not be null");
			assertEquals(2, result.size(), "Should return 2 seed multipliers");
			assertEquals("John", result.get(0).getFirstName(), "First multiplier's name should be John");
			assertEquals("Jane", result.get(1).getFirstName(), "Second multiplier's name should be Jane");
			verify(techUptakeService, times(1)).getSeedMultipliers();
		}

		@Test
		@DisplayName("Should return empty list when no seed multipliers exist")
		void testGetSeedMultipliersEmptyList() {
			// Arrange
			List<SeedMultipliers> expectedMultipliers = new ArrayList<>();
			when(techUptakeService.getSeedMultipliers()).thenReturn(expectedMultipliers);

			// Act
			List<SeedMultipliers> result = techUptakeController.getSeedMultipliers();

			// Assert
			assertNotNull(result, "Seed multipliers list should not be null");
			assertTrue(result.isEmpty(), "Seed multipliers list should be empty");
			assertEquals(0, result.size(), "Size should be 0");
			verify(techUptakeService, times(1)).getSeedMultipliers();
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

			when(techUptakeService.getSeedMultipliers()).thenReturn(expectedMultipliers);

			// Act
			List<SeedMultipliers> result = techUptakeController.getSeedMultipliers();

			// Assert
			assertNotNull(result, "Seed multipliers list should not be null");
			assertEquals(1, result.size(), "Should return 1 seed multiplier");
			assertEquals("John", result.get(0).getFirstName());
			verify(techUptakeService, times(1)).getSeedMultipliers();
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
			when(techUptakeService.getSeedMultipliers()).thenReturn(expectedMultipliers);

			// Act
			List<SeedMultipliers> result = techUptakeController.getSeedMultipliers();

			// Assert
			assertNotNull(result, "Seed multipliers list should not be null");
			assertEquals(1000, result.size(), "Should return 1000 seed multipliers");
			verify(techUptakeService, times(1)).getSeedMultipliers();
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

			when(techUptakeService.getSeedMultipliers()).thenReturn(expectedMultipliers);

			// Act
			List<SeedMultipliers> result = techUptakeController.getSeedMultipliers();

			// Assert
			assertNotNull(result, "Seed multipliers list should not be null");
			assertEquals(1, result.size(), "Should return 1 seed multiplier");
			assertNull(result.get(0).getFirstName(), "FirstName should be null");
			assertNull(result.get(0).getLastName(), "LastName should be null");
			verify(techUptakeService, times(1)).getSeedMultipliers();
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

			when(techUptakeService.getSeedMultipliers()).thenReturn(expectedMultipliers);

			// Act
			List<SeedMultipliers> result = techUptakeController.getSeedMultipliers();

			// Assert
			assertNotNull(result, "Seed multipliers list should not be null");
			assertEquals(1, result.size(), "Should return 1 seed multiplier");
			assertEquals("Jean-Pierre", result.get(0).getFirstName());
			assertEquals("O'Brien", result.get(0).getLastName());
			verify(techUptakeService, times(1)).getSeedMultipliers();
		}

		@Test
		@DisplayName("Should handle service exception gracefully")
		void testGetSeedMultipliersServiceThrowsException() {
			// Arrange
			when(techUptakeService.getSeedMultipliers()).thenThrow(new RuntimeException("Database connection failed"));

			// Act & Assert
			assertThrows(RuntimeException.class, () -> techUptakeController.getSeedMultipliers(),
					"Should throw RuntimeException when service fails");
			verify(techUptakeService, times(1)).getSeedMultipliers();
		}

	}

	@Nested
	@DisplayName("GetTechUptakeAnalysis Method Tests")
	class GetTechUptakeAnalysisTests {

		@Test
		@DisplayName("Should return tech uptake analysis with valid data")
		void testGetTechUptakeAnalysisSuccess() {
			// Arrange
			Map<String, Integer> plantingMaterialsFreq = new HashMap<>();
			plantingMaterialsFreq.put("Banana", 150);
			plantingMaterialsFreq.put("Potato", 100);

			Map<String, Integer> plantingVarietiesFreq = new HashMap<>();
			plantingVarietiesFreq.put("Local", 180);
			plantingVarietiesFreq.put("Improved", 70);

			Map<String, Integer> bananaVarietiesFreq = new HashMap<>();
			bananaVarietiesFreq.put("Matooke", 120);
			bananaVarietiesFreq.put("Musa", 30);

			Map<String, Integer> potatoVarietiesFreq = new HashMap<>();
			potatoVarietiesFreq.put("Irish", 70);
			potatoVarietiesFreq.put("Sweet", 30);

			Map<String, Integer> plantingTechFreq = new HashMap<>();
			plantingTechFreq.put("Traditional", 140);
			plantingTechFreq.put("Modern", 110);

			Map<String, Integer> sellingPointsFreq = new HashMap<>();
			sellingPointsFreq.put("Market", 200);
			sellingPointsFreq.put("Direct", 50);

			when(techUptakeService.getPlantingMaterialsFrequency()).thenReturn(plantingMaterialsFreq);
			when(techUptakeService.getPlantingVarietiesFrequency()).thenReturn(plantingVarietiesFreq);
			when(techUptakeService.getBananaVarietiesFrequency()).thenReturn(bananaVarietiesFreq);
			when(techUptakeService.getPotatoVarietiesFrequency()).thenReturn(potatoVarietiesFreq);
			when(techUptakeService.getPlantingTechFrequency()).thenReturn(plantingTechFreq);
			when(techUptakeService.getAverageBananaPlantingMaterialsProduced()).thenReturn(500);
			when(techUptakeService.getMedianBananaPlantingMaterialsProduced()).thenReturn(450);
			when(techUptakeService.getAveragePotatoPlantingMaterialsProduced()).thenReturn(300);
			when(techUptakeService.getMedianPotatoPlantingMaterialsProduced()).thenReturn(280);
			when(techUptakeService.getAverageNumberOfProductionTimes()).thenReturn(3);
			when(techUptakeService.getMedianNumberOfProductionTimes()).thenReturn(2);
			when(techUptakeService.getAverageIndividualBuyersQuantityPerSeason()).thenReturn(25);
			when(techUptakeService.getMedianIndividualBuyersQuantityPerSeason()).thenReturn(20);
			when(techUptakeService.getFemaleBuyersAverageAge()).thenReturn(35);
			when(techUptakeService.getFemaleBuyersMedianAge()).thenReturn(32);
			when(techUptakeService.getMaleBuyersAverageAge()).thenReturn(38);
			when(techUptakeService.getMaleBuyersMedianAge()).thenReturn(35);
			when(techUptakeService.getSellingPointsFrequency()).thenReturn(sellingPointsFreq);
			when(techUptakeService.getAverageAnnualProductionCapacity()).thenReturn(1000);
			when(techUptakeService.getMedianAnnualProductionCapacity()).thenReturn(900);
			when(techUptakeService.getAverageAnnualProductionSold()).thenReturn(800);
			when(techUptakeService.getMedianAnnualProductionSold()).thenReturn(750);
			when(techUptakeService.getAverageAnnualProductionGivenAway()).thenReturn(100);
			when(techUptakeService.getMedianAnnualProductionGivenAway()).thenReturn(80);
			when(techUptakeService.getAverageAnnualProductionLost()).thenReturn(50);
			when(techUptakeService.getMedianAnnualProductionLost()).thenReturn(40);
			when(techUptakeService.getAverageCurrentPlantingMaterialsStock()).thenReturn(200);
			when(techUptakeService.getMedianCurrentPlantingMaterialsStock()).thenReturn(180);

			// Act
			TechUptakeAnalysisDto result = techUptakeController.getTechUptakeAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertEquals(2, result.getPlantingMaterialsFrequency().size(), "Should have 2 planting materials");
			assertEquals(2, result.getPlantingVarietiesFrequency().size(), "Should have 2 varieties");
			assertEquals(2, result.getBananaVarietiesFrequency().size(), "Should have 2 banana varieties");
			assertEquals(2, result.getPotatoVarietiesFrequency().size(), "Should have 2 potato varieties");
			assertEquals(2, result.getPlantingTechFrequency().size(), "Should have 2 planting techs");
			assertEquals(2, result.getSellingPointsFrequency().size(), "Should have 2 selling points");

			assertEquals(500, result.getAverageBananaPlantingMaterialsProduced(), "Average banana materials should be 500");
			assertEquals(450, result.getMedianBananaPlantingMaterialsProduced(), "Median banana materials should be 450");
			assertEquals(300, result.getAveragePotatoPlantingMaterialsProduced(), "Average potato materials should be 300");
			assertEquals(280, result.getMedianPotatoPlantingMaterialsProduced(), "Median potato materials should be 280");
			assertEquals(3, result.getAverageNumberOfProductionTimes(), "Average production times should be 3");
			assertEquals(2, result.getMedianNumberOfProductionTimes(), "Median production times should be 2");
			assertEquals(25, result.getAverageIndividualBuyersQuantityPerSeason(), "Average buyers quantity should be 25");
			assertEquals(20, result.getMedianIndividualBuyersQuantityPerSeason(), "Median buyers quantity should be 20");
			assertEquals(35, result.getFemaleBuyersAverageAge(), "Female buyers average age should be 35");
			assertEquals(32, result.getFemaleBuyersMedianAge(), "Female buyers median age should be 32");
			assertEquals(38, result.getMaleBuyersAverageAge(), "Male buyers average age should be 38");
			assertEquals(35, result.getMaleBuyersMedianAge(), "Male buyers median age should be 35");
			assertEquals(1000, result.getAverageAnnualProductionCapacity(), "Average production capacity should be 1000");
			assertEquals(900, result.getMedianAnnualProductionCapacity(), "Median production capacity should be 900");
			assertEquals(800, result.getAverageAnnualProductionSold(), "Average production sold should be 800");
			assertEquals(750, result.getMedianAnnualProductionSold(), "Median production sold should be 750");
			assertEquals(100, result.getAverageAnnualProductionGivenAway(), "Average production given away should be 100");
			assertEquals(80, result.getMedianAnnualProductionGivenAway(), "Median production given away should be 80");
			assertEquals(50, result.getAverageAnnualProductionLost(), "Average production lost should be 50");
			assertEquals(40, result.getMedianAnnualProductionLost(), "Median production lost should be 40");
			assertEquals(200, result.getAverageCurrentPlantingMaterialsStock(), "Average current stock should be 200");
			assertEquals(180, result.getMedianCurrentPlantingMaterialsStock(), "Median current stock should be 180");

			// Verify all service methods were called
			verify(techUptakeService, times(1)).getPlantingMaterialsFrequency();
			verify(techUptakeService, times(1)).getPlantingVarietiesFrequency();
			verify(techUptakeService, times(1)).getBananaVarietiesFrequency();
			verify(techUptakeService, times(1)).getPotatoVarietiesFrequency();
			verify(techUptakeService, times(1)).getPlantingTechFrequency();
			verify(techUptakeService, times(1)).getAverageBananaPlantingMaterialsProduced();
			verify(techUptakeService, times(1)).getMedianBananaPlantingMaterialsProduced();
			verify(techUptakeService, times(1)).getAveragePotatoPlantingMaterialsProduced();
			verify(techUptakeService, times(1)).getMedianPotatoPlantingMaterialsProduced();
			verify(techUptakeService, times(1)).getAverageNumberOfProductionTimes();
			verify(techUptakeService, times(1)).getMedianNumberOfProductionTimes();
			verify(techUptakeService, times(1)).getAverageIndividualBuyersQuantityPerSeason();
			verify(techUptakeService, times(1)).getMedianIndividualBuyersQuantityPerSeason();
			verify(techUptakeService, times(1)).getFemaleBuyersAverageAge();
			verify(techUptakeService, times(1)).getFemaleBuyersMedianAge();
			verify(techUptakeService, times(1)).getMaleBuyersAverageAge();
			verify(techUptakeService, times(1)).getMaleBuyersMedianAge();
			verify(techUptakeService, times(1)).getSellingPointsFrequency();
			verify(techUptakeService, times(1)).getAverageAnnualProductionCapacity();
			verify(techUptakeService, times(1)).getMedianAnnualProductionCapacity();
			verify(techUptakeService, times(1)).getAverageAnnualProductionSold();
			verify(techUptakeService, times(1)).getMedianAnnualProductionSold();
			verify(techUptakeService, times(1)).getAverageAnnualProductionGivenAway();
			verify(techUptakeService, times(1)).getMedianAnnualProductionGivenAway();
			verify(techUptakeService, times(1)).getAverageAnnualProductionLost();
			verify(techUptakeService, times(1)).getMedianAnnualProductionLost();
			verify(techUptakeService, times(1)).getAverageCurrentPlantingMaterialsStock();
			verify(techUptakeService, times(1)).getMedianCurrentPlantingMaterialsStock();
		}

		@Test
		@DisplayName("Should handle zero values for all metrics")
		void testGetTechUptakeAnalysisZeroValues() {
			// Arrange
			when(techUptakeService.getPlantingMaterialsFrequency()).thenReturn(new HashMap<>());
			when(techUptakeService.getPlantingVarietiesFrequency()).thenReturn(new HashMap<>());
			when(techUptakeService.getBananaVarietiesFrequency()).thenReturn(new HashMap<>());
			when(techUptakeService.getPotatoVarietiesFrequency()).thenReturn(new HashMap<>());
			when(techUptakeService.getPlantingTechFrequency()).thenReturn(new HashMap<>());
			when(techUptakeService.getAverageBananaPlantingMaterialsProduced()).thenReturn(0);
			when(techUptakeService.getMedianBananaPlantingMaterialsProduced()).thenReturn(0);
			when(techUptakeService.getAveragePotatoPlantingMaterialsProduced()).thenReturn(0);
			when(techUptakeService.getMedianPotatoPlantingMaterialsProduced()).thenReturn(0);
			when(techUptakeService.getAverageNumberOfProductionTimes()).thenReturn(0);
			when(techUptakeService.getMedianNumberOfProductionTimes()).thenReturn(0);
			when(techUptakeService.getAverageIndividualBuyersQuantityPerSeason()).thenReturn(0);
			when(techUptakeService.getMedianIndividualBuyersQuantityPerSeason()).thenReturn(0);
			when(techUptakeService.getFemaleBuyersAverageAge()).thenReturn(0);
			when(techUptakeService.getFemaleBuyersMedianAge()).thenReturn(0);
			when(techUptakeService.getMaleBuyersAverageAge()).thenReturn(0);
			when(techUptakeService.getMaleBuyersMedianAge()).thenReturn(0);
			when(techUptakeService.getSellingPointsFrequency()).thenReturn(new HashMap<>());
			when(techUptakeService.getAverageAnnualProductionCapacity()).thenReturn(0);
			when(techUptakeService.getMedianAnnualProductionCapacity()).thenReturn(0);
			when(techUptakeService.getAverageAnnualProductionSold()).thenReturn(0);
			when(techUptakeService.getMedianAnnualProductionSold()).thenReturn(0);
			when(techUptakeService.getAverageAnnualProductionGivenAway()).thenReturn(0);
			when(techUptakeService.getMedianAnnualProductionGivenAway()).thenReturn(0);
			when(techUptakeService.getAverageAnnualProductionLost()).thenReturn(0);
			when(techUptakeService.getMedianAnnualProductionLost()).thenReturn(0);
			when(techUptakeService.getAverageCurrentPlantingMaterialsStock()).thenReturn(0);
			when(techUptakeService.getMedianCurrentPlantingMaterialsStock()).thenReturn(0);

			// Act
			TechUptakeAnalysisDto result = techUptakeController.getTechUptakeAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertEquals(0, result.getAverageBananaPlantingMaterialsProduced(), "Average banana materials should be 0");
			assertEquals(0, result.getMedianBananaPlantingMaterialsProduced(), "Median banana materials should be 0");
			assertEquals(0, result.getAveragePotatoPlantingMaterialsProduced(), "Average potato materials should be 0");
			assertEquals(0, result.getMedianPotatoPlantingMaterialsProduced(), "Median potato materials should be 0");
			assertEquals(0, result.getAverageNumberOfProductionTimes(), "Average production times should be 0");
			assertEquals(0, result.getMedianNumberOfProductionTimes(), "Median production times should be 0");
			assertEquals(0, result.getAverageIndividualBuyersQuantityPerSeason(), "Average buyers quantity should be 0");
			assertEquals(0, result.getMedianIndividualBuyersQuantityPerSeason(), "Median buyers quantity should be 0");
			assertEquals(0, result.getFemaleBuyersAverageAge(), "Female buyers average age should be 0");
			assertEquals(0, result.getFemaleBuyersMedianAge(), "Female buyers median age should be 0");
			assertEquals(0, result.getMaleBuyersAverageAge(), "Male buyers average age should be 0");
			assertEquals(0, result.getMaleBuyersMedianAge(), "Male buyers median age should be 0");
			assertEquals(0, result.getAverageAnnualProductionCapacity(), "Average production capacity should be 0");
			assertEquals(0, result.getMedianAnnualProductionCapacity(), "Median production capacity should be 0");
			assertEquals(0, result.getAverageAnnualProductionSold(), "Average production sold should be 0");
			assertEquals(0, result.getMedianAnnualProductionSold(), "Median production sold should be 0");
			assertEquals(0, result.getAverageAnnualProductionGivenAway(), "Average production given away should be 0");
			assertEquals(0, result.getMedianAnnualProductionGivenAway(), "Median production given away should be 0");
			assertEquals(0, result.getAverageAnnualProductionLost(), "Average production lost should be 0");
			assertEquals(0, result.getMedianAnnualProductionLost(), "Median production lost should be 0");
			assertEquals(0, result.getAverageCurrentPlantingMaterialsStock(), "Average current stock should be 0");
			assertEquals(0, result.getMedianCurrentPlantingMaterialsStock(), "Median current stock should be 0");

			assertTrue(result.getPlantingMaterialsFrequency().isEmpty(), "Planting materials frequency should be empty");
			assertTrue(result.getPlantingVarietiesFrequency().isEmpty(), "Planting varieties frequency should be empty");
			assertTrue(result.getBananaVarietiesFrequency().isEmpty(), "Banana varieties frequency should be empty");
			assertTrue(result.getPotatoVarietiesFrequency().isEmpty(), "Potato varieties frequency should be empty");
			assertTrue(result.getPlantingTechFrequency().isEmpty(), "Planting tech frequency should be empty");
			assertTrue(result.getSellingPointsFrequency().isEmpty(), "Selling points frequency should be empty");
		}

		@Test
		@DisplayName("Should handle empty maps for all frequency data")
		void testGetTechUptakeAnalysisEmptyMaps() {
			// Arrange
			Map<String, Integer> emptyPlantingMaterials = new HashMap<>();
			Map<String, Integer> emptyVarieties = new HashMap<>();
			Map<String, Integer> emptyBananaVarieties = new HashMap<>();
			Map<String, Integer> emptyPotatoVarieties = new HashMap<>();
			Map<String, Integer> emptyPlantingTech = new HashMap<>();
			Map<String, Integer> emptySellingPoints = new HashMap<>();

			when(techUptakeService.getPlantingMaterialsFrequency()).thenReturn(emptyPlantingMaterials);
			when(techUptakeService.getPlantingVarietiesFrequency()).thenReturn(emptyVarieties);
			when(techUptakeService.getBananaVarietiesFrequency()).thenReturn(emptyBananaVarieties);
			when(techUptakeService.getPotatoVarietiesFrequency()).thenReturn(emptyPotatoVarieties);
			when(techUptakeService.getPlantingTechFrequency()).thenReturn(emptyPlantingTech);
			when(techUptakeService.getSellingPointsFrequency()).thenReturn(emptySellingPoints);
			when(techUptakeService.getAverageBananaPlantingMaterialsProduced()).thenReturn(100);
			when(techUptakeService.getMedianBananaPlantingMaterialsProduced()).thenReturn(90);
			when(techUptakeService.getAveragePotatoPlantingMaterialsProduced()).thenReturn(80);
			when(techUptakeService.getMedianPotatoPlantingMaterialsProduced()).thenReturn(70);
			when(techUptakeService.getAverageNumberOfProductionTimes()).thenReturn(2);
			when(techUptakeService.getMedianNumberOfProductionTimes()).thenReturn(2);
			when(techUptakeService.getAverageIndividualBuyersQuantityPerSeason()).thenReturn(15);
			when(techUptakeService.getMedianIndividualBuyersQuantityPerSeason()).thenReturn(12);
			when(techUptakeService.getFemaleBuyersAverageAge()).thenReturn(30);
			when(techUptakeService.getFemaleBuyersMedianAge()).thenReturn(28);
			when(techUptakeService.getMaleBuyersAverageAge()).thenReturn(32);
			when(techUptakeService.getMaleBuyersMedianAge()).thenReturn(30);
			when(techUptakeService.getAverageAnnualProductionCapacity()).thenReturn(500);
			when(techUptakeService.getMedianAnnualProductionCapacity()).thenReturn(450);
			when(techUptakeService.getAverageAnnualProductionSold()).thenReturn(400);
			when(techUptakeService.getMedianAnnualProductionSold()).thenReturn(380);
			when(techUptakeService.getAverageAnnualProductionGivenAway()).thenReturn(50);
			when(techUptakeService.getMedianAnnualProductionGivenAway()).thenReturn(40);
			when(techUptakeService.getAverageAnnualProductionLost()).thenReturn(25);
			when(techUptakeService.getMedianAnnualProductionLost()).thenReturn(20);
			when(techUptakeService.getAverageCurrentPlantingMaterialsStock()).thenReturn(100);
			when(techUptakeService.getMedianCurrentPlantingMaterialsStock()).thenReturn(90);

			// Act
			TechUptakeAnalysisDto result = techUptakeController.getTechUptakeAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertNotNull(result.getPlantingMaterialsFrequency(), "Planting materials frequency should not be null");
			assertNotNull(result.getPlantingVarietiesFrequency(), "Planting varieties frequency should not be null");
			assertNotNull(result.getBananaVarietiesFrequency(), "Banana varieties frequency should not be null");
			assertNotNull(result.getPotatoVarietiesFrequency(), "Potato varieties frequency should not be null");
			assertNotNull(result.getPlantingTechFrequency(), "Planting tech frequency should not be null");
			assertNotNull(result.getSellingPointsFrequency(), "Selling points frequency should not be null");

			assertTrue(result.getPlantingMaterialsFrequency().isEmpty(), "Planting materials frequency should be empty");
			assertTrue(result.getPlantingVarietiesFrequency().isEmpty(), "Planting varieties frequency should be empty");
			assertTrue(result.getBananaVarietiesFrequency().isEmpty(), "Banana varieties frequency should be empty");
			assertTrue(result.getPotatoVarietiesFrequency().isEmpty(), "Potato varieties frequency should be empty");
			assertTrue(result.getPlantingTechFrequency().isEmpty(), "Planting tech frequency should be empty");
			assertTrue(result.getSellingPointsFrequency().isEmpty(), "Selling points frequency should be empty");
		}

		@Test
		@DisplayName("Should handle large frequency data sets")
		void testGetTechUptakeAnalysisLargeData() {
			// Arrange
			Map<String, Integer> plantingMaterialsFreq = new HashMap<>();
			for (int i = 0; i < 50; i++) {
				plantingMaterialsFreq.put("Material" + i, i * 10);
			}

			Map<String, Integer> varietiesFreq = new HashMap<>();
			for (int i = 0; i < 30; i++) {
				varietiesFreq.put("Variety" + i, i * 7);
			}

			Map<String, Integer> bananaVarietiesFreq = new HashMap<>();
			for (int i = 0; i < 20; i++) {
				bananaVarietiesFreq.put("Banana" + i, i * 12);
			}

			Map<String, Integer> potatoVarietiesFreq = new HashMap<>();
			for (int i = 0; i < 15; i++) {
				potatoVarietiesFreq.put("Potato" + i, i * 9);
			}

			Map<String, Integer> plantingTechFreq = new HashMap<>();
			for (int i = 0; i < 10; i++) {
				plantingTechFreq.put("Tech" + i, i * 15);
			}

			Map<String, Integer> sellingPointsFreq = new HashMap<>();
			for (int i = 0; i < 25; i++) {
				sellingPointsFreq.put("Point" + i, i * 5);
			}

			when(techUptakeService.getPlantingMaterialsFrequency()).thenReturn(plantingMaterialsFreq);
			when(techUptakeService.getPlantingVarietiesFrequency()).thenReturn(varietiesFreq);
			when(techUptakeService.getBananaVarietiesFrequency()).thenReturn(bananaVarietiesFreq);
			when(techUptakeService.getPotatoVarietiesFrequency()).thenReturn(potatoVarietiesFreq);
			when(techUptakeService.getPlantingTechFrequency()).thenReturn(plantingTechFreq);
			when(techUptakeService.getSellingPointsFrequency()).thenReturn(sellingPointsFreq);
			when(techUptakeService.getAverageBananaPlantingMaterialsProduced()).thenReturn(1000);
			when(techUptakeService.getMedianBananaPlantingMaterialsProduced()).thenReturn(900);
			when(techUptakeService.getAveragePotatoPlantingMaterialsProduced()).thenReturn(800);
			when(techUptakeService.getMedianPotatoPlantingMaterialsProduced()).thenReturn(700);
			when(techUptakeService.getAverageNumberOfProductionTimes()).thenReturn(5);
			when(techUptakeService.getMedianNumberOfProductionTimes()).thenReturn(4);
			when(techUptakeService.getAverageIndividualBuyersQuantityPerSeason()).thenReturn(50);
			when(techUptakeService.getMedianIndividualBuyersQuantityPerSeason()).thenReturn(40);
			when(techUptakeService.getFemaleBuyersAverageAge()).thenReturn(40);
			when(techUptakeService.getFemaleBuyersMedianAge()).thenReturn(38);
			when(techUptakeService.getMaleBuyersAverageAge()).thenReturn(42);
			when(techUptakeService.getMaleBuyersMedianAge()).thenReturn(40);
			when(techUptakeService.getAverageAnnualProductionCapacity()).thenReturn(2000);
			when(techUptakeService.getMedianAnnualProductionCapacity()).thenReturn(1800);
			when(techUptakeService.getAverageAnnualProductionSold()).thenReturn(1600);
			when(techUptakeService.getMedianAnnualProductionSold()).thenReturn(1500);
			when(techUptakeService.getAverageAnnualProductionGivenAway()).thenReturn(200);
			when(techUptakeService.getMedianAnnualProductionGivenAway()).thenReturn(180);
			when(techUptakeService.getAverageAnnualProductionLost()).thenReturn(100);
			when(techUptakeService.getMedianAnnualProductionLost()).thenReturn(80);
			when(techUptakeService.getAverageCurrentPlantingMaterialsStock()).thenReturn(400);
			when(techUptakeService.getMedianCurrentPlantingMaterialsStock()).thenReturn(360);

			// Act
			TechUptakeAnalysisDto result = techUptakeController.getTechUptakeAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertEquals(50, result.getPlantingMaterialsFrequency().size(), "Should have 50 planting materials");
			assertEquals(30, result.getPlantingVarietiesFrequency().size(), "Should have 30 varieties");
			assertEquals(20, result.getBananaVarietiesFrequency().size(), "Should have 20 banana varieties");
			assertEquals(15, result.getPotatoVarietiesFrequency().size(), "Should have 15 potato varieties");
			assertEquals(10, result.getPlantingTechFrequency().size(), "Should have 10 planting techs");
			assertEquals(25, result.getSellingPointsFrequency().size(), "Should have 25 selling points");
		}

		@Test
		@DisplayName("Should handle very high production values")
		void testGetTechUptakeAnalysisHighValues() {
			// Arrange
			when(techUptakeService.getPlantingMaterialsFrequency()).thenReturn(new HashMap<>());
			when(techUptakeService.getPlantingVarietiesFrequency()).thenReturn(new HashMap<>());
			when(techUptakeService.getBananaVarietiesFrequency()).thenReturn(new HashMap<>());
			when(techUptakeService.getPotatoVarietiesFrequency()).thenReturn(new HashMap<>());
			when(techUptakeService.getPlantingTechFrequency()).thenReturn(new HashMap<>());
			when(techUptakeService.getSellingPointsFrequency()).thenReturn(new HashMap<>());
			when(techUptakeService.getAverageBananaPlantingMaterialsProduced()).thenReturn(10000);
			when(techUptakeService.getMedianBananaPlantingMaterialsProduced()).thenReturn(9500);
			when(techUptakeService.getAveragePotatoPlantingMaterialsProduced()).thenReturn(8000);
			when(techUptakeService.getMedianPotatoPlantingMaterialsProduced()).thenReturn(7500);
			when(techUptakeService.getAverageNumberOfProductionTimes()).thenReturn(20);
			when(techUptakeService.getMedianNumberOfProductionTimes()).thenReturn(18);
			when(techUptakeService.getAverageIndividualBuyersQuantityPerSeason()).thenReturn(500);
			when(techUptakeService.getMedianIndividualBuyersQuantityPerSeason()).thenReturn(450);
			when(techUptakeService.getFemaleBuyersAverageAge()).thenReturn(120);
			when(techUptakeService.getFemaleBuyersMedianAge()).thenReturn(110);
			when(techUptakeService.getMaleBuyersAverageAge()).thenReturn(130);
			when(techUptakeService.getMaleBuyersMedianAge()).thenReturn(120);
			when(techUptakeService.getAverageAnnualProductionCapacity()).thenReturn(50000);
			when(techUptakeService.getMedianAnnualProductionCapacity()).thenReturn(45000);
			when(techUptakeService.getAverageAnnualProductionSold()).thenReturn(40000);
			when(techUptakeService.getMedianAnnualProductionSold()).thenReturn(38000);
			when(techUptakeService.getAverageAnnualProductionGivenAway()).thenReturn(5000);
			when(techUptakeService.getMedianAnnualProductionGivenAway()).thenReturn(4500);
			when(techUptakeService.getAverageAnnualProductionLost()).thenReturn(2500);
			when(techUptakeService.getMedianAnnualProductionLost()).thenReturn(2000);
			when(techUptakeService.getAverageCurrentPlantingMaterialsStock()).thenReturn(10000);
			when(techUptakeService.getMedianCurrentPlantingMaterialsStock()).thenReturn(9000);

			// Act
			TechUptakeAnalysisDto result = techUptakeController.getTechUptakeAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertEquals(10000, result.getAverageBananaPlantingMaterialsProduced(), "Average banana materials should be 10000");
			assertEquals(9500, result.getMedianBananaPlantingMaterialsProduced(), "Median banana materials should be 9500");
			assertEquals(8000, result.getAveragePotatoPlantingMaterialsProduced(), "Average potato materials should be 8000");
			assertEquals(7500, result.getMedianPotatoPlantingMaterialsProduced(), "Median potato materials should be 7500");
			assertEquals(20, result.getAverageNumberOfProductionTimes(), "Average production times should be 20");
			assertEquals(18, result.getMedianNumberOfProductionTimes(), "Median production times should be 18");
			assertEquals(500, result.getAverageIndividualBuyersQuantityPerSeason(), "Average buyers quantity should be 500");
			assertEquals(450, result.getMedianIndividualBuyersQuantityPerSeason(), "Median buyers quantity should be 450");
			assertEquals(120, result.getFemaleBuyersAverageAge(), "Female buyers average age should be 120");
			assertEquals(110, result.getFemaleBuyersMedianAge(), "Female buyers median age should be 110");
			assertEquals(130, result.getMaleBuyersAverageAge(), "Male buyers average age should be 130");
			assertEquals(120, result.getMaleBuyersMedianAge(), "Male buyers median age should be 120");
			assertEquals(50000, result.getAverageAnnualProductionCapacity(), "Average production capacity should be 50000");
			assertEquals(45000, result.getMedianAnnualProductionCapacity(), "Median production capacity should be 45000");
			assertEquals(40000, result.getAverageAnnualProductionSold(), "Average production sold should be 40000");
			assertEquals(38000, result.getMedianAnnualProductionSold(), "Median production sold should be 38000");
			assertEquals(5000, result.getAverageAnnualProductionGivenAway(), "Average production given away should be 5000");
			assertEquals(4500, result.getMedianAnnualProductionGivenAway(), "Median production given away should be 4500");
			assertEquals(2500, result.getAverageAnnualProductionLost(), "Average production lost should be 2500");
			assertEquals(2000, result.getMedianAnnualProductionLost(), "Median production lost should be 2000");
			assertEquals(10000, result.getAverageCurrentPlantingMaterialsStock(), "Average current stock should be 10000");
			assertEquals(9000, result.getMedianCurrentPlantingMaterialsStock(), "Median current stock should be 9000");
		}

		@Test
		@DisplayName("Should handle service exception when fetching analysis")
		void testGetTechUptakeAnalysisServiceThrowsException() {
			// Arrange
			when(techUptakeService.getPlantingMaterialsFrequency())
					.thenThrow(new RuntimeException("Database error"));

			// Act & Assert
			assertThrows(RuntimeException.class, () -> techUptakeController.getTechUptakeAnalysis(),
					"Should throw RuntimeException when service fails");
		}

		@Test
		@DisplayName("Should handle null maps returned from service")
		void testGetTechUptakeAnalysisNullMaps() {
			// Arrange
			when(techUptakeService.getPlantingMaterialsFrequency()).thenReturn(null);
			when(techUptakeService.getPlantingVarietiesFrequency()).thenReturn(null);
			when(techUptakeService.getBananaVarietiesFrequency()).thenReturn(null);
			when(techUptakeService.getPotatoVarietiesFrequency()).thenReturn(null);
			when(techUptakeService.getPlantingTechFrequency()).thenReturn(null);
			when(techUptakeService.getSellingPointsFrequency()).thenReturn(null);
			when(techUptakeService.getAverageBananaPlantingMaterialsProduced()).thenReturn(100);
			when(techUptakeService.getMedianBananaPlantingMaterialsProduced()).thenReturn(90);
			when(techUptakeService.getAveragePotatoPlantingMaterialsProduced()).thenReturn(80);
			when(techUptakeService.getMedianPotatoPlantingMaterialsProduced()).thenReturn(70);
			when(techUptakeService.getAverageNumberOfProductionTimes()).thenReturn(2);
			when(techUptakeService.getMedianNumberOfProductionTimes()).thenReturn(2);
			when(techUptakeService.getAverageIndividualBuyersQuantityPerSeason()).thenReturn(15);
			when(techUptakeService.getMedianIndividualBuyersQuantityPerSeason()).thenReturn(12);
			when(techUptakeService.getFemaleBuyersAverageAge()).thenReturn(30);
			when(techUptakeService.getFemaleBuyersMedianAge()).thenReturn(28);
			when(techUptakeService.getMaleBuyersAverageAge()).thenReturn(32);
			when(techUptakeService.getMaleBuyersMedianAge()).thenReturn(30);
			when(techUptakeService.getAverageAnnualProductionCapacity()).thenReturn(500);
			when(techUptakeService.getMedianAnnualProductionCapacity()).thenReturn(450);
			when(techUptakeService.getAverageAnnualProductionSold()).thenReturn(400);
			when(techUptakeService.getMedianAnnualProductionSold()).thenReturn(380);
			when(techUptakeService.getAverageAnnualProductionGivenAway()).thenReturn(50);
			when(techUptakeService.getMedianAnnualProductionGivenAway()).thenReturn(40);
			when(techUptakeService.getAverageAnnualProductionLost()).thenReturn(25);
			when(techUptakeService.getMedianAnnualProductionLost()).thenReturn(20);
			when(techUptakeService.getAverageCurrentPlantingMaterialsStock()).thenReturn(100);
			when(techUptakeService.getMedianCurrentPlantingMaterialsStock()).thenReturn(90);

			// Act
			TechUptakeAnalysisDto result = techUptakeController.getTechUptakeAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertNull(result.getPlantingMaterialsFrequency(), "Planting materials frequency can be null");
			assertNull(result.getPlantingVarietiesFrequency(), "Planting varieties frequency can be null");
			assertNull(result.getBananaVarietiesFrequency(), "Banana varieties frequency can be null");
			assertNull(result.getPotatoVarietiesFrequency(), "Potato varieties frequency can be null");
			assertNull(result.getPlantingTechFrequency(), "Planting tech frequency can be null");
			assertNull(result.getSellingPointsFrequency(), "Selling points frequency can be null");
		}

		@Test
		@DisplayName("Should return complete analysis data structure")
		void testGetTechUptakeAnalysisCompleteStructure() {
			// Arrange
			Map<String, Integer> plantingMaterialsFreq = new HashMap<>();
			plantingMaterialsFreq.put("Banana", 200);
			plantingMaterialsFreq.put("Potato", 150);

			Map<String, Integer> varietiesFreq = new HashMap<>();
			varietiesFreq.put("Local", 250);
			varietiesFreq.put("Improved", 100);

			Map<String, Integer> bananaVarietiesFreq = new HashMap<>();
			bananaVarietiesFreq.put("Matooke", 180);
			bananaVarietiesFreq.put("Musa", 20);

			Map<String, Integer> potatoVarietiesFreq = new HashMap<>();
			potatoVarietiesFreq.put("Irish", 120);
			potatoVarietiesFreq.put("Sweet", 30);

			Map<String, Integer> plantingTechFreq = new HashMap<>();
			plantingTechFreq.put("Traditional", 200);
			plantingTechFreq.put("Modern", 150);

			Map<String, Integer> sellingPointsFreq = new HashMap<>();
			sellingPointsFreq.put("Market", 300);
			sellingPointsFreq.put("Direct", 50);

			when(techUptakeService.getPlantingMaterialsFrequency()).thenReturn(plantingMaterialsFreq);
			when(techUptakeService.getPlantingVarietiesFrequency()).thenReturn(varietiesFreq);
			when(techUptakeService.getBananaVarietiesFrequency()).thenReturn(bananaVarietiesFreq);
			when(techUptakeService.getPotatoVarietiesFrequency()).thenReturn(potatoVarietiesFreq);
			when(techUptakeService.getPlantingTechFrequency()).thenReturn(plantingTechFreq);
			when(techUptakeService.getSellingPointsFrequency()).thenReturn(sellingPointsFreq);
			when(techUptakeService.getAverageBananaPlantingMaterialsProduced()).thenReturn(750);
			when(techUptakeService.getMedianBananaPlantingMaterialsProduced()).thenReturn(700);
			when(techUptakeService.getAveragePotatoPlantingMaterialsProduced()).thenReturn(550);
			when(techUptakeService.getMedianPotatoPlantingMaterialsProduced()).thenReturn(500);
			when(techUptakeService.getAverageNumberOfProductionTimes()).thenReturn(4);
			when(techUptakeService.getMedianNumberOfProductionTimes()).thenReturn(3);
			when(techUptakeService.getAverageIndividualBuyersQuantityPerSeason()).thenReturn(35);
			when(techUptakeService.getMedianIndividualBuyersQuantityPerSeason()).thenReturn(30);
			when(techUptakeService.getFemaleBuyersAverageAge()).thenReturn(37);
			when(techUptakeService.getFemaleBuyersMedianAge()).thenReturn(35);
			when(techUptakeService.getMaleBuyersAverageAge()).thenReturn(40);
			when(techUptakeService.getMaleBuyersMedianAge()).thenReturn(38);
			when(techUptakeService.getAverageAnnualProductionCapacity()).thenReturn(1500);
			when(techUptakeService.getMedianAnnualProductionCapacity()).thenReturn(1300);
			when(techUptakeService.getAverageAnnualProductionSold()).thenReturn(1200);
			when(techUptakeService.getMedianAnnualProductionSold()).thenReturn(1100);
			when(techUptakeService.getAverageAnnualProductionGivenAway()).thenReturn(150);
			when(techUptakeService.getMedianAnnualProductionGivenAway()).thenReturn(120);
			when(techUptakeService.getAverageAnnualProductionLost()).thenReturn(75);
			when(techUptakeService.getMedianAnnualProductionLost()).thenReturn(60);
			when(techUptakeService.getAverageCurrentPlantingMaterialsStock()).thenReturn(300);
			when(techUptakeService.getMedianCurrentPlantingMaterialsStock()).thenReturn(270);

			// Act
			TechUptakeAnalysisDto result = techUptakeController.getTechUptakeAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertNotNull(result.getPlantingMaterialsFrequency(), "Planting materials frequency should not be null");
			assertNotNull(result.getPlantingVarietiesFrequency(), "Planting varieties frequency should not be null");
			assertNotNull(result.getBananaVarietiesFrequency(), "Banana varieties frequency should not be null");
			assertNotNull(result.getPotatoVarietiesFrequency(), "Potato varieties frequency should not be null");
			assertNotNull(result.getPlantingTechFrequency(), "Planting tech frequency should not be null");
			assertNotNull(result.getSellingPointsFrequency(), "Selling points frequency should not be null");

			assertEquals(200, result.getPlantingMaterialsFrequency().get("Banana"), "Banana should have 200 frequency");
			assertEquals(250, result.getPlantingVarietiesFrequency().get("Local"), "Local variety should have 250 frequency");
			assertEquals(180, result.getBananaVarietiesFrequency().get("Matooke"), "Matooke should have 180 frequency");
			assertEquals(120, result.getPotatoVarietiesFrequency().get("Irish"), "Irish potato should have 120 frequency");
			assertEquals(200, result.getPlantingTechFrequency().get("Traditional"), "Traditional tech should have 200 frequency");
			assertEquals(300, result.getSellingPointsFrequency().get("Market"), "Market should have 300 frequency");
		}

	}

	@Nested
	@DisplayName("Controller Initialization Tests")
	class ControllerInitializationTests {

		@Test
		@DisplayName("Should initialize controller with non-null service")
		void testControllerInitialization() {
			// Assert
			assertNotNull(techUptakeController, "Controller should not be null");
			assertNotNull(techUptakeService, "Service mock should not be null");
		}

		@Test
		@DisplayName("Should handle multiple calls sequentially")
		void testMultipleSequentialCalls() {
			// Arrange
			when(techUptakeService.getSeedMultipliers()).thenReturn(new ArrayList<>());

			// Act
			List<SeedMultipliers> result1 = techUptakeController.getSeedMultipliers();
			List<SeedMultipliers> result2 = techUptakeController.getSeedMultipliers();
			List<SeedMultipliers> result3 = techUptakeController.getSeedMultipliers();

			// Assert
			assertNotNull(result1);
			assertNotNull(result2);
			assertNotNull(result3);
			verify(techUptakeService, times(3)).getSeedMultipliers();
		}

	}

}

