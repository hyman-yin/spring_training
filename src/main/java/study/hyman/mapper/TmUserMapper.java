package study.hyman.mapper;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import study.hyman.dto.TmUser;

public interface TmUserMapper {
	public List<TmUser> selectByPrimarykey(@RequestParam("id") String id);
	
	public List<TmUser> selectByTmUser(TmUser tmUser);
	
	public long insert(TmUser tmUser);
	
	public long deleteByPrimaryKey(@RequestParam("id") String id);
	
	public long update(TmUser tmUser);
}
