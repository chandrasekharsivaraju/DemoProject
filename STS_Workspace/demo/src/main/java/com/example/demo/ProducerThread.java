package com.example.demo;

public class ProducerThread extends Thread {
	
	CubyHole cubyHole;

	public ProducerThread(CubyHole cubyHole)
	{
		this.cubyHole = cubyHole;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("Prodcuer Thread Producing :: " + i);
			try {
				cubyHole.put(i);
				sleep(2000);
			} catch (InterruptedException e) {
			}
		}
	}
}


