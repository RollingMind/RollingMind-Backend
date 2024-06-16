package RollingRolling.RollingMindBackend.service.hotrollingpaper;

import RollingRolling.RollingMindBackend.domain.room.Room;
import RollingRolling.RollingMindBackend.dto.room.HotRollingPaperResponse;
import RollingRolling.RollingMindBackend.repository.room.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HotRollingPaperService {
    private final RoomRepository roomRepository;

    public List<HotRollingPaperResponse> findHotRollingPaper() {
        return roomRepository.findAllRoomsWithParticipantsCount();
    }

    public List<HotRollingPaperResponse> searchRoomsByTitle(String keyword){  //제목으로 롤링페이퍼 방 검색
        return roomRepository.findByTitleContaining(keyword);
    }
}
