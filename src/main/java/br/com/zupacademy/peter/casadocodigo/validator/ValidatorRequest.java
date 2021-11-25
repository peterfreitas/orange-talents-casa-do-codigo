package br.com.zupacademy.peter.casadocodigo.validator;

public class ValidatorRequest {

    private String campo;
    private String erro;

    public ValidatorRequest(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }



}
