package org.zerock.bitboard.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.bitboard.dto.BoardDTO;
import org.zerock.bitboard.dto.PageDTO;
import org.zerock.bitboard.dto.PageMaker;
import org.zerock.bitboard.sevice.BoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Log4j2
@WebServlet(name = "ListController", value = "/board/list")
public class ListController extends HttpServlet {

    private Integer getInt(String str) { //Integer-> null값 받기위해서. int는 null 반환 x
        try {
            int value = Integer.parseInt(str);
            if(value <= 0) { //페이지 음수값 처리
                return null;
            }
            return value;
        }catch (Exception e) {
            return null;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer page = getInt(request.getParameter("page")); //page -> 숫자 반환 받으려고 !
        Integer size = getInt(request.getParameter("size"));

        PageDTO pageDTO = PageDTO.builder().build();

        if(page != null) { pageDTO.setPage(page); }
        if(size != null) { pageDTO.setSize(size); }

        log.info("===================1");
        log.info(pageDTO);

        List<BoardDTO> dtoList = BoardService.INSTANCE.getList(pageDTO);

        log.info("===================2");
        log.info(dtoList);

        request.setAttribute("dtoList", dtoList); //택배 보내기

        PageMaker pageMaker = new PageMaker(pageDTO.getPage(), pageDTO.getSize(), 1230);

        request.setAttribute("pageMaker", pageMaker);


        request.getRequestDispatcher("/WEB-INF/board/list.jsp").forward(request, response);

    }

}
