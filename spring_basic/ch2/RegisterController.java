package com.fastcampus.ch3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.beans.Encoder;
import java.net.URLEncoder;
import java.util.Base64;

@Controller
//@RequestMapping(value="/register", method={RequestMethod.POST, RequestMethod.GET})
@RequestMapping("/register")    // 위와 같은 코드
public class RegisterController {

    // 방법(1)
//    @PostMapping("/save")
//    public String save(User user, Model model) throws Exception {
//        // 1. 유효성 검사
//        if (!isValid(user)) {
//            String msg = URLEncoder.encode("id 또는 pwd가 유효하지 않습니다.", "utf-8");
//            return "redirect:/register/add?msg=" + msg;
//        }
//
//        // 2. DB에 신규회원 정보를 저장
//        return "registerInfo";
//    }

    // 방법(2)
    @PostMapping("/save")
    public String save(User user, Model model) throws Exception {
        // 1. 유효성 검사
        if (!isValid(user)) {
            String msg = URLEncoder.encode("id 또는 pwd가 유효하지 않습니다.", "utf-8");
            model.addAttribute("msg", msg);
            return "redirect:/register/add";

            // - "redirect"는 다시 요청하라는 의미.
            // - 여기서 'model'은 "/register/save" 요청을 통해 'registerInfo.jsp'에 전달하기 위한 것.
            // - 'model'은 "/register/add" 요청을 수행할 수 없음.
            // - 그래서 스프링이 자동으로 '방법(1)'의 코드로 바꿔줌.
        }

        // 2. DB에 신규회원 정보를 저장
        return "registerInfo";
    }


    // 유효성 검사 메서드
    private boolean isValid(User user) {
        return true;
    }
}
