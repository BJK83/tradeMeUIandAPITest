package jSONDeserialize;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {

	String name;
	String number;
	String path;
	ArrayList<Category> subcategories;
	boolean hasClassifieds;
	int areaOfBusiness;
	boolean isLeaf;
	int count;
	boolean IsRestricted;
	boolean hasLegalNotice;
	boolean canHaveSecondCategory;
	boolean canBeSecondCategory;

	@JsonProperty("Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("Number")
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@JsonProperty("Path")
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@JsonProperty("Subcategories")
	public ArrayList<Category> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(ArrayList<Category> subcategories) {
		this.subcategories = subcategories;
	}

	@JsonProperty("HasClassifieds")
	public boolean isHasClassifieds() {
		return hasClassifieds;
	}

	public void setHasClassifieds(boolean hasClassifieds) {
		this.hasClassifieds = hasClassifieds;
	}

	@JsonProperty("AreaOfBusiness")
	public int getAreaOfBusiness() {
		return areaOfBusiness;
	}

	public void setAreaOfBusiness(int areaOfBusiness) {
		this.areaOfBusiness = areaOfBusiness;
	}

	@JsonProperty("IsLeaf")
	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	@JsonProperty("Count")
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@JsonProperty("IsRestricted")
	public boolean isIsRestricted() {
		return IsRestricted;
	}

	public void setIsRestricted(boolean isRestricted) {
		IsRestricted = isRestricted;
	}

	@JsonProperty("HasLegalNotice")
	public boolean isHasLegalNotice() {
		return hasLegalNotice;
	}

	public void setHasLegalNotice(boolean hasLegalNotice) {
		this.hasLegalNotice = hasLegalNotice;
	}

	@JsonProperty("CanHaveSecondCategory")
	public boolean isCanHaveSecondCategory() {
		return canHaveSecondCategory;
	}

	public void setCanHaveSecondCategory(boolean canHaveSecondCategory) {
		this.canHaveSecondCategory = canHaveSecondCategory;
	}

	@JsonProperty("CanBeSecondCategory")
	public boolean isCanBeSecondCategory() {
		return canBeSecondCategory;
	}

	public void setCanBeSecondCategory(boolean canBeSecondCategory) {
		this.canBeSecondCategory = canBeSecondCategory;
	}

}
