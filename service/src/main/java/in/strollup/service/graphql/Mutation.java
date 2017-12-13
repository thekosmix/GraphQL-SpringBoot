package in.strollup.service.graphql;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import graphql.GraphQLException;
import graphql.schema.DataFetchingEnvironment;
import in.strollup.entity.mongo.Link;
import in.strollup.entity.mongo.User;
import in.strollup.entity.mongo.Vote;
import in.strollup.repo.mongo.LinkRepository;
import in.strollup.repo.mongo.UserRepository;
import in.strollup.repo.mongo.VoteRepository;
import in.strollup.service.graphql.relation.SigninPayload;
import in.strollup.service.pojo.AuthContext;
import in.strollup.service.pojo.AuthData;

@Service
public class Mutation implements GraphQLMutationResolver {

	@Autowired
	private LinkRepository linkRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VoteRepository voteRepository;

	// public Link createLink(String url, String description, String userId) {
	// Link newLink = new Link(url, description, userId);
	// newLink = linkRepository.save(newLink);
	// return newLink;
	// }

	// The way to inject the context is via DataFetchingEnvironment
	public Link createLink(String url, String description, DataFetchingEnvironment env) {
		AuthContext context = env.getContext();
		Link newLink = new Link(url, description, context.getUser().getId());
		newLink = linkRepository.save(newLink);
		return newLink;
	}

	public Link createLinkId(String id, String url, String description, String userId) {
		Link newLink = new Link(id, url, description, userId);
		newLink = linkRepository.save(newLink);
		return newLink;
	}

	public User createUser(String name, AuthData auth) {
		User newUser = new User(name, auth.getEmail(), auth.getPassword());
		return userRepository.save(newUser);
	}

	public SigninPayload signinUser(AuthData auth) throws IllegalAccessException {
		User user = userRepository.findByEmail(auth.getEmail());
		if (user.getPassword().equals(auth.getPassword())) {
			return new SigninPayload(user.getId(), user);
		}
		throw new GraphQLException("Invalid credentials");
	}

	public Vote createVote(String linkId, String userId) {
		ZonedDateTime now = Instant.now().atZone(ZoneOffset.UTC);
		return voteRepository.save(new Vote(now, userId, linkId));
	}
}