<%@ page import="com.example.questionnairesurvey.controller.RequestConst" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>アンケート内容</title>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<h1>アンケート内容</h1>
<form id="form" name="form1" action="complete" method="post">

    <label>当社部門：</label>
    <input type="text" name="department" ><br>

    <label>当社担当：</label>
    <input type="text" name="charge" ><br>

    <%-- QUESTION1 --%>
    <div class="content-block">
        <div class="question">Q<%= RequestConst.QUESTION_ARRAY[0] %> </div>
        <%
            String[] $Q1_SELECT_ARRAY = RequestConst.Q1_SELECT_ARRAY;
            for( int x = 0; x < $Q1_SELECT_ARRAY.length; x++) {
                String strValue = Integer.toString(x+1);
                int y = x + 1;

        %>
        <div class="radio-button">
            <input type="radio" id="<%= "Q1_RADIO" + strValue %>" name="Q1_RADIO" value=<%= y %> >
            <label class="radio-button" ><%= $Q1_SELECT_ARRAY[x] %></label>
        </div>
        <%
            }
        %>
    </div>
    <div class="error-message">这个选项没有选择</div><br>

    <%-- QUESTION2 --%>
    <div class="content-block">
        <div class="question">Q<%= RequestConst.QUESTION_ARRAY[1] %> </div>
        <textarea name="Q2_ANSWER_TEXT" cols="50" rows="20"  maxlength="300"  style="resize:none;" > </textarea>
    </div>

    <%-- QUESTION3 --%>
    <div class="content-block">
        <div class="question">Q<%= RequestConst.QUESTION_ARRAY[2] %> </div>
        <textarea name="Q3_ANSWER_TEXT" cols="50" rows="20"  maxlength="300"  style="resize:none;" > </textarea>
    </div>

    <div class="content-bottom">
        <button type="submit"  id="submit" value="submit" >
            <span class="">提交</span>
        </button>
    </div>

</form>
</body>
</html>
