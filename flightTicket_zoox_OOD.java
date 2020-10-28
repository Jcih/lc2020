Class Solution {

	public static main (String[] args) {
		List<String> input = new ArrayList<>(
		"United 150 Premium",
		"AirlineB 100 Economy",
		"AirlineC 200 Business");

		//implement your codes


		for (String str : input) {
            String[] splits = str.split(" ");
            String brand = splits[0];
            double miles = Double.parseDouble(splits[1]);//need convert
            String seat_class = splits[2];

            Operation operation = OperationFactory.createOperation(brand, miles, seat_class);

            System.out.println(operation.calculate());
		}
	}


	public static class OperationFactory {


	    public static Operation createOperation(String brand, double miles, String seat_class) {
			Operation operation_obj = null;
			switch(brand) {
			    case "United":
			        operation_ojb = new United(miles, seat_class);
			        break;
			    case "AirlineB":
			        operation_ojb = new AirlineB(miles, seat_class);
			        break;
				case "AirlineC":
			        operation_ojb = new AirlineC(miles, seat_class);
			        break;

			}
			return operation_obj;
			}
	}


	public interface Operation {
		public double calculate();
	}

	public class United implements Operation {
		private double miles;
		private String seat_class;

		public United(double miles, String seat_class) {
			this.miles = miles;
			this.seat_class = seat_class;

		}

        @Override
		public double calculate() {
			double price = 0;

			price = formulaA;

			return price;
		} 
	}


	public class AirlineB implements Operation {
		private double miles;
		private String seat_class;

		public AirlineB(double miles, String seat_class) {
			this.miles = miles;
			this.seat_class = seat_class;

		}

        @Override
		public double calculate() {
			double price = 0;

			price = formulaB;

			return price;
		} 
	}


	public class AirlineC implements Operation {
		private double miles;
		private String seat_class;

		public AirlineC (double miles, String seat_class) {
			this.miles = miles;
			this.seat_class = seat_class;

		}

        @Override
		public double calculate() {
			double price = 0;

			price = formulaC;

			return price;
		} 
	}
}
