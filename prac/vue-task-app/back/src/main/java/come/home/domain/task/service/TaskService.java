package come.home.domain.task.service;

import java.util.List;
import java.util.Optional;

import come.home.domain.task.domain.Task;

public interface TaskService {
	
	public Task saveTask(Task task);
	public List<Task> listTask();
	public Task modifyTask(Task task);
	public Optional<Task> getTask(Long seq);
	public void deleteTask(Task task);
}

