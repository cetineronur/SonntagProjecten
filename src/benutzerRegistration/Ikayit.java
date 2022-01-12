package techproed.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public interface Ikayit {

	
	void idList(Statement st, Connection con) throws SQLException, ClassNotFoundException;

	
}
