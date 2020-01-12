package task.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.annotations.GenericGenerator;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Table(name = "USER")
@ToString
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;
	private String name;
	@Email
	private String email;
	private String telNo;
	
	public User(String name, String email, String telNo) {
		this.name = name;
		this.email = email;
		this.telNo = telNo;
	}
	
	@Builder
	public User(UUID id, String name, String email, String telNo) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.telNo = telNo;
	}
}
