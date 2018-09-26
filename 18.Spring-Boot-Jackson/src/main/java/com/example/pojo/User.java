package com.example.pojo;

import java.io.Serializable;
import java.util.Date;

import com.example.config.UserDeserializer;
import com.example.config.UserSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
@JsonView
@JsonView，作用在类或者属性上，用来定义一个序列化组。 比如对于User对象，某些情况下只返回userName属性就行，
而某些情况下需要返回全部属性。 因此User对象可以定义成如下：


 */


//@JsonIgnoreProperties({ "password", "age" }) todo @JsonIgnoreProperties，忽略一组属性，作用于类上，比如JsonIgnoreProperties({ "password", "age" })。
//@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class) @JsonNaming，用于指定一个命名策略，作用于类或者属性上。Jackson自带了多种命名策略，你可以实现自己的命名策略，比如输出的key 由Java命名方式转为下面线命名方法 —— userName转化为user-name。
//@JsonSerialize(using = UserSerializer.class) @JsonSerialize，指定一个实现类来自定义序列化。类必须实现JsonSerializer接口，
//@JsonDeserialize (using = UserDeserializer.class) //@JsonDeserialize，用户自定义反序列化，同@JsonSerialize ，类需要实现JsonDeserializer接口。
public class User implements Serializable {

	private static final long serialVersionUID = 6222176558369919436L;

	public interface UserNameView {
	}

	public interface AllUserFieldView extends UserNameView {
	}

	@JsonView(UserNameView.class)
	private String userName;
	
	@JsonView(AllUserFieldView.class)
	private int age;

	 @JsonIgnore //@Jsonlgnore，作用在属性上，用来忽略此属性。
	//@JsonView(AllUserFieldView.class)  //{"userName":"mrbird","age":26,"bth":"2018-09-26 14:19:12"}
	private String password;

	@JsonProperty("bth") //todo @@JsonProperty，作用在属性上，用来为JSON Key指定一个别名。
	// @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  @JsonFormat，用于日期格式化，
	@JsonView(AllUserFieldView.class)
	private Date birthday;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
