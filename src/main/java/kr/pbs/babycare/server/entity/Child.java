package kr.pbs.babycare.server.entity;

import kr.pbs.babycare.server.entity.code.ChildState;
import kr.pbs.babycare.server.entity.code.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@DynamicInsert
@DynamicUpdate
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Child implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    private String name;

    private LocalDate birthday;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private ChildState state;

    private LocalDateTime regDt;

    private LocalDateTime updDt;

    @ManyToOne
    @JoinColumn(name = "parent_idx")
    private Parent parent;
}
