<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file = "top.jsp" %>

<div class="container">

    <form action="/board/add" method="POST" enctype="multipart/form-data">

        <div class="form-group">
            <label for="exampleFormControlInput1">제목</label>
            <input type="text" class="form-control" name="title">
        </div>

        <div class="form-group">
            <label for="contents">내용</label>
            <textarea class="form-control" id="contents" name="contents" rows="5"></textarea>
        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">첨부파일</span>
            </div>
            <div class="custom-file">
                <input type="file" class="custom-file-input" id="filename" name="filename">
                <label class="custom-file-label" for="filename">파일을 선택하세요</label>
            </div>
        </div>

        <div style="width:10em;padding-top:2em;margin:auto;">
            <button type="submit" class="btn btn-outline-primary btn-lg">등록</button>
        </div>

    </form>

</div>

<%@ include file = "bottom.jsp" %>