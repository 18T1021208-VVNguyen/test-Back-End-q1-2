package org.example.question_1_2.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class SignupRequest {

    @NotBlank
    private  String username;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotEmpty
    private Set<String> strRoles;
}
