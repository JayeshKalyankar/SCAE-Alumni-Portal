package reusableComponents;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




public class JiraOperations {
	String jiraURL = PropertiesOperations.getPropertyValueByKey("jiraURL");
	String jiraUserName = PropertiesOperations.getPropertyValueByKey("jiraUserName");
	String jiraAccessKey = PropertiesOperations.getPropertyValueByKey("jiraSecretKey");


	//create Jira Issue as bug
	public String createJiraIssue(String assigneeId, String Description, String issueType, String label, String projectId, String reporterID, String summary) throws ClientProtocolException, IOException, ParseException {
		
		String issueId = null; //to store issue / bug id.
		
		HttpClient httpClient = HttpClientBuilder.create().build();
		String url = jiraURL+"/rest/api/3/issue";
		HttpPost postRequest = new HttpPost(url);
		postRequest.addHeader("content-type", "application/json");

	//	BASE64Encoder base=new BASE64Encoder();
		String encoding = Base64.getEncoder().encodeToString((jiraUserName+":"+jiraAccessKey).getBytes());
		//String encoding = base.encode((jiraUserName+":"+jiraAccessKey).getBytes());
		postRequest.setHeader("Authorization", "Basic " + encoding);

		StringEntity params = new StringEntity(createPayloadForCreateJiraIssue(assigneeId, Description, issueType, label, projectId, reporterID, summary));
		postRequest.setEntity(params);
		HttpResponse response = httpClient.execute(postRequest);

		//convert httpresponse to string
		String jsonString = EntityUtils.toString(response.getEntity());

		//convert sring to Json
		JSONParser parser = new JSONParser();  
		JSONObject json = (JSONObject) parser.parse(jsonString);

		//extract issuekey from Json
		issueId = (String) json.get("key");

		return issueId;

	}

	//Add attachment to already created bug / issue in JIRA
		public void addAttachmentToJiraIssue(String issueId, String filePath) throws ClientProtocolException, IOException 
		{
			String pathname= filePath; 
			File fileUpload = new File(pathname);

			HttpClient httpClient = HttpClientBuilder.create().build();
			String url = jiraURL+"/rest/api/3/issue/"+issueId+"/attachments";
			HttpPost postRequest = new HttpPost(url);

			//BASE64Encoder base=new BASE64Encoder();
			//String encoding = base.encode((jiraUserName+":"+jiraAccessKey).getBytes());
			String encoding = Base64.getEncoder().encodeToString((jiraUserName+":"+jiraAccessKey).getBytes());

			postRequest.setHeader("Authorization", "Basic " + encoding);
			postRequest.setHeader("X-Atlassian-Token","nocheck");

			MultipartEntityBuilder entity=MultipartEntityBuilder.create();
			entity.addPart("file", new FileBody(fileUpload));
			postRequest.setEntity( entity.build());
			HttpResponse response = httpClient.execute(postRequest);
			System.out.println(response.getStatusLine());

			if(response.getStatusLine().toString().contains("200 OK")){
				System.out.println("Attachment uploaded");
			} else{
				System.out.println("Attachment not uploaded");
			}
		}
	
	//creates payload for create issue post request
	private static String createPayloadForCreateJiraIssue(String assigneeId, String Description, String issueType, String label, String projectId, String reporterID, String summary) {
		
		String JiraPayload;
		
		JiraPayload = 
			"{\r\n\t"
			+ "\"fields\": {\r\n\t\t"
			+ "\"assignee\": {\r\n\t\t\t"
			+ "\"id\": \""+assigneeId+"\"\r\n\t\t},\r\n\t\t"
			+ "\"customfield_10021\": [],\r\n\t\t"
			+ "\"description\": {\r\n\t\t\t"
			+ "\"content\": [\r\n\t\t\t\t{\r\n\t\t\t\t\t"
			+ "\"content\": [\r\n\t\t\t\t\t\t{\r\n\t\t\t\t\t\t\t"
			+ "\"text\": \""+Description+"\",\r\n\t\t\t\t\t\t\t"
			+ "\"type\": "
			+ "\"text\"\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t],\r\n\t\t\t\t\t"
			+ "\"type\": \"paragraph\"\r\n\t\t\t\t}\r\n\t\t\t],\r\n\t\t\t"
			+ "\"type\": \"doc\",\r\n\t\t\t"
			+ "\"version\": 1\r\n\t\t},\r\n\t\t"
			+ "\"issuetype\": {\r\n\t\t\t"
			+ "\"id\": \""+issueType+"\"\r\n\t\t},\r\n\t\t"
			+ "\"labels\": [\r\n\t\t\t\""+label+"\"\r\n\t\t],\r\n\t\t"
			+ "\"project\": {\r\n\t\t\t"
			+ "\"id\": \""+projectId+"\"\r\n\t\t},\r\n\t\t"
			+ "\"reporter\": {\r\n\t\t\t"
			+ "\"id\": \""+reporterID+"\"\r\n\t\t},\r\n\t\t"
			+ "\"summary\": \""+summary+"\"\r\n\t},\r\n\t"
			+ "\"update\": {}\r\n"
			+ "}";
		
		return JiraPayload;
	}
				
				
}