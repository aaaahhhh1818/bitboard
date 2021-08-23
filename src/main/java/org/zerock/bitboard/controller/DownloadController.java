package org.zerock.bitboard.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@Log4j2
@WebServlet(name = "download", value = "/down")
public class DownloadController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("Download....doGet......");

        //경로 설정
        String path = "C:\\upload";
        String fileName = request.getParameter("fname");

        File targetFile = new File(path, fileName); //File api
        OutputStream out = null;

        try {
            //파일 복사 - 파일 폴더에 빨대 꼽기
            out = response.getOutputStream();
            Path targetPath = targetFile.toPath(); //java.nio

            //mime type 지정
            String contentType = Files.probeContentType(targetPath);
            log.info(contentType);

            response.setContentType(contentType);
            Files.copy(targetPath, out); //경로, OutputStream 필요

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (Exception e) {
            }
        }
    }
}
