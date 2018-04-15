package in.strollup.service.pojo;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import graphql.servlet.GraphQLContext;
import in.strollup.entity.mongo.User;
import lombok.Getter;

@Getter
public class AuthContext extends GraphQLContext {

	private User user;

	public AuthContext(User user, Optional<HttpServletRequest> request, Optional<HttpServletResponse> response) {
		super(request, response);
		this.user = user;
	}
}
