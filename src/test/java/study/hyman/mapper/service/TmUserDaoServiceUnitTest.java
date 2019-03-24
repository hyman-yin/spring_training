package study.hyman.mapper.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import study.hyman.base.BaseUnitTest;
import study.hyman.dto.TmUser;

@Transactional
public class TmUserDaoServiceUnitTest extends BaseUnitTest {
	@Autowired
	private TmUserDaoService tmUserDaoService;
	
	@Before
	public void initDb() {
		TmUser tmUser = new TmUser();
		tmUser.setId("1");
		tmUser.setUserId("hyman");
		tmUser.setUserName("尹龙成");
		tmUserDaoService.deleteByPrimaryKey(tmUser.getId());
		tmUserDaoService.insert(tmUser);
	}
	
	@Test
	public void selectByPrimarykey() {
		
		
		String id="1";
		TmUser tmUser = tmUserDaoService.selectByPrimarykey(id);
		assertNotNull(tmUser);
		assertEquals("hyman", tmUser.getUserId());
	}

	@Test
	public void selectByTmUser() {
		TmUser tmUser = new TmUser();
		tmUser.setId("1");
		List<TmUser> list = tmUserDaoService.selectByTmUser(tmUser);
		assertNotNull(list);
		assertEquals(1, list.size());
		tmUser.setUserId("hyman");
		List<TmUser> list2 = tmUserDaoService.selectByTmUser(tmUser);
		assertEquals(1, list2.size());
		
		tmUser.setUserId("hyman2b");
		List<TmUser> list3 = tmUserDaoService.selectByTmUser(tmUser);
		assertTrue(CollectionUtils.isEmpty(list3));
	}

	@Test
	public void insert() {
		TmUser tmUser = new TmUser();
		tmUser.setUserId("zhagnsan");
		tmUser.setUserName("张三");
		long count = tmUserDaoService.insert(tmUser);
		assertEquals(1, count);
	}

	@Test
	public void deleteByPrimaryKey() {
		String id="1";
		long count = tmUserDaoService.deleteByPrimaryKey(id);
		assertEquals(1, count);
	}
	
	@Test
	public void update() {
		TmUser tmUser = tmUserDaoService.selectByPrimarykey("1");
		tmUser.setUserName("龙成尹");
		long count = tmUserDaoService.update(tmUser);
		assertEquals(1, count);
	}
}
