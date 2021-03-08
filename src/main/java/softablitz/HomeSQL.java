package softablitz;

import java.sql.*;

public class HomeSQL {

    public static void HomeSQL() {
        HomeAPI homeAPI = new HomeAPI();
        Connection connection = SQLConnection.getConnection();
        Statement statement = null;
        try{
            statement = connection.createStatement();
            statement.executeUpdate("TRUNCATE TABLE STATEWISE");

            Home home = homeAPI.HomeAPI();
            for(Home.regionData regiondata: home.regionData) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO STATEWISE VALUES (?,?,?,?,?)");
                preparedStatement.setString(1, regiondata.getRegion());
                preparedStatement.setInt(2, regiondata.getTotalInfected());

                preparedStatement.setInt(3, regiondata.getRecovered());

                preparedStatement.setInt(4, regiondata.getDeceased());
                preparedStatement.setInt(5, regiondata.getTotal());

                preparedStatement.executeUpdate();
            }

            /*statement.executeUpdate("TRUNCATE TABLE HOME");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO HOME VALUES (?,?,?,?,?,?,?,?,?,?,?");
            preparedStatement.setInt(1, home.getActiveCases());
            preparedStatement.setInt(2, home.getActiveCasesNew());
            preparedStatement.setInt(3, home.getRecovered());
            preparedStatement.setInt(4, home.getRecoveredNew());
            preparedStatement.setInt(5, home.getDeaths());
            preparedStatement.setInt(6, home.getDeathsNew());
            preparedStatement.setInt(7, home.getPreviousDayTests());
            preparedStatement.setInt(8, home.getTotalCases());
            preparedStatement.setString(9, home.getSourceUrl());
            preparedStatement.setString(10, home.getLastUpdatedAtApify());
            preparedStatement.setString(11, home.getReadMe());
            preparedStatement.executeUpdate();
            */


        }catch (SQLException e){
            e.printStackTrace();;
        }
        catch (Exception e){
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
