package ifellow.dto;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    public String name;
    public String job;
    public String id;
    public Date createdAt;
}
