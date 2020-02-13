package come.home.domain.task.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import come.home.domain.task.domain.Task;
import come.home.domain.task.domain.TaskStatus;

@SpringBootTest
public class TaskServiceTest {
	@Autowired
	private TaskService s;
	
	@Test
	public void 할일_저장_수정_조회_테스트() {
		//given
		Task task = Task.builder().title("title").content("content").status(TaskStatus.READY).build();
		task = s.saveTask(task);
		
		//when
		task.setTitle("title2");
		task.setStatus(TaskStatus.DONE);
		s.modifyTask(task);
		
		//then
		Task result = s.getTask(task.getSeq()).orElseThrow();
		
		assertThat(result.getTitle()).isEqualTo("title2");
		assertThat(result.getStatus()).isEqualTo(TaskStatus.DONE);
	}
	
	@Test
	public void 할일_삭제_테스트() {
		//given
		Task task = Task.builder().title("title").content("content").status(TaskStatus.READY).build();
		task = s.saveTask(task);
		
		s.deleteTask(task);
		
		assertThat(s.getTask(task.getSeq()).isEmpty()).isTrue();
	}
}
