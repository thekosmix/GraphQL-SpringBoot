package in.strollup.repo.mongo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import in.strollup.entity.mongo.Link;

public interface LinkRepository extends MongoRepository<Link, String> {

	List<Link> findByUrlLikeOrDescriptionLike(String url, String description, Pageable pageableRequest);

	default List<Link> findByUrlLikeOrDescriptionLikePaginated(String url, String description, int skip, int first) {
		return findByUrlLikeOrDescriptionLike(url, description, new PageRequest(skip, first));
	}

	default List<Link> findPaginated(int skip, int first) {
		Page<Link> page = findAll(new PageRequest(skip, first));
		return page.getContent();
	}
}
