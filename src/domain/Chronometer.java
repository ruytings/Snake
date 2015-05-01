package domain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class Chronometer extends StartableObject implements Subject {

	private static final int DELAY_IN_MILLISECONDS = 0;
	private int intervalInMilliseconds = 1;
	private java.util.Timer timer;
	private int time;
	
	private Set<Observer> observers = new HashSet<>();

	public Chronometer() {
	}
	
	public Chronometer(int interval) {
		setIntervalInMilliseconds(interval);
	}

	public void start() {
		setTime(0);
		run();
		super.start();
	}

	public void resume() {
		run();
		super.resume();
	}

	private void run() {
		if (timer != null) {
			timer.cancel();
		}
		timer = new Timer();
		timer.schedule(new Task(), DELAY_IN_MILLISECONDS,
				getIntervalInMilliseconds());
	}

	public void stop() {
		if (timer != null) {
			timer.cancel();
		}
		super.stop();
	}

	public int getTime() {
		return time;
	}

	private void setTime(int time) {
		this.time = time;
	}

	private class Task extends TimerTask {
		public void run() {
			setTime(getTime() + getIntervalInMilliseconds());
			try {
				notifyObservers();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public int getIntervalInMilliseconds() {
		return intervalInMilliseconds;
	}

	public void setIntervalInMilliseconds(int intervalInMilliseconds) { 
		this.intervalInMilliseconds = intervalInMilliseconds;
	}

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		Iterator<Observer> iterator = observers.iterator();
		while(iterator.hasNext()){
			Observer o = iterator.next();
			if(o.equals(observer)){
				iterator.remove();
			}
		}
	}

	@Override
	public void notifyObservers() {
		for(Observer o :observers){
			o.update();
		}
	}
}
