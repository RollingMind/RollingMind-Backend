package RollingRolling.RollingMindBackend.service.hotrollingpaper;

import RollingRolling.RollingMindBackend.domain.room.Room;
import RollingRolling.RollingMindBackend.repository.room.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HotRollingPaperService {
    private final RoomRepository roomRepository;

    public List<Room> findAllRoomsOrderByParticipantsDesc(){
        return roomRepository.findAllRoomsOrderByParticipantsDesc();
    }
}
