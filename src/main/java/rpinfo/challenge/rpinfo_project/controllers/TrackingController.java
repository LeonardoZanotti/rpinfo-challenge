package rpinfo.challenge.rpinfo_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import rpinfo.challenge.rpinfo_project.models.Tracking;
import rpinfo.challenge.rpinfo_project.models.dtos.TrackingDTO;
import rpinfo.challenge.rpinfo_project.services.TrackingService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tracking")
public class TrackingController {

    @Autowired
    private TrackingService trackingService;

    @PostMapping
    public ResponseEntity<Tracking> createTracking(@RequestBody TrackingDTO trackingDTO) {
        Tracking createdTracking = trackingService.createTracking(trackingDTO);
        return new ResponseEntity<>(createdTracking, HttpStatus.CREATED);
    }

    @GetMapping("/byServiceOrder/{serviceOrderId}")
    public ResponseEntity<List<Tracking>> getTrackingsByServiceOrderId(@PathVariable Long serviceOrderId) {
        List<Tracking> trackings = trackingService.getTrackingsByServiceOrderId(serviceOrderId);
        return new ResponseEntity<>(trackings, HttpStatus.OK);
    }
}
