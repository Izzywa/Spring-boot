package com.REST.spring_boot.security;

import com.REST.spring_boot.authentication.Users;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {
    public static Users getCurrentUser() {
        // Get the currently authenticated user from the security context
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        assert auth != null;
        // Return the user details
        // This will return an instance of Users class
        return (Users) auth.getPrincipal();
    }
}
