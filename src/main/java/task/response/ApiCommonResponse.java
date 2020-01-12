package task.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import task.constants.Constants;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiCommonResponse implements Constants {
	int code = CODE_SUCCESS;
	String error;
}
