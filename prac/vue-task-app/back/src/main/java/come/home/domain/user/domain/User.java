package come.home.domain.user.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import come.home.domain.user.dto.UserResDto;
import come.home.global.domain.BasicEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class User extends BasicEntity{
	@Id
	private String userId;
	private String userName;
	private String userPassword;
	
	@Builder
	public User(String userId, String userName, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
	}
	
	public UserResDto toDto() {
		return UserResDto
				.builder()
					.userId(this.userId)
					.userName(this.userName)
					.userPassword(this.userPassword)
					.build();
	}
}
