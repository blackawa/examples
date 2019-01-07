import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class UseServiceAccount {
    private static final String SERVICE_ACCOUNT_JSON_FILE_PATH = "src/main/resources/serviceAccount.json";
    private static final String SPREADSHEET_ID = "1YHPIFP9h-IrCpy7ZThmp5m609BjVXXdo5GzPWPl4YZo";

    private static GoogleCredential getCredential(HttpTransport transport, JsonFactory jsonFactory) throws IOException {
        return GoogleCredential.fromStream(new FileInputStream(SERVICE_ACCOUNT_JSON_FILE_PATH), transport, jsonFactory)
                .createScoped(SheetsScopes.all());
    }

    private static Sheets getSheetsService(HttpTransport transport, JsonFactory jsonFactory, GoogleCredential credential) {
        return new Sheets.Builder(transport, jsonFactory, credential).setApplicationName("Sheets API お試し").build();
    }

    public static void main(String[] args) throws IOException, GeneralSecurityException {
        HttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
        GoogleCredential credential = getCredential(transport, jsonFactory);
        Sheets sheetsService = getSheetsService(transport, jsonFactory, credential);
        String range = "Sheet 1!A2:F31";
        ValueRange res = sheetsService.spreadsheets().values().get(SPREADSHEET_ID, range).execute();
        System.out.println("Hello~~~~");
    }
}
