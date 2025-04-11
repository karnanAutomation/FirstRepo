package utility;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import action.Baseclass;

@SuppressWarnings("deprecation")
public class GoogleSheetsReader extends Baseclass{
    private static final String SPREADSHEET_ID = "1p6vWvqPWJS4CfVJ2d7GTluuCTQZwB1z3jIwIW1lKiaw"; // Replace with your actual Spreadsheet ID
    // public String RANGE = "Karna"; // Fetch all columns from the second sheet
    private static final String API_KEY = "AIzaSyCCgPeR92txy893y1IK9nw4bZFUJsqZp9E"; // Replace with your actual API Key
    private static final String RANGE = "credentials!A:E";

    public static List<List<Object>> getLocators(String sheetName) throws IOException, GeneralSecurityException {
        // Set up the Sheets API client
        Sheets sheetsService = new Sheets.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JacksonFactory.getDefaultInstance(),
                null) // No credentials needed for API key
                .setApplicationName("Playwright Google Sheets Integration")
                .build();

        try {
            // Read data from the sheet using the API key
            ValueRange response = sheetsService.spreadsheets().values()
                    .get(SPREADSHEET_ID, sheetName)
                    .setKey(API_KEY) // Add the API key here
                    .execute();

            List<List<Object>> values = response.getValues();
            if (values == null || values.isEmpty()) {
                System.out.println("No data found in the sheet: " + sheetName);
                return Collections.emptyList();
            }

            return values;
        } catch (IOException e) {
            System.err.println("Error reading data from Google Sheets: " + e.getMessage());
            throw e;
        }
    }



/* Going to login using the system name by geting the system name as well */

    public static String getSystemName() throws IOException {
        return System.getProperty("user.name");
    }

    public static String[] fetchCredentialsforclassmain(String testClassName) throws IOException, GeneralSecurityException {
        List<List<Object>> values = getSheetData();
        String systemName = getSystemName().trim(); // Ensure no extra spaces

        System.out.println("Detected System Name: " + systemName);

        if (values == null || values.isEmpty()) {
            System.out.println("No data found in the sheet.");
            return null;
        }

        for (List<Object> row : values) {
            if (row.size() < 5) continue; // Ensure all necessary columns exist

            String sheetSystemName = Objects.toString(row.get(3), "").trim(); // Column D - System Name
            String username = Objects.toString(row.get(1), "");  // Column B - Username

            // Determine client ID column dynamically
            boolean isSmokeOwnerUK = testClassName.equalsIgnoreCase("smokeOwner") && !username.equalsIgnoreCase("office");
            boolean isSmokeOwnerUS = testClassName.equalsIgnoreCase("smokeOwnerUS") && !username.equalsIgnoreCase("office");
            boolean isSmokeOfficeStaff = testClassName.equalsIgnoreCase("smokeOwner") && username.equalsIgnoreCase("office");

            if (isSmokeOwnerUK || isSmokeOwnerUS || isSmokeOfficeStaff) {
                if (systemName.equalsIgnoreCase(sheetSystemName)) {
                    String clientId = isSmokeOwnerUS ? Objects.toString(row.get(4), "") : Objects.toString(row.get(0), "");  // Column E for US, Column A for others
                    String password = Objects.toString(row.get(2), "");  // Column C - Password

                    System.out.println("✅ Match found! Logging in with:");
                    System.out.println("Client ID: " + clientId + ", Username: " + username);

                    return new String[]{clientId, username, password};
                }
            }
        }

        System.out.println("❌ No matching system name found in Google Sheets.");
        return null;
    }






    public static List<List<Object>> getSheetData() throws IOException, GeneralSecurityException {
        Sheets sheetsService = new Sheets.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JacksonFactory.getDefaultInstance(),
                null) // No credentials needed for API key
                .setApplicationName("Google Sheets Integration")
                .build();
    
        try {
            // Fetch data from the correct sheet
            ValueRange response = sheetsService.spreadsheets().values()
                    .get(SPREADSHEET_ID, RANGE) // ✅ Ensure correct sheet name
                    .setKey(API_KEY)
                    .execute();
    
            return response.getValues();
        } catch (IOException e) {
            System.err.println("Error reading data from Google Sheets: " + e.getMessage());
            throw e;
        }
    }
    



    



    }