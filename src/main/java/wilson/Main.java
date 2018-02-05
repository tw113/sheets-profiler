package wilson;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {

        Sheets service = SheetLoader.getSheetsService();

        String spreadsheetID = "1wNXlJwsLrN2tRZRLfysGlSWUxG6szTNI8gYoL8Eijm0";
        String range = "A:AW";

        ValueRange valueRange = service.spreadsheets().values()
                .get(spreadsheetID, range)
                .execute();

        valueRange.setMajorDimension("COLUMNS");
        int numOfKeys = valueRange.getValues().get(0).size();
        int numOfProfiles = valueRange.getValues().size() - 1;

        File data = new File("data.txt");
        BufferedWriter bw = null;

        try {

            //if the file doesn't exist, create it
            if (!data.exists()) {
                data.createNewFile();
            }

            FileWriter fw = new FileWriter(data);
            bw = new BufferedWriter(fw);

            //write to file in JSON format
            bw.write("[");
            for (int i = 1; i < numOfProfiles + 1; i++) {
                bw.write("{");
                for (int j = 0; j < numOfKeys; j++) {
                    bw.write("\"" + valueRange.getValues().get(0).get(j)
                             + "\":\"" + valueRange.getValues().get(i).get(j)
                             + "\"");
                    if(j != numOfKeys - 1) {
                        bw.write(",");
                    } else {
                        continue;
                    }
                }
                bw.write("}");

                if(i != numOfProfiles) {
                    bw.write(",");
                } else {
                    continue;
                }
            }
            bw.write("]");

            System.out.println("Wrote spreadsheet data to file successfully");
            System.out.println("Number of Form Questions: " + numOfKeys);
            System.out.println("Number of Profiles Found: " + numOfProfiles);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally {

            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (Exception e) {
                System.out.println("Failed to close BufferWriter " + e);
            }
        }

        BufferedReader bufferedReader = new BufferedReader(new FileReader(data));

        String dataContents = bufferedReader.readLine();

        JSONArray jsonArray = new JSONArray(dataContents);
        JSONObject obj;

        Gson gson = new Gson();

        Map<String, Profile> profiles = new TreeMap<String, Profile>();

        for (int i = 0; i < jsonArray.length(); i++) {
            obj = jsonArray.getJSONObject(i);

            Profile profile = gson.fromJson(obj.toString(), Profile.class);
            String key = profile.getName();
            profiles.put(key, profile);
        }

        for(Map.Entry<String, Profile> p : profiles.entrySet()) {
            System.out.println("Key: " + p.getKey());
            System.out.println("Value: " + p.getValue().toString());
            System.out.println("Email: " + p.getValue().getEmail());
            System.out.println("");
        }

    }
}
