package in.strollup.app.config;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.google.gson.Gson;
import com.mongodb.WriteConcern;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;

/**
 * Created by jaiprakash on 28/12/16.
 */
@Configuration
@ComponentScan(value = { "in.strollup.entity", "in.strollup.repo", "in.strollup.service", "in.strollup.api",
		"in.strollup.app.context" })
@EnableMongoRepositories(basePackages = "in.strollup.repo.mongo", mongoTemplateRef = "mongoTemplate")
public class AppConfig {

	@Bean
	static Gson gson() {
		return new Gson();
	}

	@Bean({ "mongoTemplate" })
	public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory) throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory);
		mongoTemplate.setWriteConcern(WriteConcern.ACKNOWLEDGED);
		return mongoTemplate;
	}

	@Bean
	public GraphQLScalarType DateTime() {
		GraphQLScalarType dateTime = new GraphQLScalarType("DateTime", "DataTime scalar", new Coercing() {
			@Override
			public String serialize(Object input) {
				return ((ZonedDateTime) input).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
			}

			@Override
			public Object parseValue(Object input) {
				return serialize(input);
			}

			@Override
			public ZonedDateTime parseLiteral(Object input) {
				if (input instanceof StringValue) {
					return ZonedDateTime.parse(((StringValue) input).getValue());
				} else {
					return null;
				}
			}
		});
		return dateTime;
	}
}
