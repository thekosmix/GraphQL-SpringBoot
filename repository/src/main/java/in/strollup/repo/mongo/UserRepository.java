package in.strollup.repo.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.strollup.entity.mongo.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByEmail(String email);

}
