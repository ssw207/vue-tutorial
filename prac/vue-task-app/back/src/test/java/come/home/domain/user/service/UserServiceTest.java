package come.home.domain.user.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import come.home.domain.user.dto.UserReqDto;
import come.home.domain.user.dto.UserResDto;

@SpringBootTest
public class UserServiceTest {
	@Autowired
	private UserService userService;
	
	private UserReqDto userReqDto;
	
	@BeforeEach
	public void 초기세팅() {
	userReqDto = UserReqDto.builder().userId("id").userPassword("pw").userName("name").build();
	}
	
	@Test
	public void 회원가입() {
		UserResDto userResDto = userService.singUpUser(userReqDto);
		assertThat(userResDto.getUserId()).isEqualTo("id");
	}
	
	@Test
	public void 로그인() throws Exception {
		//given
		UserResDto userResDto = userService.singUpUser(userReqDto);
		
		UserResDto dto = userService.login(userReqDto);
		assertThat(dto != null).isTrue();
	}	
}
