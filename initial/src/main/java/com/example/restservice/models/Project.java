package com.example.restservice.models;

import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.codecs.pojo.annotations.BsonRepresentation;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class Project {

	@BsonRepresentation(BsonType.OBJECT_ID)
	public String _id;
	private int id;
	private String name;
	private String region;
	private String aims;
	private String strategy;
	private List<String> investors;
	private int total;

	public Project() {}

	public Project(String _id, int id, String name, String region, String aims, String strategy, List<String> investors, int total) {
		this._id = _id;
		this.id = id;
		this.name = name;
		this.region = region;
		this.aims = aims;
		this.strategy = strategy;
		this.investors = investors;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAims() {
		return aims;
	}

	public void setAims(String aims) {
		this.aims = aims;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

	public List<String> getInvestors() {
		return investors;
	}

	public void setInvestors(List<String> investors) {
		this.investors = investors;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
