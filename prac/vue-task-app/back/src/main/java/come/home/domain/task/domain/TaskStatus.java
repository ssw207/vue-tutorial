package come.home.domain.task.domain;

import java.util.Arrays;

import come.home.domain.task.exception.TaskServiceException;
import lombok.Getter;

@Getter
public enum TaskStatus {
	READY("예정", "10"),
	DOING("진행중", "20"),
	DONE("완료", "30");
	
	private String title;
	private String code;
	private TaskStatus(String title, String code) {
		this.title = title;
		this.code = code;
	}
	
	public static TaskStatus ofCode(String code) {
		return Arrays.stream(TaskStatus.values()) 
				.filter(v -> v.getCode().equals(code))
				.findAny()
				.orElseThrow(() -> new TaskServiceException(String.format("상태코드에 code=[%s]가 존재하지 않습니다", code)));
	}
}
