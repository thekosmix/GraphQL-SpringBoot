package in.strollup.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.strollup.entity.mongo.User;
import in.strollup.service.graphql.LinkQuery;

@RestController
@RequestMapping("api/rest/user")
public class UserController {

	@Autowired
	private LinkQuery query;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public List<User> get() {
		return query.getAllUsers();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public User get(@PathVariable("id") String id) {
		return query.getUserById(id);
	}

}
