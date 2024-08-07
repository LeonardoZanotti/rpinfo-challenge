package rpinfo.challenge.rpinfo_project.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import rpinfo.challenge.rpinfo_project.models.Client;
import rpinfo.challenge.rpinfo_project.models.Equipment;
import rpinfo.challenge.rpinfo_project.models.ServiceOrder;
import rpinfo.challenge.rpinfo_project.models.Tracking;
import rpinfo.challenge.rpinfo_project.models.dtos.TrackingDTO;
import rpinfo.challenge.rpinfo_project.services.TrackingService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TrackingControllerTest {

    @Mock
    private TrackingService trackingService;

    @InjectMocks
    private TrackingController trackingController;

    public TrackingControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createTracking() {
        Client client = new Client();
        client.setId(1L);
        client.setName("Test Client");
        client.setAddress("Test Address");
        client.setPhone("999-999");
        client.setEmail("test@test.com");

        Equipment equipment = new Equipment();
        equipment.setId(1L);
        equipment.setBrand("Test Brand");
        equipment.setType("Test Type");

        ServiceOrder serviceOrder = new ServiceOrder();
        serviceOrder.setDescription("Test Service Order");
        serviceOrder.setPending(true);
        serviceOrder.setStarted(false);
        serviceOrder.setClient(client);
        serviceOrder.setEquipment(equipment);

        TrackingDTO trackingDTO = new TrackingDTO();
        trackingDTO.setDescription("Test Tracking");
        trackingDTO.setServiceOrderId(1L);

        Tracking tracking = new Tracking();
        tracking.setDescription("Test Tracking");
        tracking.setServiceOrder(serviceOrder);

        when(trackingService.createTracking(trackingDTO)).thenReturn(tracking);

        ResponseEntity<Tracking> response = trackingController.createTracking(trackingDTO);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(tracking, response.getBody());

        verify(trackingService, times(1)).createTracking(trackingDTO);
    }

    @Test
    void getTrackingsByServiceOrderId() {
        Client client = new Client();
        client.setId(1L);
        client.setName("Test Client");
        client.setAddress("Test Address");
        client.setPhone("999-999");
        client.setEmail("test@test.com");

        Equipment equipment = new Equipment();
        equipment.setId(1L);
        equipment.setBrand("Test Brand");
        equipment.setType("Test Type");

        ServiceOrder serviceOrder = new ServiceOrder();
        serviceOrder.setDescription("Test Service Order");
        serviceOrder.setPending(true);
        serviceOrder.setStarted(false);
        serviceOrder.setClient(client);
        serviceOrder.setEquipment(equipment);
        
        Tracking tracking1 = new Tracking();
        tracking1.setDescription("Test Tracking 1");
        tracking1.setServiceOrder(serviceOrder);
        
        Tracking tracking2 = new Tracking();
        tracking2.setDescription("Test Tracking 2");
        tracking2.setServiceOrder(serviceOrder);

        List<Tracking> trackings = Arrays.asList(tracking1, tracking2);

        when(trackingService.getTrackingsByServiceOrderId(1L)).thenReturn(trackings);

        ResponseEntity<List<Tracking>> response = trackingController.getTrackingsByServiceOrderId(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(trackings, response.getBody());

        verify(trackingService, times(1)).getTrackingsByServiceOrderId(1L);
    }
}
