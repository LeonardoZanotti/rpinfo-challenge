package rpinfo.challenge.rpinfo_project.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import rpinfo.challenge.rpinfo_project.models.dtos.ServiceOrderDTO;
import rpinfo.challenge.rpinfo_project.models.Client;
import rpinfo.challenge.rpinfo_project.models.Equipment;
import rpinfo.challenge.rpinfo_project.models.ServiceOrder;
import rpinfo.challenge.rpinfo_project.services.ServiceOrderService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ServiceOrderControllerTest {

    @Mock
    private ServiceOrderService serviceOrderService;

    @InjectMocks
    private ServiceOrderController serviceOrderController;

    public ServiceOrderControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createServiceOrder() {
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
       
        ServiceOrderDTO serviceOrderDTO = new ServiceOrderDTO();
        serviceOrderDTO.setClientId(1L);
        serviceOrderDTO.setEquipmentId(1L);
        serviceOrderDTO.setDescription("Test Service Order");

        ServiceOrder serviceOrder = new ServiceOrder();
        serviceOrder.setDescription("Test Service Order");
        serviceOrder.setPending(true);
        serviceOrder.setStarted(false);
        serviceOrder.setClient(client);
        serviceOrder.setEquipment(equipment);

        when(serviceOrderService.createServiceOrder(serviceOrderDTO)).thenReturn(serviceOrder);

        ResponseEntity<ServiceOrder> response = serviceOrderController.createServiceOrder(serviceOrderDTO);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(serviceOrder, response.getBody());

        verify(serviceOrderService, times(1)).createServiceOrder(serviceOrderDTO);
    }

    @Test
    void getPendingServiceOrders() {
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

        ServiceOrder serviceOrder1 = new ServiceOrder();
        serviceOrder1.setDescription("Test Service Order 1");
        serviceOrder1.setPending(true);
        serviceOrder1.setStarted(false);
        serviceOrder1.setClient(client);
        serviceOrder1.setEquipment(equipment);

        ServiceOrder serviceOrder2 = new ServiceOrder();
        serviceOrder2.setDescription("Test Service Order 2");
        serviceOrder2.setPending(true);
        serviceOrder2.setStarted(false);
        serviceOrder2.setClient(client);
        serviceOrder2.setEquipment(equipment);

        List<ServiceOrder> serviceOrders = Arrays.asList(serviceOrder1, serviceOrder2);

        when(serviceOrderService.getPendingServiceOrders()).thenReturn(serviceOrders);

        ResponseEntity<List<ServiceOrder>> response = serviceOrderController.getPendingServiceOrders();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(serviceOrders, response.getBody());

        verify(serviceOrderService, times(1)).getPendingServiceOrders();
    }

    @Test
    void startServiceOrder() {
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

        when(serviceOrderService.startServiceOrder(1L)).thenReturn(Optional.of(serviceOrder));

        ResponseEntity<ServiceOrder> response = serviceOrderController.startServiceOrder(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(serviceOrder, response.getBody());

        verify(serviceOrderService, times(1)).startServiceOrder(1L);
    }

    @Test
    void completeServiceOrder() {
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

        when(serviceOrderService.completeServiceOrder(1L)).thenReturn(Optional.of(serviceOrder));

        ResponseEntity<ServiceOrder> response = serviceOrderController.completeServiceOrder(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(serviceOrder, response.getBody());

        verify(serviceOrderService, times(1)).completeServiceOrder(1L);
    }
}
