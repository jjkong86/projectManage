package task.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import task.model.Project;
import task.repositories.UserRepository;
import task.request.ProjectsRequest;
import task.response.ProjectDetailResponse;
import task.response.ProjectListResponse;
import task.service.ProjectService;

@RestController
@AllArgsConstructor
public class ProjectController {

	ProjectService projectService;

	UserRepository userRepository;

	@GetMapping(value = "/")
	public String test() {
		projectService.testData();
		return "hello world!!";
	}

	@PostMapping(value = "/projects")
	public List<ProjectListResponse> getProjectsAndOrdered(@RequestBody ProjectsRequest param) {
//		if (result.hasErrors()) {
//			String message = result.getFieldError().getDefaultMessage();
//		}
		if (param.getSize() < 1) {
			param.setSize(10);
		}

		List<ProjectListResponse> res = projectService.getProjectsAndOrdered(param);
		return res;
	}

	@GetMapping(value = "/projects/{projectId}")
	public ProjectDetailResponse getProjectDetail(@PathVariable UUID projectid, BindingResult result) {
		return projectService.getProjectDetail(projectid);
	}

	@PostMapping(value = "/projects/{projectId}")
	public void registerProject(@RequestBody Project project, BindingResult result) {
		
	}

	@PutMapping(value = "/projects/{projectId}")
	public void updateProject(@PathVariable int projectid, @Valid @RequestBody Project project, BindingResult result) {
		projectService.registerProject(project);
	}

	@PostMapping(value = "/supports/{projectId}")
	public void registerSupportor(@PathVariable int projectid, BindingResult result) {

	}

	@PostMapping(value = "/testData")
	public void testData() {
		projectService.testData();
	}
}
