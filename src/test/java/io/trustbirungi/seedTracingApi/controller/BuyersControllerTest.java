package io.trustbirungi.seedTracingApi.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import io.trustbirungi.seedTracingApi.dto.BuyersAnalysisDto;
import io.trustbirungi.seedTracingApi.entity.Buyers;
import io.trustbirungi.seedTracingApi.service.BuyersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName("BuyersController Unit Tests")
class BuyersControllerTest {

	@Mock
	private BuyersService buyersService;

	private BuyersController buyersController;

	@BeforeEach
	void setUp() {
		buyersController = new BuyersController(buyersService);
	}

	@Nested
	@DisplayName("GetBuyers Method Tests")
	class GetBuyersTests {

		@Test
		@DisplayName("Should return list of buyers successfully")
		void testGetBuyersSuccess() {
			// Arrange
			List<Buyers> expectedBuyers = new ArrayList<>();
			Buyers buyer1 = new Buyers();
			buyer1.setMetaInstanceId("buyer1");
			buyer1.setFirstName("John");
			buyer1.setLastName("Doe");
			buyer1.setBuyerSex("Male");
			expectedBuyers.add(buyer1);

			Buyers buyer2 = new Buyers();
			buyer2.setMetaInstanceId("buyer2");
			buyer2.setFirstName("Jane");
			buyer2.setLastName("Smith");
			buyer2.setBuyerSex("Female");
			expectedBuyers.add(buyer2);

			when(buyersService.getBuyers()).thenReturn(expectedBuyers);

			// Act
			List<Buyers> result = buyersController.getBuyers();

			// Assert
			assertNotNull(result, "Buyers list should not be null");
			assertEquals(2, result.size(), "Should return 2 buyers");
			assertEquals("John", result.get(0).getFirstName(), "First buyer's name should be John");
			assertEquals("Jane", result.get(1).getFirstName(), "Second buyer's name should be Jane");
			verify(buyersService, times(1)).getBuyers();
		}

		@Test
		@DisplayName("Should return empty list when no buyers exist")
		void testGetBuyersEmptyList() {
			// Arrange
			List<Buyers> expectedBuyers = new ArrayList<>();
			when(buyersService.getBuyers()).thenReturn(expectedBuyers);

			// Act
			List<Buyers> result = buyersController.getBuyers();

			// Assert
			assertNotNull(result, "Buyers list should not be null");
			assertTrue(result.isEmpty(), "Buyers list should be empty");
			assertEquals(0, result.size(), "Size should be 0");
			verify(buyersService, times(1)).getBuyers();
		}

		@Test
		@DisplayName("Should return list with single buyer")
		void testGetBuyersSingleBuyer() {
			// Arrange
			List<Buyers> expectedBuyers = new ArrayList<>();
			Buyers buyer = new Buyers();
			buyer.setMetaInstanceId("buyer1");
			buyer.setFirstName("John");
			expectedBuyers.add(buyer);

			when(buyersService.getBuyers()).thenReturn(expectedBuyers);

			// Act
			List<Buyers> result = buyersController.getBuyers();

			// Assert
			assertNotNull(result, "Buyers list should not be null");
			assertEquals(1, result.size(), "Should return 1 buyer");
			assertEquals("John", result.get(0).getFirstName());
			verify(buyersService, times(1)).getBuyers();
		}

		@Test
		@DisplayName("Should return large list of buyers")
		void testGetBuyersLargeList() {
			// Arrange
			List<Buyers> expectedBuyers = new ArrayList<>();
			for (int i = 0; i < 1000; i++) {
				Buyers buyer = new Buyers();
				buyer.setMetaInstanceId("buyer" + i);
				buyer.setFirstName("FirstName" + i);
				expectedBuyers.add(buyer);
			}
			when(buyersService.getBuyers()).thenReturn(expectedBuyers);

			// Act
			List<Buyers> result = buyersController.getBuyers();

			// Assert
			assertNotNull(result, "Buyers list should not be null");
			assertEquals(1000, result.size(), "Should return 1000 buyers");
			verify(buyersService, times(1)).getBuyers();
		}

		@Test
		@DisplayName("Should handle buyers with null fields")
		void testGetBuyersWithNullFields() {
			// Arrange
			List<Buyers> expectedBuyers = new ArrayList<>();
			Buyers buyer = new Buyers();
			buyer.setMetaInstanceId("buyer1");
			buyer.setFirstName(null);
			buyer.setLastName(null);
			buyer.setBuyerSex(null);
			expectedBuyers.add(buyer);

			when(buyersService.getBuyers()).thenReturn(expectedBuyers);

			// Act
			List<Buyers> result = buyersController.getBuyers();

			// Assert
			assertNotNull(result, "Buyers list should not be null");
			assertEquals(1, result.size(), "Should return 1 buyer");
			assertNull(result.get(0).getFirstName(), "FirstName should be null");
			assertNull(result.get(0).getLastName(), "LastName should be null");
			verify(buyersService, times(1)).getBuyers();
		}

		@Test
		@DisplayName("Should return buyers with special characters in names")
		void testGetBuyersWithSpecialCharacters() {
			// Arrange
			List<Buyers> expectedBuyers = new ArrayList<>();
			Buyers buyer = new Buyers();
			buyer.setMetaInstanceId("buyer1");
			buyer.setFirstName("Jean-Pierre");
			buyer.setLastName("O'Brien");
			expectedBuyers.add(buyer);

			when(buyersService.getBuyers()).thenReturn(expectedBuyers);

			// Act
			List<Buyers> result = buyersController.getBuyers();

			// Assert
			assertNotNull(result, "Buyers list should not be null");
			assertEquals(1, result.size(), "Should return 1 buyer");
			assertEquals("Jean-Pierre", result.get(0).getFirstName());
			assertEquals("O'Brien", result.get(0).getLastName());
			verify(buyersService, times(1)).getBuyers();
		}

		@Test
		@DisplayName("Should handle service exception gracefully")
		void testGetBuyersServiceThrowsException() {
			// Arrange
			when(buyersService.getBuyers()).thenThrow(new RuntimeException("Database connection failed"));

			// Act & Assert
			assertThrows(RuntimeException.class, () -> buyersController.getBuyers(),
					"Should throw RuntimeException when service fails");
			verify(buyersService, times(1)).getBuyers();
		}

	}

	@Nested
	@DisplayName("GetBuyersAnalysis Method Tests")
	class GetBuyersAnalysisTests {

		@Test
		@DisplayName("Should return buyers analysis with valid data")
		void testGetBuyersAnalysisSuccess() {
			// Arrange
			Map<String, Integer> ageCohorts = new HashMap<>();
			ageCohorts.put("18-25", 50);
			ageCohorts.put("26-35", 75);
			ageCohorts.put("36-45", 100);

			Map<String, Integer> districts = new HashMap<>();
			districts.put("Kampala", 80);
			districts.put("Mukono", 60);
			districts.put("Jinja", 85);

			when(buyersService.getMaleBuyersPercent()).thenReturn(55.5);
			when(buyersService.getFemaleBuyersPercent()).thenReturn(44.5);
			when(buyersService.getMaleBuyersAverageAge()).thenReturn(35);
			when(buyersService.getFemaleBuyersAverageAge()).thenReturn(32);
			when(buyersService.getMaleBuyersMedianAge()).thenReturn(34);
			when(buyersService.getFemaleBuyersMedianAge()).thenReturn(31);
			when(buyersService.getAgeCohorts()).thenReturn(ageCohorts);
			when(buyersService.getBuyersDistricts()).thenReturn(districts);

			// Act
			BuyersAnalysisDto result = buyersController.getBuyersAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertEquals(55.5, result.getMaleBuyersPercent(), "Male buyers percent should be 55.5");
			assertEquals(44.5, result.getFemaleBuyersPercent(), "Female buyers percent should be 44.5");
			assertEquals(35, result.getMaleBuyersAverageAge(), "Male average age should be 35");
			assertEquals(32, result.getFemaleBuyersAverageAge(), "Female average age should be 32");
			assertEquals(34, result.getMaleBuyersMedianAge(), "Male median age should be 34");
			assertEquals(31, result.getFemaleBuyersMedianAge(), "Female median age should be 31");
			assertEquals(3, result.getAgeCohorts().size(), "Should have 3 age cohorts");
			assertEquals(3, result.getBuyersDistricts().size(), "Should have 3 districts");

			verify(buyersService, times(1)).getMaleBuyersPercent();
			verify(buyersService, times(1)).getFemaleBuyersPercent();
			verify(buyersService, times(1)).getMaleBuyersAverageAge();
			verify(buyersService, times(1)).getFemaleBuyersAverageAge();
			verify(buyersService, times(1)).getMaleBuyersMedianAge();
			verify(buyersService, times(1)).getFemaleBuyersMedianAge();
			verify(buyersService, times(1)).getAgeCohorts();
			verify(buyersService, times(1)).getBuyersDistricts();
		}

		@Test
		@DisplayName("Should handle zero percent values")
		void testGetBuyersAnalysisZeroPercent() {
			// Arrange
			when(buyersService.getMaleBuyersPercent()).thenReturn(0.0);
			when(buyersService.getFemaleBuyersPercent()).thenReturn(100.0);
			when(buyersService.getMaleBuyersAverageAge()).thenReturn(0);
			when(buyersService.getFemaleBuyersAverageAge()).thenReturn(30);
			when(buyersService.getMaleBuyersMedianAge()).thenReturn(0);
			when(buyersService.getFemaleBuyersMedianAge()).thenReturn(29);
			when(buyersService.getAgeCohorts()).thenReturn(new HashMap<>());
			when(buyersService.getBuyersDistricts()).thenReturn(new HashMap<>());

			// Act
			BuyersAnalysisDto result = buyersController.getBuyersAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertEquals(0.0, result.getMaleBuyersPercent(), "Male buyers percent should be 0.0");
			assertEquals(100.0, result.getFemaleBuyersPercent(), "Female buyers percent should be 100.0");
			assertEquals(0, result.getMaleBuyersAverageAge(), "Male average age should be 0");
			verify(buyersService, times(1)).getMaleBuyersPercent();
		}

		@Test
		@DisplayName("Should handle empty age cohorts and districts maps")
		void testGetBuyersAnalysisEmptyMaps() {
			// Arrange
			Map<String, Integer> emptyAgeCohorts = new HashMap<>();
			Map<String, Integer> emptyDistricts = new HashMap<>();

			when(buyersService.getMaleBuyersPercent()).thenReturn(50.0);
			when(buyersService.getFemaleBuyersPercent()).thenReturn(50.0);
			when(buyersService.getMaleBuyersAverageAge()).thenReturn(30);
			when(buyersService.getFemaleBuyersAverageAge()).thenReturn(30);
			when(buyersService.getMaleBuyersMedianAge()).thenReturn(30);
			when(buyersService.getFemaleBuyersMedianAge()).thenReturn(30);
			when(buyersService.getAgeCohorts()).thenReturn(emptyAgeCohorts);
			when(buyersService.getBuyersDistricts()).thenReturn(emptyDistricts);

			// Act
			BuyersAnalysisDto result = buyersController.getBuyersAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertNotNull(result.getAgeCohorts(), "Age cohorts map should not be null");
			assertNotNull(result.getBuyersDistricts(), "Districts map should not be null");
			assertTrue(result.getAgeCohorts().isEmpty(), "Age cohorts should be empty");
			assertTrue(result.getBuyersDistricts().isEmpty(), "Districts should be empty");
		}

		@Test
		@DisplayName("Should handle large age cohorts and districts data")
		void testGetBuyersAnalysisLargeData() {
			// Arrange
			Map<String, Integer> ageCohorts = new HashMap<>();
			for (int i = 0; i < 100; i++) {
				ageCohorts.put("Cohort" + i, i * 10);
			}

			Map<String, Integer> districts = new HashMap<>();
			for (int i = 0; i < 50; i++) {
				districts.put("District" + i, i * 5);
			}

			when(buyersService.getMaleBuyersPercent()).thenReturn(50.0);
			when(buyersService.getFemaleBuyersPercent()).thenReturn(50.0);
			when(buyersService.getMaleBuyersAverageAge()).thenReturn(35);
			when(buyersService.getFemaleBuyersAverageAge()).thenReturn(35);
			when(buyersService.getMaleBuyersMedianAge()).thenReturn(34);
			when(buyersService.getFemaleBuyersMedianAge()).thenReturn(34);
			when(buyersService.getAgeCohorts()).thenReturn(ageCohorts);
			when(buyersService.getBuyersDistricts()).thenReturn(districts);

			// Act
			BuyersAnalysisDto result = buyersController.getBuyersAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertEquals(100, result.getAgeCohorts().size(), "Should have 100 age cohorts");
			assertEquals(50, result.getBuyersDistricts().size(), "Should have 50 districts");
		}

		@Test
		@DisplayName("Should handle decimal values for percentages")
		void testGetBuyersAnalysisDecimalPercentages() {
			// Arrange
			when(buyersService.getMaleBuyersPercent()).thenReturn(33.3333);
			when(buyersService.getFemaleBuyersPercent()).thenReturn(66.6667);
			when(buyersService.getMaleBuyersAverageAge()).thenReturn(28);
			when(buyersService.getFemaleBuyersAverageAge()).thenReturn(29);
			when(buyersService.getMaleBuyersMedianAge()).thenReturn(27);
			when(buyersService.getFemaleBuyersMedianAge()).thenReturn(28);
			when(buyersService.getAgeCohorts()).thenReturn(new HashMap<>());
			when(buyersService.getBuyersDistricts()).thenReturn(new HashMap<>());

			// Act
			BuyersAnalysisDto result = buyersController.getBuyersAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertEquals(33.3333, result.getMaleBuyersPercent(), 0.0001,
					"Male buyers percent should be 33.3333");
			assertEquals(66.6667, result.getFemaleBuyersPercent(), 0.0001,
					"Female buyers percent should be 66.6667");
		}

		@Test
		@DisplayName("Should handle special characters in district names")
		void testGetBuyersAnalysisSpecialCharacterDistricts() {
			// Arrange
			Map<String, Integer> districts = new HashMap<>();
			districts.put("North-West", 50);
			districts.put("South-East", 60);
			districts.put("Central/Urban", 70);

			when(buyersService.getMaleBuyersPercent()).thenReturn(50.0);
			when(buyersService.getFemaleBuyersPercent()).thenReturn(50.0);
			when(buyersService.getMaleBuyersAverageAge()).thenReturn(30);
			when(buyersService.getFemaleBuyersAverageAge()).thenReturn(30);
			when(buyersService.getMaleBuyersMedianAge()).thenReturn(30);
			when(buyersService.getFemaleBuyersMedianAge()).thenReturn(30);
			when(buyersService.getAgeCohorts()).thenReturn(new HashMap<>());
			when(buyersService.getBuyersDistricts()).thenReturn(districts);

			// Act
			BuyersAnalysisDto result = buyersController.getBuyersAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertEquals(3, result.getBuyersDistricts().size(), "Should have 3 districts");
			assertTrue(result.getBuyersDistricts().containsKey("North-West"),
					"Should contain North-West district");
		}

		@Test
		@DisplayName("Should handle very high age values")
		void testGetBuyersAnalysisHighAges() {
			// Arrange
			when(buyersService.getMaleBuyersPercent()).thenReturn(50.0);
			when(buyersService.getFemaleBuyersPercent()).thenReturn(50.0);
			when(buyersService.getMaleBuyersAverageAge()).thenReturn(120);
			when(buyersService.getFemaleBuyersAverageAge()).thenReturn(110);
			when(buyersService.getMaleBuyersMedianAge()).thenReturn(115);
			when(buyersService.getFemaleBuyersMedianAge()).thenReturn(105);
			when(buyersService.getAgeCohorts()).thenReturn(new HashMap<>());
			when(buyersService.getBuyersDistricts()).thenReturn(new HashMap<>());

			// Act
			BuyersAnalysisDto result = buyersController.getBuyersAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertEquals(120, result.getMaleBuyersAverageAge(), "Male average age should be 120");
			assertEquals(110, result.getFemaleBuyersAverageAge(), "Female average age should be 110");
		}

		@Test
		@DisplayName("Should handle negative percentage values (edge case)")
		void testGetBuyersAnalysisNegativePercentages() {
			// Arrange
			when(buyersService.getMaleBuyersPercent()).thenReturn(-10.0);
			when(buyersService.getFemaleBuyersPercent()).thenReturn(110.0);
			when(buyersService.getMaleBuyersAverageAge()).thenReturn(30);
			when(buyersService.getFemaleBuyersAverageAge()).thenReturn(30);
			when(buyersService.getMaleBuyersMedianAge()).thenReturn(30);
			when(buyersService.getFemaleBuyersMedianAge()).thenReturn(30);
			when(buyersService.getAgeCohorts()).thenReturn(new HashMap<>());
			when(buyersService.getBuyersDistricts()).thenReturn(new HashMap<>());

			// Act
			BuyersAnalysisDto result = buyersController.getBuyersAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertEquals(-10.0, result.getMaleBuyersPercent(), "Should handle negative percentages");
			assertEquals(110.0, result.getFemaleBuyersPercent(), "Should handle percentages > 100");
		}

		@Test
		@DisplayName("Should handle service exception when fetching analysis")
		void testGetBuyersAnalysisServiceThrowsException() {
			// Arrange
			when(buyersService.getMaleBuyersPercent())
					.thenThrow(new RuntimeException("Database error"));

			// Act & Assert
			assertThrows(RuntimeException.class, () -> buyersController.getBuyersAnalysis(),
					"Should throw RuntimeException when service fails");
		}

		@Test
		@DisplayName("Should handle null maps returned from service")
		void testGetBuyersAnalysisNullMaps() {
			// Arrange
			when(buyersService.getMaleBuyersPercent()).thenReturn(50.0);
			when(buyersService.getFemaleBuyersPercent()).thenReturn(50.0);
			when(buyersService.getMaleBuyersAverageAge()).thenReturn(30);
			when(buyersService.getFemaleBuyersAverageAge()).thenReturn(30);
			when(buyersService.getMaleBuyersMedianAge()).thenReturn(30);
			when(buyersService.getFemaleBuyersMedianAge()).thenReturn(30);
			when(buyersService.getAgeCohorts()).thenReturn(null);
			when(buyersService.getBuyersDistricts()).thenReturn(null);

			// Act
			BuyersAnalysisDto result = buyersController.getBuyersAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertNull(result.getAgeCohorts(), "Age cohorts can be null");
			assertNull(result.getBuyersDistricts(), "Districts can be null");
		}

		@Test
		@DisplayName("Should return complete analysis data structure")
		void testGetBuyersAnalysisCompleteStructure() {
			// Arrange
			Map<String, Integer> ageCohorts = new HashMap<>();
			ageCohorts.put("18-25", 100);
			ageCohorts.put("26-35", 150);

			Map<String, Integer> districts = new HashMap<>();
			districts.put("Kampala", 120);
			districts.put("Wakiso", 130);

			when(buyersService.getMaleBuyersPercent()).thenReturn(60.0);
			when(buyersService.getFemaleBuyersPercent()).thenReturn(40.0);
			when(buyersService.getMaleBuyersAverageAge()).thenReturn(32);
			when(buyersService.getFemaleBuyersAverageAge()).thenReturn(28);
			when(buyersService.getMaleBuyersMedianAge()).thenReturn(31);
			when(buyersService.getFemaleBuyersMedianAge()).thenReturn(27);
			when(buyersService.getAgeCohorts()).thenReturn(ageCohorts);
			when(buyersService.getBuyersDistricts()).thenReturn(districts);

			// Act
			BuyersAnalysisDto result = buyersController.getBuyersAnalysis();

			// Assert
			assertNotNull(result, "Analysis DTO should not be null");
			assertNotNull(result.getAgeCohorts(), "Age cohorts should not be null");
			assertNotNull(result.getBuyersDistricts(), "Districts should not be null");
			assertEquals(100, result.getAgeCohorts().get("18-25"),
					"Age cohort 18-25 should have 100 buyers");
			assertEquals(120, result.getBuyersDistricts().get("Kampala"),
					"Kampala should have 120 buyers");
		}

	}

	@Nested
	@DisplayName("Controller Initialization Tests")
	class ControllerInitializationTests {

		@Test
		@DisplayName("Should initialize controller with non-null service")
		void testControllerInitialization() {
			// Assert
			assertNotNull(buyersController, "Controller should not be null");
			assertNotNull(buyersService, "Service mock should not be null");
		}

		@Test
		@DisplayName("Should handle multiple calls sequentially")
		void testMultipleSequentialCalls() {
			// Arrange
			when(buyersService.getBuyers()).thenReturn(new ArrayList<>());

			// Act
			List<Buyers> result1 = buyersController.getBuyers();
			List<Buyers> result2 = buyersController.getBuyers();
			List<Buyers> result3 = buyersController.getBuyers();

			// Assert
			assertNotNull(result1);
			assertNotNull(result2);
			assertNotNull(result3);
			verify(buyersService, times(3)).getBuyers();
		}

	}

}































