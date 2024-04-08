package RollingRolling.RollingMindBackend;

import RollingRolling.RollingMindBackend.domain.Rooms;
import RollingRolling.RollingMindBackend.repository.RoomsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class RollingMindBackendApplicationTests {
	@Autowired
	RoomsRepository roomsRepository;
	@DisplayName("rooms 테이블 조회")
	@Test
	public void selectRoom(){
//		String id = "312345";
		List<Rooms> rooms = roomsRepository.findAll();
		for(Rooms room : rooms){
			System.out.println("-----------------------------------------------------------");
			System.out.println("room_id : " + room.getRoom_id());
			System.out.println("host_id : " + room.getHost_id());
			System.out.println("open : " + room.getOpen());
			System.out.println("participation_request : " + room.getParticipation_request());
		}

	}
	@DisplayName("rooms 테이블 데이터 추가")
	@Test
	public void insertRoom(){
		Rooms newRoom = Rooms.builder().room_id("311423")
				.host_id(124234)
				.open("private")
				.participation_request("n")
				.build();

		roomsRepository.save(newRoom);
	}
	@Test
	void contextLoads() {
	}

}
