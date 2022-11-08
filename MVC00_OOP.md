## O.O.P 5대 설계 원칙 - S.O.L.I.D

> 1. SRP : 단일 책임의 원칙 - 하나의 메서드는 하나의 책임(관심사)만 진다.
> 객체 지향 설계를 잘하기 위해서는 코드의 분리를 잘해야 함.
> - 관심사에 따른 분리
> - 공통(중복) 코드의 분리
> - (자주)변하는 코드와 (자주)변하지 않는 코드를 분리

___

## Class 객체는 설계도 객체

> 설계도 객체를 통해 객체를 생성할 수 있고, 객체의 정보를 얻을 수 있음 >> Reflection API
> Spring MVC 구조
> 1. DispatcherServlet이 입력 처리, Model 객체를 만들어서 Controller에게 전달
> 2. Controller가 처리 후 결과를 Model 객체에 저장해서 DispatcherServlet에게 전달
> 3. DispatcherServlet이 View로 전달하면 View가 응답을 만들어내서 클라이언트에게 전송

___

#### Tomcat 내부 구성 및 처리 과정
> 0. 브라우저에서 'http://www.fastcampus.com/ch2/TwoDice'를 요청
> 1. Server(Tomcat)
> 2. Thread Pool, Service
> 3. Connector(Protocol), Engine(Catalina)
> 4. Host(www.fastcampus.com)/ n개 가능
> 5. Context(Web App, 각각의 스프링 프로젝트, /ch2)/ n개 가능
> 6. Servlet(Dispatcher-Servlet, 작은 서버 프로그램)/ n개 가능
> 7. @Controller
> 8. @RequestMapping("/rollDice")

___

#### .jsp -> .java -> .class 경로
> 1. Run Configurations
> 2. Arguments
> 3. -Dwtp.deploy="..."에 ...경로 복사 및 이동
> 4. 상위 폴더(tmp0)로 이동
> 5. work -> Catalina -> localhost -> 해당 프로젝트 이름의 폴더
> - WEB_002dINF : 스프링에서 사용하는 views(.jsp) 폴더가 변환되는 저장소
> 
#### jsp의 내용을 수정했지만 적용이 안되는 경우 해결법
> - 방법(1). 해당 프로젝트 이름의 폴더 내의 모든 파일과 폴더를 삭제
> - 방법(2). STS -> Servers -> Tomcat 우클릭 -> Clean Tomcat Work Directory...
> - 브라우저 새로고침 및 URL 재호출 -> 수정된 파일로 자동 생성 및 컴파일

___

#### .m2(Maven 저장소)
- 'pom.xml(Maven의 의존성 관리 파일)'의 'dependency'로 등록된 모듈들이 다운받아지는 경로 >> 'C:/User/insb1/.m2/repository'
- 알 수 없는 문제가 발생하면 대부분 프로젝트에서 의존(사용)하고 있는 모듈 간에 충돌이 때문에 발생. 'repository'를 삭제하고 'STS'에서 'Maven Update'를 수행하면 됨. 그러면 자동으로 'repository'가 재생성되면서 해결됨. '.m2'는 절대 삭제하면 안 됨.
- '/C:\Users\insb1\.m2\repository\org\springframework\spring-web\5.0.7.RELEASE' 폴더에서 'spring-web-5.0.7.RELEASE.jar' : 실제 모듈, 'spring-web-5.0.7.RELEASE-sources.jar' : 소스 파일

___
### @RequestMapping의 URL패턴

|     |종류|URL패턴|매칭URL|
|-----|----|-------|-------|
|1순위|exact mapping<br>(정확히 일치)|/login/hello.do|http://localhost/ch2/login/hello.do|
|2순위|path mapping<br>(경로 맵핑)|/login/*|http://localhost/ch2/login/<br>http://localhost/ch2/login/hello<br>http://localhost/ch2/login/hello.do<br>http://localhost/ch2/login/test/|
|3순위|extension mapping<br>(확장자 맵핑)|*.do|http://localhost/ch2/hi.do<br>http://localhost/ch2/login/hello.do|

- ? : 한 글자 / * : 여러 글자 / ** : 하위 경로 포함
- ** : 여기에 아무 경로가 안들어가도, 여러 경로가 들어가도 해당됨
- 위 경로 중에 없으면 404 Not Found 발생

___
