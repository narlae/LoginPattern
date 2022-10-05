package narlae.LoginPattern.web.member.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class MemberSaveForm {
    @NotNull
    private String member_email;
    @NotNull
    private String member_nm;
    private Integer member_telno;
    private String member_pwd;
    private Date member_subs_dt;
    private Date member_birth;
    private boolean member_ad_ag;
    private boolean member_id_ag;
}
