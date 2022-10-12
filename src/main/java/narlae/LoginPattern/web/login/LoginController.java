package narlae.LoginPattern.web.login;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import narlae.LoginPattern.domain.login.LoginService;
import narlae.LoginPattern.domain.member.Member;
import narlae.LoginPattern.web.SessionConst;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    private void addCookie(LoginForm form, HttpServletResponse response, boolean isRememberId) {
        Cookie cookie;
        if(isRememberId) {
            cookie = new Cookie(SessionConst.REMEMBER_ID, form.getMember_email());
        }else{
            cookie = new Cookie(SessionConst.REMEMBER_ID, null);
            cookie.setMaxAge(0);
        }
        response.addCookie(cookie);
    }

    @GetMapping("/login") //required=true 때 값이 없으면 예외 발생
    public String loginForm(@CookieValue(name="rememberId", required = false) String rememberedId ,Model model,
                            HttpServletRequest request) {

        LoginForm form = new LoginForm();
        if(rememberedId!=null)
            form.setMember_email(rememberedId);

        model.addAttribute("loginForm", form);
        return "/login/loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult,
                        @RequestParam(defaultValue = "/") String redirectURL,
                        HttpServletRequest request, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            return "/login/loginForm";
        }

        Member loginMember = loginService.login(form.getMember_email(), form.getMember_pwd());
        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "/login/loginForm";
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        boolean isRememberId = form.isRememberId();
        addCookie(form, response, isRememberId);
        return "redirect:" + redirectURL;
    }



    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
