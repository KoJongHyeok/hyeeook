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

#### 톰캣 내부 구성 및 처리 과정
> 1. Server
> 2. Service
> 3. Engine
> 4. Host
> 5. Context
> 6. Servlet
> 7. 
