package RollingRolling.RollingMindBackend.repository;

import RollingRolling.RollingMindBackend.domain.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomsRepository extends JpaRepository<Rooms, String> {
}
