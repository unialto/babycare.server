package kr.pbs.babycare.server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import kr.pbs.babycare.server.entity.code.ParentState;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@DynamicInsert
@DynamicUpdate
@SuperBuilder
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"children"})
public class Parent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int idx;

    protected String email;

    protected String password;

    protected String name;

    @Enumerated(EnumType.STRING)
    protected ParentState state;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime regDt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime updDt;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    protected List<Child> children;
}
