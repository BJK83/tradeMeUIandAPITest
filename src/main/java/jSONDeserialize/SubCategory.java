package jSONDeserialize;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

	
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubCategory {
//	
//	String name;
//	String number;
//	String path;
//	int count;
//	boolean IsRestricted;
//	boolean hasLegalNotice;
//	boolean hasClassifieds;
//	int areaOfBusiness;
//	boolean canHaveSecondCategory;
//	boolean canBeSecondCategory;
//	boolean isLeaf;
//
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getNumber() {
//		return number;
//	}
//	public void setNumber(String number) {
//		this.number = number;
//	}
//	public String getPath() {
//		return path;
//	}
//	public void setPath(String path) {
//		this.path = path;
//	}
//
//	public int getCount() {
//		return count;
//	}
//	public void setCount(int count) {
//		this.count = count;
//	}
//	public boolean isIsRestricted() {
//		return IsRestricted;
//	}
//	public void setIsRestricted(boolean isRestricted) {
//		IsRestricted = isRestricted;
//	}
//	public boolean isHasLegalNotice() {
//		return hasLegalNotice;
//	}
//	public void setHasLegalNotice(boolean hasLegalNotice) {
//		this.hasLegalNotice = hasLegalNotice;
//	}
//	public boolean isHasClassifieds() {
//		return hasClassifieds;
//	}
//	public void setHasClassifieds(boolean hasClassifieds) {
//		this.hasClassifieds = hasClassifieds;
//	}
//	public int getAreaOfBusiness() {
//		return areaOfBusiness;
//	}
//	public void setAreaOfBusiness(int areaOfBusiness) {
//		this.areaOfBusiness = areaOfBusiness;
//	}
//	public boolean isCanHaveSecondCategory() {
//		return canHaveSecondCategory;
//	}
//	public void setCanHaveSecondCategory(boolean canHaveSecondCategory) {
//		this.canHaveSecondCategory = canHaveSecondCategory;
//	}
//	public boolean isCanBeSecondCategory() {
//		return canBeSecondCategory;
//	}
//	public void setCanBeSecondCategory(boolean canBeSecondCategory) {
//		this.canBeSecondCategory = canBeSecondCategory;
//	}
//	public boolean isLeaf() {
//		return isLeaf;
//	}
//	public void setLeaf(boolean isLeaf) {
//		this.isLeaf = isLeaf;
//	}


@JsonProperty("Name")
public String getName() {
	return this.name;
}

public void setName(String name) {
	this.name = name;
}

String name;

@JsonProperty("Number")
public String getNumber() {
	return this.number;
}

public void setNumber(String number) {
	this.number = number;
}

String number;

@JsonProperty("Path")
public String getPath() {
	return this.path;
}

public void setPath(String path) {
	this.path = path;
}

String path;

@JsonProperty("HasClassifieds")
public boolean getHasClassifieds() {
	return this.hasClassifieds;
}

public void setHasClassifieds(boolean hasClassifieds) {
	this.hasClassifieds = hasClassifieds;
}

boolean hasClassifieds;

@JsonProperty("AreaOfBusiness")
public int getAreaOfBusiness() {
	return this.areaOfBusiness;
}

public void setAreaOfBusiness(int areaOfBusiness) {
	this.areaOfBusiness = areaOfBusiness;
}

int areaOfBusiness;

@JsonProperty("IsLeaf")
public boolean getIsLeaf() {
	return this.isLeaf;
}

public void setIsLeaf(boolean isLeaf) {
	this.isLeaf = isLeaf;
}

boolean isLeaf;

}
