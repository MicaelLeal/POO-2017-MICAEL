package app;

import exceptions.SaldoInsuficienteException;
import model.*;

public class Main {
	public static void main(String[] args) {
		Conta conta = new ContaPoupanca();
		
		try {
			conta.deposita(100);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			conta.saca(101);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
