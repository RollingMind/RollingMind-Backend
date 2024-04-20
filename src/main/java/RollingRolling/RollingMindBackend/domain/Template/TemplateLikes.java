package RollingRolling.RollingMindBackend.domain.Template;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "template_likes")
public class TemplateLikes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false, name = "memberNum")
    private int memberNum;

    @Column(name = "templateId")
    private int templateId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "templateId", insertable=false, updatable=false)
    private Template template;

    @Builder
    public TemplateLikes(int memberNum, int templateId){
        this.memberNum = memberNum;
        this.templateId = templateId;
    }
}
