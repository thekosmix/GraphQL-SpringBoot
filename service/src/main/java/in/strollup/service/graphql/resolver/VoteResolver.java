package in.strollup.service.graphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLResolver;

import in.strollup.entity.mongo.Link;
import in.strollup.entity.mongo.User;
import in.strollup.entity.mongo.Vote;
import in.strollup.repo.mongo.LinkRepository;
import in.strollup.repo.mongo.UserRepository;

@Service
public class VoteResolver implements GraphQLResolver<Vote> {

	@Autowired
	private LinkRepository linkRepository;

	@Autowired
	private UserRepository userRepository;

	public User user(Vote vote) {
		return userRepository.findOne(vote.getUserId());
	}

	public Link link(Vote vote) {
		return linkRepository.findOne(vote.getLinkId());
	}
}
