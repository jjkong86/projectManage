package task.util;

import lombok.Getter;

@Getter
public enum ProjectState {
	PREPARED(0), INPROGRESS(1), SUCCESS(2), FAIL(3);

	int type;

	ProjectState(int type) {
		this.type = type;
	}
}
