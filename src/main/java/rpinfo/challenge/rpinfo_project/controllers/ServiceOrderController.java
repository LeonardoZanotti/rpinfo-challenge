package rpinfo.challenge.rpinfo_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rpinfo.challenge.rpinfo_project.models.dtos.ServiceOrderDTO;
import rpinfo.challenge.rpinfo_project.models.ServiceOrder;
import rpinfo.challenge.rpinfo_project.services.ServiceOrderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/service-order")
public class ServiceOrderController {

    @Autowired
    private ServiceOrderService serviceOrderService;

    @PostMapping
    public ResponseEntity<ServiceOrder> createServiceOrder(@RequestBody ServiceOrderDTO serviceOrderDTO) {
        ServiceOrder createdServiceOrder = serviceOrderService.createServiceOrder(serviceOrderDTO);
        return new ResponseEntity<>(createdServiceOrder, HttpStatus.CREATED);
    }

    @GetMapping("/pending")
    public ResponseEntity<List<ServiceOrder>> getPendingServiceOrders() {
        List<ServiceOrder> pendingServiceOrders = serviceOrderService.getPendingServiceOrders();
        return new ResponseEntity<>(pendingServiceOrders, HttpStatus.OK);
    }

    @PutMapping("/{id}/start")
    public ResponseEntity<ServiceOrder> startServiceOrder(@PathVariable Long id) {
        Optional<ServiceOrder> updatedServiceOrder = serviceOrderService.startServiceOrder(id);
        return updatedServiceOrder.map(serviceOrder -> new ResponseEntity<>(serviceOrder, HttpStatus.OK))
                                  .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<ServiceOrder> completeServiceOrder(@PathVariable Long id) {
        Optional<ServiceOrder> updatedServiceOrder = serviceOrderService.completeServiceOrder(id);
        return updatedServiceOrder.map(serviceOrder -> new ResponseEntity<>(serviceOrder, HttpStatus.OK))
                                  .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
