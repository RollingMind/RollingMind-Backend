package RollingRolling.RollingMindBackend.service.hotrollingpaper;

import RollingRolling.RollingMindBackend.domain.room.Room;
import RollingRolling.RollingMindBackend.dto.room.RoomResponse;
import RollingRolling.RollingMindBackend.repository.room.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HotRollingPaperService {
    private final RoomRepository roomRepository;

    public List<RoomResponse> findAllRoomsOrderByParticipantsDesc() {
        List<Object[]> results = roomRepository.findAllRoomsWithParticipantsCount();
        return results.stream()
                .map(result -> new RoomResponse((Room) result[0], (Long) result[1]))
                .collect(Collectors.toList());
    }

    public List<Room> searchRoomsByTitle(String keyword){  //제목으로 롤링페이퍼 방 검색
        return roomRepository.findByTitleContaining(keyword);
    }
}
