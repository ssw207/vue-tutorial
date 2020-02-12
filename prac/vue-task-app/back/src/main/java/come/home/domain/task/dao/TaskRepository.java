package come.home.domain.task.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import come.home.domain.task.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
