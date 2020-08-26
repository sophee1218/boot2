package com.boot2.dao;

import java.util.List;

import com.boot2.vo.MemberInfoVO;

public interface MemberInfoDAO
{

	int selectTotalCount(MemberInfoVO mi);
	List<MemberInfoVO> selectMemberInfoList(MemberInfoVO mi);
}
