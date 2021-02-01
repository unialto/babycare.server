package kr.pbs.babycare.server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import kr.pbs.babycare.server.entity.code.ParentState;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"children"})
@Entity
@DynamicInsert //NULL은 Insert에 미포함
@DynamicUpdate //NULL은 Update에 미포함
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idx")
public class Parent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    private String email;

    private String password;

    private String name;

    @Enumerated(EnumType.STRING)
    private ParentState state;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updDt;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Child> children;
}
