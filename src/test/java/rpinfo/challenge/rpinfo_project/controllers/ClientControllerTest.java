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
        Client client = new Client();
        client.setName("Test Client");
        client.setAddress("Test Address");
        client.setPhone("999-999");
        client.setEmail("test@test.com");

        when(clientService.createClient(client)).thenReturn(client);

        ResponseEntity<Client> response = clientController.createClient(client);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(client, response.getBody());

        verify(clientService, times(1)).createClient(client);
    }

    @Test
    void getClientById() {
        Client client = new Client();
        client.setId(1L);
        client.setName("Test Client");
        client.setAddress("Test Address");
        client.setPhone("999-999");
        client.setEmail("test@test.com");

        when(clientService.getClientById(1L)).thenReturn(client);

        ResponseEntity<Client> response = clientController.getClientById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(client, response.getBody());

        verify(clientService, times(1)).getClientById(1L);
    }
}
