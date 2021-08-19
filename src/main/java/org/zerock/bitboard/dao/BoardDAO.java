package org.zerock.bitboard.dao;

import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSession;
import org.zerock.bitboard.dto.BoardDTO;
import org.zerock.bitboard.dto.PageDTO;

import java.util.List;

@Log4j2
public enum BoardDAO {

    INSTANCE;


    private static final String PREFIX ="org.zerock.bitboard.dao.BoardMapper";

    public Integer insert(BoardDTO boardDTO) throws RuntimeException {

        Integer bno = null;

        try (SqlSession session = MyBatisLoader.INSTANCE.getFactory().openSession(true)) {
            session.insert(PREFIX + ".insert", boardDTO);
            bno = boardDTO.getBno();
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

        return bno;

    }

    public BoardDTO select(Integer bno) throws RuntimeException {

        BoardDTO dto = null;

        try (SqlSession session = MyBatisLoader.INSTANCE.getFactory().openSession(true)) {
            BoardDTO boardDTO = session.selectOne(PREFIX + ".select", bno); //파라미터 여러개 줄수없음
            session.commit();
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        return dto;
    }

    public List<BoardDTO> list(PageDTO pageDTO) throws RuntimeException {

        List<BoardDTO> list = null;

        try (SqlSession session = MyBatisLoader.INSTANCE.getFactory().openSession(true)) {
           list = session.selectList(PREFIX + ".list", pageDTO);
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        return list;
    }

    public void delete(Integer bno) throws RuntimeException {

        try (SqlSession session = MyBatisLoader.INSTANCE.getFactory().openSession(true)) {
            session.delete(PREFIX + ".delete", bno);
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

    }

    public void update(BoardDTO dto) throws RuntimeException {

        try (SqlSession session = MyBatisLoader.INSTANCE.getFactory().openSession(true)) {
            session.update(PREFIX + ".update", dto);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

    }

}
