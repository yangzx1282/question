package com.zhoupb.questions.service;

import com.zhoupb.questions.pojo.Platform;

public interface PlatformService {
	
	/**
	 * 对象里name属性不空就行
	 * @param name
	 * @return
	 */
	public Platform selectByName(Platform name);
	public boolean insert(Platform platform);
}
