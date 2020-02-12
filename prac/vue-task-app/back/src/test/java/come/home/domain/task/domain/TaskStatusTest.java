package come.home.domain.task.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class TaskStatusTest {

	@Test
	public void 조회테스트() {
		String title = TaskStatus.READY.getTitle();
		String code = TaskStatus.READY.getCode();
		log.debug("{}sss",code);
		assertThat(code).isEqualTo("10");
		assertThat(title).isEqualTo("예정");
	}
	
	@Test
	public void 디비컬럼_이넘_변환_테스트() {
		TaskStatus taskEnum = TaskStatus.ofCode("10");
		assertThat(taskEnum.getTitle()).isEqualTo("예정");
	}
}
