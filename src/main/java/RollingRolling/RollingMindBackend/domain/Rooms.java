package RollingRolling.RollingMindBackend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Rooms {
    @Id
    @Column(nullable = false)
    private String room_id;

    @Column(nullable = false)
    private int host_id;

    @Column(nullable = false)
    private String open;

    @Column(nullable = false)
    private String participation_request;

    @Builder
    public Rooms(String room_id, int host_id, String open, String participation_request){
        this.room_id = room_id;
        this.host_id = host_id;
        this.open = open;
        this.participation_request = participation_request;
    }
}