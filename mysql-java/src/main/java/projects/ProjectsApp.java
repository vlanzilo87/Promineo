package projects;

import projects.dao.DbConnection;

public class ProjectsApp {

	public ProjectsApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		DbConnection.getConnection();
	}

}
