package dao;

import java.sql.Connection;

public class OjdbcSession implements AutoCloseable {
	
	private Connection conn;
	private boolean using;
	
	public OjdbcSession(Connection conn) {
		this.conn = conn;
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	void setUse() {
		using = true;
	}
	
	boolean using() {
		return using;
	}
	
	@Override
	public void close() throws Exception {
		using = false;
	}
}
