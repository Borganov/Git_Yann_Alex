package contact;

public class Question {

	private String question;
	private String response1;
	private String response2;
	private String response3;
	private int response;
	
	/**
	 * 
	 * @param question �nonc� de la question
	 * @param response1 proposition de r�ponse 1
	 * @param response2 proposition de r�ponse 2
	 * @param response3 proposition de r�ponse 3
	 * @param response num�ro de l'�nnonc� correcte
	 */

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
	/**
	 * M�thode pour tester si la r�ponse s�lectionn�e par le joueur est exacte
	 * @param select r�cup�re l'�nnonc� selectionn� par le joueur
	 * @return initialis� � true, le change en false si la propositon s�lectionn�e par le joueur ne correspond pas � la r�ponse initialis� par le programmeur
	 */
	public boolean reponseControl(int select){

		boolean reponse =true;
		if(select!=getResponse()){
		reponse=false;
		}
		return reponse;
	}
	
}
