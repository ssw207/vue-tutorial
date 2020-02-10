package come.home.domain.user.dto;

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
public class UserResDto {
	
	private String userId;
	private String userName;
	private String userPassword;
	
	@Builder
	public UserResDto(String userId, String userName, String userPassword) {
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
	}
}

