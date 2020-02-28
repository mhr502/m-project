package chapter07.polymophism.section773;

import chapter07.polymophism.section772.HanKookTire;

public class CarExample {
	public static void main(String[] args) {
		Car car = new Car();
		
		for(int i=1;i<=5;i++) {
			int problemLocation = car.run();
			if(problemLocation !=0) {
				System.out.println(car.tires[problemLocation-1].location+ " HanKookTire으로 교체");
				car.tires[problemLocation-1] =
						new HanKookTire(car.tires[problemLocation-1].location,15);
				
			}
			System.out.println("---------------------------------");
		}
	}
}
