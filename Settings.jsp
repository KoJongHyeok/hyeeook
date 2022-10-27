<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- ---------------------------------------------------------------------------------------------- -->

<!-- 한글 변환 필터 시작 -->
<!-- 경로 : src -> main -> webapp -> WEB-INF -> web.xml -> 맨아래에 붙여넣기 -->
	<filter>
		<filter-name>encodingFilter</filter-name>
		<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
		<init-param>
			<param-name>encoding</param-name>
			<param-value>UTF-8</param-value>
		</init-param>
		<init-param>
			<param-name>forceEncoding</param-name>
			<param-value>true</param-value>
		</init-param>
	</filter>
	
	<filter-mapping>
		<filter-name>encodingFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
<!-- 한글 변환 필터 끝 -->

<!-- ---------------------------------------------------------------------------------------------- -->

<!-- Preferences -> HTML Files -> Encoding : UTF-8 -->
