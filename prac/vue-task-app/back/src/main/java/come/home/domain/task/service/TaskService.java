package come.home.domain.task.service;

import java.util.List;
import java.util.Optional;

import come.home.domain.task.domain.Task;

public interface TaskService {
	
	public Task saveTask(Task task);
	public List<Task> listTask();
	public Optional<Task> getTask(Task task);
	public Task modifyTask(Task task);
}
