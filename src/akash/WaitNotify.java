/**
 * Akash Anjanappa -Java threads wait and notify
 * 16 March 2017
 * checkout :  http://howtodoinjava.com/core-java/multi-threading/how-to-work-with-wait-notify-and-notifyall-in-java/
 */
package akash;

import java.util.ArrayList;

public class WaitNotify {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList();
		int maxSize = 5;
		
		Thread producer = new Thread(new Producer(list,maxSize),"Producer");
		Thread consumer = new Thread(new Consumer(list, maxSize),"Consumer");
		
		producer.start();
		consumer.start();
	}
}

class Producer implements Runnable {
	
	ArrayList<Integer> produceList;
	int MAX_SIZE;
	int count = 0;

	Producer(ArrayList<Integer> list,int maxSize){
		this.produceList = list;
		this.MAX_SIZE = maxSize;
	}
	
	@Override
	public void run() {
	 while(true){
		 try {
			 produce();
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	 }
		
	}
	
	void produce() throws InterruptedException{
		synchronized (produceList) {
			while(produceList.size() == MAX_SIZE){
				System.out.println("Producer Waiting, queue is full..");
				produceList.wait();
			}
			produceList.add(++count);
			System.out.println("Produced and put into list:"+count);
			produceList.notify();	
		}
	}
}

class Consumer implements Runnable{
	ArrayList<Integer> consumeList;
	int MAX_SIZE;
	int value;
	
	Consumer(ArrayList<Integer> list,int maxSize){
		this.consumeList = list;
		this.MAX_SIZE = maxSize;
	}
	
	
	public void run(){
		while(true){
			try{
				consume();
				Thread.sleep(1100);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
	}
	
	void consume() throws InterruptedException{
		synchronized(consumeList){
			while(consumeList.isEmpty()){
				System.out.println("Consumer waiting for list to be filled!!");
				consumeList.wait();
			}
			value = consumeList.remove(0);
			System.out.println("Consumed object of value:"+value);
			consumeList.notify();
		}				
	}
}
