package come.home.global.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import come.home.domain.task.domain.TaskStatus;
import come.home.domain.task.exception.TaskServiceException;
import come.home.global.util.StringUtil;

@Converter
public class TaskStatusConverter implements AttributeConverter<TaskStatus, String>{

	@Override
	public String convertToDatabaseColumn(TaskStatus attribute) {
		if (attribute == null) return "";
		return attribute.getCode();
	}

	@Override
	public TaskStatus convertToEntityAttribute(String dbData) {
		return TaskStatus.ofCode(dbData);
	}
	
}
