/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test.exception;

/**
 *
 * @author Nilton Fernando
 */
public enum ExceptionMessages {
    ERRO_AO_LOGIN("login.erro"),
    SUCESSO_LOGIN("login.sucesso"),
    LOGIN_ACENTO("login.acento"),
    NOME_INVALIDO("nome.invalido")
    ;
    private final String value;
    
    private ExceptionMessages(String value) {
        this.value= value;
    }

    public String getValue() {
        return value;
    }
    
}
