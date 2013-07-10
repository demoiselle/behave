package br.gov.frameworkdemoiselle.behave.runner.webdriver.util;

public class Timer {
	private static Timer instance;
	private long start;
	private long end;

	public Timer() {
		reset();
	}

	public static Timer getInstance() {
		if (instance == null) {
			instance = new Timer();
		}
		return instance;
	}

	public void start() {
		start = getCurrentTime();
	}

	public void end() {
		end = getCurrentTime();
	}

	private long getCurrentTime() {
		return System.currentTimeMillis();
	}

	public long duration() {
		return (end - start);
	}

	public long getTimeElapsed() {
		return getCurrentTime() - getStart();
	}

	public void reset() {
		start = 0;
		end = 0;
	}

	public long getStart() {
		return start;
	}

	public long getEnd() {
		return end;
	}

}
