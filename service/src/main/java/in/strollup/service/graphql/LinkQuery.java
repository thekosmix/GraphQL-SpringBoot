package in.strollup.service.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import in.strollup.entity.mongo.Link;
import in.strollup.entity.mongo.User;
import in.strollup.repo.mongo.LinkRepository;
import in.strollup.repo.mongo.UserRepository;

@Service
public class LinkQuery implements GraphQLQueryResolver {

	@Autowired
	private LinkRepository linkRepository;

	@Autowired
	private UserRepository userRepository;

	public List<Link> getAllLinks() {
		return linkRepository.findAll();
	}

	public Link getLinkById(String id) {
		return linkRepository.findOne(id);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(String id) {
		return userRepository.findOne(id);
	}
}