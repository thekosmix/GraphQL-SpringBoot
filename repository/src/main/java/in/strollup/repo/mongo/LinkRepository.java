package in.strollup.repo.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.strollup.entity.mongo.Link;

public interface LinkRepository extends MongoRepository<Link, String> {

	List<Link> findByUrlLikeOrDescriptionLike(String url, String description);
}
