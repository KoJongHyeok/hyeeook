
/*
- 세션(Session)
- 서로 관련된 요청(응답 포함)들을 하나로 묶은 것(쿠키를 이용).
    >> 원래 각각의 요청은 서로 관계가 없는데 관계를 만들어주는 것이 세션.
- 브라우저마다 개별 저장소(세션 객체)를 서버에서 제공함.
    >> 브라우저마다 제공하는 이유는 세션이 쿠키를 이용하기 때문(쿠키는 브라우저에 저장됨).
    >> 브라우저 : 서버(세션) = 1 : 1
    >> 같은 PC에서 다른 브라우저를 사용하면 세션 ID도 달라짐.
- 세션 객체는 서버에 저장됨.

- 세션의 작동 과정(login~logout)
- 1. 클라이언트(브라우저)가 서버에 최초 요청을 보냄.
- 2. 요청을 받은 서버가 무조건 세션 객체(저장소)를 만들고 세션 ID를 쿠키에 저장해서 응답에 같이 보냄.
        >> Set-Cookie : JSESSIONID=2F460A...; Path=/ch2; ...
        >> 위 내용이 응답 헤더에 추가됨.
- 3. 클라이언트의 브라우저에 세션 ID가 담긴 쿠키가 저장됨.
- 4. 그 다음 요청부터 세션 ID가 저장된 쿠키가 자동으로 같이 따라 감.
        >> Cookie: JSESSIONID=2F460A...
        >> 위 내용이 요청 헤더에 추가됨.
        >> 두 번째 요청부터 같은 세션으로 묶임.
        >> 세션 ID가 담긴 쿠키로 서버에서는 같은 브라우저에서 온 요청인지를 식별함.
        >> 같은 세션에 포함되는 동안 세션 ID와 일치하는 세션 저장소를 사용할 수 있음.
- 5-1. 세션 수동 종료 : invalidate()
- 5-2. 세션 자동 종료 : Timeout()
- 6. 세션이 끝나면 그 다음부터는 새로운 세션 ID가 발급되고 그에 맞는 세션이 새로 시작됨.

- 세션 객체 얻기
- HttpSession session = request.getSession();
- session.setAttribute("id", "asdf");
- request(요청 정보) 안에 세션 ID가 들어있기 때문에 request를 통해서 세션 객체에 접근.

- 세션과 관련된 메서드
- String getId() : 세션의 ID를 반환.
- long getLastAccessedTime() : 세션 내에서 최근 요청을 받은 시간을 반환.
- boolean isNew() : 새로 생성된 세션인지를 반환. request.getSession() 호출 후 사용.
- void invalidate() : 세션 객체를 제거(저장된 객체도 함께). 로그아웃.
- void setMaxInactiveInterval(int interval) : 지정된 시간(초) 후에 세션을 종료(예약 종료).
- int getMaxInactiveInterval() : 예약된 세션 종료 시간을 반환.

- 속성 관련 메서드
- void setAttribute(String name, String value) : 지정된 값(value)을 지정된 속성 이름(name)으로 저장.
- Object getAttribute(String name) : 지정된 이름(name)으로 저장된 속성의 값을 반환.
- void removeAttribute(String name) : 지정된 이름(name)의 속성을 삭제.
- Enumeration getAttributeNames() : 기본 객체에 저장된 모든 속성의 이름을 반환.

- 세션의 수동 종료
- HttpSession session = request.getSession();
- session.invalidate();                     // 1. 세션 즉시 종료.
- session.setMaxInactiveInterval(30*60);    // 2. 예약 종료(30분 후). 초단위.

- 세션의 자동 종료 - web.xml
<session-config>
    <session-timeout>30</session-timeout>   // 30분 후 자동 종료. 분단위.
</session-config>

- 쿠키와 세션 비교
- 쿠키 : 브라우저에 저장     서버 부담X      보안에 불리      서버 다중화에 유리
- 세션 : 서버에 저장       서버 부담O      보안에 유리      서버 다중화에 불리
*/
