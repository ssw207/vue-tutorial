package come.home.domain.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import come.home.domain.user.domain.User;

public interface UserRepository extends JpaRepository<User, String>{

}
