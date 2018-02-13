package exercicio02;

public class NumberUtils {
	private int number;
	
	public NumberUtils(int number) {
		this.number = number;
	}
	
	public boolean isPair() {
		if (this.number % 2 == 0)
			return true;
		else
			return false;
	}
	
	public boolean isOdd() {
		if (!this.isPair())
			return true;
		else
			return false;
	}

	public boolean isPrime() {
		for (int i = 2; i <= this.number/2; i++) {
			if (this.number % i == 0){
				return false;
			}
		}
		return true;
	}
	
	public String printCount() {
		String count = "";
		for (int i = 0; i < this.number; i++) {
			count += i+", ";
		}
		return count+this.number;
	}
	
	public String reversePrintCount() {
		String count = "";
		for (int i = this.number; i > 0; i--) {
			count += i + ", ";
		}
		return count+0;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}	
}
