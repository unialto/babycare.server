package kr.pbs.babycare.server.api.login;

import kr.pbs.babycare.server.entity.Parent;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LoginMapper {
    LoginMapper MAPPER = Mappers.getMapper(LoginMapper.class);

    LoginDTO toLoginDTO(Parent parent);
}
