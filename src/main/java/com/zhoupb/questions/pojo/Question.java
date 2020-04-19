package com.zhoupb.questions.pojo;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id = null;
	private String question = null;
	private String answerText = null;
	private String anserChoice = null;
	private Date createTime = null;
	private Integer platformId = null;

	public Question() {
	}

	public Question(Integer id, String question, String answerText, String anserChoice, Date createTime,
			Integer platformId) {
		super();
		this.id = id;
		this.question = question;
		this.answerText = answerText;
		this.anserChoice = anserChoice;
		this.createTime = createTime;
		this.platformId = platformId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public String getAnserChoice() {
		return anserChoice;
	}

	public void setAnserChoice(String anserChoice) {
		this.anserChoice = anserChoice;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getPlatformId() {
		return platformId;
	}

	public void setPlatformId(Integer platformId) {
		this.platformId = platformId;
	}

}
