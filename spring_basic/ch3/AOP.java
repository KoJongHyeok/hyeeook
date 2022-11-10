package com.fastcampus.ch3.aop;

import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AopMain {
    public static void main(String[] args) throws Exception {
        // MyClass 객체를 동적으로 생성해서 MyAdvice 객체의 invoke() 메서드로 넘겨주는 코드.

        // 1. 부가 기능(advice) 객체 생성.
        MyAdvice myAdvice = new MyAdvice();

        // 2. 핵심 기능(target) 클래스의 클래스 객체 생성.
        Class clazz = Class.forName("com.fastcampus.ch3.aop.MyClass");

        // 3. 클래스 객체를 통해 핵심 기능(target) 객체 생성.
        Object obj = clazz.newInstance();

        // 4. 핵심 기능(target) 객체에 정의된 메서드를 하나씩 꺼내서 부가 기능(advice) 객체의 메서드로 넘겨줌.
        for (Method m : clazz.getDeclaredMethods()) {
            myAdvice.invoke(m, obj, null);
        }
    }
}

class MyClass {     // 핵심 기능 클래스(target).

    @Transactional  // 다른 애너테이션으로 해도 무관.
    void aaa() {
        System.out.println("aaa() is called");
    }       // join point

    void aaa2() {
        System.out.println("aaa2() is called");
    }     // join point

    void bbb() {
        System.out.println("bbb() is called");
    }       // join point
}

//----------------------------------바로 밑이 주요 내용임------------------------------------------------------

//class MyAdvice {        // 부가 기능 클래스(advice), 방법(1).
//
//    Pattern p = Pattern.compile("a.*");     // 부가 기능(advice)을 추가할 핵심 기능(target)의 메서드(join point)를 구분하기 위한 패턴(pointcut).
//    boolean matches(Method m) {                   // 메서드와 패턴을 매치해서 일치하면 true, 불일치하면 false.
//        Matcher matcher = p.matcher(m.getName());
//        return matcher.matches();
//    }
//
//    void invoke(Method m, Object obj, Object... args) throws Exception {
//
//        if(matches(m))
//        {System.out.println("[before]{");}
//
//        m.invoke(obj, args);    // 역으로 핵심 기능(target)의 메서드를 호출.
//                                // reflection API를 이용.
//
//        if(matches(m))
//        {System.out.println("}[after]");}
//    }
//}

class MyAdvice {        // 부가 기능 클래스(advice), 방법(2).

    void invoke(Method m, Object obj, Object... args) throws Exception {

        if(m.getAnnotation(Transactional.class)!=null)      // 핵심 기능(target) 중 해당 애너테이션이 붙은 메서드(join point)만 부가 기능(advice)의 메서드를 추가.
        {System.out.println("[before]{");}

        m.invoke(obj, args);

        if(m.getAnnotation(Transactional.class)!=null)
        {System.out.println("}[after]");}
    }
}

/*
- AOP(Aspect Oriented Programming)
- 관점 지향 프로그래밍? 횡단 관심사? cross-cutting concerns?
- 부가 기능(advice)을 동적으로 추가해주는 기술(동적 추가 : 프로그램 만들 때 추가하는 것이 아니라 코드가 실행되는 과정에서 자동으로 부가 기능(코드)이 추가된다는 뜻).
- 메서드의 시작 또는 끝에 자동으로 코드(advice)를 추가(메서드마다 라인수도 다르고 내용도 바뀌는데 메서드의 시작과 끝은 항상 정해져 있기 때문).

- 관련 용어
- target : advice가 추가될 객체(핵심 기능).
- advice : target에 동적으로 추가될 부가 기능(코드).
- join point : advice가 추가(join)될 대상(메서드).
- pointcut : join point들을 정의한 패턴.
                코드 작성 형식 : execution(접근제어자 반환타입 패키지명.클래스명.메서드명(매개변수 목록))
                               execution(* com.fastcampus.ch3.aop.*.*(..))
                               >> 접근제어자는 생략 가능.
                               >> 반환타입과 클래스명, 메서드명은 종류에 제한없이 가능하다는 의미.
                               >> 매개변수는 개수, 타입의 제한이 없다는 의미.
                               >> 적용될 advice가 여러 개인 경우 그 다음 advice에 메서드 호출 결과를 반환해야 함. 이 경우는 메서드의 반환타입을 Object로 작성.
                                    @Order() 애너테이션을 붙여서 advice의 순서를 정해줄 수 있음(@Order(1), @Order(2), @Order(3)).
                               >> 적용될 advice가 하나인 경우는 메서드의 반환타입을 void로 작성. 
- proxy : target에 advice가 동적으로 추가되어 생성된 객체.
- weaving : target에 advice를 추가해서 proxy를 생성하는 것.

- AOP 기술을 요약하면
- 1. 원래 하나로 작성될 코드를 핵심 기능(target)과 부가 기능(advice)으로 나눠서 작성(변경에 유리한 코드).
            만약 분리하지 않고 하나의 코드로 작성하면 코드 중복이 발생하고 관심사의 분리가 이루어지지 않음.
            핵심 기능만 고쳐도, 부가 기능만 고쳐도 메서드를 모두 고치고 테스트해야 함(변경에 불리한 코드가 됨).
- 2. 실행 중에 핵심 기능과 부가 기능이 원래 하나였던 것처럼 합쳐짐.

---------------------------------AOP 기술을 적용하기 전의 코드--------------------------------------------------------------

class MyClass {
    void aaa() {
        System.out.println("[before]{");
        System.out.println("aaa() is called");
        System.out.println("}[after]");
    }

    void aaa2() {
        System.out.println("[before]{");
        System.out.println("aaa2() is called");
        System.out.println("}[after]");
    }

    void bbb() {
        System.out.println("[before]{");
        System.out.println("bbb() is called");
        System.out.println("}[after]");
    }
}

------------------------------------------------------------------------------------------------------------------------

- Advice의 종류
- Advice의 설정은 XML과 애너테이션, 두 가지 방법으로 가능.
-                       애너테이션
- around advice     :   @Around             메서드의 시작과 끝 부분에 추가되는 부가 기능
- before advice     :   @Before             메서드의 시작 부분에 추가되는 부가 기능
- after advice      :   @After              메서드의 끝 부분에 추가되는 부가 기능
- after returning   :   @AfterReturning     예외가 발생하지 않았을 때, 실행되는 부가 기능(try 블럭 끝)
- after throwing    :   @AfterThrowing      예외가 발생했을 때, 실행되는 부가 기능(catch 블럭 끝)
*/
