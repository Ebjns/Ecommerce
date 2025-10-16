package com.ecommerce.store.controllers;

import com.ecommerce.store.repository.UserRepository;
import com.ecommerce.store.models.Order;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173") // allow React access
@RequestMapping("/auth")
public class AuthenticationController {
    private final UserRepository repo;

    public AuthenticationController(UserRepository repo) {
        this.repo = repo;
    }

}
