package RollingRolling.RollingMindBackend.service.postit;

import RollingRolling.RollingMindBackend.domain.postit.PostIt;
import RollingRolling.RollingMindBackend.dto.postit.PostitRequest;
import RollingRolling.RollingMindBackend.repository.postit.PostItRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PostItService {
    private final PostItRepository postItRepository;
    public List<PostIt> findByRoomId(String roomId){
        return postItRepository.findByRoomId(roomId);
    }

    public PostitRequest save(PostitRequest postitRequest){  //포스트잇 저장
        PostIt postIt = PostIt.builder()
                .roomId(postitRequest.getRoomId())
                .nickname(postitRequest.getNickname())
                .content(postitRequest.getContent())
                .build();
        postItRepository.save(postIt);

        return postitRequest;
    }
}
