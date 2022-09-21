
class Toyota {
	public void vehicleType()

	{
		System.out.println("Vehicle Type is Car");
	}
}

class Car extends Toyota {

	public void brand() {
		System.out.println("Brand is Toyota");
	}

	public void Model() {
		System.out.println("Model is Camry");
	}
}

public class Vehicles extends Car {

	public void color() {

		System.out.println("Color is Red");
	}

	public void speed() {
		System.out.println("Speed is 120kph");
	}

	public static void main(String args[]) {
		Vehicles car = new Vehicles();
		car.vehicleType();
		car.brand();
		car.Model();
		car.color();
		car.speed();
	}
}