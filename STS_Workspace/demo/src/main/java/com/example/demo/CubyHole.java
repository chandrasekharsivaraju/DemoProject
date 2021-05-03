package com.example.demo;

public class CubyHole {
	
	private Boolean isAvailable = false;
	private int value;

	public synchronized void put(int v) throws InterruptedException {
		while (isAvailable == true) {
			wait();
		}
		this.value = v;
		isAvailable = true;
		notifyAll();
	}

	public synchronized int get() throws InterruptedException {
		while (isAvailable == false) {
			wait();
		}
		isAvailable = false;
		notifyAll();
		return this.value;
	}
	
	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
}

