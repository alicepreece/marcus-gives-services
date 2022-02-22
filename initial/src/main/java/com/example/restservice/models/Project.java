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
	private String region;
	private String aims;
	private String fundType;
	private String strategy;
	private String avoidedAreas;
	private String managementFees;
	private List<Integer> investors;
	private int total;

	public Project() {
	}

	public Project(String _id, int id, String name, String region, String aims, String fundType, String strategy, String avoidedAreas, String managementFees, List<Integer> investors, int total) {
		this._id = _id;
		this.id = id;
		this.name = name;
		this.region = region;
		this.aims = aims;
		this.fundType = fundType;
		this.strategy = strategy;
		this.avoidedAreas = avoidedAreas;
		this.managementFees = managementFees;
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

	public String getFundType() {
		return fundType;
	}

	public void setFundType(String fundType) {
		this.fundType = fundType;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

	public String getAvoidedAreas() {
		return avoidedAreas;
	}

	public void setAvoidedAreas(String avoidedAreas) {
		this.avoidedAreas = avoidedAreas;
	}

	public String getManagementFees() {
		return managementFees;
	}

	public void setManagementFees(String managementFees) {
		this.managementFees = managementFees;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Project project = (Project) o;
		return id == project.id &&
				total == project.total &&
				Objects.equals(name, project.name) &&
				Objects.equals(region, project.region) &&
				Objects.equals(aims, project.aims) &&
				Objects.equals(fundType, project.fundType) &&
				Objects.equals(strategy, project.strategy) &&
				Objects.equals(avoidedAreas, project.avoidedAreas) &&
				Objects.equals(managementFees, project.managementFees) &&
				Objects.equals(investors, project.investors);
	}

	@Override
	public int hashCode() {
		return Objects.hash(_id, id, name, region, aims, fundType, strategy, avoidedAreas, managementFees, investors, total);
	}

	@Override
	public String toString() {
		return "Project{" +
				"_id='" + _id + '\'' +
				", id=" + id +
				", name='" + name + '\'' +
				", region='" + region + '\'' +
				", aims='" + aims + '\'' +
				", fundType='" + fundType + '\'' +
				", strategy='" + strategy + '\'' +
				", avoidedAreas='" + avoidedAreas + '\'' +
				", managementFees='" + managementFees + '\'' +
				", investors=" + investors +
				", total=" + total +
				'}';
	}
}