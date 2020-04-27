package com.it.wecodeyou.off.repository;

import java.util.List;

import com.it.wecodeyou.member.model.MemberVO;
import com.it.wecodeyou.off.model.OffVO;

public interface IOffMapper {
	public void register(OffVO ovo);
	
	public List<OffVO> listByUser(MemberVO mvo);
	
	public List<OffVO> list();
	
	public void update(OffVO ovo);
	
	public void remove(Integer offNo);
	
	
}
