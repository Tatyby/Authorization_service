package com.example.authorization_service.controller;

import com.example.authorization_service.Authorities;
import com.example.authorization_service.model.User;
import com.example.authorization_service.service.AuthorizationService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Validated
@RestController("/")
@AllArgsConstructor
public class AuthorizationController {
    AuthorizationService service;

    @GetMapping("authorize")
    public List<Authorities> getAuthorities(@Validated User user) {
        return service.getAuthorities(user);

    }




//    @GetMapping("/books/{id}/wiki")
//    public Mono<Object> getWiki(@PathVariable("id") @NotBlank String id) {
//    return service.someRestCall(id);
//
//    }
}
