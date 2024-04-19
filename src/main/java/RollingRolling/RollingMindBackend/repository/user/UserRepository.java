package RollingRolling.RollingMindBackend.repository.user;

import RollingRolling.RollingMindBackend.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long member_num);
    User save(User user);
}
