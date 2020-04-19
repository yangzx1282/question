package com.zhoupb.questions.service;

import com.zhoupb.questions.pojo.bo.QuestionBo;

public interface QuestionService {

	public boolean insert(QuestionBo question);
	
	/**
	 * 查询别家的
	 * @param questionName
	 * @return
	 */
	public QuestionBo queryOtherServer(QuestionBo question);
}
