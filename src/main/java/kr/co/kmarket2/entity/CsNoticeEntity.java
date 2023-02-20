package kr.co.kmarket2.entity;

<<<<<<< HEAD
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
=======
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
>>>>>>> remotes/origin/hongminjun
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
<<<<<<< HEAD
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
=======
>>>>>>> remotes/origin/hongminjun

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
<<<<<<< HEAD
@EntityListeners(AuditingEntityListener.class)
=======
>>>>>>> remotes/origin/hongminjun
@Table(name = "km_cs_notice")
public class CsNoticeEntity {
	@Id
	private int no;
<<<<<<< HEAD
//	private int cate1;
=======
	private int cate1;
>>>>>>> remotes/origin/hongminjun
	private String title;
	private String content;
	private int hit;
	private String regip;
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date rdate;
<<<<<<< HEAD
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cate1")
	private CsCate1Entity cate1Entity;
=======
>>>>>>> remotes/origin/hongminjun
}
