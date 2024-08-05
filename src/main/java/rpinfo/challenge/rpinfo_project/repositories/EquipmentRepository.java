package rpinfo.challenge.rpinfo_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rpinfo.challenge.rpinfo_project.models.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
