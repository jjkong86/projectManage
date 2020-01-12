package task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.UUID;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import task.util.OrderedType;
import task.util.ProjectState;

public class Test {
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		ProjectState[] p = ProjectState.values();
		System.out.println(Arrays.toString(p));
		ProjectState p1 = ProjectState.FAIL;
		System.out.println(p1.getType());
		
		UUID id = UUID.randomUUID();
		System.out.println(id.toString());
		LocalDateTime time = LocalDateTime.now();
//		time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		System.out.println(time.toString());
		LocalDateTime time1 = LocalDateTime.now();
//		time1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		time1.plusDays(7);
		
		LocalDateTime localDateTime = LocalDateTime.now(); //  2018-03-18T20:00:00
		 
		localDateTime.plusDays(1); //  2018-03-19T20:00:00
		localDateTime.minusDays(1); //  2018-03-17T20:00:00
		
		
		OrderedType o = OrderedType.STARTDATE;
		System.out.println(o.name());
		
	}
}
