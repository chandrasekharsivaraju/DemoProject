import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapping;

public class DestinationBean {
 
	private String primaryKey;
 
	@Mapping("fullName")
	private String name;
	
	@Mapping("sourceBenchmarkList")
	private List<Benchmark> destinationBenchmarkList = new ArrayList<>();
	 
 
	public List<Benchmark> getDestinationBenchmarkList() {
		return destinationBenchmarkList;
	}

	public void setDestinationBenchmarkList(List<Benchmark> destinationBenchmarkList) {
		this.destinationBenchmarkList = destinationBenchmarkList;
	}

	private String city;
 
	private String postalCode;
 
	public String getPrimaryKey() {
		return primaryKey;
	}
 
	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public String getCity() {
		return city;
	}
 
	public void setCity(String city) {
		this.city = city;
	}
 
	public String getPostalCode() {
		return postalCode;
	}
 
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
 
	@Override
	public String toString() {
		return "DestinationBean [primaryKey=" + primaryKey + ", name=" + name + ", city=" + city + ", postalCode="
				+ postalCode +  " destinationBenchmarkList :: "+ destinationBenchmarkList + "]" ;
	}
 
}