<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 15.02.2022
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><a href="#inlineContent" class="defaultDOMWindow">Open DOM Window</a></p>
<script type="text/javascript">
    $('.defaultDOMWindow').openDOMWindow({
        eventType:'click',
        loader:1,
        loaderImagePath:'animationProcessing.gif',
        loaderHeight:16,
        loaderWidth:17
    });
</script>
<div id="inlineContent" style=" display:none;">
    <p>Inline Content</p>
    <p>Click overlay to close window</p>
    <p>Consequat ea Investigationes in enim congue. Option velit volutpat quod blandit ex. Congue parum praesent aliquam nam clari. Qui praesent quam sollemnes id vulputate. In imperdiet diam at sequitur et. Minim delenit in dolor dolore typi. Erat delenit laoreet quinta videntur id. Ii at qui eum ut usus. Quis etiam suscipit iusto elit dolor. Dolor congue eodem adipiscing cum placerat. </p>
    <p>Erat usus lorem adipiscing non in. Nobis claram iusto et dolore facilisis. Claritatem decima velit decima ipsum wisi. Quinta ullamcorper sollemnes usus aliquip in. Ut aliquip velit tempor facit putamus. Habent duis et option quod facer. Delenit facer consequat seacula molestie notare. Qui tincidunt nobis lectores eleifend eorum. Decima usus facer id parum legere. Nonummy nonummy facilisis sit qui eodem. </p>
</div>
</body>
</html>
