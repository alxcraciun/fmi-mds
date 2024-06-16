package com.oportune.oportune.controller;

import com.oportune.oportune.dto.MessageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagesController {

    @GetMapping("/messages")
    @PreAuthorize("hasAnyAuthority('MEMBER', 'ADMIN')")
    public ResponseEntity<MessageDto> message() {
        return ResponseEntity.ok(new MessageDto("user's message"));
    }

    @GetMapping("/protected/messages")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<MessageDto> protectedMessage() {
        return ResponseEntity.ok(new MessageDto("protected user's message"));
    }
}
