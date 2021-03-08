package softablitz;

import java.sql.*;

public class NotificationsSQL {

    public static void NotificationsSQL() {
        NotificationsAPI notificationsAPI = new NotificationsAPI();
        Connection connection = SQLConnection.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("TRUNCATE TABLE NOTIFICATIONS");

            Notifications notifications = notificationsAPI.NotificationsAPI();

            for(Notifications.LatestData.NotificationsData notificationsData: notifications.data.notifications){
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO NOTIFICATIONS VALUES (?,?)");
                preparedStatement.setString(1, notificationsData.getTitle());
                preparedStatement.setString(2, notificationsData.getLink());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try{
                if(statement!=null){
                    statement.close();
                }
            }catch (SQLException e1){
                e1.printStackTrace();
            }
            try{
                if(connection!=null){
                    connection.close();
                }
            }catch(SQLException e2){
                e2.printStackTrace();
            }
        }
    }
}


/*package softablitz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class NotificationsSQL {
    public void NotificationsSQL() throws IOException, InterruptedException {
        Connection connection = SQLConnection.getConnection();
        Statement statement = null;
        NotificationsAPI notificationsAPI = new NotificationsAPI();
        Notifications notifications = notificationsAPI.NotificationsAPI();
        try{
            statement = connection.createStatement();
            for(Notifications.LatestData.NotificationsData notificationsData: notifications.data.notifications){
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO NOTIFICATIONS VALUES(?,?)");
                preparedStatement.setString(1, notificationsData.getTitle());
                preparedStatement.setString(2, notificationsData.getLink());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
*/
