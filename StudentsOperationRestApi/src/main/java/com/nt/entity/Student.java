package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {
	

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY )
	private Integer sid;
	
	@NonNull
	@Column(length=20)
	private String name;
	
	@NonNull
	@Column(length=30)
	private String addr;
	
	@NonNull
	@Column(length=20)
	private String subject;
	
	@NonNull
	private Long phoneno;
	
	

}
