package com.dg.android.syncnotes.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Note {

	@JsonProperty(value = "created_at")
	String createdAt;
	@JsonProperty
	String description;
	@JsonProperty
	String id;
	@JsonProperty
	String name;
	@JsonProperty
	String title;
	@JsonProperty(value = "updated_at")
	String updatedAt;

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Note [createdAt=");
		builder.append(createdAt);
		builder.append(", description=");
		builder.append(description);
		builder.append(", id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", title=");
		builder.append(title);
		builder.append(", updatedAt=");
		builder.append(updatedAt);
		builder.append("]");
		return builder.toString();
	}

}
