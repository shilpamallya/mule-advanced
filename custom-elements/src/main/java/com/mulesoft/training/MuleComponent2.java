package com.mulesoft.training;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mule.api.annotations.param.InboundHeaders;
import org.mule.api.annotations.param.Payload;

public class MuleComponent2 {

  public Map<String,String> processMap(Map<String, String> input) {
    // processMap implementation 
	//1.	Resolution by reflection
	  input.put("processed by", "processMap");
    return input;
  }

  public Map<String,String> processArray(List<String> input) {
    // processArray implementation
	//1.	Resolution by reflection
	  Map<String, String> output = new HashMap<String, String>();
	  output.put("message", input.get(0));
	  output.put("processed by", "processArray");
	  return output;
  }

  public Map<String,String> processString(String input) {
    // processString implementation
	//1.	Resolution by reflection
	  Map<String, String> output = new HashMap<String, String>();
	  output.put("message", input);
	  output.put("processed by", "processString");
    return output;
  }

  //2. Resolution by Annotation
  public Map<String,String> processAll(@Payload Object input, @InboundHeaders("http.method") String method){
	  Map<String, String> output = new HashMap<String, String>();
	  output.put("message", input.toString());
	  output.put("processed by", "processAll");
	  output.put("http.method", method);
	  return output;
  }
  
  public Map<String,String> processString2() {
    // processString2 implementation
    return null;
  }

} 
