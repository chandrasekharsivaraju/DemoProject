package com.example.demo;

public class ConsumerThread extends Thread {

	CubyHole cubyHole;

	public ConsumerThread(CubyHole cubyHole) {
		this.cubyHole = cubyHole;
	}

	@Override
	public void run() {
		try {
			for (int i = 1; i <= 10; i++) {
				System.out.println("Consumer Thread Consuming :: " + cubyHole.get());
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
		}
	}

}

