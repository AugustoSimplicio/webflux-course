package br.com.augusto.webfluxcourse.mapper;

import br.com.augusto.webfluxcourse.entity.User;
import br.com.augusto.webfluxcourse.model.request.UserRequest;
import br.com.augusto.webfluxcourse.model.response.UserResponse;
import org.mapstruct.*;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = IGNORE,
         nullValueCheckStrategy = ALWAYS)
public interface UserMapper {

    @Mapping(target = "id" , ignore = true)
    User toEntity(final UserRequest request);

    @Mapping(target = "id", ignore = true)
    User toEntity(final UserRequest request, @MappingTarget final User entity);

    UserResponse toResponse(final User entity);
}
