package national.exam.practice.dto;

import lombok.Builder;
import lombok.Getter;
import national.exam.practice.entity.Role;

@Getter
@Builder
public class UserResponse {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private Role role;
}
