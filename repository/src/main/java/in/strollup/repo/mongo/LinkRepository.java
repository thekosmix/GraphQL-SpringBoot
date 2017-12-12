package in.strollup.repo.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.strollup.entity.mongo.Link;

public interface LinkRepository extends MongoRepository<Link, String> {

}
