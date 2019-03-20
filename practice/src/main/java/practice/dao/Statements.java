package practice.dao;

public final class Statements {
	
	public static class Route{
		public static String SELECT_ROUTE="SELECT STEP,X,Y FROM ROUTE WHERE ID=?";
		public static String SELECT_LOCATION="SELECT STEP,X,Y FROM ROUTE WHERE ID=1 AND STEP=?";
	}
	public static class Log{
		public static String INSERT = "INSERT INTO LOG (LOCATION) VALUES(?)";
	}

}
