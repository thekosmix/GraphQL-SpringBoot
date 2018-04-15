package in.strollup.entity.mongo;

import java.time.ZonedDateTime;

import javax.persistence.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@Document(collection = "vote")
@NoArgsConstructor
public class Vote extends AbstractModifiableEntity {
	private String userId;
	private String linkId;

	public Vote(ZonedDateTime createdAt, String userId, String linkId) {
		this(null, createdAt, userId, linkId);
	}

	public Vote(String id, ZonedDateTime createdAt, String userId, String linkId) {
		super.setId(id);
		super.setCreatedAt(createdAt);
		this.userId = userId;
		this.linkId = linkId;
	}
}
