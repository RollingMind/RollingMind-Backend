package RollingRolling.RollingMindBackend;

import RollingRolling.RollingMindBackend.domain.user.CustomUserDetails;
import RollingRolling.RollingMindBackend.dto.postit.PostItUpdateRequest;
import RollingRolling.RollingMindBackend.service.postit.PostItService;
import RollingRolling.RollingMindBackend.service.room.RoomService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RollingMindBackendApplicationTests {
	@Autowired
	PostItService postItService;
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private RoomService roomService;
	@Autowired
	private ObjectMapper objectMapper;
	@Test
	@WithMockUser(username="길동", roles = {"USER"})
	public void deletePostItTest() throws Exception {
		Long postItId = 2L;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String nickname = authentication.getName();
		postItService.delete(postItId, nickname);
	}
	@Test
	@WithMockUser(username="순자", roles = {"USER"})
	public void updatePostItTest() throws Exception {
		CustomUserDetails customUserDetails = new CustomUserDetails();
		customUserDetails.setId(100002);
		customUserDetails.setNickname("순자");
		UsernamePasswordAuthenticationToken authentication =
				new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Update request 객체 생성
		PostItUpdateRequest postItUpdateRequest = new PostItUpdateRequest("수수수수퍼노바", "#FFFFFF", "닝닝");

		// 요청 바디를 JSON 문자열로 변환
		String requestBody = objectMapper.writeValueAsString(postItUpdateRequest);

		// PATCH 요청 수행
		ResultActions resultActions = mockMvc.perform(
						patch("/api/postit/{postItId}", 232)
								.contentType(MediaType.APPLICATION_JSON)
								.content(requestBody))
				.andDo(print()) // 요청 및 응답 출력
				.andExpect(status().isOk()) // 상태 코드 200 확인
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)) // 응답 Content-Type 확인
				.andExpect(content().json(requestBody)); // 응답 내용 확인 (여기서는 요청과 동일한 내용이 반환된다고 가정)

	}
	@Test
	@WithMockUser(username="박성호", roles={"USER"})
	public void deleteRoomTest() throws Exception {
		CustomUserDetails customUserDetails = new CustomUserDetails();
		customUserDetails.setId(100008);
		customUserDetails.setUsername("박성호");
		UsernamePasswordAuthenticationToken authentication =
				new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		ResultActions resultActions = mockMvc.perform(
				MockMvcRequestBuilders.delete("/api/room/{roomId}",399999)
						.contentType(MediaType.APPLICATION_JSON));
		// then
		MvcResult mvcResult = resultActions
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
	}
	@Test
	void contextLoads() {
	}

}
