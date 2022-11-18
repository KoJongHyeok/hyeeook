<%@ page import="java.net.URLDecoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- ----------------------------------------------------------------------------------------------------------------------- -->

<%@ page isErrorPage="true" %>
<!--
- '이 페이지는 에러가 발생했을 때 보여주기 위한 페이지'라는 의미.
- error.jsp view 파일 상단에 isErrorPage="" 코드를 작성하면 컨트롤러에서 Model을 통해 에러 객체를 전달받지 않아도 됨.
- pageContext.exception 기본 객체를 바로 사용할 수 있음.

- isErrorPage="true" 일 때 jsp의 특성으로 인해 에러 상태 코드의 디폴트 값인 500으로 강제 전환됨.
- 내가 원하는 에러 상태 코드로 설정하기 위해서는 isErrorPage="false" 작성해야 함.
-->

<!-- ----------------------------------------------------------------------------------------------------------------------- -->
