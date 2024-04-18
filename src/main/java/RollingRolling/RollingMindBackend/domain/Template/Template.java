package RollingRolling.RollingMindBackend.domain.Template;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "template")
public class Template {
    @Id
    @Column(nullable = false)
    private String image_path;

    @Column(nullable = false)
    private String hashtag;

    @Builder
    public Template(String image_path, String hashtag) {
        this.image_path = image_path;
        this.hashtag = hashtag;
    }

    public void update(String image_path, String hashtag) {
        this.image_path = image_path;
        this.hashtag = hashtag;
    }
}
