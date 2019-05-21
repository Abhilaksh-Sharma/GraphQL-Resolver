package practice.graphql.java.resolver.resolver;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import practice.graphql.java.resolver.model.GraphQLModel;
import practice.graphql.java.resolver.repo.GraphQLRepository;

@Component
public class MutationResolver implements GraphQLMutationResolver{
	
	@Autowired
	GraphQLRepository graphQLRepository;
	
	public GraphQLModel createModel(Integer id , String name , Integer cost , Boolean flag){
		return graphQLRepository.save(new GraphQLModel(id, name, cost, flag));
	}
	
	public Optional<GraphQLModel> deleteModel(Integer id) {
		Optional<GraphQLModel> graphQLModel = graphQLRepository.findById(id);
		graphQLRepository.deleteById(id);
		return  graphQLModel;
	}
	
	public GraphQLModel updateModel(Integer id , String name , Integer cost , Boolean flag) {
		return graphQLRepository.save(new GraphQLModel(id, name, cost, flag));
	}

}
