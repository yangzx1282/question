package com.zhoupb.questions.pojo;

public class OtherServerJson {
	// {"code":200,"question":"湖南省大学生创新创业就业学院:
	// 大学生经常和同学们合伙创业，这说明了大学生创业具有（）（）","answer":"C"}
	private String code = null;
	private String question = null;
	private String answer = null;

	public OtherServerJson() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "OtherServerJson [code=" + code + ", question=" + question + ", answer=" + answer + "]";
	}

}
