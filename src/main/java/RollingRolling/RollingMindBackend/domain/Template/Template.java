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

    @Column(name = "Template_id", nullable = false)
    private int Template_id;

    @Column(name = "option_value", nullable = false)
    private String option_value;

    @Column(name = "hashtag", nullable = false)
    private String hashtag;

    @Builder
    public Template(int Template_id, String option_value, String hashtag) {
        this.Template_id = Template_id;
        this.option_value = option_value;
        this.hashtag = hashtag;
    }

    public void update(int Template_id, String option_value, String hashtag) {
        this.Template_id = Template_id;
        this.option_value = option_value;
        this.hashtag = hashtag;
    }
}
