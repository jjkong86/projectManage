package task.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import task.util.ProjectState;

@Entity
@Getter
@Table(name = "PROJECT")
@NoArgsConstructor
@ToString
public class Project {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;
	private String title;
	private String description;
	@Max(value = 100000000, message = "targetFigure max value is 100000000")
	private int targetFigure;
	@Max(value = 100000, message = "supportCount max value is 100000")
	private int supportCount;
	@Max(value = 100000000, message = "supportAmount max value is 100000000")
	private int supportAmount;

	@Enumerated(EnumType.STRING)
	private ProjectState state;

	@Column(columnDefinition = "boolean default true")
	private boolean isOpen;

	private UUID creatorId;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime endDate;

	@Builder
	public Project(UUID id, String title, String description, int targetFigure, int supportCount, int supportAmount,
			ProjectState state, boolean isOpen, UUID creatorId, LocalDateTime startDate, LocalDateTime endDate) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.targetFigure = targetFigure;
		this.supportCount = supportCount;
		this.supportAmount = supportAmount;
		this.state = state;
		this.isOpen = isOpen;
		this.creatorId = creatorId;
		this.startDate = startDate;
		this.endDate = endDate;
	}
}
