package kr.pbs.babycare.server.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QParent is a Querydsl query type for Parent
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QParent extends EntityPathBase<Parent> {

    private static final long serialVersionUID = -634410691L;

    public static final QParent parent = new QParent("parent");

    public final ListPath<Child, QChild> children = this.<Child, QChild>createList("children", Child.class, QChild.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    public final NumberPath<Integer> idx = createNumber("idx", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final DateTimePath<java.time.LocalDateTime> regDt = createDateTime("regDt", java.time.LocalDateTime.class);

    public final EnumPath<kr.pbs.babycare.server.entity.code.ParentState> state = createEnum("state", kr.pbs.babycare.server.entity.code.ParentState.class);

    public final DateTimePath<java.time.LocalDateTime> updDt = createDateTime("updDt", java.time.LocalDateTime.class);

    public QParent(String variable) {
        super(Parent.class, forVariable(variable));
    }

    public QParent(Path<? extends Parent> path) {
        super(path.getType(), path.getMetadata());
    }

    public QParent(PathMetadata metadata) {
        super(Parent.class, metadata);
    }

}

