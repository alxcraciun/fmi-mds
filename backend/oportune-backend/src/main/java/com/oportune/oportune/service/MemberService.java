package com.oportune.oportune.service;

import com.oportune.oportune.dto.CredentialsDto;
import com.oportune.oportune.dto.SignUpDto;
import com.oportune.oportune.dto.UserDto;
import com.oportune.oportune.entities.Member;
import com.oportune.oportune.enums.Role;
import com.oportune.oportune.exceptions.AppException;
import com.oportune.oportune.mapper.UserMapper;
import com.oportune.oportune.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    public UserDto login(CredentialsDto credentialsDto) {
        Member member = memberRepository.findByLogin(credentialsDto.getLogin())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), member.getPassword())) {
            return userMapper.toUserDto(member);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public UserDto register(SignUpDto userDto) {
        Optional<Member> optionalUser = memberRepository.findByLogin(userDto.getLogin());

        if (optionalUser.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        Member member = userMapper.signUpToUser(userDto);
        member.setRole(Role.MEMBER);
        member.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.getPassword())));

        Member savedUser = memberRepository.save(member);

        return userMapper.toUserDto(savedUser);
    }

    public UserDto findByLogin(String login) {
        Member member = memberRepository.findByLogin(login)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(member);
    }

}
