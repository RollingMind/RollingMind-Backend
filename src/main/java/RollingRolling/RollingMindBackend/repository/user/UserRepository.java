package RollingRolling.RollingMindBackend.repository.user;

import RollingRolling.RollingMindBackend.domain.user.Login;
import RollingRolling.RollingMindBackend.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, String>{
    boolean existsByUserId(String userId);
    boolean existsByNickname(String nickname);

    List<User> findAllByMemberNumIn(List<Integer> memberNums);

    Optional<User> findByUserId(String userId);
    Optional<Login> findByPassword(String password);
}
