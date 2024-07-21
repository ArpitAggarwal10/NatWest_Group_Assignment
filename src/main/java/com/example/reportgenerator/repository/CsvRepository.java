package com.example.reportgenerator.repository;

import com.example.reportgenerator.model.Input;
import com.example.reportgenerator.model.Reference;
import com.example.reportgenerator.model.Output;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.stereotype.Repository;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Repository
public class CsvRepository {

    public List<Input> readInputs(String filePath) throws IOException {
        return new CsvToBeanBuilder<Input>(new FileReader(filePath))
                .withType(Input.class)
                .build()
                .parse();
    }

    public List<Reference> readReferences(String filePath) throws IOException {
        return new CsvToBeanBuilder<Reference>(new FileReader(filePath))
                .withType(Reference.class)
                .build()
                .parse();
    }

    public void writeOutputs(String filePath, List<Output> outputs) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            StatefulBeanToCsv<Output> beanToCsv = new StatefulBeanToCsvBuilder<Output>(writer)
                    .withSeparator(',')
                    .build();

            try {
                beanToCsv.write(outputs);
            } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
                // Handle specific exceptions here
                e.printStackTrace(); // Or log the exception using a logging framework like SLF4J
                // Optionally, you can throw a custom exception or handle the error based on your application's requirements
            }
        }
    }
}
