package RollingRolling.RollingMindBackend.domain.Template;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "template")
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "option_value", nullable = false)
    private String option_value;

    @Column(name = "hashtag", nullable = false)
    private String hashtag;


    @Builder
    public Template(String option_value, String hashtag) {
        this.option_value = option_value;
        this.hashtag = hashtag;
    }

    public void update(String option_value, String hashtag) {
        this.option_value = option_value;
        this.hashtag = hashtag;
    }
}
