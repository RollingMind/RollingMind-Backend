package RollingRolling.RollingMindBackend.repository.user;

import RollingRolling.RollingMindBackend.domain.user.User;
import RollingRolling.RollingMindBackend.dto.create.user.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long>{

    User findById(long member_num);

}
