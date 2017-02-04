package core.com.spring.test.data;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Agenda {

	private Integer diaVencimentoFatura;
	private Integer diaLimiteEnvioMovimentacao;
	private String mesEnvioMovimentacao;
	private Integer diaPrevistoParaFaturamento;

	public Agenda(Integer diaVencimentoFatura,Integer diaLimiteEnvioMovimentacao,String mesEnvioMovimentacao,Integer diaPrevistoParaFaturamento) {
		super();
		this.diaVencimentoFatura = diaVencimentoFatura;
		this.diaLimiteEnvioMovimentacao = diaLimiteEnvioMovimentacao;
		this.mesEnvioMovimentacao = mesEnvioMovimentacao;
		this.diaPrevistoParaFaturamento = diaPrevistoParaFaturamento;
	}

	public Agenda() {
		super();
	}

	public Integer getDiaVencimentoFatura() {
		return diaVencimentoFatura;
	}

	public void setDiaVencimentoFatura(Integer diaVencimentoFatura) {
		this.diaVencimentoFatura = diaVencimentoFatura;
	}

	public Integer getDiaLimiteEnvioMovimentacao() {
		return diaLimiteEnvioMovimentacao;
	}

	public void setDiaLimiteEnvioMovimentacao(Integer diaLimiteEnvioMovimentacao) {
		this.diaLimiteEnvioMovimentacao = diaLimiteEnvioMovimentacao;
	}

	public String getMesEnvioMovimentacao() {
		return mesEnvioMovimentacao;
	}

	public void setMesEnvioMovimentacao(String mesEnvioMovimentacao) {
		this.mesEnvioMovimentacao = mesEnvioMovimentacao;
	}

	public Integer getDiaPrevistoParaFaturamento() {
		return diaPrevistoParaFaturamento;
	}

	public void setDiaPrevistoParaFaturamento(Integer diaPrevistoParaFaturamento) {
		this.diaPrevistoParaFaturamento = diaPrevistoParaFaturamento;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this,obj);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
