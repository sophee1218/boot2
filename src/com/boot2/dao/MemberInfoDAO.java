package com.boot2.dao;

import java.util.List;
import java.util.Map;

public interface MemberInfoDAO
{
	  List<Map<String,Object>> selectTest(Map<String,Object> member);
	  List<Map<String, Object>> selectMemberInfoList(Map<String, Object> member);


}
