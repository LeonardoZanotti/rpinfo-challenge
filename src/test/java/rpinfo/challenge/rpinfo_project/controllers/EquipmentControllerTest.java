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
        assertEquals(1, 1);
    }

    @Test
    void getEquipmentById() {
        assertEquals(1, 1);
    }
}
