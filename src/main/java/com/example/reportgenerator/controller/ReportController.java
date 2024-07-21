package com.example.reportgenerator.controller;

import com.example.reportgenerator.service.ReportService;
import com.example.reportgenerator.repository.CsvRepository;
import com.example.reportgenerator.model.Output;
import com.example.reportgenerator.model.Input;
import com.example.reportgenerator.model.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private CsvRepository csvRepository;

    @PostMapping("/generate")
    public List<Output> generateReport(@RequestParam String inputFilePath,
                                       @RequestParam String referenceFilePath,
                                       @RequestParam String outputFilePath) throws IOException {
        List<Input> inputs = csvRepository.readInputs(inputFilePath);
        List<Reference> references = csvRepository.readReferences(referenceFilePath);
        List<Output> outputs = reportService.generateReport(inputs, references);
        csvRepository.writeOutputs(outputFilePath, outputs);
        return outputs;
    }
}
