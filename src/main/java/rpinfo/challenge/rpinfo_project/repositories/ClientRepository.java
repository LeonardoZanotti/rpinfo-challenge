package rpinfo.challenge.rpinfo_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rpinfo.challenge.rpinfo_project.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
