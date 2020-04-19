package com.zhoupb.questions.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zhoupb.questions.mapper.QuestionMapper;
import com.zhoupb.questions.pojo.OtherServerJson;
import com.zhoupb.questions.pojo.Platform;
import com.zhoupb.questions.pojo.bo.QuestionBo;
import com.zhoupb.questions.service.PlatformService;
import com.zhoupb.questions.service.QuestionService;
import com.zhoupb.questions.utils.Common;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionMapper questionMapper = null;
	@Autowired
	private PlatformService platformService = null;
	
	@Override
	public boolean insert(QuestionBo question) {
		
		/**
		 * 应该判断传过来的平台名称与数据库中的平台名称的重复性 题目名称也应该一样
		 */
		
		Platform platform = this.platformService.selectByName(question.getPlatform());
		//	新平台需要插入 且不不相似的时候插入
		if (platform == null || platform.getId() == null || platform.getId() == 0) {
			if (!this.platformService.insert(question.getPlatform())) return false;
			System.err.println(question.getPlatform().getId());
		}
		question.setPlatformId(platform.getId());
		return this.questionMapper.insertSelective(question) != 0;
	}

	@Override
	public QuestionBo queryOtherServer(QuestionBo question) {
		String url = "http://do.71kpay.com/wk/json/api2.php?tm=" + question.getQuestion();
		RestTemplate client = new RestTemplate();
		String str = client.getForObject(url, String.class);
		System.out.println(str);
		OtherServerJson otherServerJson = Common.stringToObject(str, OtherServerJson.class);
		question.setAnswerText(otherServerJson.getAnswer());
		return question;
	}
	
}
