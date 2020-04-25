<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file = "../layout/top.jsp" %>

<div class="col-sm-10 text-left">
    <h1>사이트 관리</h1>
    <hr>
    <form class="form-horizontal" action="/admin-page/site/update" method="POST">
        <div class="form-group">
            <label class="control-label col-sm-2" for="joinStatus">가입가능여부:</label>
            <div class="col-sm-9">
                <label class="radio-inline">
                    <input type="radio" id="joinStatus" name="joinStatus" value="Y" <c:if test='${info.joinStatus == "Y"}' > checked </c:if>>가능
                </label>
                <label class="radio-inline">
                    <input type="radio" name="joinStatus" value="N" <c:if test='${info.joinStatus == "N"}' > checked </c:if>>불가능
                </label>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="layoutType">레이아웃:</label>
            <div class="col-sm-9">
                <c:forEach var="layout" items="${layoutList}">
                    <label class="radio-inline">
                        <input type="radio" id="layoutType" name="layoutType" value="${layout.detail}"
                            <c:if test='${info.layoutType == layout.detail}' > checked </c:if>> ${layout.getDetail()}
                    </label>
                </c:forEach>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">저장</button>
            </div>
        </div>
    </form>
</div>

<%@ include file = "../layout/bottom.jsp" %>
