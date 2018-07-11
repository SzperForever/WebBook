<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
</head>
<body>
<script src="js/jquery-1.12.2.min.js"></script>
<script type="text/javascript">
    function submit() {
        var username = $("#userName").val();
        var password = $("#password").val();
        console.log(username);
        var postdata = {
            userName: username,
            password: password
        };
        console.log(postdata);
        $.ajax({
            url: "Login.do",
            type: "POST",
            dataType: 'json',
            data: postdata,
            success: function (data) {
                console.log(data.code + "msg: " + data.msg);
            }
        })
    }
    function submitBook() {
        var bookId = $("#bookId").val();
        console.log(bookId)
        $.ajax({
            url: "addToCart/" + bookId + ".do",
            type: "POST",
            success: function (data) {
                alert(data)
            }
        })
    }
</script>
<div id="login">
    <h2>用户登陆</h2>
            <input class="input-text" type="text" name="userName" id="userName"/>
            <input class="input-text" type="password" name="passWord" id="password"/>

        <input class="input-btn" type="submit" name="submit" value="submit" onclick="submit()"/>
        <input class="book" type="text" name="bookId" id="bookId"><button onclick="submitBook()">submit</button>

</div>
</body>
</html>
