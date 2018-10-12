package DaDaRent;

public class Car{
	String CarName;
	int rental;
	int capacity;
	public Car(){
		this.CarName = "***";
		this.rental = 0;
		this.capacity = 0;
	}
	public Car(String n, int r, int c){
		this.CarName = n;
		this.rental = r;
		this.capacity = c;
	}
	public class PassengerCar extends Car{
		public PassengerCar(){
			super();
		}
		public PassengerCar(String n, int r, int c){
			super(n, r, c);
		}
	}
	public class trucks extends Car{
		public trucks(){
			super();
		}
		public trucks(String n, int r, int c){
			super(n, r, c);
		}
	}
	public class Pickup extends Car{
		public Pickup(){
			super();
		}
		public Pickup(String n, int r, int c){
			super(n, r, c);
		}
	}
}