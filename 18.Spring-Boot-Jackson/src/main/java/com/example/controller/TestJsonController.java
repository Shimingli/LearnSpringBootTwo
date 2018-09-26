package com.example.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.Me;
import com.example.pojo.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class TestJsonController {

	@Autowired//@Autowired 注释，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。 通过 @Autowired的使用来消除 set ，get方法
	ObjectMapper mapper;

     // http://localhost:8080/getuser
    // {"userName":"mrbird","age":26,"password":"123456","birthday":"2018-09-26 11:36:58"}
	@JsonView(User.AllUserFieldView.class) //@JsonView可以过滤序列化对象的字段属性，可以使你有选择的序列化对象
	@RequestMapping("getuser")
	@ResponseBody
	public User getUser() {
		User user = new User();
		user.setUserName("mrbird");
		user.setAge(26);
		user.setPassword("123456");
		user.setBirthday(new Date());
		return user;
	}


	//http://localhost:8080/serialization
    //{"userName":"mrbird","age":0,"password":null,"birthday":"2018-09-26 11:37:30"}
	@RequestMapping("/serialization") //要把注解改成这个才可以 @RestController
	//@ResponseBody
	 String serialization() {
		try {
			User user = new User();
			user.setUserName("mrbird");
			user.setBirthday(new Date());
			//jackon的jar包，使用writeValuesAsString的方法就可以把对角转化成json字符串。
			String str = mapper.writeValueAsString(user);
			//{"userName":"mrbird","age":0,"password":null,"birthday":"2018-09-26 14:03:52"}
            System.out.println("shiming 得到的值是"+str);
			return str;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
   // mrbird 26
	@RequestMapping("readjsonstring")
	@ResponseBody
	public String readJsonString() {
		try {
			String json = "{\"name\":\"mrbird\",\"age\":26}";
			JsonNode node = this.mapper.readTree(json);
			String name = node.get("name").asText();
			int age = node.get("age").asInt();
			return name + " " + age;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
//    绑定对象
//    我们也可以将Java对象和JSON数据进行绑定
   // http://localhost:8080/readjsonasobject
    // mrbird
	@RequestMapping("readjsonasobject")
	@ResponseBody
	public String readJsonAsObject() {
		try {
			String json = "{\"userName\":\"mrbird\"}";
			User user = mapper.readValue(json, User.class);
			String name = user.getUserName();
			return name;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	//{"userName":"mrbird","age":26,"password":"123456","birthday":"2018-09-26 11:38:49"}
	@RequestMapping("formatobjecttojsonstring")
	@ResponseBody
	public String formatObjectToJsonString() {
		try {
			User user = new User();
			user.setUserName("shiming");
			user.setAge(26);
			user.setPassword("123456");
			user.setBirthday(new Date());
			String jsonStr = mapper.writeValueAsString(user);
			return jsonStr;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("updateuser")
	@ResponseBody
	public int updateUser(@RequestBody List<User> list) {
		return list.size();
	}


	//mrbirdscott
	@RequestMapping("customize")
	@ResponseBody
	public String customize() throws JsonParseException, JsonMappingException, IOException {
		String jsonStr = "[{\"userName\":\"mrbird\",\"age\":26},{\"userName\":\"scott\",\"age\":27}]";
		JavaType type = mapper.getTypeFactory().constructParametricType(List.class, User.class);
		List<User> list = mapper.readValue(jsonStr, type);
		String msg = "";
		for (User user : list) {
			msg += user.getUserName();
		}
		return msg;
	}

	/*
	http://localhost:8080/shiming
	shiming
	 */
	@RequestMapping("shiming")
	@ResponseBody
	public String shiming() {
		return "shiming";
	}
    //{"name":"wo","age":"15"}   我得到了验证
	@RequestMapping("shiming1")
	@ResponseBody
	public Me shiming1() {
        Me me = new Me();
        me.setName("wo");
        me.setAge("15");
        return me;
	}

}
