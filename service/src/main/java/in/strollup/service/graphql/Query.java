package in.strollup.service.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import in.strollup.dto.LinkFilter;
import in.strollup.entity.mongo.Link;
import in.strollup.entity.mongo.User;
import in.strollup.repo.mongo.LinkRepository;
import in.strollup.repo.mongo.UserRepository;

@Service
public class Query implements GraphQLQueryResolver {

	@Autowired
	private LinkRepository linkRepository;

	@Autowired
	private UserRepository userRepository;

	public Link getLinkById(String id) {
		return linkRepository.findOne(id);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(String id) {
		return userRepository.findOne(id);
	}

	public List<Link> getAllLinks(LinkFilter filter) {
		if (filter == null) {
			return linkRepository.findAll();
		}
		return linkRepository.findByUrlLikeOrDescriptionLike(filter.getUrlContains(), filter.getDescriptionContains());
	}
}