package kr.pbs.babycare.server.entity;

import kr.pbs.babycare.server.entity.code.ParentState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@DynamicInsert
@DynamicUpdate
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    private String email;

    private String password;

    private String name;

    @Enumerated(EnumType.STRING)
    private ParentState state;

    private LocalDateTime regDt;

    private LocalDateTime updDt;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<Child> children;
}
