package come.home.global.domain;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Getter
@MappedSuperclass // 엔티티가 아닌 클래스를 상속받기 위해 사용
@EntityListeners(AuditingEntityListener.class)
public abstract class BasicEntity { // 단독으로 사용되는것을 방지하기위해 abstract 선언
	
	@CreatedDate
	private Date dtFrt;
	
	@LastModifiedDate
	private Date dtLst;

}
