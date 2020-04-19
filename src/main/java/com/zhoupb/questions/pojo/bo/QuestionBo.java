package com.zhoupb.questions.pojo.bo;

import com.zhoupb.questions.pojo.Platform;
import com.zhoupb.questions.pojo.Question;

public class QuestionBo extends Question {

	private Platform platform = null;

	public QuestionBo() {
	}

	public QuestionBo(String question, String platformName) {
		super();
		this.setQuestion(question);
		this.platform = new Platform();
		this.platform.setName(platformName);
	}
	
	public QuestionBo(Platform platform) {
		super();
		this.platform = platform;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

}
