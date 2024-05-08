package RollingRolling.RollingMindBackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RollingMindBackendApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@WithMockUser(username="길동")
	public void deletePostItTest() throws Exception {
		Long postItId = 7L;
		String nickname = "길동";
		mockMvc.perform(delete("/api/postit/delete/{postItId}", postItId, nickname))
				.andExpect(status().isOk());
	}
	@Test
	void contextLoads() {
	}

}
