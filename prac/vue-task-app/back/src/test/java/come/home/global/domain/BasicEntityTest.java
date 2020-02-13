package come.home.global.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import come.home.domain.task.dao.TaskRepository;
import come.home.domain.task.domain.Task;
import come.home.domain.task.domain.TaskStatus;
import come.home.domain.task.service.TaskService;

@SpringBootTest
public class BasicEntityTest {
	@Autowired
	TaskService s;
	
	@Autowired
	TaskRepository r;
	
	@AfterEach
	public void destory() {
		r.deleteAll();
	}
	
	@Test
	public void 생성일_자동저장_테스트() {
		Task task = Task.builder().title("title").content("content").status(TaskStatus.DONE).build();
		Task resTask = s.saveTask(task);
		
		assertThat(resTask.getDtFrt()).isNotNull();
	}
	
	@Test
	public void 수정일_자동저장_테스트() throws Exception {
		Task reqTask = Task.builder().title("title").content("content").status(TaskStatus.DONE).build();
		Task savedTask = s.saveTask(reqTask);
		
		reqTask = s.getTask(savedTask.getSeq()).orElseThrow(() -> new Exception("Task조회에 실패"));
		reqTask.setContent("title2");
		Task resultTask = s.saveTask(reqTask);
		
		assertThat(resultTask.getDtLst()).isNotNull();
	}
}
