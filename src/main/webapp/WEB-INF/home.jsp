<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="gb2312">
    <title>tt</title>
    <script src="../jquery/dist/jquery.min.js"></script>
</head>
<body>
<script>
    var count = 0;
    function startSearch(){
        setTimeout(flush,5000);
    }

    function flush() {
        var fg = false;
        $.ajax({
            url: "/getJson", //请求的url
            dataType: "json",
            success: function (json) {
                var date = new Date();
                for (var obj in json) {
                    var d1 = new Date(json[obj].TheDate);
                    //console.log(json[obj]);
                    //大于当前日期
                    if (d1 > date) {
                        if (json[obj].IsBookEnabled == true) {
                            if (json[obj].BookCount < json[obj].Seats) {
                                console.log(json[obj]);
                                var aa = "http://www.gzjponline.com/Jp/Booking/" + json[obj].ScheduleId;
                                $("#fill").html(aa);
                                window.open(aa);
                                fg = true;
                                break;
                            }
                        }
                    }

                }
                if(!fg) {
                    count++;
                    $("#fill").html("no seat count: "+count);
                    setTimeout(flush,5000);
                }

            },
            error: function (xhr, status, error) {
                console.log(xhr);
            }
        });
    }

</script>
<div>Hello!</div></br>
<form action="/setUserInfo">
    <input type="text" name="name">
    <input type="text" name="idCard">
    <input type="text" name="phone">
    <input type="submit" value="GO">
</form>
<input type="button" onclick="startSearch()" value="ok">
<img src="../imgs/pic.jpg" />
<div id="fill" href="">Waiting..</div>

</body>
</html>