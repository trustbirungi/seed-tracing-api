package io.trustbirungi.seedTracingApi.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import io.trustbirungi.seedTracingApi.repository.SeedMultipliersRepository;

@ExtendWith(MockitoExtension.class)
class SeedMultipliersServiceImplTest {

    @Mock
    private SeedMultipliersRepository seedMultipliersRepository;

    @InjectMocks
    private SeedMultipliersServiceImpl seedMultipliersService;

    @Test
    void testGetMalePercent() {
        doReturn(7).when(seedMultipliersRepository).getMaleMultipliersCount();
        doReturn(3).when(seedMultipliersRepository).getFemaleMultipliersCount();

        double result = seedMultipliersService.getMalePercent();

        assertEquals(70.0, result);
    }

    @Test
    void testGetMalePercent_NoMultipliers() {
        doReturn(0).when(seedMultipliersRepository).getMaleMultipliersCount();
        doReturn(0).when(seedMultipliersRepository).getFemaleMultipliersCount();

        double result = seedMultipliersService.getMalePercent();

        assertTrue(Double.isNaN(result));
    }

    @Test
    void testGetFemalePercent() {
        doReturn(7).when(seedMultipliersRepository).getMaleMultipliersCount();
        doReturn(3).when(seedMultipliersRepository).getFemaleMultipliersCount();

        double result = seedMultipliersService.getFemalePercent();

        assertEquals(30.0, result);
    }

    @Test
    void testGetMaleAverageAge() {
        doReturn(40.5).when(seedMultipliersRepository).getMaleAverageAge();

        int result = seedMultipliersService.getMaleAverageAge();

        assertEquals(41, result);
    }

    @Test
    void testGetFemaleAverageAge() {
        doReturn(38.2).when(seedMultipliersRepository).getFemaleAverageAge();

        int result = seedMultipliersService.getFemaleAverageAge();

        assertEquals(38, result);
    }

    @Test
    void testGetMaleMedianAge_EvenSize() {
        List<Integer> ages = Arrays.asList(35, 40, 45, 50);
        when(seedMultipliersRepository.getMaleMultipliersAges()).thenReturn(ages);

        int result = seedMultipliersService.getMaleMedianAge();

        assertEquals(42, result);
    }

    @Test
    void testGetMaleMedianAge_OddSize() {
        List<Integer> ages = Arrays.asList(35, 40, 45);
        when(seedMultipliersRepository.getMaleMultipliersAges()).thenReturn(ages);

        int result = seedMultipliersService.getMaleMedianAge();

        assertEquals(40, result);
    }

    @Test
    void testGetMaleMedianAge_EmptyList() {
        when(seedMultipliersRepository.getMaleMultipliersAges()).thenReturn(Collections.emptyList());

        assertThrows(IndexOutOfBoundsException.class, () -> seedMultipliersService.getMaleMedianAge());
    }

    @Test
    void testGetFemaleMedianAge_EvenSize() {
        List<Integer> ages = Arrays.asList(30, 35, 40, 45);
        when(seedMultipliersRepository.getFemaleMultipliersAges()).thenReturn(ages);

        int result = seedMultipliersService.getFemaleMedianAge();

        assertEquals(37, result);
    }

    @Test
    void testGetFemaleMedianAge_EmptyList() {
        when(seedMultipliersRepository.getFemaleMultipliersAges()).thenReturn(Collections.emptyList());

        assertThrows(IndexOutOfBoundsException.class, () -> seedMultipliersService.getFemaleMedianAge());
    }

    @Test
    void testGetAgeCohorts() {
        List<Integer> ages = Arrays.asList(18, 25, 30, 35, 40, 50, 60, 70, 80, 90);
        when(seedMultipliersRepository.getMultipliersAges()).thenReturn(ages);

        Map<String, Integer> result = seedMultipliersService.getAgeCohorts();

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
    void testGetFemaleAgeCohorts() {
        List<Integer> ages = Arrays.asList(18, 25, 30);
        when(seedMultipliersRepository.getFemaleMultipliersAges()).thenReturn(ages);

        Map<String, Integer> result = seedMultipliersService.getFemaleAgeCohorts();

        assertEquals(2, result.get("18 - 29"));
        assertEquals(1, result.get("30 - 39"));
    }

    @Test
    void testGetMaleAgeCohorts() {
        List<Integer> ages = Arrays.asList(40, 50);
        when(seedMultipliersRepository.getMaleMultipliersAges()).thenReturn(ages);

        Map<String, Integer> result = seedMultipliersService.getMaleAgeCohorts();

        assertEquals(1, result.get("40 - 49"));
        assertEquals(1, result.get("50 - 59"));
    }

    @Test
    void testGetIndividualMultipliersPercent() {
        doReturn(8).when(seedMultipliersRepository).getIndividualMultipliersCount();
        doReturn(2).when(seedMultipliersRepository).getGroupMultipliersCount();

        double result = seedMultipliersService.getIndividualMultipliersPercent();

        assertEquals(80.0, result);
    }

    @Test
    void testGetGroupMultipliersPercent() {
        doReturn(8).when(seedMultipliersRepository).getIndividualMultipliersCount();
        doReturn(2).when(seedMultipliersRepository).getGroupMultipliersCount();

        double result = seedMultipliersService.getGroupMultipliersPercent();

        assertEquals(20.0, result);
    }

    @Test
    void testGetAverageGroupSize() {
        doReturn(5.6).when(seedMultipliersRepository).getAverageGroupSize();

        int result = seedMultipliersService.getAverageGroupSize();

        assertEquals(6, result);
    }

    @Test
    void testGetMedianGroupSize_EvenSize() {
        List<Integer> sizes = Arrays.asList(3, 4, 5, 6);
        when(seedMultipliersRepository.getGroupSizes()).thenReturn(sizes);

        int result = seedMultipliersService.getMedianGroupSize();

        assertEquals(4, result);
    }

    @Test
    void testGetMedianGroupSize_EmptyList() {
        when(seedMultipliersRepository.getGroupSizes()).thenReturn(Collections.emptyList());

        assertThrows(IndexOutOfBoundsException.class, () -> seedMultipliersService.getMedianGroupSize());
    }

    @Test
    void testGetAverageFemaleMembersPerGroup() {
        doReturn(2.3).when(seedMultipliersRepository).getAverageFemaleMembersPerGroup();

        int result = seedMultipliersService.getAverageFemaleMembersPerGroup();

        assertEquals(2, result);
    }

    @Test
    void testGetAverageMaleMembersPerGroup() {
        doReturn(3.7).when(seedMultipliersRepository).getAverageMaleMembersPerGroup();

        int result = seedMultipliersService.getAverageMaleMembersPerGroup();

        assertEquals(4, result);
    }

    @Test
    void testGetMultipliersDistricts() {
        List<String> districts = Arrays.asList("DistrictA", "districta", "DistrictB");
        when(seedMultipliersRepository.getMultipliersDistricts()).thenReturn(districts);

        Map<String, Integer> result = seedMultipliersService.getMultipliersDistricts();

        assertEquals(2, result.get("districta"));
        assertEquals(1, result.get("districtb"));
    }

    @Test
    void testGetPlantingMaterialsFrequency() {
        List<String> materials = Arrays.asList("banana apple", "Banana", "apple orange");
        when(seedMultipliersRepository.getPlantingMaterials()).thenReturn(materials);

        Map<String, Integer> result = seedMultipliersService.getPlantingMaterialsFrequency();

        assertEquals(2, result.get("banana"));
        assertEquals(2, result.get("apple"));
        assertEquals(1, result.get("orange"));
    }

    @Test
    void testGetPlantingMaterialsVarietiesFrequency() {
        List<String> varieties = Arrays.asList("variety1 variety2", "Variety1");
        when(seedMultipliersRepository.getPlantingMaterialsVarieties()).thenReturn(varieties);

        Map<String, Integer> result = seedMultipliersService.getPlantingMaterialsVarietiesFrequency();

        assertEquals(2, result.get("variety1"));
        assertEquals(1, result.get("variety2"));
    }

    @Test
    void testGetBananaVarietiesFrequency() {
        List<String> varieties = Arrays.asList("banana type1", "Banana type2");
        when(seedMultipliersRepository.getBananaPlantingMaterialsVarieties()).thenReturn(varieties);

        Map<String, Integer> result = seedMultipliersService.getBananaVarietiesFrequency();

        assertEquals(2, result.get("banana"));
        assertEquals(1, result.get("type1"));
        assertEquals(1, result.get("type2"));
    }

    @Test
    void testGetPotatoVarietiesFrequency() {
        List<String> varieties = Arrays.asList("potato typeA", "Potato typeB");
        when(seedMultipliersRepository.getPotatoPlantingMaterialsVarieties()).thenReturn(varieties);

        Map<String, Integer> result = seedMultipliersService.getPotatoVarietiesFrequency();

        assertEquals(2, result.get("potato"));
        assertEquals(1, result.get("typea"));
        assertEquals(1, result.get("typeb"));
    }

    @Test
    void testGetPlantingMethodsFrequency() {
        List<String> methods = Arrays.asList("method1", "Method1", "method2");
        when(seedMultipliersRepository.getPlantingMethods()).thenReturn(methods);

        Map<String, Integer> result = seedMultipliersService.getPlantingMethodsFrequency();

        assertEquals(2, result.get("method1"));
        assertEquals(1, result.get("method2"));
    }
}
