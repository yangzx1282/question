package com.zhoupb.questions.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhoupb.questions.mapper.PlatformMapper;
import com.zhoupb.questions.pojo.Platform;
import com.zhoupb.questions.service.PlatformService;

@Service
public class PlatformServiceImpl implements PlatformService {

	@Autowired
	private PlatformMapper platformMapper = null;
	
	@Override
	public Platform selectByName(Platform platform) {
		List<Platform> list = this.platformMapper.select(platform);
		return list == null || list.size() == 0 ? null : list.get(0);
	}

	@Override
	public boolean insert(Platform platform) {
		return this.platformMapper.insertSelective(platform) != 0;
	}

}
