<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<form:form action="${pageContext.request.contextPath}/store" method="post"  modelAttribute="userobj">
        <div>
            <label>Name : </label>
            <form:input path="textField"></form:input>
        </div>

        <div class="break">
            <label>Cities : </label>
            <form:select path="ddSelectionOption" id="location" >
                <form:option selected="true"
                             value="Please Select a Location" disabled="true"/>
                <form:options items="${locationList}" />
            </form:select>
        </div>

        <div class="break">
            <label>Email : </label>
            <form:input path="email"></form:input>
        </div>

        <div class="break">
            <label>Phone Number : </label>
            <form:input path="phoneNumber"></form:input>
        </div>

        <input type="submit" value="save">
</form:form>

<style>
    .break{
        margin-top: 10px;
    }
</style>
