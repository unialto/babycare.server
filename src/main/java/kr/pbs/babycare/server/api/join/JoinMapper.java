package kr.pbs.babycare.server.api.join;

import kr.pbs.babycare.server.entity.Parent;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JoinMapper {
    JoinMapper MAPPER = Mappers.getMapper(JoinMapper.class);

//    @Mapping(target = "idx", constant = "0")
    Parent toParent(JoinDTO dto);
}
