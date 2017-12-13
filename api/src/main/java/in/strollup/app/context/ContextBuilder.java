package in.strollup.app.context;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.servlet.DefaultGraphQLContextBuilder;
import graphql.servlet.GraphQLContext;
import in.strollup.entity.mongo.User;
import in.strollup.repo.mongo.UserRepository;
import in.strollup.service.pojo.AuthContext;

@Component
public class ContextBuilder extends DefaultGraphQLContextBuilder {
	@Autowired
	private UserRepository userRepository;

	@Override
	public GraphQLContext build(Optional<HttpServletRequest> request, Optional<HttpServletResponse> response) {
		User user = request.map(req -> req.getHeader("Authorization")).filter(id -> !id.isEmpty())
				.map(id -> id.replace("Bearer ", "")).map(userRepository::findOne).orElse(null);
		return new AuthContext(user, request, response);
	}
}
