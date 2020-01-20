package task.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import task.model.Project;
import task.model.User;
import task.repositories.ProjectRepository;
import task.repositories.SupporterRepository;
import task.repositories.UserRepository;
import task.request.ProjectsRequest;
import task.response.ProjectDetailResponse;
import task.response.ProjectListResponse;
import task.util.ProjectState;
import task.util.Utils;

@Service
@AllArgsConstructor
public class ProjectService {

	UserRepository userRepository;

	ProjectRepository projectRepository;

	SupporterRepository supporterRepository;

//	ProjectService(UserRepository userRepository, ProjectRepository projectRepository, SupporterRepository supporterRepository) {
//		this.userRepository = userRepository;
//		this.projectRepository = projectRepository;
//		this.supporterRepository = supporterRepository;
//	}

	public List<ProjectListResponse> getProjectsAndOrdered(ProjectsRequest param) {
		PageRequest pr = PageRequest.of(param.getPageno(), param.getSize(), Sort.Direction.DESC,
				param.getType().getType());
		Page<Project> result = projectRepository.findByIsOpenTrue(pr);
		List<ProjectListResponse> list = new ArrayList<>();
		for (Project project : result) {
			ProjectListResponse temp = new ProjectListResponse(project);
			list.add(temp);
		}
		return list;

	}

	public ProjectDetailResponse getProjectDetail(UUID id) {
		Project result = projectRepository.findById(id).get();
		return new ProjectDetailResponse(result);
	}

	public void registerProject(Project project) {
		projectRepository.save(project);
	}

	public void updateProject() {
		// TODO Auto-generated method stub

	}

	public void registerSupporter() {
		// TODO Auto-generated method stub

	}

	public void testData() {

		List<User> users = new ArrayList<>(
				Arrays.asList(new User[] { new User("정재공", "jjkong86@naver.com", "01049239954"),
						new User("hello", "hello@naver.com", "01012345678") }));
		List<Project> projects = new ArrayList<>(Arrays.asList(new Project[] {
				Project.builder().title("투자").description("많은 투자 부탁드려요").targetFigure(100000000).supportCount(100000)
						.supportAmount(50000000).state(ProjectState.INPROGRESS).creatorId(users.get(0).getId())
						.isOpen(true).startDate(Utils.getTime(0)).endDate(Utils.getTime(7)).build(),
				Project.builder().title("투자1").description("많은 투자 부탁드려요1").targetFigure(1000000).supportCount(1000)
						.supportAmount(500000).state(ProjectState.INPROGRESS).creatorId(users.get(0).getId())
						.isOpen(true).startDate(Utils.getTime(0)).endDate(Utils.getTime(7)).build(),
				Project.builder().title("투자1").description("많은 투자 부탁드려요1").targetFigure(1000000).supportCount(1000)
						.supportAmount(500000).state(ProjectState.INPROGRESS).creatorId(users.get(0).getId())
						.isOpen(false).startDate(Utils.getTime(0)).endDate(Utils.getTime(7)).build() }));

		for (User user : users) {
			userRepository.save(user);
		}

		for (Project project : projects) {
			projectRepository.save(project);
		}
	}
}
