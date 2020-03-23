<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>회원가입</title>
    </head>
    <body>
        <form action="/mem/join" method="post">
            <table>
                <tr>
                    <td>아이디</td>
                    <td><input type="text" name="memId"></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="text" name="memPw"></td>
                </tr>
                <tr>
                    <td>이름</td>
                    <td><input type="text" name="memName"></td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td><input type="text" name="memEmail"></td>
                </tr>
            </table>

            <input type="submit" value="가입하기">
        </form>
    </body>
</html>
