package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(String id, String pwd, boolean rememberId, HttpServletResponse response) throws Exception {
        // 1. id, pwd 체크
        if (!loginCheck(id, pwd)) {
            // 2-1. id, pwd 불일치시 loginForm 이동 및 오류 메세지 출력
            String msg = URLEncoder.encode( "id 또는 pwd가 틀렸소!", "utf-8");
            return "redirect:/login/login?msg=" + msg;
        }

        // 3-1. rememberId에 체크되어 있으면 쿠키 생성 및 응답 헤더에 담기
        Cookie cookie = new Cookie("id", id);

        // 3-2. rememberId에 체크되어 있지 않으면 쿠키 삭제
        if (!rememberId) {
            cookie.setMaxAge(0);    // 혹시 있을지도 모르는 쿠키를 삭제.
        }
            response.addCookie(cookie);


        // 2-2. id, pwd 일치시 home 이동
        return "index";
    }

    private boolean loginCheck(String id, String pwd) {
        return "asdf".equals(id) && "1234".equals(pwd);
    }

}

/*
- 쿠키(Cookie)란?
- 이름(name)과 값(value)의 쌍으로 구성된 작은 정보. 아스키 문자만 가능(한글은 URL 인코딩 해야 함).
- 그 외에도 Domain 정보, path 정보, 유효기간 등이 담겨있음.
- 서버에서 생성 후 전송, 브라우저에 저장. 유효기간 이후 자동 삭제.
- 서버에 요청시 domain, (그 하위 경로까지 포함하여)path 정보가 일치하는 경우에만 자동 전송.
    >> 쿠키는 여러개 있을 수 있는데 임의의 사이트에 방문하면 쿠키 중에서 domain, path 정보가 일치하는 것은 자동으로 전송됨.
- 쿠키는 브라우저에 저장되기 때문에 클라이언트가 쿠키를 삭제할 수도 있고 서버에서 발급하는 쿠키를 거부할 수도 있음.
- 쿠키는 클라이언트를 식별하는 기술.

- 쿠키의 작동 과정
- 1. 클라이언트가 서버에 요청을 보냄.
- 2. 서버에서 쿠키를 만드는 코드를 수행해서 쿠키가 만들어지고 그 쿠키를 응답 헤더에 담아서 클라이언트에게 보냄.
- 3. 그렇게 클라이언트에게 전달된 쿠키는 브라우저에 저장됨.
- 4. 다시 클라이언트가 서버에 요청을 할 때 domain, path 정보가 일치하면 자동으로 그에 맞는 쿠키가 요청 헤더에 담겨서 같이 감.

- 쿠키의 생성(서버에서 수행되는 코드)
- Cookie cookie = new Cookie("id", "asdf");     // 쿠키 생성. "id" : name, "asdf" : value.
- cookie.setMaxAge(60*60*24);                   // 유효기간 설정(초).
- response.addCookie(cookie);                   // 응답에 쿠키 추가.
    >> 쿠키를 추가하는 코드가 수행되면
    >> Set-Cookie : id=asdf; Max-Age=86400(상대시간으로 표기된 유효기간); Expires=...(절대시간으로 표기된 유효기간)
    >> 위 내용이 응답 헤더에 추가됨.

- 쿠키의 삭제
- Cookie cookie = new Cookie("id", "");     // 변경할 쿠키와 같은 이름 쿠키 생성.
- cookie.setMaxAge(0);                      // 유효기간을 0으로 설정(삭제).
    >> 쿠키의 유효기간을 0으로 해서 쿠키 자체는 존재하는 것처럼 보이지만
    >> 유효기간이 만료되었으므로 자동 삭제됨.
- response.addCookie(cookie);               // 응답에 쿠키 추가.

- 쿠키의 변경
- Cookie cookie = new Cookie("id", "");     // 변경할 쿠키와 같은 이름 쿠키 생성.
- cookie.setValue(URLEncoder.encode("고종혁"));    // 값(value)의 변경.
- cookie.setDomain("www.fastcampus.co.kr"); // Domain 변경.
- cookie.setPath("/ch2");                   // Path(경로) 변경.
- cookie.setMaxAge(60*60*24*7);             // 유효기간 변경.
    >> 이러한 부분을 직접 설정하지 않으면 서버의 응답을 가지고 판단해서 결정됨.
- response.addCookie(cookie);               // 응답에 쿠키 추가.

- 쿠키 읽어오기
- Cookie[] cookies = request.getCookies();  // 쿠키 읽기. 쿠키가 없으면 null.
- for (Cookie cookie : cookies)
    {String name = cookie.getName(); String value = cookie.getValue();}
*/
