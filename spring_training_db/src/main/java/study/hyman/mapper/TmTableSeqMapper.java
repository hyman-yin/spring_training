package study.hyman.mapper;

import org.springframework.web.bind.annotation.RequestParam;

import study.hyman.dto.TmTableSeq;

public interface TmTableSeqMapper {
	public Long selectValByPrimarykey(@RequestParam("id") String seqName);
	public long update(TmTableSeq tmTableSeq);
}
