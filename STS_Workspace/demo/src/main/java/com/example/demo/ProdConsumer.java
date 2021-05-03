package com.example.demo;

public class ProdConsumer {

	public static void main(String[] args)  {

		CubyHole cubyHole = new CubyHole();
		ProducerThread producerThread = new ProducerThread(cubyHole);
		ConsumerThread consumerThread = new ConsumerThread(cubyHole);
		
		producerThread.start();
		consumerThread.start();
		
	}
}
