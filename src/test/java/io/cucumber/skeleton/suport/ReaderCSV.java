package io.cucumber.skeleton.suport;

import java.io.Reader;
import com.opencsv.CSVReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReaderCSV {

    public ArrayList<String> oneByOne(String SAMPLE_CSV_FILE_PATH, String CT) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        String[] nextRecord;

        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading Records One by One in a String array
            while ((nextRecord = csvReader.readNext()) != null) {

                if (nextRecord[0].equalsIgnoreCase(CT)){
                    for (String cell : nextRecord) {
                        //System.out.print(cell + ",");
                        list.add(cell);
                    }
                }
            }
            System.out.print("\n");
            reader.close();
            csvReader.close();

        }
        return list;
    }
}

