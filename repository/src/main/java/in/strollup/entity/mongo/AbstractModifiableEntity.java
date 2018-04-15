package in.strollup.entity.mongo;

import java.time.ZonedDateTime;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractModifiableEntity extends AbstractIdEntity {

	@Field
	private ZonedDateTime updatedAt;

	@PreUpdate
	@PrePersist
	protected void onUpdate() {
		this.updatedAt = ZonedDateTime.now();
	}

}
