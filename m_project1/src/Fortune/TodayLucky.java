package fortune;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TodayLucky {
	public static void main(String[] args) {
		Date date = new Date();// Date 클래스의 객체 생성
		SimpleDateFormat dateForm = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		// 오늘 날짜를 어떻게 표현할 것인가를 결정해주는 출력 형식

		Random r = new Random(); // Random클래스의 객체 생성
		int randomNum = r.nextInt(101); // 101미만의 수를 랜덤으로 나오게 함

		System.out.println("현재:" + dateForm.format(date) + "\t금전운:" + randomNum + "%");
		if (randomNum > 90) {
			System.out.println("복권 한번 사보세요!");
		}

	}
}
