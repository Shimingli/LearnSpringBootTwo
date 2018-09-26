## 	Spring Boot中的JSON技术

* https://mrbird.cc/Spring-Boot%20JSON.html
* RestController Controller 注解的区别  
* JSON一般用的都是阿里巴巴的Fastjson，后来发现使用Spring Boot内置的Jackson来完成JSON的序列化和反序列化操作也挺方便。Jackson不但可以完成简单的序列化和反序列化操作，也能实现复杂的个性化的序列化和反序列化操作。 


* 在Spring中使用@ResponseBody注解可以将方法返回的对象序列化成JSON，比如：
``` 
@RequestMapping("getuser")
@ResponseBody
public User getUser() {
    User user = new User();
    user.setUserName("mrbird");
    user.setBirthday(new Date());
    return user;
} 

```


* @Autowired 注释，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。 通过 @Autowired的使用来消除 set ，get方法

* RestController Controller 注解的区别 
  *  @RestController注解是@Controller和@ResponseBody注解的结合。
  *  @RestController是@ResponseBody ＋ @Controller合体，当你在这个controller中方法只是想返回一个页面时，就不能用@RestController,因为它会把你的返回值当作数据返回，而不是页面名字，所以这时候就只能用@Controller。
``` 
//此时并不会返回到home.html页面，而是直接在当前页面输出home字符串。
总之一句话，返回页面用@Controller，要想返回数据就用@RestController,这个注解对于返回数据比较方便，因为它会自动将对象实体转换为JSON格式。
@RestController
public class HomeController {

 @RequestMapping("/")
 public String index(Model model){
  Msg msg =  new Msg("测试标题","测试内容","额外信息，只对管理员显示");
  model.addAttribute("msg", msg);
  return "home";//home.html
 }
}
```     



* 序列化
  Jackson通过使用mapper的writeValueAsString方法将Java对象序列化为JSON格式字符串：
  
* 反序列化
  使用@ResponseBody注解可以使对象序列化为JSON格式字符串，除此之外，Jackson也提供了反序列化方法。  

































































































































