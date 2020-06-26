package br.com.duosdevelop.vb.apiTestCelula;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

import static br.com.duosdevelop.vb.apiTestCelula.constant.ApplicationConstant.BASE_URI;

public class AuthenticationTest {

    public static String getAccessToken(){
        Response response = RestAssured.given()
                .request()
                .header("Authorization", "Basic bTBiMWwzQDptMGJpbDNjbGllbnQ=")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .contentType("application/x-www-form-urlencoded")
                .formParam("client", "m0b1l3@")
                .formParam("username", "maria@gmail.com")
                .formParam("password", "maria")
                .formParam("grant_type", "password")
                .when()
                .post(BASE_URI + "/oauth/token");
        JSONObject jsonObject = new JSONObject(response.getBody().asString());
        return jsonObject.get("access_token").toString();
    }
}
