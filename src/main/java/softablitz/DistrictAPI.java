package softablitz;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DistrictAPI {
    public District DistrictAPI() throws IOException, InterruptedException {
        String searchUrl = "https://api.covidindiatracker.com/state_data.json";
        Gson gson = new GsonBuilder().create();

        try
        {
            File myFile = new File("District.json");
            FileOutputStream fos = new FileOutputStream("District.json");

            URL url = new URL(searchUrl);
            URLConnection urlcon = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));

            int c;
            while((c=br.read())!=-1) // write to file
            {
                fos.write((char) c);
            }
            fos.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //now gson handling
        try {
            URL url = new URL(searchUrl);
            URLConnection urlcon = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));

            District response = gson.fromJson(br, (Type) District.class); // created response object
            return response;
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
