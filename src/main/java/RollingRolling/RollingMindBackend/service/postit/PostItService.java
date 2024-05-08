package RollingRolling.RollingMindBackend.service.postit;

import RollingRolling.RollingMindBackend.domain.postit.PostIt;
import RollingRolling.RollingMindBackend.dto.postit.PostItRequest;
import RollingRolling.RollingMindBackend.repository.postit.PostItRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PostItService {
    private final PostItRepository postItRepository;
    public List<PostIt> findByRoomId(String roomId){
        return postItRepository.findByRoomId(roomId);
    }

    public PostItRequest save(PostItRequest postitRequest){  //포스트잇 저장
        PostIt postIt = PostIt.builder()
                .roomId(postitRequest.getRoomId())
                .nickname(postitRequest.getNickname())
                .content(postitRequest.getContent())
                .build();
        postItRepository.save(postIt);

        return postitRequest;
    }

    public void delete(Long postItId, String userNickname) {  //포스트잇 삭제
        PostIt postIt = postItRepository.findById(postItId)
                .orElseThrow(() -> new EntityNotFoundException("포스트잇을 찾을 수 없습니다. id: " + postItId));

        if(!postIt.getNickname().equals(userNickname)) {
            throw new IllegalStateException("포스트잇 삭제 권한이 없습니다.");
        }

        postItRepository.delete(postIt);
    }

    @Transactional
    public PostIt update(Long postItId, String userNickname, String content){  //포스트잇 수정
        PostIt postIt = postItRepository.findById(postItId)
                .orElseThrow(() -> new EntityNotFoundException("포스트잇을 찾을 수 없습니다. id: " + postItId));

        if(!postIt.getNickname().equals(userNickname)) {
            throw new IllegalStateException("포스트잇 수정 권한이 없습니다.");
        }
        postIt.update(content);
        postItRepository.save(postIt);
        return postIt;
    }
}
