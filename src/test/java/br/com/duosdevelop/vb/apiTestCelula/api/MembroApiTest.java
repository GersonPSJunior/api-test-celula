package br.com.duosdevelop.vb.apiTestCelula.api;

import br.com.duosdevelop.vb.apiTestCelula.AuthenticationTest;
import br.com.duosdevelop.vb.apiTestCelula.mock.MockObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;

import static br.com.duosdevelop.vb.apiTestCelula.constant.ApplicationConstant.*;

public class MembroApiTest {

    private String accessToken;

    @Before
    public void setUp(){
        accessToken = AuthenticationTest.getAccessToken();
    }

    @Test
    public void membrosPostTest(){
        RestAssured.given()
                .header(AUTHORIZATION, BEARER +accessToken)
                .contentType(ContentType.JSON)
                .body(MockObject.getMembro())
                .when()
                .post(BASE_URI+"/membros")
                .then()
                .statusCode(201);
    }

    @Test
    public void membrosGetTest(){
        RestAssured.given()
                .header(AUTHORIZATION, BEARER +accessToken)
                .when()
                .get(BASE_URI+"/membros")
                .then()
                .statusCode(200);
    }

    @Test
    public void membrosGetAtivoBatizadoTest(){
        RestAssured.given()
                .header(AUTHORIZATION, BEARER +accessToken)
                .param("ativo", "sim")
                .param("batizado", "sim")
                .when()
                .get(BASE_URI+"/membros")
                .then()
                .statusCode(200);
    }

    @Test
    public void membrosGetIdTest(){
        RestAssured.given()
                .header(AUTHORIZATION, BEARER +accessToken)
                .when()
                .get(BASE_URI+"/membros/1")
                .then()
                .statusCode(200);
    }

    @Test
    public void membrosGetIdNotFoundTest(){
        RestAssured.given()
                .header(AUTHORIZATION, BEARER +accessToken)
                .when()
                .get(BASE_URI+"/membros/-1")
                .then()
                .statusCode(404);
    }
}
