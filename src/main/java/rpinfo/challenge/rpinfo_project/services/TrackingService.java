package rpinfo.challenge.rpinfo_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rpinfo.challenge.rpinfo_project.models.ServiceOrder;
import rpinfo.challenge.rpinfo_project.models.Tracking;
import rpinfo.challenge.rpinfo_project.models.dtos.TrackingDTO;
import rpinfo.challenge.rpinfo_project.repositories.ServiceOrderRepository;
import rpinfo.challenge.rpinfo_project.repositories.TrackingRepository;

import java.util.Optional;

@Service
public class TrackingService {

    @Autowired
    private TrackingRepository trackingRepository;

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    public Tracking createTracking(TrackingDTO trackingDTO) {
        Optional<ServiceOrder> serviceOrder = serviceOrderRepository.findById(trackingDTO.getServiceOrderId());

        if (serviceOrder.isPresent()) {
            Tracking tracking = new Tracking();
            tracking.setDescription(trackingDTO.getDescription());
            tracking.setServiceOrder(serviceOrder.get());
            return trackingRepository.save(tracking);
        } else {
            throw new RuntimeException("Service order not found");
        }
    }
}
