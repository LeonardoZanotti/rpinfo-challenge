package rpinfo.challenge.rpinfo_project.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import rpinfo.challenge.rpinfo_project.models.Equipment;
import rpinfo.challenge.rpinfo_project.services.EquipmentService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EquipmentControllerTest {

    @Mock
    private EquipmentService equipmentService;

    @InjectMocks
    private EquipmentController equipmentController;

    public EquipmentControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createEquipment() {
        Equipment equipment = new Equipment();
        equipment.setBrand("Test Brand");
        equipment.setType("Test Type");

        when(equipmentService.createEquipment(equipment)).thenReturn(equipment);

        ResponseEntity<Equipment> response = equipmentController.createEquipment(equipment);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(equipment, response.getBody());

        verify(equipmentService, times(1)).createEquipment(equipment);
    }

    @Test
    void getEquipmentById() {
        Equipment equipment = new Equipment();
        equipment.setId(1L);
        equipment.setBrand("Test Brand");
        equipment.setType("Test Type");

        when(equipmentService.getEquipmentById(1L)).thenReturn(equipment);

        ResponseEntity<Equipment> response = equipmentController.getEquipmentById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(equipment, response.getBody());

        verify(equipmentService, times(1)).getEquipmentById(1L);
    }
}
