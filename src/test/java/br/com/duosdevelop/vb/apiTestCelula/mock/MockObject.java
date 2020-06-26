package br.com.duosdevelop.vb.apiTestCelula.mock;

public class MockObject {

    public static String getCelula(){
        return "{" +
                "\"nome\" : \"Mariana\"," +
                "\"lider\" : \"Ane\"," +
                "\"dia\" : 7," +
                "\"horario\" : \"14:00\"," +
                "\"endereco\" : {" +
                "\"rua\" : \"Rua fulano\"," +
                "\"numero\" : \"123\"," +
                "\"cep\" : \"872163871268\"," +
                "\"cidade\" : 1," +
                "\"estado\" : 1" +
                "}" +
                "}";
    }
}
