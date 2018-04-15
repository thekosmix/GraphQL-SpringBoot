package in.strollup.entity.mongo;

import javax.persistence.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@Document(collection = "link")
@NoArgsConstructor
public class Link extends AbstractModifiableEntity {

	private String url;
	private String description;
	private String userId;

	public Link(String url, String description, String userId) {
		this(null, url, description, userId);
	}

	public Link(String id, String url, String description, String userId) {
		super.setId(id);
		this.url = url;
		this.description = description;
		this.userId = userId;
	}
}
