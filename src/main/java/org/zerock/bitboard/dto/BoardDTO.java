package org.zerock.bitboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

//BoardDTO는 이제 얘만 사용하는거 아니고 image도 같이 사용해야함 !
public class BoardDTO {

    private Integer bno;
    private String title, content, writer;
    private int viewcount;
    private Timestamp regdate, updatedate;

    private List<AttachDTO> attachDTOList;

    //이미지 보관
    public void addAttach(AttachDTO attachDTO) {

        if(attachDTOList == null) {
            attachDTOList = new ArrayList<>();
        }

        attachDTOList.add(attachDTO);

    }

}
