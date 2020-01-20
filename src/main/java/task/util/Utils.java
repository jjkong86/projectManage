package task.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
	public static LocalDateTime getTime(int time) {
		LocalDateTime date = LocalDateTime.now().plusDays(time);
		date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		return date;
	}

}
