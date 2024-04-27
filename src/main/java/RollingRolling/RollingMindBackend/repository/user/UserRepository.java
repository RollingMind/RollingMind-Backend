package RollingRolling.RollingMindBackend.repository.user;

import RollingRolling.RollingMindBackend.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, String>{
    boolean existsByMemberNum(int memberNum);
    boolean existsByUserId(String userId);
    boolean existsByNickname(String nickname);

    List<User> findAllByMemberNumIn(List<Integer> memberNums);
}
