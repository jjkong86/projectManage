package task.response;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import task.model.Project;
import task.util.ProjectState;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProjectDetailResponse extends ApiCommonResponse {

	Result result;
	
	public ProjectDetailResponse(Project result) {
	}
	
	@Data
	public class Result {
		private String title;
		private String description;
		private int targetFigure;
		private int supportCount;
		private int supportAmount;
		private ProjectState state;
		private LocalDateTime startDate;
		private LocalDateTime endDate;
		
		public Result(Project project) {
			this.title = project.getTitle();
			this.description = project.getDescription();
			this.targetFigure = project.getTargetFigure();
			this.supportCount = project.getSupportCount();
			this.supportAmount = project.getSupportAmount();
			this.state = project.getState();
			this.startDate = project.getStartDate();
			this.endDate = project.getEndDate();
		}
	}

}
