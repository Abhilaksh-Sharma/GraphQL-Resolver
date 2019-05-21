package practice.graphql.java.resolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.SchemaParser;

import graphql.execution.AsyncExecutionStrategy;
import graphql.execution.ExecutionStrategy;
import graphql.schema.GraphQLSchema;
import graphql.servlet.GraphQLServlet;
import graphql.servlet.SimpleGraphQLServlet;
import practice.graphql.java.resolver.resolver.MutationResolver;
import practice.graphql.java.resolver.resolver.QueryResolver;



@Component
public class GraphQLResolver {
	
	@Autowired
	QueryResolver queryResolver;

	@Autowired
	MutationResolver mutationResolver;
	
	@Bean
	public ServletRegistrationBean<GraphQLServlet> servletRegistrationBean() {
		GraphQLSchema schema = SchemaParser.newParser().resolvers(queryResolver, mutationResolver)
				.file("mySchema.graphqls").build().makeExecutableSchema();
		ExecutionStrategy executionStrategy = new AsyncExecutionStrategy();
		GraphQLServlet servlet = new SimpleGraphQLServlet(schema, executionStrategy);
		return new ServletRegistrationBean<>(servlet, "/graphql");
	}

}
