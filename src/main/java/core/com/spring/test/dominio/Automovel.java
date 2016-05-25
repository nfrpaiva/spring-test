/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test.dominio;

import core.com.spring.test.validator.AnoFabricacaoMaiorQueAnoModelo;
import javax.validation.constraints.NotNull;

/**
 *
 * @author fernando
 */
@AnoFabricacaoMaiorQueAnoModelo
public class Automovel {

    @NotNull
    private Integer anoFabricacao;
    @NotNull
    private Integer anoModelo;

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

}
