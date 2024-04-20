package RollingRolling.RollingMindBackend.service.postit;

import RollingRolling.RollingMindBackend.domain.postit.PostIt;
import RollingRolling.RollingMindBackend.repository.postit.PostItRepository;
import RollingRolling.RollingMindBackend.repository.room.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PostItService {
    private final PostItRepository postItRepository;
    public List<PostIt> findByRoomId(String room_id){
        return postItRepository.findByRoomId(room_id);
    }
}
