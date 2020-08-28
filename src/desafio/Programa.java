package desafio;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Programa {

	public static void main(String[] args) {
		List<Produto> produtos = new ArrayList<>();
		List<Cliente> clientes = new ArrayList<>();
		List<Compra> compras = new ArrayList<>();
		
		Consumer<String> println = nome -> System.out.println(nome);
		Consumer<Produto> printlnP = prod -> System.out.println(prod);
		
/*------------------------------- Lists -------------------------------------*/
		
		produtos.add(new Produto ("Computador", 2500.00));
		produtos.add(new Produto ("Celular", 1900.00));
		produtos.add(new Produto ("Tablet", 1500.00));
		produtos.add(new Produto ("Televisão", 990.00));
		produtos.add(new Produto ("Aquecedor", 370.00));
		produtos.add(new Produto ("Notebook", 3500.00));
		
		
		clientes.add(new Cliente ("Nemo", 000));
		clientes.add(new Cliente ("Anna", 001));
		clientes.add(new Cliente ("Elise", 002));
		clientes.add(new Cliente ("Jean", 003));
		
		compras.add(new Compra (produtos.get(0), clientes.get(1)));
		compras.add(new Compra (produtos.get(2), clientes.get(2)));
		compras.add(new Compra (produtos.get(4), clientes.get(1)));
		compras.add(new Compra (produtos.get(5), clientes.get(3)));
		
/*------------------------------- filtro de preços -------------------------------------*/		
		produtos.stream()
			.filter(prod -> prod.preco > 1000)
			.forEach(printlnP);
		
		System.out.println("");
		
/*------------------------------- Mapa por nomes -------------------------------------*/
		clientes.stream()
			.map(cliente -> cliente.nome)
			.forEach(println);
		
		System.out.println("");
		
/*------------------------------- Valor total em vendas -------------------------------------*/		
		compras.stream()
			.map(compra -> compra.prod.preco)
			.reduce((total, atual) -> total + atual)
			.ifPresent(System.out::println);
		
		System.out.println("");
		
/*------------------------------- Valor em vendas para cliente 1 -------------------------------------*/
		compras.stream()
			.filter(compra -> compra.cliente.nome.equals("Anna"))
			.map(compra -> compra.prod.preco)
			.reduce((total, atual) -> total + atual)
			.ifPresent(System.out::println);
	}

}
