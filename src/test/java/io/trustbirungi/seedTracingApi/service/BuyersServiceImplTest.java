package io.trustbirungi.seedTracingApi.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import io.trustbirungi.seedTracingApi.entity.Buyers;
import io.trustbirungi.seedTracingApi.repository.BuyersRepository;

@ExtendWith(MockitoExtension.class)
class BuyersServiceImplTest {

    @Mock
    private BuyersRepository buyersRepository;

    @InjectMocks
    private BuyersServiceImpl buyersService;

    @BeforeEach
    void setUp() {
        // Setup can be done here if needed
    }

    @Test
    void testGetBuyers() {
        List<Buyers> expectedBuyers = Arrays.asList(new Buyers(), new Buyers());
        when(buyersRepository.findAll()).thenReturn(expectedBuyers);

        List<Buyers> result = buyersService.getBuyers();

        assertEquals(expectedBuyers, result);
        verify(buyersRepository).findAll();
    }

    @Test
    void testGetMaleBuyersPercent() {
        doReturn(6).when(buyersRepository).getMaleBuyersCount();
        doReturn(4).when(buyersRepository).getFemaleBuyersCount();

        double result = buyersService.getMaleBuyersPercent();

        assertEquals(60.0, result);
    }

    @Test
    void testGetMaleBuyersPercent_NoBuyers() {
        doReturn(0).when(buyersRepository).getMaleBuyersCount();
        doReturn(0).when(buyersRepository).getFemaleBuyersCount();

        double result = buyersService.getMaleBuyersPercent();

        assertTrue(Double.isNaN(result));
    }

    @Test
    void testGetFemaleBuyersPercent() {
        doReturn(6).when(buyersRepository).getMaleBuyersCount();
        doReturn(4).when(buyersRepository).getFemaleBuyersCount();

        double result = buyersService.getFemaleBuyersPercent();

        assertEquals(40.0, result);
    }

    @Test
    void testGetFemaleBuyersPercent_NoBuyers() {
        doReturn(0).when(buyersRepository).getMaleBuyersCount();
        doReturn(0).when(buyersRepository).getFemaleBuyersCount();

        double result = buyersService.getFemaleBuyersPercent();

        assertTrue(Double.isNaN(result));
    }

    @Test
    void testGetMaleBuyersAverageAge() {
        doReturn(36).when(buyersRepository).getMaleBuyersAverageAge();

        int result = buyersService.getMaleBuyersAverageAge();

        assertEquals(36, result);
    }

    @Test
    void testGetFemaleBuyersAverageAge() {
        doReturn(32).when(buyersRepository).getFemaleBuyersAverageAge();

        int result = buyersService.getFemaleBuyersAverageAge();

        assertEquals(32, result);
    }

    @Test
    void testGetMaleBuyersMedianAge_EvenSize() {
        List<Integer> ages = Arrays.asList(35, 40, 45, 50);
        when(buyersRepository.getMaleBuyersAges()).thenReturn(ages);

        int result = buyersService.getMaleBuyersMedianAge();

        assertEquals(42, result);
    }

    @Test
    void testGetMaleBuyersMedianAge_OddSize() {
        List<Integer> ages = Arrays.asList(35, 40, 45);
        when(buyersRepository.getMaleBuyersAges()).thenReturn(ages);

        int result = buyersService.getMaleBuyersMedianAge();

        assertEquals(40, result);
    }

    @Test
    void testGetMaleBuyersMedianAge_EmptyList() {
        when(buyersRepository.getMaleBuyersAges()).thenReturn(Collections.emptyList());

        assertThrows(IndexOutOfBoundsException.class, () -> buyersService.getMaleBuyersMedianAge());
    }

    @Test
    void testGetFemaleBuyersMedianAge_EvenSize() {
        List<Integer> ages = Arrays.asList(25, 30, 35, 40);
        when(buyersRepository.getFemaleBuyersAges()).thenReturn(ages);

        int result = buyersService.getFemaleBuyersMedianAge();

        assertEquals(32, result);
    }

    @Test
    void testGetFemaleBuyersMedianAge_OddSize() {
        List<Integer> ages = Arrays.asList(25, 35, 45);
        when(buyersRepository.getFemaleBuyersAges()).thenReturn(ages);

        int result = buyersService.getFemaleBuyersMedianAge();

        assertEquals(35, result);
    }

    @Test
    void testGetFemaleBuyersMedianAge_EmptyList() {
        when(buyersRepository.getFemaleBuyersAges()).thenReturn(Collections.emptyList());

        assertThrows(IndexOutOfBoundsException.class, () -> buyersService.getFemaleBuyersMedianAge());
    }

    @Test
    void testGetAgeCohorts() {
        List<Integer> ages = Arrays.asList(18, 25, 30, 35, 40, 50, 60, 70, 80, 90, 17, 100);
        when(buyersRepository.getBuyersAges()).thenReturn(ages);

        Map<String, Integer> result = buyersService.getAgeCohorts();

        assertEquals(2, result.get("18 - 29"));
        assertEquals(2, result.get("30 - 39"));
        assertEquals(1, result.get("40 - 49"));
        assertEquals(1, result.get("50 - 59"));
        assertEquals(1, result.get("60 - 69"));
        assertEquals(1, result.get("70 - 79"));
        assertEquals(1, result.get("80 - 89"));
        assertEquals(1, result.get("90 - 99"));
    }

    @Test
    void testGetAgeCohorts_EmptyList() {
        when(buyersRepository.getBuyersAges()).thenReturn(Collections.emptyList());

        Map<String, Integer> result = buyersService.getAgeCohorts();

        assertEquals(0, result.get("18 - 29"));
        // All should be 0
    }

    @Test
    void testGetBuyersDistricts() {
        List<String> districts = Arrays.asList("DistrictA", "districta", "DistrictB");
        when(buyersRepository.getBuyersDistricts()).thenReturn(districts);

        Map<String, Integer> result = buyersService.getBuyersDistricts();

        assertEquals(2, result.get("districta"));
        assertEquals(1, result.get("districtb"));
    }

    @Test
    void testGetBuyersDistricts_EmptyList() {
        when(buyersRepository.getBuyersDistricts()).thenReturn(Collections.emptyList());

        Map<String, Integer> result = buyersService.getBuyersDistricts();

        assertTrue(result.isEmpty());
    }

    @Test
    void testGetBoughtPlantingMaterialsAverageQuantity() {
        int result = buyersService.getBoughtPlantingMaterialsAverageQuantity();

        assertEquals(0, result);
    }

    @Test
    void testGetBoughtPlantingMaterialsMedianQuantity() {
        int result = buyersService.getBoughtPlantingMaterialsMedianQuantity();

        assertEquals(0, result);
    }

    @Test
    void testGetSurvivedPlantingMaterialsAverageQuantity() {
        int result = buyersService.getSurvivedPlantingMaterialsAverageQuantity();

        assertEquals(0, result);
    }

    @Test
    void testGetSurvivedPlantingMaterialsMedianQuantity() {
        int result = buyersService.getSurvivedPlantingMaterialsMedianQuantity();

        assertEquals(0, result);
    }

    @Test
    void testGetDamagedPlantingMaterialsAverageQuantity() {
        int result = buyersService.getDamagedPlantingMaterialsAverageQuantity();

        assertEquals(0, result);
    }

    @Test
    void testGetDamagedPlantingMaterialsMedianQuantity() {
        int result = buyersService.getDamagedPlantingMaterialsMedianQuantity();

        assertEquals(0, result);
    }
}
