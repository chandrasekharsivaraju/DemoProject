import java.util.Arrays;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

public class testdozo {

	public static void main(String args[]) {
		 
		// Create a Mapper Object
		Mapper mapper = new DozerBeanMapper();
 
		Benchmark sb = new Benchmark();
		sb.setBenchmarkName("sourcebenchmarkname22");
		
		Benchmark sb1 = new Benchmark();
		sb1.setBenchmarkName("sourcebenchmarkname11");
		
		
		SourceBean sourceBean = new SourceBean();
		sourceBean.setId(1);
		sourceBean.setFullName("John Doe");
		sourceBean.setCity("San Francisco");
		sourceBean.setZipCode("90912");
		
		sourceBean.getSourceBenchmarkList().addAll(Arrays.asList(sb,sb1));
		
		System.out.println("********************");
		System.out.println(sourceBean);
		
		System.out.println("********************");
		// Use the mapper Object and then map the required object
		
		DestinationBean destBean = mapper.map(sourceBean, DestinationBean.class);
		
		
		System.out.println(destBean);
	}
}
