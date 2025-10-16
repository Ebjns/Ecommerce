package com.ecommerce.store.service;

import com.ecommerce.store.dto.UserDTO;
import com.ecommerce.store.dto.request.LoginRequest;
import com.ecommerce.store.dto.request.RegisterRequest;
import com.ecommerce.store.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
    UserDTO getUserByUsername(String username);
}
