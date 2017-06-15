package contact;

public class Question {
	
	private String question;
	private String response1;
	private String response2;
	private String response3;
	private int response;
	
	public Question(String question, String response1, String response2, String response3, int response) {
		super();
		this.question = question;
		this.response1 = response1;
		this.response2 = response2;
		this.response3 = response3;
		this.response = response;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getResponse1() {
		return response1;
	}

	public void setResponse1(String response1) {
		this.response1 = response1;
	}

	public String getResponse2() {
		return response2;
	}

	public void setResponse2(String response2) {
		this.response2 = response2;
	}

	public String getResponse3() {
		return response3;
	}

	public void setResponse3(String response3) {
		this.response3 = response3;
	}

	public int getResponse() {
		return response;
	}

	public void setResponse(int response) {
		this.response = response;
	}
	
	public boolean reponseControl(int select){
		
		boolean reponse =true;
		if(select!=getResponse()){
		reponse=false;
		}
		return reponse;
	}
	
}
