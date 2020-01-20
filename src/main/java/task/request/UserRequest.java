package task.request;

import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
public class UserRequest {
	private UUID id;
	private String name;
	private String email;
	private String telNo;
	
	public UserRequest(String name, String email, String telNo) {
		this.name = name;
		this.email = email;
		this.telNo = telNo;
	}
	
	public UserRequest(UUID id, String name, String email, String telNo) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.telNo = telNo;
	}
}
