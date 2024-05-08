package RollingRolling.RollingMindBackend;

import RollingRolling.RollingMindBackend.service.postit.PostItService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RollingMindBackendApplicationTests {
	@Autowired
	PostItService postItService;
	@Autowired
	private MockMvc mockMvc;

	@Test
	@WithMockUser(username="길동", roles = {"USER"})
	public void deletePostItTest() throws Exception {
		Long postItId = 2L;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String nickname = authentication.getName();
		postItService.delete(postItId, nickname);
	}
	@Test
	void contextLoads() {
	}

}
