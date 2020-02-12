package come.home.domain.task.dto;

import come.home.domain.task.domain.Task;
import come.home.domain.task.domain.TaskStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * @Controller에서 @RequestBody로 외부에서 데이터를 받는경우 
 * 기본생성자 + set메소드롤 통해서만 값이 할당
 */
@Setter  
@Getter
@NoArgsConstructor
@ToString
public class TaskResDto {
	
	private Long seq;
	private String title;
	private String content;
	private TaskStatus status;
	
	@Builder
	public TaskResDto(Long seq, String title, String content, TaskStatus status) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.status = status;
	}
	
	public Task toEntity(Long seq, String title, String content, TaskStatus status) {
		return Task
				.builder()
					.seq(seq)
					.title(title)
					.content(content)
					.status(status)
					.build();
	}
}

