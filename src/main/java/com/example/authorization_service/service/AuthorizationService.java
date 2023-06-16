package com.example.authorization_service.service;

import com.example.authorization_service.Authorities;
import com.example.authorization_service.model.User;
import com.example.authorization_service.exception.InvalidCredentials;
import com.example.authorization_service.exception.UnauthorizedUser;
import com.example.authorization_service.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorizationService {
   UserRepository userRepository;

    public List<Authorities> getAuthorities(User user) {
        if (isEmpty(user.getUser()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }


    //    private  final WebClient webClient;
//
//    public AuthorizationService(WebClient.Builder webClientBuilder) {
//        this.webClient = webClientBuilder
//                .baseUrl("https://ru.wikipedia.org/w/api.php")
//                .build();
//    }
//
//    public Mono<Object> someRestCall(String name) {
//        return this.webClient
//                .get()
//                .uri("?action=query&list=search&srsearch={name}&format=json",name).accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToMono(Object.class);
//
//    }


}