package com.example.restservice.models;

import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonRepresentation;

import java.util.List;
import java.util.Objects;

public class Project {

	@BsonRepresentation(BsonType.OBJECT_ID)
	public String _id;
	private int id;
	private String name;
	private String goal;
	private int total;
	private String region;
	private String aims;
	private String strategy;
	private String fees;
	private List<Integer> investors;
	private Scores scores;

	public Project() {
	}

	public Project(int id, String name, String goal, int total, String region, String aims, String strategy, String fees, List<Integer> investors, Scores scores) {
		this.id = id;
		this.name = name;
		this.goal = goal;
		this.total = total;
		this.region = region;
		this.aims = aims;
		this.strategy = strategy;
		this.fees = fees;
		this.investors = investors;
		this.scores = scores;
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

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) { this.goal = goal;}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

	public String getFees() {
		return fees;
	}

	public void setFees(String managementFees) {
		this.fees = managementFees;
	}

	public List<Integer> getInvestors() {
		return investors;
	}

	public void setInvestors(List<Integer> investors) {
		this.investors = investors;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Scores getScores() { return scores; }

	public void setScores(Scores scores) { this.scores = scores; }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Project project = (Project) o;
		return id == project.id &&
				total == project.total &&
				Objects.equals(name, project.name) &&
				Objects.equals(goal, project.goal) &&
				Objects.equals(region, project.region) &&
				Objects.equals(aims, project.aims) &&
				Objects.equals(strategy, project.strategy) &&
				Objects.equals(fees, project.fees) &&
				Objects.equals(investors, project.investors) &&
				Objects.equals(scores, project.scores);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, goal, total, region, aims, strategy, fees, investors, scores);
	}

	@Override
	public String toString() {
		return "Project{" +
				", id=" + id +
				", name='" + name + '\'' +
				", goal='" + goal + '\'' +
				", total=" + total +
				", region='" + region + '\'' +
				", aims='" + aims + '\'' +
				", strategy='" + strategy + '\'' +
				", fees='" + fees + '\'' +
				", investors=" + investors +
				", scores=" + scores +
				'}';
	}
}