package org.zerock.bitboard.controller;

import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnails;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.Collection;

@WebServlet(name = "Upload", value = "/upload")
@Log4j2
@MultipartConfig(fileSizeThreshold = 1024 * 1024)
public class UploadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //GET 방식으로 화면 볼꺼임
        request.getRequestDispatcher("/WEB-INF/upload.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //파일 폴더 경로 지정
        String uploadFolder = "C:\\upload";

        byte[] buffer = new byte[1024 * 8];

        //파일 업로드 시작
        Collection<Part> parts = request.getParts();

        parts.forEach(part -> {
            log.info(part);

            String type = part.getContentType();
            //log.info(type); //null이 찍히는 이유 -> 일반? 파일이라서
            if (type == null) { //null 일 때 이름먼저 파악
                log.info("partName: " + part.getName()); //name을 가져옴
                return;
            }

            String fileName = part.getSubmittedFileName();

            String uploadFileName = System.currentTimeMillis()+ "_" + fileName;

            log.info(fileName);

            //파일 업로드
            try (InputStream in = part.getInputStream(); //자동으로 close()
                 OutputStream fos = new FileOutputStream(uploadFolder + File.separator+ System.currentTimeMillis() + "_" + fileName);
                 //separator : 중간 경로 지정
                ) {
                    while (true) {
                        int count = in.read(buffer);
                        if (count == -1) { break; } //더 이상 읽을 데이터가 없음
                        fos.write(buffer, 0, count);
                    }

            } catch (Exception e) {

            } //원본 파일 저장 끝

            //이미지에 대해서만 섬네일
            if(type.startsWith("image")) {
                try {
                    Thumbnails.of(new File(uploadFolder + File.separator + uploadFileName))
                            .size(100, 100)
                            .toFile(uploadFolder + File.separator + "s_" + uploadFileName);
                }catch (Exception e) {

                }
            }

            log.info("-------------------------------------");

        });//for each
    }
}
