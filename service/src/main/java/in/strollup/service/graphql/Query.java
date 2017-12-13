package in.strollup.service.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import in.strollup.entity.mongo.Link;
import in.strollup.entity.mongo.User;
import in.strollup.repo.mongo.LinkRepository;
import in.strollup.repo.mongo.UserRepository;
import in.strollup.service.pojo.LinkFilter;

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

	public List<Link> getAllLinks(LinkFilter filter, Number skip, Number first) {
		if (filter == null && skip == null && first == null) {
			return linkRepository.findAll();
		}

		int skipInt = skip == null ? 0 : skip.intValue();
		int firstInt = first == null ? 1 : first.intValue();

		if (filter == null) {
			return linkRepository.findPaginated(skipInt, firstInt);
		}

		return linkRepository.findByUrlLikeOrDescriptionLikePaginated(filter.getUrlContains(),
				filter.getDescriptionContains(), skipInt, firstInt);
	}
}