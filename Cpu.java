package cpu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Cpu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		JSONObject object = new JSONObject();
		JSONArray values=new JSONArray();
		
		File f=new File("CPU.txt");
		
		float maximum=0f;
		float total=0f;
		float average=0f;
		
		int count=1;
		try
		{
			BufferedReader br=new BufferedReader(new FileReader(f));
		
			String s="";
		
			
			while((s=br.readLine())!=null)
			{
				String str=s.substring(42,46);
				
				str=str.trim();
				
				float val=Float.parseFloat(str);
				
				if(maximum<val)
				{
					maximum=val;
				}
				
				total=total+val;
			
				//System.out.println(count+"s:"+s1);
				String tot=count+"s";
				
				JSONObject ob = new JSONObject();
				ob.put(tot,val);
				values.add(ob);
				
				count++;
			}
		}
		
		catch(Exception e)
		{
			
		}
		
		average=total/(count-1);
		
		double avg1 = Math.round(average * 100.0) / 100.0;
		
		object.put("values",values);
		object.put("maxcpu",maximum);
		object.put("Avgcpu",avg1);
		
		JSONObject report=new JSONObject();
		
		report.put("sampletransaction", object);
		
		try
		{
		
		FileWriter fw=new FileWriter("output.json");
		
		fw.write(report.toString());
		fw.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		//reading file
		
		
		System.out.print(values.toJSONString());
		
				JSONParser jsonParser = new JSONParser();
				
				
				try
				{
					FileReader reader = new FileReader("output.json");
		            Object obj = jsonParser.parse(reader);
		            JSONObject jo=(JSONObject)obj;
		            
		            System.out.println(jo.toString());
		            
		            
		            
		            Double Average=(Double)jo.get("AverageMemory(MB)");
		        } 
				catch(Exception e)
				{
					System.out.println(e);
				}
	}

}
