package rpinfo.challenge.rpinfo_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rpinfo.challenge.rpinfo_project.models.ServiceOrder;
import rpinfo.challenge.rpinfo_project.services.ServiceOrderService;

import java.util.List;

@RestController
@RequestMapping("/service-orders")
public class ServiceOrderController {

    @Autowired
    private ServiceOrderService serviceOrderService;

    @PostMapping
    public ResponseEntity<ServiceOrder> createServiceOrder(@RequestBody ServiceOrder serviceOrder) {
        ServiceOrder createdServiceOrder = serviceOrderService.createServiceOrder(serviceOrder);
        return new ResponseEntity<>(createdServiceOrder, HttpStatus.CREATED);
    }

    @GetMapping("/pending")
    public ResponseEntity<List<ServiceOrder>> getPendingServiceOrders() {
        List<ServiceOrder> pendingServiceOrders = serviceOrderService.getPendingServiceOrders();
        return new ResponseEntity<>(pendingServiceOrders, HttpStatus.OK);
    }

    @PutMapping("/{id}/start")
    public ResponseEntity<ServiceOrder> startServiceOrder(@PathVariable Long id) {
        ServiceOrder updatedServiceOrder = serviceOrderService.startServiceOrder(id);
        if (updatedServiceOrder != null) {
            return new ResponseEntity<>(updatedServiceOrder, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<ServiceOrder> completeServiceOrder(@PathVariable Long id) {
        ServiceOrder updatedServiceOrder = serviceOrderService.completeServiceOrder(id);
        if (updatedServiceOrder != null) {
            return new ResponseEntity<>(updatedServiceOrder, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
