
public class MenuItem {
		private String name;
		private double price;
		private int calorie;
		
		public MenuItem(String _name, double _price, int _calorie) {
			name = _name;
			price = _price;
			calorie = _calorie;
		}

		public MenuItem(String _name, double _price) {
			name = _name;
			price = _price;
		}
		public String getName() {
			return name;
		}
		
		public double getPrice() {
			return price;
		}
		
		public int getCalorie() {
			return calorie;
		}
		public double increasePrice(double percent) {
			price = price + (percent/100)*price;
			return price;
		}
		
}
