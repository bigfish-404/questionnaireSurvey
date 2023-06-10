<%@ page import="com.example.questionnairesurvey.controller.RequestConst" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    boolean checked = false;
    boolean disabled =false;
    //两种模式获取modelValue。一种是前端获取一种是url获取
    int modelValue = (int) request.getAttribute("modelValue");
    //int modelValue =Integer.parseInt(request.getParameter("MODEL"));
    if(1 == modelValue){
        disabled =true;
        request.setAttribute("disabled",disabled);
    }

%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>问卷调查</title>
    <script>
        window.onload = function() {
            // 两种模式获取modelValue。一种是前端获取一种是url获取
            //var urlParams = new URLSearchParams(window.location.search);
            //var modelValue = urlParams.get('MODEL');
            var modelValue = <%= request.getAttribute("modelValue") %>;

            if (modelValue == 1) {
                var submitButton = document.getElementById('warning');
                submitButton.style.display = 'none';
                submitButton.disabled = true;
            }
        }
    </script>
</head>
<body>
<h1>问卷调查</h1>
<form id="form" name="form1" action="complete" method="post">
    <%-- QUESTION1 --%>
    <div class="content-block">
        <div class="question">Q<%= RequestConst.QUESTION_ARRAY[0] %> </div>
        <%
            String[] $Q1_SELECT_ARRAY = RequestConst.Q1_SELECT_ARRAY;
            for( int x = 0; x < $Q1_SELECT_ARRAY.length; x++) {
                String strValue = Integer.toString(x+1);
                int y = $Q1_SELECT_ARRAY.length-x-1;
                if (request.getAttribute("Q3_RADIO1Value") != null){
                    Integer Q1_RADIO1Value = (int) request.getAttribute("Q1_RADIO1Value");
                    checked = y ==Q1_RADIO1Value;
                }

        %>
        <div class="radio-button">
            <input type="radio" id="<%= "Q1_RADIO1" + strValue %>" name="Q1_RADIO1" value=<%= y %>   <%= checked ? "checked" : ""  %>   ${ requestScope.disabled ? "disabled" : ""}  required  >
            <label class="radio-button" ><%= $Q1_SELECT_ARRAY[x] %></label>
        </div>
        <%
            }
        %>
    </div>
    <div class="content-block">
            <div class="question">Q<%= RequestConst.QUESTION_ARRAY[1] %> </div>
            <%
                String[] $Q2_SELECT_ARRAY = RequestConst.Q2_SELECT_ARRAY;
                for( int x = 0; x < $Q1_SELECT_ARRAY.length; x++) {
                    String strValue = Integer.toString(x+1);
                    int y = $Q2_SELECT_ARRAY.length-x-1;
                    if (request.getAttribute("Q3_RADIO1Value") != null){
                        Integer Q2_RADIO1Value = (int) request.getAttribute("Q2_RADIO1Value");
                        checked = y ==Q2_RADIO1Value;
                    }

            %>
            <div class="radio-button">
                <input type="radio" id="<%= "Q2_RADIO1" + strValue %>" name="Q2_RADIO1" value=<%= y %>  <%= checked ? "checked" : ""  %> ${ requestScope.disabled ? "disabled" : ""}   required >
                <label class="radio-button" ><%= $Q2_SELECT_ARRAY[x] %></label>
            </div>
            <%
                }
            %>
        </div>
    <div class="content-block">
            <div class="question">Q<%= RequestConst.QUESTION_ARRAY[2] %> </div>
            <%
                String[] $Q3_SELECT_ARRAY = RequestConst.Q3_SELECT_ARRAY;
                for( int x = 0; x < $Q3_SELECT_ARRAY.length; x++) {
                    String strValue = Integer.toString(x+1);
                    int y = $Q3_SELECT_ARRAY.length-x-1;
                    if (request.getAttribute("Q3_RADIO1Value") != null){
                        Integer Q3_RADIO1Value = (int) request.getAttribute("Q3_RADIO1Value");
                        checked = y ==Q3_RADIO1Value;
                    }

            %>
            <div class="radio-button">
                <input type="radio" id="<%= "Q3_RADIO1" + strValue %>" name="Q3_RADIO1" value=<%= y %> <%= checked ? "checked" : ""  %> ${ requestScope.disabled ? "disabled" : ""}  required >
                <label class="radio-button" ><%= $Q3_SELECT_ARRAY[x] %> </label>
            </div>
            <%
                }
            %>
        </div>
    <div class="content-block">
            <div class="question">Q<%= RequestConst.QUESTION_ARRAY[4] %> </div>
            <%
                String[] $Q4_SELECT_ARRAY = RequestConst.Q4_SELECT_ARRAY;

                for( int x = 0; x < $Q4_SELECT_ARRAY.length; x++) {
                    String strValue = Integer.toString(x+1);
                    int y = $Q4_SELECT_ARRAY.length-x-1;
                    if (request.getAttribute("Q4_RADIO1Value") != null){
                        Integer Q4_RADIO1Value = (int) request.getAttribute("Q4_RADIO1Value");
                        checked = y ==Q4_RADIO1Value;
                    }

            %>
            <div class="radio-button">
                <input type="radio" id="<%= "Q4_RADIO1" + strValue %>" name="Q4_RADIO1" value=<%= y %> <%= checked ? "checked" : ""  %> ${ requestScope.disabled ? "disabled" : ""}   required>
                <label class="radio-button" ><%= $Q4_SELECT_ARRAY[x] %></label>
            </div>
            <%
                }
            %>
        </div>

        <%-- QUESTION5 --%>
        <div class="content-block">
            <div class="question">Q<%= RequestConst.QUESTION_ARRAY[4] %> </div>
            <%
                String Q5_ANSWER_TEXT = "";
                if (request.getAttribute("Q5_ANSWER_TEXT") != null){
                   Q5_ANSWER_TEXT = (String) request.getAttribute("Q5_ANSWER_TEXT") ;
                }
            %>
            <textarea name="Q5_ANSWER_TEXT" cols="50" rows="2" data-rule="zenkaku" data-label="偦偺懠" maxlength="300"  style="resize:none;" value="2"  ${ requestScope.disabled ? "disabled" : ""}></textarea>
        </div>

        <div class="content-bottom">
            <button type="submit" class="button" id="warning"  >
                <span class="">提交</span>
            </button>
        </div>

</form>
</body>
</html>
