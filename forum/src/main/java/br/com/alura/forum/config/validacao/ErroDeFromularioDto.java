package br.com.alura.forum.config.validacao;

public class ErroDeFromularioDto {
    private String campo;
    private String erro;

    public ErroDeFromularioDto(String campo, String erro) {
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
