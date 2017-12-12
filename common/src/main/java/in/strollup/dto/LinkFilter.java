package in.strollup.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LinkFilter {
	@JsonProperty("description_contains")
	private String descriptionContains;

	@JsonProperty("url_contains")
	private String urlContains;
}