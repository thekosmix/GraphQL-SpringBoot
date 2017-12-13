package in.strollup.app.context;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.DefaultGraphQLErrorHandler;
import in.strollup.service.pojo.SanitizedError;

@Component
public class ErrorHandler extends DefaultGraphQLErrorHandler {
	@Override
	protected List<GraphQLError> filterGraphQLErrors(List<GraphQLError> errors) {
		return errors.stream().filter(e -> e instanceof ExceptionWhileDataFetching || super.isClientError(e)).map(
				e -> e instanceof ExceptionWhileDataFetching ? new SanitizedError((ExceptionWhileDataFetching) e) : e)
				.collect(Collectors.toList());
	}
}
