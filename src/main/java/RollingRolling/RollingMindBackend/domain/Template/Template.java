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

    @Column(name = "templateId")
    private int templateId;

    @Column(name = "optionValue", nullable = false)
    private String optionValue;

    @Column(name = "hashtag", nullable = false)
    private String hashtag;


    @Builder
    public Template(int templateId, String optionValue, String hashtag) {
        this.templateId = templateId;
        this.optionValue = optionValue;
        this.hashtag = hashtag;
    }

    public void update(String optionValue, String hashtag) {
        this.optionValue = optionValue;
        this.hashtag = hashtag;
    }
}
