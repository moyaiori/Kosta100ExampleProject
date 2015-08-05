package kr.or.kosta.race;

public class RaceGame {

	public static void main(String[] args) {
		System.out.println("지금부터 경주마 게임을 시작합니다.");
		System.out.println("각 조별 경주마 입장...");
		System.out.println("준비~~~");
		Horse horse1 = new Horse("박래빈");
		Horse horse2 = new Horse("김현구");
		Horse horse3 = new Horse("유안상");
		Horse horse4 = new Horse("김기정");
		Horse horse5 = new Horse("손진영");
		Horse horse6 = new Horse("김동욱");
		System.out.println("땅~~~~~~~~~~~~~");
		
		horse1.start();
		horse2.start();
		horse3.start();
		horse4.start();
		horse5.start();
		horse6.start();
		
		try {
			horse1.join();
			horse2.join();
			horse3.join();
			horse4.join();
			horse5.join();
			horse6.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("경주마 게임이 종료 되었습니다.");
		
		
		
	}

}
