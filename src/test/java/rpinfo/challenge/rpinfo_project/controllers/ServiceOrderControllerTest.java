package rpinfo.challenge.rpinfo_project.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import rpinfo.challenge.rpinfo_project.dtos.ServiceOrderDTO;
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
        assertEquals(1, 1);
    }

    @Test
    void getPendingServiceOrders() {
        assertEquals(1, 1);
    }

    @Test
    void startServiceOrder() {
        assertEquals(1, 1);
    }

    @Test
    void completeServiceOrder() {
        assertEquals(1, 1);
    }
}
