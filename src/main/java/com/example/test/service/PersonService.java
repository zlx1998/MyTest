package com.example.test.service;

import com.dtflys.forest.annotation.Header;
import com.dtflys.forest.annotation.JSONBody;
import com.dtflys.forest.annotation.Post;

import java.util.Map;

/**
 * @author zlx
 * @date 2022/10/24 18:12
 */
public interface PersonService {
	@Post("http://10.78.155.17/api/sicp4-basestore-center/api/personInfoQueryApi/queryPersonInfo")
	String postJsonMap(@JSONBody Map mapObj, @Header("Authorization") String access);


}
