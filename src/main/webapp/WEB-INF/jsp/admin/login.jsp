<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file = "layout/top.jsp" %>

<div class="col-sm-10 text-left">
    <div class="panel panel-default" style="margin-top: 10%;">
        <div class="panel-heading">Login</div>
        <div class="panel-body">
            <form action="" method="">
                <div class="form-group row">
                    <label for="email_address" class="col-md-4 col-form-label text-md-right">Id</label>
                    <div class="col-md-6">
                        <input type="text" id="id" class="form-control" name="id" required="" autofocus="">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="password" class="col-md-4 col-form-label text-md-right">Password</label>
                    <div class="col-md-6">
                        <input type="password" id="password" class="form-control" name="password" required="">
                    </div>
                </div>

                <div class="col-md-12 text-center">
                    <button type="submit" class="btn btn-primary">
                        Register
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>

<%@ include file = "layout/bottom.jsp" %>
