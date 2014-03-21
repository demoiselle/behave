package br.gov.serpro.treino.business;

import br.gov.framework.demoiselle.core.layer.IBusinessController;

public interface IChartBC extends IBusinessController {

	public byte[] getChartLine90(Long idScenario);

	public byte[] getChartError(Long idScenario);
	
	public byte[] getChartTimes(Long idScenario);

	public byte[] getChartMon(Long idResource, Long idExecution);

	public void cleanCharts();

	public byte[] getChartFeedbackAnswers();

	public byte[] getChartFeedbackTotals();

	public byte[] getChartFeedbackTotalProjects();
	
	public byte[] getChartFeedbackAvgAnswers();

	
	
}
