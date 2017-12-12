package in.strollup.entity.mongo;

import javax.persistence.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@Document(collection = "user")
@NoArgsConstructor
public class User extends AbstractModifiableEntity {

	private String name;
	private String email;
	private String password;

	public User(String name, String email, String password) {
		this(null, name, email, password);
	}

	public User(String id, String name, String email, String password) {
		super.setId(id);
		this.name = name;
		this.email = email;
		this.password = password;
	}
}
