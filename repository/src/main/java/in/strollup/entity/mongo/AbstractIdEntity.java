package in.strollup.entity.mongo;

import java.time.ZonedDateTime;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractIdEntity {

	@Id
	private String id;

	@Field
	private ZonedDateTime createdAt;

	@PrePersist
	protected void onCreate() {
		this.createdAt = ZonedDateTime.now();
	}
}
