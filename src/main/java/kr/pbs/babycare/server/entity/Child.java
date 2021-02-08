package kr.pbs.babycare.server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import kr.pbs.babycare.server.entity.code.ChildState;
import kr.pbs.babycare.server.entity.code.Gender;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@DynamicInsert
@DynamicUpdate
@SuperBuilder
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"parent"})
public class Child implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int idx;

    protected String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    protected LocalDate birthday;

    @Enumerated(EnumType.STRING)
    protected Gender gender;

    @Enumerated(EnumType.STRING)
    protected ChildState state;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime regDt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime updDt;

    @ManyToOne
    @JoinColumn(name = "parent_idx")
    protected Parent parent;
}
