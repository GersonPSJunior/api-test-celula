package br.com.duosdevelop.vb.apiTestCelula.api;

import br.com.duosdevelop.vb.apiTestCelula.AuthenticationTest;
import br.com.duosdevelop.vb.apiTestCelula.mock.MockObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;

import static br.com.duosdevelop.vb.apiTestCelula.constant.ApplicationConstant.*;

public class CelulasApiTest {

    private String accessToken;

    @Before
    public void setUp(){
        accessToken = AuthenticationTest.getAccessToken();
    }

    @Test
    public void celulasPostTest(){
        RestAssured.given()
                .header(AUTHORIZATION, BEARER +accessToken)
                .contentType(ContentType.JSON)
                .body(MockObject.getCelula())
                .when()
                .post(BASE_URI+"/celulas")
                .then()
                .statusCode(201);
    }

    @Test
    public void celulasGetTest(){
        RestAssured.given()
                .when()
                .get(BASE_URI+"/celulas")
                .then()
                .statusCode(200);
    }
}
