package softablitz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatewiseSQL {

    public static void DatewiseSQL() throws IOException, InterruptedException{


        Connection connection = SQLConnection.getConnection();
        DatewiseAPI datewiseAPI = new DatewiseAPI();
        Datewise datewise = datewiseAPI.DatewiseAPI();
        Statement statement = null;
        try{
            statement = connection.createStatement();
            statement.executeUpdate("TRUNCATE TABLE DATEWISENATIONAL");
            for(Datewise.Data data : datewise.data){
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO DATEWISENATIONAL VALUES(?,?,?,?)");
                preparedStatement.setString(1, data.getDay());
                preparedStatement.setInt(2, data.getSummary().getTotal());
                preparedStatement.setInt(3, data.getSummary().getDischarged());
                preparedStatement.setInt(4, data.getSummary().getDeaths());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}