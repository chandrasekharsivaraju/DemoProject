import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapping;

public class SourceBean {
 
	private int id;
	
	private List<Benchmark> sourceBenchmarkList = new ArrayList<>();
 
	// Direct Field level mapping
	
	public List<Benchmark> getSourceBenchmarkList() {
		return sourceBenchmarkList;
	}

	public void setSourceBenchmarkList(List<Benchmark> sourceBenchmarkList) {
		this.sourceBenchmarkList = sourceBenchmarkList;
	}

	private String fullName;
 
	// Maping happens directly as the destination bean has same field name.
	private String city;
 
	@Mapping("postalCode")
	private String zipCode;
 
	// Getter level mapping;
	// Automatic Type conversion happens from int to String
	@Mapping("primaryKey")
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
 
	public String getFullName() {
		return fullName;
	}
 
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
 
	public String getCity() {
		return city;
	}
 
	public void setCity(String city) {
		this.city = city;
	}
 
	public String getZipCode() {
		return zipCode;
	}
 
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "SourceBean [id=" + id + ", sourceBenchmarkList=" + sourceBenchmarkList + ", fullName=" + fullName
				+ ", city=" + city + ", zipCode=" + zipCode + "]";
	}
	
	
 
}