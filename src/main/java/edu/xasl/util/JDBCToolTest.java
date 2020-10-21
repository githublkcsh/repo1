package edu.xasl.util;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

public class JDBCToolTest {

	@Test
	public void testGetconnection() {
		Connection conn=JDBCTool.getconnection();
		System.out.println(conn );
	}

}
