package Home.PracticeProject.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.type.TypeReference;

public class DataReader {
	public List<HashMap<String,String>> getJsonDataToMap() throws IOException
	{
		//convert json to string
		System.out.println(System.getProperty("user.dir"));
		String jsonContent =FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\Home\\PracticeProject\\data\\orderData.json"),StandardCharsets.UTF_8);
		ObjectMapper mapper= new ObjectMapper();
		//convert to list of hashmap
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){
			
		});
		return data;		
				

	}

}
