package fluxos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {
//		Stream<String> nomes = Stream.of("Carlos", "Agnys", "Ruan", "Laura");
//		
//		List<String> outrosNomes = Arrays.asList("Weronika", "Pedro", "Luana");
//		Stream<String> streamOutrosNomes = outrosNomes.stream();
//		
//		Consumer<String> println = nome -> System.out.println(nome);
//		
//		nomes.forEach(println);
//		streamOutrosNomes.forEach(println);
		
		UnaryOperator<Double> aplicarDesconto = preco -> preco * (1 - 0.1); 
		Consumer<Double> println = preco -> System.out.println(preco);
		List<Produto> produtos = new ArrayList<>();
		Predicate<Double> baratos = preco -> preco < 1500;
		Predicate<Double> caros = preco -> preco > 2000;
		
		produtos.add(new Produto ("Computador", 2500.00));
		produtos.add(new Produto ("Celular", 1900.00));
		produtos.add(new Produto ("Tablet", 1500.00));
		produtos.add(new Produto ("Notebook", 3500.00));
		
		Stream<Produto> streamProdutos = produtos.stream();
		
//		produtos.stream()
//			.map(prod -> prod.preco)
//			.map(aplicarDesconto)
//			.forEach(println); //aqui é permitido usar mais de uma vez, pois é uma stream diferente, declarada em tempo de execução
		
		/*Stream <Double> precoComDesconto = streamProdutos
				.map(prod -> prod.preco)
				.map(aplicarDesconto)
				.filter(baratos);
		
		precoComDesconto.forEach(println);*/
		
		double precoComDesconto = streamProdutos
				.map(prod -> prod.preco)
				.map(aplicarDesconto)
				.filter(baratos)
				.reduce(0.0, (total, atual) -> total + atual);
		
		System.out.println(precoComDesconto);
		
		/*streamProdutos
		.map(prod -> prod.preco)
		.map(aplicarDesconto)
		.map(aplicarDesconto)
		.forEach(println);
								//não é possível usar uma mesma stream duas vezes, se ela já recebeu um terminal
		streamProdutos
		.map(prod -> prod.preco)
		.map(aplicarDesconto)
		.forEach(println); */
	}

}
