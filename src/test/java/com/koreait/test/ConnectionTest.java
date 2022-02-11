package com.koreait.test;


import com.koreait.junittest.Query;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;


public class ConnectionTest {
    @Test
    public void getConnTest() {
        System.out.println("[getConn Test}");
        assertNotNull(Query.getConn());
    }



}
