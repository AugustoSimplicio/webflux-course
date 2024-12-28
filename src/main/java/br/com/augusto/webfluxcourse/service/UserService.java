package br.com.augusto.webfluxcourse.service;

import br.com.augusto.webfluxcourse.entity.User;
import br.com.augusto.webfluxcourse.mapper.UserMapper;
import br.com.augusto.webfluxcourse.model.request.UserRequest;
import br.com.augusto.webfluxcourse.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Mono<User> save(final UserRequest request) {
        return userRepository.save(userMapper.toEntity(request));
    }
}
