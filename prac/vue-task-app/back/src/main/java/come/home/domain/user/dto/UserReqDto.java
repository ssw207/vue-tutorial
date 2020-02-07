package come.home.domain.user.dto;

import come.home.domain.user.domain.User;
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
public class UserReqDto {
	
	private String userId;
	private String userName;
	private String userPassword;
	
	@Builder
	public UserReqDto(String userId, String userName, String userPassword) {
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public User toEntity() {
		return User.builder()
				.userId(this.userId)
				.userName(this.userName)
				.userPassword(this.userPassword)
				.build();
	}
}
