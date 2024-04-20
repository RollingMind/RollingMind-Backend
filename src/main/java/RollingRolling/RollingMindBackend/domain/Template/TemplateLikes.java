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

    @ManyToOne
    @JoinColumn(name = "templateId")
    private Template template;

    @Builder
    public TemplateLikes(int member_num, Template template){
        this.memberNum = member_num;
        this.template = template;
    }
}
