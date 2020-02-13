package come.home.domain.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import come.home.domain.task.dao.TaskRepository;
import come.home.domain.task.domain.Task;
import come.home.domain.task.exception.TaskServiceException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
	private TaskRepository r;
	
	@Override
	public Task saveTask(Task task) {
		return r.save(task);
	}

	@Override
	public List<Task> listTask() {
		return r.findAll();
	}

	@Override
	public Optional<Task> getTask(Long seq) {
		return r.findById(seq);
	}

	@Override
	public void deleteTask(Task task) {
		r.delete(task);
	}

	@Override
	public Task modifyTask(Task task) {
		Task resTask = r.findById(task.getSeq()).orElseThrow(()-> new TaskServiceException(String.format("수정할 할일이 없습니다.[%s]", task)));
		resTask.setContent(task.getContent());
		resTask.setTitle(task.getTitle());
		resTask.setStatus(task.getStatus());
		return r.save(resTask);
	}
}