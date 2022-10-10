package narlae.LoginPattern.web.login;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LoginForm {

    @NotEmpty
    private String member_email;
    @NotEmpty
    private String member_pwd;

    private boolean rememberId;

}
