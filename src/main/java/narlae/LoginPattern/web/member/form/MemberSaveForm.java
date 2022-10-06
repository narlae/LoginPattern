package narlae.LoginPattern.web.member.form;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Data
public class MemberSaveForm {
    @NotNull
    private String member_email;
    @NotNull
    private String member_nm;
    private Integer member_telno;
    private String member_pwd;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate member_subs_dt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate member_birth;
    private boolean member_ad_ag;
    private boolean member_id_ag;
}
