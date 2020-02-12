package come.home.domain.task.domain;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import come.home.global.converter.TaskStatusConverter;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	private String title;
	private String content;
	
	@Convert(converter = TaskStatusConverter.class)
	private TaskStatus status;
	
	@Builder
	public Task(long seq, String title, String content, TaskStatus status) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.status = status;
	}
}
