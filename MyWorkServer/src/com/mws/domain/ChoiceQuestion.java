package com.mws.domain;

public class ChoiceQuestion {
	private int qid;
	private String qcontext;
	private String answerA;
	private String answerB;
	private String answerC;
	private String answerD;
	private String rightAnswer;
	public int getQid() {
		return qid;
	}
	public void setQid(int cellStr) {
		this.qid = cellStr;
	}
	public String getQcontext() {
		return qcontext;
	}
	public void setQcontext(String qcontext) {
		this.qcontext = qcontext;
	}
	public String getAnswerA() {
		return answerA;
	}
	public void setAnswerA(String answerA) {
		this.answerA = answerA;
	}
	public String getAnswerB() {
		return answerB;
	}
	public void setAnswerB(String answerB) {
		this.answerB = answerB;
	}
	public String getAnswerC() {
		return answerC;
	}
	public void setAnswerC(String answerC) {
		this.answerC = answerC;
	}
	public String getAnswerD() {
		return answerD;
	}
	public void setAnswerD(String answerD) {
		this.answerD = answerD;
	}
	public String getRightAnswer() {
		return rightAnswer;
	}
	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
	@Override
	public String toString() {
		return "ChoiceQuestion [qid=" + qid + ", qcontext=" + qcontext
				+ ", answerA=" + answerA + ", answerB=" + answerB
				+ ", answerC=" + answerC + ", answerD=" + answerD
				+ ", rightAnswer=" + rightAnswer + "]";
	}
	public ChoiceQuestion(int qid, String qcontext, String answerA,
			String answerB, String answerC, String answerD, String rightAnswer) {
		super();
		this.qid = qid;
		this.qcontext = qcontext;
		this.answerA = answerA;
		this.answerB = answerB;
		this.answerC = answerC;
		this.answerD = answerD;
		this.rightAnswer = rightAnswer;
	}
	public ChoiceQuestion(){
		super();
	}
	
	
}
