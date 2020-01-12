package task;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import task.model.Project;
import task.model.Supporter;
import task.model.User;
import task.repositories.ProjectRepository;
import task.repositories.UserRepository;
import task.util.ProjectState;
import task.util.Utils;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProjectManageApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProjectRepository projectRepository;

	List<User> users;
	List<Project> projects;
	List<Supporter> supporters;

	@Before
	public void setup() {

		users = new ArrayList<>(Arrays.asList(new User[] { new User("정재공", "jjkong86@naver.com", "01049239954"),
				new User("hello", "hello@naver.com", "01012345678") }));
		projects = new ArrayList<>(Arrays.asList(new Project[] {
				Project.builder().title("투자").description("많은 투자 부탁드려요").targetFigure(100000000).supportCount(100000)
						.supportAmount(50000000).state(ProjectState.INPROGRESS).creatorId(users.get(0).getId())
						.isOpen(true).startDate(Utils.getTime(0)).endDate(Utils.getTime(7)).build(),
				Project.builder().title("투자1").description("많은 투자 부탁드려요1").targetFigure(1000000).supportCount(1000)
						.supportAmount(500000).state(ProjectState.INPROGRESS).creatorId(users.get(0).getId())
						.isOpen(true).startDate(Utils.getTime(0)).endDate(Utils.getTime(7)).build(),
				Project.builder().title("투자1").description("많은 투자 부탁드려요1").targetFigure(1000000).supportCount(1000)
						.supportAmount(500000).state(ProjectState.INPROGRESS).creatorId(users.get(0).getId())
						.isOpen(false).startDate(Utils.getTime(0)).endDate(Utils.getTime(7)).build() }));
	}

	@Test
	public void 유저생성() {
		List<User> results = new ArrayList<>();
		users.stream().forEach(user -> results.add(userRepository.save(user)));

		List<User> getUsers = new ArrayList<>();
		results.stream().forEach(user -> getUsers.add(userRepository.findById(user.getId()).get()));

		// insert user id와 get user id 비교
		results.stream().forEach(user -> assertThat(user.getId(), is(findByUserId(getUsers, user.getId()))));
	}

	@Test
	public void 프로젝트생성() {
		List<Project> results = new ArrayList<>();
		projects.stream().forEach(project -> results.add(projectRepository.save(project)));

		List<Project> getProject = new ArrayList<>();
		results.stream().forEach(project -> getProject.add(projectRepository.findById(project.getId()).get()));

		// insert project id와 get project id 비교
		projects.stream()
				.forEach(project -> assertThat(project.getId(), is(findByProjectId(getProject, project.getId()))));
	}

	private UUID findByUserId(List<User> list, UUID id) {
		return list.stream().filter(user -> user.getId().equals(id)).findFirst().get().getId();
	}

	private UUID findByProjectId(List<Project> list, UUID id) {
		return list.stream().filter(user -> user.getId().equals(id)).findFirst().get().getId();
	}
}
