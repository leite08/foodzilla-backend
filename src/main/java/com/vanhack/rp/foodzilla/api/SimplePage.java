package com.vanhack.rp.foodzilla.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A simple class to hide unnecessary properties on the resulting Json of the API
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties({})
public class SimplePage<T>  {
//public class SimplePage<T> extends PageImpl<T> {
//
//	public SimplePage(List<T> content) {
//		super(content);
//	}
//
//	public SimplePage(List<T> content, Pageable pageable, long total) {
//		super(content, pageable, total);
//	}
//
//	public static <T> SimplePage<T> from(Page<T> page) {
//		return new SimplePage<T>(page.getContent(), new PageRequest(page.getNumber(), page.getSize()),
//				page.getTotalElements());
//	}

}
