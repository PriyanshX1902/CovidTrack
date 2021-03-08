package softablitz;

import java.sql.*;

public class HelplineSQL {

    public static void HelplineSQL() {
        HelplineAPI helplineAPI = new HelplineAPI();
        Connection connection = SQLConnection.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("TRUNCATE TABLE HELPLINESREGIONAL");

            Helpline helpline = helplineAPI.HelplineAPI();

            for (Helpline.HelplineData.Contacts.Regional regional : helpline.data.contacts.regional) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO HELPLINESREGIONAL VALUES (?,?)");
                preparedStatement.setString(1, regional.getLoc());
                preparedStatement.setString(2, regional.getNumber());
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

