package come.home.domain.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import come.home.domain.user.dto.UserReqDto;
import come.home.domain.user.dto.UserResDto;
import come.home.domain.user.service.UserService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {
	private UserService s;
	
	@PostMapping("/user/save")
	public UserResDto save(@RequestBody UserReqDto userReqDto) {
		return s.saveUser(userReqDto);
	}
	
	@PostMapping("/user/login")
	public UserResDto login(@RequestBody UserReqDto userReqDto) throws Exception {
		return s.login(userReqDto);
	}
}
