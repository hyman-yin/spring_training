package study.hyman.mapper.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.hyman.constant.SeqNameConstant;
import study.hyman.dto.TmUser;
import study.hyman.mapper.TmUserMapper;
import study.hyman.util.EncodeUtil;

@Service
public class TmUserDaoService {
	@Autowired
	private TmUserMapper tmUserMapper;

	@Autowired
	private TmTableSeqDaoService tmTableSeqDaoService;
	
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 */
	public TmUser selectByPrimarykey(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		}
		List<TmUser> list = tmUserMapper.selectByPrimarykey(id);
		if(CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}

	/**
	 * 根据对象查询，如果对象为空，或者属性均为空，则查所有
	 * @param tmUser
	 * @return
	 */
	public List<TmUser> selectByTmUser(TmUser tmUser) {
		return tmUserMapper.selectByTmUser(tmUser);
	}

	/**
	 * 插入
	 * @param tmUser
	 * @return 0失败，大于0成功
	 */
	public long insert(TmUser tmUser) {
		if(tmUser==null) {
			return 0;
		}
		if(StringUtils.isBlank(tmUser.getId())){
			tmUser.setId(tmTableSeqDaoService.selectNextVal(SeqNameConstant.SEQ_TM_USER));
		}
		
		if(StringUtils.isNotBlank(tmUser.getPassword())) {
			tmUser.setPassword(EncodeUtil.encryptBASE64(tmUser.getPassword().getBytes()));
		}
		
		return tmUserMapper.insert(tmUser);
	}

	/**
	 * 根据主键删除
	 * @param id
	 * @return
	 */
	public long deleteByPrimaryKey(String id) {
		if(StringUtils.isBlank(id)) {
			return 0;
		}
		return tmUserMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 更新
	 * @param tmUser
	 * @return
	 */
	public long update(TmUser tmUser) {
		if(tmUser==null || StringUtils.isBlank(tmUser.getId())) {
			return 0;
		}
		if(StringUtils.isNotBlank(tmUser.getPassword())) {
			tmUser.setPassword(EncodeUtil.encryptBASE64(tmUser.getPassword().getBytes()));
		}
		return tmUserMapper.update(tmUser);
	}
}
