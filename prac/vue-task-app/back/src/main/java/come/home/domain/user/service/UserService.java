package come.home.domain.user.service;

import come.home.domain.user.dto.UserReqDto;
import come.home.domain.user.dto.UserResDto;

public interface UserService {

	//회원가입
	public UserResDto singUpUser(UserReqDto userReqDto);
	//로그입
	public UserResDto login(UserReqDto userReqDto) ;
}
