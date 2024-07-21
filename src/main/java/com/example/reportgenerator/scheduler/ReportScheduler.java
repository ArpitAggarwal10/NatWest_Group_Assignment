package com.example.reportgenerator.scheduler;

import com.example.reportgenerator.service.ReportService;
import com.example.reportgenerator.repository.CsvRepository;
import com.example.reportgenerator.model.Output;
import com.example.reportgenerator.model.Input;
import com.example.reportgenerator.model.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.List;

@Component
public class ReportScheduler {

    @Autowired
    private ReportService reportService;

    @Autowired
    private CsvRepository csvRepository;

    @Scheduled(cron = "0 0 0 * * ?") // This cron expression runs every day at midnight
    public void generateDailyReport() {
        try {
            String inputFilePath = "path/to/input.csv";
            String referenceFilePath = "path/to/reference.csv";
            String outputFilePath = "path/to/output.csv";

            List<Input> inputs = csvRepository.readInputs(inputFilePath);
            List<Reference> references = csvRepository.readReferences(referenceFilePath);
            List<Output> outputs = reportService.generateReport(inputs, references);
            csvRepository.writeOutputs(outputFilePath, outputs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
