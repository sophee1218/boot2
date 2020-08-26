package com.boot2.service;

import java.util.Map;

import com.boot2.vo.MemberInfoVO;

public interface MemberInfoService
{
	Map<String,Object> selectMemberInfoList(MemberInfoVO mi);
}
