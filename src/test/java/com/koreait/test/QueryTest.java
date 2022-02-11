package com.koreait.test;
import com.koreait.junittest.BoardVO;
import com.koreait.junittest.Query;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class QueryTest {
//    @BeforeAll
//    public static void beforeAll() {
//        System.out.println("=========== Before All ===========");
//        Query.createTable();
//    }
//
//    @AfterAll
//    public static void afterAll() {
//        System.out.println("=========== After All ===========");
//        Query.dropTable();
//    }


    @BeforeEach
    public void beforeEach() {
        System.out.println("---- Before Each ----");


        Query.boardDelete(0);
        BoardVO vo = new BoardVO();
        String a = "대용";
        String b = "스마트";
        vo.setBtitle(a);
        vo.setBcontent(b);
        Query.boardInsert(vo);

        BoardVO vo1 = new BoardVO();
        String c = "준우";
        String d = "바보";
        vo.setBtitle(c);
        vo.setBcontent(d);
        Query.boardInsert(vo);



    }
//
    @AfterEach
    public void afterEach() {
        System.out.println("---- After Each ----");
    }
    @Test
    public void beforeAllTest(){
        assertEquals(Query.getAllBoardList().size(), 2);
    }

    @Test
    public void testA(){
        BoardVO vo1 = Query.getBoardDetail(1);
        assertEquals(vo1.getBid(), 1);
        assertEquals(vo1.getBtitle(), "대용");
        assertEquals(vo1.getBcontent(), "스마트");
        BoardVO vo2 = Query.getBoardDetail(2);
        assertEquals(vo2.getBid(), 2);
        assertEquals(vo2.getBtitle(), "준우");
        assertEquals(vo2.getBcontent(), "바보");

    }

    @Test
    public void testB(){
        Query.boardDelete(1);
        Query.boardDelete(2);
    }

    @Test
    public void testC(){
        String c = "변경";
        String d = "완료";
        BoardVO vo = new BoardVO();
        vo.setBid(1);
        vo.setBtitle(c);
        vo.setBcontent(d);
        Query.boardUpdate(vo);
        BoardVO vo1 = new BoardVO();
        vo1.setBid(2);
        vo1.setBtitle(c);
        vo1.setBcontent(d);
        Query.boardUpdate(vo1);
        BoardVO vo3 = Query.getBoardDetail(1);
        BoardVO vo4 = Query.getBoardDetail(2);
        assertEquals(vo3.getBid(), vo.getBid());
        assertEquals(vo4.getBid(), vo1.getBid());
    }
}
