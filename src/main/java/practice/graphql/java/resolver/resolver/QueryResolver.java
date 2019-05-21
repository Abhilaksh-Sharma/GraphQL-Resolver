package practice.graphql.java.resolver.resolver;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import practice.graphql.java.resolver.model.GraphQLModel;
import practice.graphql.java.resolver.repo.GraphQLRepository;

@Component
public class QueryResolver implements GraphQLQueryResolver {

	@Autowired
	GraphQLRepository graphQLRepository;

	public List<GraphQLModel> models() {
		return graphQLRepository.findAll();
	}

	public Optional<GraphQLModel> modelById(Integer id) {
		return graphQLRepository.findById(id);
	}
	
	public List<GraphQLModel> modelByName(String name) {
		return graphQLRepository.findByName(name);
	}
	
	public List<GraphQLModel> modelByCost(Integer cost) {
		return graphQLRepository.findByCost(cost);
	}
	
	public List<GraphQLModel> modelByFlag(Boolean flag) {
		return graphQLRepository.findByFlag(flag);
	}

}
