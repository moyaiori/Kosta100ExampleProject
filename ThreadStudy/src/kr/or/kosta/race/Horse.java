package kr.or.kosta.race;

import java.util.Random;

public class Horse extends Thread {
	
	public Horse(String name){
		super(name);
	}
	
	public void race(){
		Random random = new Random();
		System.out.println(getName() + " 경주마 출발!!!!!!!");
		for (int i = 1; i < 100; i++) {
			System.out.println(getName() + " 경주마 " + i + " 미터 전진...");
			try {
				Thread.sleep(random.nextInt(500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(getName() + " 경주마 경주중 사망...");
			}
		}
		System.out.println(getName() + " 경주마 결승점 통과>>>>>>>>>>>>>>>>>>");
	}
	
	@Override
	public void run() {
		race();
	}
}
