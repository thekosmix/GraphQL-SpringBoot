package in.strollup.service.pojo;

import in.strollup.entity.mongo.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SigninPayload {
	private String token;
	private User user;
}
