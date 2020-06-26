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
    
    public static String getMembro(){
        return "{" +
                "\"nome\" : \"wlsdsdd\"," +
                "\"nascimento\" : \"12/04/1999\"," +
                "\"cpf\" : \"563.802.820-09\"," +
                "\"email\" : \"teste@teste.com\"," +
                "\"senha\" : \"teste123\"," +
                "\"telefone1\" : \"7323617273\"," +
                "\"endereco\" : {" +
                "\"rua\" : \"Rua fulano\"," +
                "\"numero\" : \"123\"," +
                "\"cep\" : \"872163871268\"," +
                "\"cidade\" : 2" +
                "}," +
                "\"ativo\" : true," +
                "\"batizado\" : true" +
                "}";
    }
}
