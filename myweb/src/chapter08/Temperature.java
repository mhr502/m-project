package chapter08;

public class Temperature {
	private double celsius;
	
	
	//celsius,fahrenheit
	
	public double getCelsius() {
		return celsius;
		}
	
	public void setCelsius(double celsius) {
		this.celsius=celsius;
	}
	
	//fahrenheit 프로퍼티는 읽기 전용이다.
	public double getFahrenheit() {
		return celsius *9.0/5.0+32.0;
	}

}
