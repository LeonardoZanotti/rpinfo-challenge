package rpinfo.challenge.rpinfo_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rpinfo.challenge.rpinfo_project.models.Tracking;

import java.util.List;

public interface TrackingRepository extends JpaRepository<Tracking, Long> {
    List<Tracking> findByServiceOrderId(Long serviceOrderId);
}
