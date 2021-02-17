package kr.pbs.babycare.server.api.child;

import kr.pbs.babycare.server.entity.Child;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ChildMapper {
    ChildMapper MAPPER = Mappers.getMapper(ChildMapper.class);

    @Mapping(source = "parent.idx", target = "parentIdx")
    ChildDTO toChildDTO(Child child);

    @Mapping(source = "parentIdx", target = "parent.idx")
    Child toChild(ChildDTO dto);
}
