package com.oportune.oportune.mapper;

import com.oportune.oportune.dto.SignUpDto;
import com.oportune.oportune.dto.UserDto;
import com.oportune.oportune.entities.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(Member member);

    @Mapping(target = "password", ignore = true)
    Member signUpToUser(SignUpDto signUpDto);

}
