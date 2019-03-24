package study.hyman.mapper.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import study.hyman.dto.TmTableSeq;
import study.hyman.mapper.TmTableSeqMapper;

@Service
public class TmTableSeqDaoService {
	
	@Value("${seq.step:300}")
	private Long step;
	
	@Autowired
	private TmTableSeqMapper tmTableSeqMapper;
	
	/**
	 * 查询序号
	 * @param seqName
	 * @return
	 */
	public Long selectValByPrimarykey(String seqName) {
		if(StringUtils.isBlank(seqName)) {
			return 1L;
		}
		return tmTableSeqMapper.selectValByPrimarykey(seqName);
	}
	
	/**
	 * 更新序号值
	 * @param tmTableSeq
	 * @return
	 */
	public long update(TmTableSeq tmTableSeq) {
		if(tmTableSeq==null || StringUtils.isBlank(tmTableSeq.getSeqName())
				|| tmTableSeq.getVal()==null) {
			return 0;
		}
		return tmTableSeqMapper.update(tmTableSeq);
	}
	
	
	/**
	 * 根据序号名称获取下一个值
	 * @param seqName
	 * @return
	 */
	public synchronized String selectNextVal(String seqName) {
		if(StringUtils.isBlank(seqName)) {
			System.err.println("传入参数seqName为空");
			return "1";
		}
		
		//1.查出当前值
		Long val = selectValByPrimarykey(seqName);
		
		//2.加上步长
		val+=step;
		
		//3.更新db值
		TmTableSeq tmTableSeq = new TmTableSeq();
		tmTableSeq.setSeqName(seqName);
		tmTableSeq.setVal(val);
		if(update(tmTableSeq)>0) {
			System.out.println(seqName+ " 获得的序号是 " + val);
			return String.valueOf(val);
		}
		System.err.println("更新db值失败,seqName:"+seqName+", val: "+val);
		return "1";
	}
	
}
