package br.com.augusto.webfluxcourse.repository;

import br.com.augusto.webfluxcourse.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final ReactiveMongoTemplate mongoTemplate;

    public Mono<User> save(final User user) {
        return this.mongoTemplate.save(user);
    }

    public Mono<User> findById(String id) {
        return this.mongoTemplate.findById(id, User.class);
    }

    public Flux<User> findAll() {
        return this.mongoTemplate.findAll(User.class);
    }

    public Mono<User> findAndRemover(String id) {
        Query query = new Query();
        Criteria where = Criteria.where("id").is(id);
        return mongoTemplate.findAndRemove(query.addCriteria(where), User.class);
    }
}
