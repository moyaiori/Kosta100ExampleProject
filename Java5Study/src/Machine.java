
public class Machine {
	
	public void move(Direction direction){
		switch (direction) {
		case WEST:
			System.out.println("서쪽 으로 갑니다.");
			break;
		case NORTH:
			System.out.println("북쪽 으로 갑니다.");
			break;
		case SOUTH:
			System.out.println("남쪽 으로 갑니다.");
			break;
		case EAST:
			System.out.println("동쪽 으로 갑니다.");
			break;
		}
	}
	
	public static void main(String[] args) {
		Machine machine = new Machine();
		machine.move(Direction.WEST);
		machine.move(Direction.EAST);
		
		Direction[] directions = Direction.values();
		
		for (int i = 0;  i < directions.length; i++) {
			System.out.println(directions[i]);
		}
		
		for (Direction direction : directions) {
			System.out.println(direction);
		}
		
		Direction d = Direction.valueOf("NORTH");
		
		System.out.println(d);
	}
	
	

}
