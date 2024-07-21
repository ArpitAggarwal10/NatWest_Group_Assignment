package com.example.reportgenerator.service;

import com.example.reportgenerator.model.Input;
import com.example.reportgenerator.model.Reference;
import com.example.reportgenerator.model.Output;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {

    public List<Output> generateReport(List<Input> inputs, List<Reference> references) {
        return inputs.stream().map(input -> {
            Reference ref = findReference(input.getRefkey1(), input.getRefkey2(), references);
            return transform(input, ref);
        }).collect(Collectors.toList());
    }

    private Reference findReference(String refkey1, String refkey2, List<Reference> references) {
        return references.stream()
                .filter(ref -> ref.getRefkey1().equals(refkey1) && ref.getRefkey2().equals(refkey2))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Reference data not found"));
    }

    private Output transform(Input input, Reference reference) {
        String outfield1 = input.getField1() + input.getField2();
        String outfield2 = reference.getRefdata1();
        String outfield3 = reference.getRefdata2() + reference.getRefdata3();
        BigDecimal outfield4 = input.getField5().max(reference.getRefdata4());
        BigDecimal outfield5 = input.getField5().multiply(outfield4);

        return new Output(outfield1, outfield2, outfield3, outfield4, outfield5);
    }
}
