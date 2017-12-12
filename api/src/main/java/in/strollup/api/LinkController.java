package in.strollup.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.strollup.entity.mongo.Link;
import in.strollup.service.graphql.LinkQuery;

@RestController
@RequestMapping("api/rest/link")
public class LinkController {

	@Autowired
	private LinkQuery query;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public List<Link> get() {
		return query.getAllLinks();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public Link get(@PathVariable("id") String id) {
		return query.getLinkById(id);
	}

}
