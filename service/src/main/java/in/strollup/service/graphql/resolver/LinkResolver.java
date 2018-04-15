package in.strollup.service.graphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLResolver;

import in.strollup.entity.mongo.Link;
import in.strollup.entity.mongo.User;
import in.strollup.repo.mongo.UserRepository;

@Service
public class LinkResolver implements GraphQLResolver<Link> {

	@Autowired
	private UserRepository userRepository;

	public User postedBy(Link link) {
		if (link.getUserId() == null) {
			return null;
		}
		return userRepository.findOne(link.getUserId());
	}
}
