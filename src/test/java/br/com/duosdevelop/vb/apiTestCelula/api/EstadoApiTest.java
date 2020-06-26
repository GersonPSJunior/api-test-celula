package br.com.duosdevelop.vb.apiTestCelula.api;

import br.com.duosdevelop.vb.apiTestCelula.AuthenticationTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;

import static br.com.duosdevelop.vb.apiTestCelula.constant.ApplicationConstant.*;

public class EstadoApiTest {

    private String accessToken;

    @Before
    public void setUp(){
        accessToken = AuthenticationTest.getAccessToken();
    }

    @Test
    public void estadosPostTest(){
        RestAssured.given()
                .header(AUTHORIZATION, BEARER +accessToken)
                .contentType(ContentType.JSON)
                .body("{\"nome\" : \"São Paulo\"}")
                .when()
                .post(BASE_URI+"/estados")
                .then()
                .statusCode(201);
    }

    @Test
    public void estadosGetTest(){
        RestAssured.given()
                .header(AUTHORIZATION, BEARER +accessToken)
                .when()
                .get(BASE_URI+"/estados")
                .then()
                .statusCode(200);
    }

    @Test
    public void estadosGetIdTest(){
        RestAssured.given()
                .header(AUTHORIZATION, BEARER +accessToken)
                .when()
                .get(BASE_URI+"/estados/1")
                .then()
                .statusCode(200);
    }

    @Test
    public void estadosGetIdNotFoundTest(){
        RestAssured.given()
                .header(AUTHORIZATION, BEARER +accessToken)
                .when()
                .get(BASE_URI+"/estados/11")
                .then()
                .statusCode(404);
    }
}
