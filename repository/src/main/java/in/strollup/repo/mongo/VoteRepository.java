package in.strollup.repo.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.strollup.entity.mongo.Vote;

public interface VoteRepository extends MongoRepository<Vote, String> {

}
