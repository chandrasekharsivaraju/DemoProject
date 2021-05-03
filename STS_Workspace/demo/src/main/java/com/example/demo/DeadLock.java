package com.example.demo;

public class DeadLock {
	public static void main(String[] args) {
		
		Thread t = new Thread();
		t.start();
		ThreadDemo1 demo1 = new ThreadDemo1();
		ThreadDemo2 demo2 = new ThreadDemo2();
		demo1.start();
		demo2.start();
	}
}

class ThreadDemo1 extends Thread {
	public void run() {
		synchronized (String.class) {
			System.out.println("Thread 1: Holding lock String");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

			synchronized (Integer.class) {
				System.out.println("Thread 1: Holding lock Integer.");
			}
		}
	}
}

class ThreadDemo2 extends Thread {
	public void run() {
		synchronized (Integer.class) {
			System.out.println("Thread 2: Holding lock Integer");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

			synchronized (String.class) {
				System.out.println("Thread 2: Holding lock String");
			}
		}
	}
}
