package org.zerock.bitboard.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.bitboard.dao.BoardDAO;
import org.zerock.bitboard.dto.BoardDTO;
import org.zerock.bitboard.sevice.BoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name = "Update", value = "/board/update")
public class UpdateController extends HttpServlet {

    private Integer getInt(String str) {
        try {
            int value = Integer.parseInt(str);
            if(value <= 0) {
                return null;
            }
            return value;
        }catch (Exception e) {
            return null;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer bno = getInt(request.getParameter("bno"));

        request.setAttribute("bno", bno);

        request.getRequestDispatcher("/WEB-INF/board/update.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer bno = getInt(request.getParameter("bno"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        BoardDTO boardDTO = BoardDTO.builder()
                .bno(bno)
                .title(title)
                .content(content)
                .build();

        BoardService.INSTANCE.update(boardDTO);

        response.sendRedirect("/board/read?bno=" + bno);

    }
}
