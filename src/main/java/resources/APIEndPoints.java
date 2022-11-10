package resources;

public enum APIEndPoints{
	

	baseURI("https://api.tmsandbox.co.nz"),
//	
	getNamedCars("/v1/Categories/UsedCars.json");
	
	//https://api.tmsandbox.co.nz/v1/Categories/UsedCars.json
	
	private String resource;
	
	APIEndPoints(String resource)
	{
		this.resource = resource;
	}
	

	public String getResource()
	{
		return resource;
	}

}
