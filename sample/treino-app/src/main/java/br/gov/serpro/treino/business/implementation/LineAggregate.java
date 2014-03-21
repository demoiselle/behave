package br.gov.serpro.treino.business.implementation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LineAggregate {

	private String label;
	private List<Long> times;
	private Long count;
	private Long countTime;
	private Long countBytes;
	private Long countError;
	private Long min;
	private Long max;

	public LineAggregate(String label) {
		this.label = label;
		times = new ArrayList<Long>();
		count = 0L;
		countTime = 0L;
		countError = 0L;
		countBytes = 0L;
		min = Long.MAX_VALUE;
		max = Long.MIN_VALUE;
	}

	public void add(Long time, boolean error, Long bytes) {
		if (max < time) {
			max = time;
		}
		if (min > time) {
			min = time;
		}
		if (error) {
			countError++;
		}
		times.add(time);
		countTime = countTime + time;
		countBytes = countBytes + bytes;
		count++;

	}

	public String getLabel() {
		return label;
	}

	public Long getCount() {
		return count;
	}

	public Long getAvg() {
		if (count == 0) {
			return 0L;
		}
		return countTime / count;
	}

	public Long getLine90() {
		return getPercentil(0.9);
	}

	public Long getMin() {
		return min;
	}

	public Long getMax() {
		return max;
	}

	public Long getMedian() {
		return getPercentil(0.5);
	}

	private Long getPercentil(Double percentil) {
		Collections.sort(times, new LongComparable());
		BigDecimal bd = new BigDecimal((times.size() - 1) * percentil);
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_DOWN);
		int index = (int) bd.doubleValue();
		return times.get(index);
	}

	private class LongComparable implements Comparator<Long> {
		public int compare(Long o1, Long o2) {
			return o1.compareTo(o2);
		}
	}

	public Double getError() {
		if (count == 0) {
			return 0.0;
		}
		return (Float.parseFloat(countError.toString()) / Float.parseFloat(count.toString())) * 100.0;
	}

	public Double getRate() {
		if (countTime == 0) {
			return 0.0;
		}
		return count / (countTime / 1000.0);
	}

	public Double getBandwidth() {
		if (countTime == 0) {
			return 0.0;
		}
		return (countBytes / 1024.0) / (countTime / 1000.0);
	}

	public Long getTime() {
		return countTime;
	}
}