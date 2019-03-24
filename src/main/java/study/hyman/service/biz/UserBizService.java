package study.hyman.service.biz;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.hyman.dto.TmUser;
import study.hyman.mapper.service.TmUserDaoService;
import study.hyman.util.EncodeUtil;

@Service
public class UserBizService {
	@Autowired
	private TmUserDaoService tmUserDaoService;
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<TmUser> selectAllUser(){
		return tmUserDaoService.selectByTmUser(null);
	}
	
	/**
	 * 保存用户
	 * @param tmUser
	 * @return
	 */
	public long addUser(TmUser tmUser) {
		return tmUserDaoService.insert(tmUser);
	}
	
	/**
	 * 校验用户名和密码
	 * @param tmUser
	 * @return
	 */
	public boolean validUser(TmUser tmUser) {
		if(tmUser==null || StringUtils.isBlank(tmUser.getPassword())) {
			return false;
		}
		List<TmUser> list = tmUserDaoService.selectByTmUser(tmUser);
		if(CollectionUtils.isEmpty(list)) {
			return false;
		}
		TmUser dbUser = list.get(0);
		if(tmUser.getPassword().equals(new String(EncodeUtil.decryptBASE64(dbUser.getPassword())))) {
			return true;
		}
		return false;
	}
}
