package task.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Getter;

@Entity
@Getter
@Table(name = "CREATOR")
public class Creator {
	@Id
//	@GeneratedValue(generator = "uuid2")
//	@GenericGenerator(name = "uuid2", strategy = "uuid2")
//	@Column(columnDefinition = "BINARY(16)")
	private String id;

	private String projectId;
	private String userId;
}
