package narlae.LoginPattern.web.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import narlae.LoginPattern.domain.ResponseDto;
import narlae.LoginPattern.domain.member.Member;
import narlae.LoginPattern.domain.member.MemberService;
import narlae.LoginPattern.web.member.form.MemberSaveForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    
//    @PostMapping("/findAll")
//    @ResponseBody
//    public ResponseEntity<?> findAll() {
//        ResponseDto responseDto = new ResponseDto();
//        responseDto.setResultCode("S0001");
//        responseDto.setRes(memberService.findAll());
//
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }


    @GetMapping("/list")
    public String findAll(Model model) {
        ArrayList<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        return "members/MemberList";
    }

    @GetMapping("/add")
    public String addForm() {
        return "members/addMemberForm";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("member") MemberSaveForm form, BindingResult bindingResult) {
        log.info("member={}", form);

        if (bindingResult.hasErrors()) {
            log.info("errors= {}", bindingResult);
            return "members/addMemberForm";
        }

//        memberService.regMember(member);


        return "home";
    }
}
