package br.com.augusto.webfluxcourse.model.response;

import org.springframework.data.mongodb.core.index.Indexed;

public record UserResponse( String id,
         String name,
         String email,
         String password) {
}
