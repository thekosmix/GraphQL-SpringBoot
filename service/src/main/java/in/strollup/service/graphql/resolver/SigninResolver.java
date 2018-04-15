package in.strollup.service.graphql.resolver;

import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLResolver;

import in.strollup.entity.mongo.User;
import in.strollup.service.pojo.SigninPayload;

@Service
public class SigninResolver implements GraphQLResolver<SigninPayload> {

	public User user(SigninPayload payload) {
		return payload.getUser();
	}
}