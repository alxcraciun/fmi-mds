package com.oportune.oportune.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority{
    MEMBER,
    ADMIN;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
