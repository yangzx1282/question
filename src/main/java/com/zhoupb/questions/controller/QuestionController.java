package com.zhoupb.questions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhoupb.questions.pojo.bo.QuestionBo;
import com.zhoupb.questions.service.QuestionService;

@Controller
@RequestMapping("question")
public class QuestionController {

	@Autowired
	private QuestionService questionService = null;

	@PostMapping("save")
	public ResponseEntity<Void> addQuestion(QuestionBo question) {
		if (question == null || StringUtils.isEmpty(question.getQuestion())
				|| StringUtils.isEmpty(question.getPlatform().getName())
				|| (StringUtils.isEmpty(question.getAnswerText()) && StringUtils.isEmpty(question.getAnserChoice())))
			return ResponseEntity.badRequest().build();
		if (this.questionService.insert(question))
			return ResponseEntity.status(HttpStatus.CREATED).build();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@GetMapping("query")
	public ResponseEntity<QuestionBo> queryQuestion(@RequestParam("tm") String questionName,
			@RequestParam("platform") String platformName) {
		if (StringUtils.isEmpty(questionName) || StringUtils.isEmpty(platformName))
			return ResponseEntity.badRequest().build();
		QuestionBo questionBo = this.questionService.queryOtherServer(new QuestionBo(questionName, platformName));
		return ResponseEntity.ok(questionBo);
	}

}
