package task.util;

import lombok.Getter;

@Getter
public enum OrderedType {
	STARTDATE("startDate"), ENDDATE("endDate"), TARGETFIGURE("targetFigure"), SUPPORTAMOUNT("supportAmount");
	private String type;
	OrderedType(String type) {
		this.type = type;
	}
}
