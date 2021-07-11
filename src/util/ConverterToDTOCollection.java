package util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 
 * @author Paulo Romano
 * @version 1.0
 * Classe para conversão de coleções entre 
 * uma Entidade e sua respectiva classe DTO
 */
public final class ConverterToDTOCollection {

	/**
	 * 
	 * @param <E> - Entidade origem que será convertida
	 * @param <R> - Collection destino para conversão
	 * @param collection - Collection de origem (Entidade)
	 * @param function - Function para aplicar a conversão
	 * entre a Entidade e sua respectiva classe DTO
	 * @param supplier - Implementação de Collection que será
	 * utilizada para armazenar os valores convertidos
	 * @return Collection do DTO
	 */
	public static <E, R> Collection<R> convertToCollection(
			Collection<E> collection, Function<E, R> function, 
			Supplier<Collection<R>> supplier) {

		return collection.stream().map(function::apply)
				.collect(Collectors.toCollection(supplier));
	}
	
	public static <E, R> List<R> convertToList(Collection<E> collection, 
			Function<E, R> function) {
		
		return (List<R>) convertToCollection(collection, 
				function, ArrayList::new);
	}
	
	public static <E, R> Set<R> convertToSet(Collection<E> collection, 
			Function<E, R> function) {
		
		return (Set<R>) convertToCollection(collection, 
				function, HashSet::new);
	}
	
	/**
	 * 
	 * @param <E> - Entidade origem que será convertida
	 * @param <R> - Collection destino para conversão
	 * @param collection - Collection de origem (Entidade)
	 * @param function - Function para aplicar a conversão
	 * entre a Entidade e sua respectiva classe DTO
	 * @param comparator - Comparator para ordenação da coleção
	 * @param supplier - Implementação de Collection que será
	 * utilizada para armazenar os valores convertidos
	 * @return Collection do DTO ordenado
	 */
	public static <E, R> Collection<R> convertToOrdenedCollection(
			Collection<E> collection, Function<E, R> function, 
			Comparator<E> comparator, Supplier<Collection<R>> supplier) {

		return collection.stream().sorted(comparator).map(function::apply)
				.collect(Collectors.toCollection(supplier));
	}
	
	public static <E, R> List<R> convertToOrdenedList(
			Collection<E> collection, Function<E, R> function,
			Comparator<E> comparator) {
		
		return (List<R>) convertToOrdenedCollection(collection, 
				function, comparator, ArrayList::new);
	}
}
