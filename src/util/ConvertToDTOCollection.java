package util;

import java.util.ArrayList;
import java.util.Collection;
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
public final class ConvertToDTOCollection {

	/**
	 * 
	 * @param <E> - Entidade que será convertida
	 * @param <R> - Collection do DTO após a conversão
	 * da Entidade
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
}
