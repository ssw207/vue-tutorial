package come.home.domain.user.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import come.home.domain.user.domain.User;
import come.home.domain.user.dto.UserReqDto;

/*
 * Boot 2.2.4.RELEASE 버전에서 Junit 5사용
 * @Runwith, @SpringBootTest 어노테이션 없이 @Test만으로 테스트 가능하다.
 */
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
//	private User userEntity = null;
//	
//	@BeforeEach  // junit4 @Before
//	public void before() {
//	UserReqDto dto = UserReqDto.builder().userId("id").userName("name").userPassword("1234").build();
//	userEntity = dto.toEntity();
//	}
	
	@Test
	public void 회원정보_테스트() {
		UserReqDto dto = UserReqDto.builder().userId("id").userName("name").userPassword("1234").build();
		User userEntity = dto.toEntity();
		System.out.println(userEntity.toString());
		
		User user = userRepository.save(userEntity);
		assertThat(user.getUserId()).isEqualTo("id");
	}
}
