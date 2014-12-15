import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/*Private key*/
/*e96ececa-9079-4ad8-ab4c-5aa744d0bf87*/
public class fetcher {
	protected static String key;
	private String http= new String("https://");
	private String apiDir= new String(".api.pvp.net/api/lol/");
	private String version = new String("/v1.4");
	private String reqKey = new String("?api_key=");	
	public fetcher(String newKey)
	{
		setKey(newKey);
	}
	
	private String curlCall(String urlAddress)
	{
		if(urlAddress==null)
		{
			return null;
		}
		
		URL url=null;
		try
		{
			//"https://na.api.pvp.net/api/lol/na/v1.4/summoner/by-name/reackage?api_key=e96ececa-9079-4ad8-ab4c-5aa744d0bf87"
			url = new URL(urlAddress);
		}
		catch (MalformedURLException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.exit(0);
		}
		String re=new String();
		try 
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		    for (String line; (line = reader.readLine()) != null;) 
		    {
		    	re=re+line;
		        System.out.println(line);
		    }
		}
		catch(Exception e)
		{
			System.out.println("You are a butt");
			re=null;
		}
		finally
		{
			System.out.println("ye");
		}
		return re;
	}
	public String getId( String sumName, String region)
	{
		
		if(!sumName.isEmpty()&&!region.isEmpty())
		{
			String getID = new String("/summoner/by-name/");
			String urlAddress= new String( this.getHttp()+region+this.getApiDir()+region+this.getVersion()+getID+sumName+this.getReqKey()+this.getKey());
			System.out.println(urlAddress);
			
			return this.curlCall(urlAddress);
		}
		return null;
	}
	public static void main(String[] args)
	{
		
		//TODO Remove keys from posting
		fetcher message = new fetcher("e96ececa-9079-4ad8-ab4c-5aa744d0bf87");
		 String me= message.getId("Reackage","na");
		
	}
	public static String getKey() 
	{
		return key;
	}
	public static void setKey(String newKey) 
	{
		fetcher.key = newKey;
	}
	public String getHttp() {
		return http;
	}
	public String getApiDir() {
		return apiDir;
	}
	public String getVersion() {
		return version;
	}
	public String getReqKey() {
		return reqKey;
	}

}
