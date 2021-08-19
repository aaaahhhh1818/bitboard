package org.zerock.bitboard.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageMaker {

    private int start, end, page, size, total;
    private boolean prev, next;

    public PageMaker(int page, int size, int total) {

        this.page = page;
        this.size = size;
        this.total = total;

        //마지막 페이지 계산
        end = (int)(Math.ceil(page / 10.0)) * 10; //소수점으로 나오기위해서 10.0으로 나눔
        start = end - 9;

        prev = start > 1;
        next = (total / (double)size) > end;

        //마지막 페이지가 토탈보다 크면 다시 계산
        if(end * size > total) {
            end = (int)(Math.ceil(total / (double)size));
        }
        //삼항연산자로 처리 가능
        //end = end * size > total ? (int)(Math.ceil(total / (double)size)) : end;
    }

}
