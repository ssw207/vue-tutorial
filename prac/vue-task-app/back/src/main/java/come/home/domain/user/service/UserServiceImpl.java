package come.home.domain.user.service;

import org.springframework.stereotype.Service;

import come.home.domain.user.dao.UserRepository;
import come.home.domain.user.domain.User;
import come.home.domain.user.dto.UserReqDto;
import come.home.domain.user.dto.UserResDto;
import come.home.domain.user.exception.UserException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	private UserRepository userRepository;
	
	@Override
	public UserResDto singUpUser(UserReqDto userReqDto) {
		if(userReqDto == null) return null;
		
		User user = userRepository.save(userReqDto.toEntity());
		return user.toDto();
	}

	@Override
	public UserResDto login(UserReqDto userReqDto) {
		if(userReqDto == null) return null;
		
		User user = userRepository.findById(userReqDto.getUserId()).orElseThrow(() -> new UserException("유저정보가 없습니다"));
		return user.toDto();
	}

}
