## Spring Boot异常处理  


* Spring Boot对异常的处理有一套默认的机制：当应用中产生异常时，Spring Boot根据发送请求头中的accept是否包含text/html来分别返回不同的响应信息。当从浏览器地址栏中访问应用接口时，请求头中的accept便会包含text/html信息，产生异常时，Spring Boot通过org.springframework.web.servlet.ModelAndView对象来装载异常信息，并以HTML的格式返回；而当从客户端访问应用接口产生异常时（客户端访问时，请求头中的accept不包含text/html），Spring Boot则以JSON的格式返回异常信息。下面来验证一下。

* 每个项目来热部署  感觉比较强的哦   哈哈哈哈哈哈哈好哈哈



* http://localhost:8080/user/1    