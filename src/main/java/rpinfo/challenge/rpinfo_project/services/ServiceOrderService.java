package rpinfo.challenge.rpinfo_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rpinfo.challenge.rpinfo_project.models.dtos.ServiceOrderDTO;
import rpinfo.challenge.rpinfo_project.models.Client;
import rpinfo.challenge.rpinfo_project.models.Equipment;
import rpinfo.challenge.rpinfo_project.models.ServiceOrder;
import rpinfo.challenge.rpinfo_project.repositories.ClientRepository;
import rpinfo.challenge.rpinfo_project.repositories.EquipmentRepository;
import rpinfo.challenge.rpinfo_project.repositories.ServiceOrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceOrderService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    public ServiceOrder createServiceOrder(ServiceOrderDTO serviceOrderDTO) {
        Optional<Client> client = clientRepository.findById(serviceOrderDTO.getClientId());
        Optional<Equipment> equipment = equipmentRepository.findById(serviceOrderDTO.getEquipmentId());

        if (client.isPresent() && equipment.isPresent()) {
            ServiceOrder serviceOrder = new ServiceOrder();
            serviceOrder.setClient(client.get());
            serviceOrder.setEquipment(equipment.get());
            serviceOrder.setDescription(serviceOrderDTO.getDescription());
            serviceOrder.setPending(true);
            serviceOrder.setStarted(false);
            return serviceOrderRepository.save(serviceOrder);
        } else {
            throw new RuntimeException("Client or Equipment not found");
        }
    }

    public ServiceOrder getServiceOrderById(Long id) {
        return serviceOrderRepository.findById(id).orElse(null);
    }

    public List<ServiceOrder> getPendingServiceOrders() {
        return serviceOrderRepository.findByPending(true);
    }

    public Optional<ServiceOrder> startServiceOrder(Long id) {
        Optional<ServiceOrder> serviceOrder = serviceOrderRepository.findById(id);
        serviceOrder.ifPresent(order -> {
            order.setStarted(true);
            serviceOrderRepository.save(order);
        });
        return serviceOrder;
    }

    public Optional<ServiceOrder> completeServiceOrder(Long id) {
        Optional<ServiceOrder> serviceOrder = serviceOrderRepository.findById(id);
        serviceOrder.ifPresent(order -> {
            order.setPending(false);
            serviceOrderRepository.save(order);
        });
        return serviceOrder;
    }
}
