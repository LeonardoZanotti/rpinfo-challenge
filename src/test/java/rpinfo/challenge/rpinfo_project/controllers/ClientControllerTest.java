package rpinfo.challenge.rpinfo_project.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import rpinfo.challenge.rpinfo_project.models.Client;
import rpinfo.challenge.rpinfo_project.services.ClientService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ClientControllerTest {

    @Mock
    private ClientService clientService;

    @InjectMocks
    private ClientController clientController;

    public ClientControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createClient() {
        assertEquals(1, 1);
    }

    @Test
    void getClientById() {
        assertEquals(1, 1);
    }
}
