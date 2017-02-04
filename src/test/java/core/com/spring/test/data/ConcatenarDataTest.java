package core.com.spring.test.data;

import org.hamcrest.Matchers;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;
import org.junit.Assert;
import org.junit.Test;

public class ConcatenarDataTest {

	// int diaAtencedendiaFaturamento = 5;

	private Integer diasParametro = 5;

	@Test
	public void test() {
		// Caso 1 -
		// Vencimento 16/5
		// Dia previsto faturamento = 1
		// proximo fat 1/6
		// data limite 26/5
		// Vencimento no mes subsequente - Dia limite mes competencia
		Agenda caso1 = new Agenda(16,27,"A",1);

		// Caso 2 -
		// Vencimento 30/5
		// Dia previsto faturamento = 15
		// proximo fat 15/6
		// data limite 10/6
		// Vencimento no mes subsequente - Dia previsto mes subsequente

		Agenda caso2 = new Agenda(30,10,"S",15);

		DateTime dataUltimoFaturamentoCaso1 = new DateTime(2016,5,1,0,0);
		Assert.assertThat(getAgenda(caso1.getDiaVencimentoFatura(),caso1.getDiaPrevistoParaFaturamento(),dataUltimoFaturamentoCaso1),Matchers.equalTo(caso1));
		DateTime dataUltimoFaturamentoCaso2 = new DateTime(2016,5,1,0,0);
		Assert.assertThat(getAgenda(caso2.getDiaVencimentoFatura(),caso2.getDiaPrevistoParaFaturamento(),dataUltimoFaturamentoCaso2),Matchers.equalTo(caso2));

	}

	private Agenda getAgenda(Integer diaVencimentoFatura,Integer diaFaturamento,DateTime dataUltimoFaturamento) {
		Integer ultimoDiaDoMesDoProximoMesDeFaturamento = dataUltimoFaturamento.plus(Months.ONE).dayOfMonth().getMaximumValue();
		DateTime proximoDiaFaturamento = dataUltimoFaturamento.plus(Months.ONE).withDayOfMonth(diaFaturamento > ultimoDiaDoMesDoProximoMesDeFaturamento ? ultimoDiaDoMesDoProximoMesDeFaturamento : diaFaturamento);
		DateTime dataLimiteEnvioMovimento = proximoDiaFaturamento.minus(Days.days(diasParametro));
		String mesEnvioMovimentacao;
		if (dataLimiteEnvioMovimento.getMonthOfYear() < proximoDiaFaturamento.getMonthOfYear()) {
			mesEnvioMovimentacao = "A";
		} else {
			mesEnvioMovimentacao = "S";
		}
		Agenda agenda = new Agenda(diaVencimentoFatura,dataLimiteEnvioMovimento.getDayOfMonth(),mesEnvioMovimentacao,proximoDiaFaturamento.dayOfMonth().get());
		return agenda;
	}

}
