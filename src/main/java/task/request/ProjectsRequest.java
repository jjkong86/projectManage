package task.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;
import task.util.OrderedType;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectsRequest {
    private int pageno;
    private int size = 10;
    @Enumerated(EnumType.STRING)
    private OrderedType type;
}
