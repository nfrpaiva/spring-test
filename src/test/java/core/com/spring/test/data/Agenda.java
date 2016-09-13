package core.com.spring.test.data;

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
		final int prime = 31;
		int result = 1;
		result = prime * result + ( (diaLimiteEnvioMovimentacao == null) ? 0 : diaLimiteEnvioMovimentacao.hashCode());
		result = prime * result + ( (diaPrevistoParaFaturamento == null) ? 0 : diaPrevistoParaFaturamento.hashCode());
		result = prime * result + ( (diaVencimentoFatura == null) ? 0 : diaVencimentoFatura.hashCode());
		result = prime * result + ( (mesEnvioMovimentacao == null) ? 0 : mesEnvioMovimentacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (diaLimiteEnvioMovimentacao == null) {
			if (other.diaLimiteEnvioMovimentacao != null)
				return false;
		} else if (!diaLimiteEnvioMovimentacao.equals(other.diaLimiteEnvioMovimentacao))
			return false;
		if (diaPrevistoParaFaturamento == null) {
			if (other.diaPrevistoParaFaturamento != null)
				return false;
		} else if (!diaPrevistoParaFaturamento.equals(other.diaPrevistoParaFaturamento))
			return false;
		if (diaVencimentoFatura == null) {
			if (other.diaVencimentoFatura != null)
				return false;
		} else if (!diaVencimentoFatura.equals(other.diaVencimentoFatura))
			return false;
		if (mesEnvioMovimentacao == null) {
			if (other.mesEnvioMovimentacao != null)
				return false;
		} else if (!mesEnvioMovimentacao.equals(other.mesEnvioMovimentacao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agenda [diaVencimentoFatura=" + diaVencimentoFatura + ", diaLimiteEnvioMovimentacao=" + diaLimiteEnvioMovimentacao + ", mesEnvioMovimentacao=" + mesEnvioMovimentacao + ", diaPrevistoParaFaturamento=" + diaPrevistoParaFaturamento + "]";
	}

}
