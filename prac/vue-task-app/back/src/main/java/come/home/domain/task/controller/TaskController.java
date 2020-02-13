package come.home.domain.task.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import come.home.domain.task.domain.Task;
import come.home.domain.task.dto.TaskReqDto;
import come.home.domain.task.exception.TaskServiceException;
import come.home.domain.task.service.TaskService;

@RestController
public class TaskController {
	private TaskService s;
	//할일목록 조회
	@GetMapping("/task")
	public List<Task> listTask() {
		return s.listTask();
	}
	//할일조회
	@GetMapping("/task/{seq}")
	public Task getTask(@PathVariable Long seq) {
		return s.getTask(seq).orElseThrow(()-> new TaskServiceException(String.format("할일 조회에 실패했습니다. [%s]", seq)));
	}
	//할일수정
	@PutMapping("/task")
	public Task updateTask(@RequestBody TaskReqDto taskReqDto) {
		return s.modifyTask(taskReqDto.toEntity());
	}
	//할일저장
	@PostMapping("/task")
	public Task saveTask(@RequestBody TaskReqDto taskReqDto) {
		return s.saveTask(taskReqDto.toEntity());
	}
	//할일삭제
	@DeleteMapping("/task")
	public void deleteTask(@RequestBody TaskReqDto taskReqDto) {
		s.deleteTask(taskReqDto.toEntity());
	}
}
