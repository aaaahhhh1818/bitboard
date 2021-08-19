package org.zerock.bitboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data //getter메서드 생성
public class PageDTO {

    @Builder.Default
    private int page = 1;
    @Builder.Default
    private int size = 10;

    public int getSkip() {
        //1page - 0skip
        //2page - 10skip
        //3page - 20skip
        return (this.page -1) * size;
    }
}
