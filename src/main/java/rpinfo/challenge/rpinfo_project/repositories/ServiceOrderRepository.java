package rpinfo.challenge.rpinfo_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rpinfo.challenge.rpinfo_project.models.ServiceOrder;

import java.util.List;

public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Long> {
    List<ServiceOrder> findByPending(boolean pending);
}
