package com.saraiev.osdbtest.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageableBuilder {

    private static final int DEFAULT_PAGE_SIZE = 10;
    private static final Sort.Direction DEFAULT_SORT_DIRECTION = Sort.Direction.ASC;
    private static final String[] DEFAULT_SORT_FIELDS = new String[] {"id"};

    private PageableBuilder() {
    }

    public static Pageable build(Integer page, Integer size, String[] sortFields) {
        if (page == null && size == null) {
            return Pageable.unpaged();
        }
        if (page == null) {
            page = 0;
        }
        if (size == null) {
            size = DEFAULT_PAGE_SIZE;
        }
        if (sortFields == null) {
            sortFields = DEFAULT_SORT_FIELDS;
        }
        return PageRequest.of(page, size, DEFAULT_SORT_DIRECTION, sortFields);
    }

}
