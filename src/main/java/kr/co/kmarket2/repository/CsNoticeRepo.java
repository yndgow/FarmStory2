package kr.co.kmarket2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.kmarket2.entity.CsNoticeEntity;

public interface CsNoticeRepo extends JpaRepository<CsNoticeEntity, Integer>{
	List<CsNoticeEntity> findAllByOrderByRdateDesc();
}
