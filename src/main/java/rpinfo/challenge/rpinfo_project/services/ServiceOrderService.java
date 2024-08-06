package rpinfo.challenge.rpinfo_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rpinfo.challenge.rpinfo_project.models.ServiceOrder;
import rpinfo.challenge.rpinfo_project.repositories.ServiceOrderRepository;

import java.util.List;

@Service
public class ServiceOrderService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    public ServiceOrder createServiceOrder(ServiceOrder serviceOrder) {
        return serviceOrderRepository.save(serviceOrder);
    }

    public List<ServiceOrder> getPendingServiceOrders() {
        return serviceOrderRepository.findByPending(true);
    }

    public ServiceOrder startServiceOrder(Long id) {
        ServiceOrder serviceOrder = serviceOrderRepository.findById(id).orElse(null);
        if (serviceOrder != null && !serviceOrder.isStarted()) {
            serviceOrder.setStarted(true);
            return serviceOrderRepository.save(serviceOrder);
        }
        return null;
    }

    public ServiceOrder completeServiceOrder(Long id) {
        ServiceOrder serviceOrder = serviceOrderRepository.findById(id).orElse(null);
        if (serviceOrder != null && serviceOrder.isPending()) {
            serviceOrder.setPending(false);
            return serviceOrderRepository.save(serviceOrder);
        }
        return null;
    }
}
