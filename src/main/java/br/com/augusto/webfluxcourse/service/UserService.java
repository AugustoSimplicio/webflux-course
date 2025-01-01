package br.com.augusto.webfluxcourse.service;

import br.com.augusto.webfluxcourse.entity.User;
import br.com.augusto.webfluxcourse.mapper.UserMapper;
import br.com.augusto.webfluxcourse.model.request.UserRequest;
import br.com.augusto.webfluxcourse.repository.UserRepository;
import br.com.augusto.webfluxcourse.service.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Mono<User> save(final UserRequest request) {
        return userRepository.save(userMapper.toEntity(request));
    }

    public Mono<User> findById(String id) {
        return userRepository.findById(id).switchIfEmpty(Mono.error(new ObjectNotFoundException("User not found")));
    }

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    public Mono<User> update(String id, final UserRequest request) {

        return userRepository.findById(id)
                .map(entity -> userMapper.toEntity(request, entity))
                .flatMap(userRepository::save);
    }
}
