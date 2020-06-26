package br.com.duosdevelop.vb.apiTestCelula;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static br.com.duosdevelop.vb.apiTestCelula.constant.ApplicationConstant.*;

public class APITest {

    @Test
    public void test(){
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
        String accessToken = jsonObject.get("access_token").toString();
        String tokenType = jsonObject.get("token_type").toString();
        System.out.println("Oauth Token with type " + tokenType + "   " + accessToken);
    }
}
