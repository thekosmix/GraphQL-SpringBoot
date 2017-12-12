package in.strollup.app.context;

import com.fasterxml.jackson.annotation.JsonIgnore;

import graphql.ExceptionWhileDataFetching;

public class ErrorHandler extends ExceptionWhileDataFetching {

	public ErrorHandler(ExceptionWhileDataFetching inner) {
		super(inner.getException());
	}

	@Override
	@JsonIgnore
	public Throwable getException() {
		return super.getException();
	}
}