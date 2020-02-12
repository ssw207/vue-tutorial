package come.home.domain.task.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import come.home.domain.task.domain.Task;
import come.home.domain.task.domain.TaskStatus;

@SpringBootTest
public class TaskRepositoryTest {
	@Autowired
	TaskRepository r;
	
	private Task taskEntity = null; 
	
	@BeforeEach
	public void init() {
		taskEntity = Task.builder()
				.status(TaskStatus.READY)
				.title("title")
				.content("content")
				.build();
	}
	
//	@AfterEach
//	public void destroy() {
//		r.deleteAll();
//	}
	
	@Test
	public void 할일입력() {
		Task task = r.save(taskEntity);
		assertThat(task.getTitle()).isEqualTo("title");
	}
	@Test
	public void 할일모두조회() {
		//given
		r.save(taskEntity);
		
		//when
		List<Task> listTask = r.findAll();
		
		//then
		assertThat(listTask.size()).isEqualTo(1);
	}
	
	@Test
	public void 할일단건조회() {
		//given
		Task reqTask = r.save(taskEntity);
		
		Task resTask = r.findById(reqTask.getSeq()).orElseThrow();
		
		assertThat(resTask.getTitle()).isEqualTo("title");
	}
}
