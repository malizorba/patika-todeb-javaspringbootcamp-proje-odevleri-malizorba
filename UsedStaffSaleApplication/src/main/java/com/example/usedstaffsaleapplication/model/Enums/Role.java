package com.example.usedstaffsaleapplication.model.Enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
        ROLE_ADMIN, ROLE_STANDARD_CLIENT;
    
        public String getAuthority() {
            return name();
        }
    }