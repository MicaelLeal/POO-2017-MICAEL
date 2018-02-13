package exercicio04;

public class Main {
	public static void main(String[] args) {
		// Questão 03.
		Senha senha = new Senha("Micael23");
		System.out.println((senha.iguaisTrim(" Micael23")) ? "Iguais" : "Diferentes");
		System.out.println((senha.tamanhoSeguro()) ? "Senha forte" : "Senha fraca");
		System.out.println((senha.posuiMaiusculaMinuscula()) ? "Maiusculas e minusclulas" : "Nao contem maiusculas e minusculas");
		System.out.println((senha.posuiNumeo() ? "Possui numero" : "Nao possui numero"));
		System.out.println((senha.ehValida()) ? "Senha valida" : "Senha invalida");
		System.out.println();
		
		// Questão 04.
		Pilha pilha = new Pilha();
		for (int i = 1; i <= 5; i++)
			pilha.empilhar(i);
		System.out.println(pilha.estaCheia() ? "Pilha cheia" : "Ha espaco");
		pilha.desempilhar();
		System.out.println("Ultimo valor: "+ pilha.retornaTopo());
		System.out.println("Valores: "+ pilha.exibir());
		System.out.println();
		
		// Questão 05.
		Banco banco = new Banco(10);
		Conta conta1 = new Conta("111", 50.00);
		Conta conta2 = new Conta("222", 100.00);
		banco.inserir(conta1);
		banco.inserir(conta2);
		banco.debitar(conta1.getNumero(), 10.00); 
		Conta conta3 = banco.consultar("111");
		System.out.println("Numero: "+ conta3.getNumero() +"\n"
				+"Saldo: "+ conta3.getSaldo());
		System.out.println("Saldo media do banco: "+ banco.mediaSaldos() +"\n");
		
		// Questão 06.
		MicroBlog blog = new MicroBlog(10);
		Postagem postagem1 = new Postagem(1);
		Postagem postagem2 = new Postagem(2);
		postagem1.setTexto("Postagem do objeto postagem1.");
		postagem2.setTexto("Postagem do objeto postagem2.");
		
		blog.novaPostagem(postagem1);
		blog.novaPostagem(postagem2);
		
		blog.curtirPostagem(1);
		
		System.out.println(blog.pegarPostagemMaisCurtida());
		
		// Questao 07.
		ParametroArgs asdf = new ParametroArgs(args);
		asdf.ordena();

	}
}
