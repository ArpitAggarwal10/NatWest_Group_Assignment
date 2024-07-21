package com.example.reportgenerator.service;

import static org.junit.jupiter.api.Assertions.*;
import com.example.reportgenerator.model.Input;
import com.example.reportgenerator.model.Reference;
import com.example.reportgenerator.model.Output;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ReportServiceTest {

    private final ReportService reportService = new ReportService();

    @Test
    public void testGenerateReport() {
        Input input = new Input("field1", "field2", "field3", new BigDecimal("10"), "key1", "key2");
        Reference reference = new Reference("key1", "ref1", "key2", "ref2", "ref3", new BigDecimal("20"));
        List<Output> outputs = reportService.generateReport(Arrays.asList(input), Arrays.asList(reference));

        assertNotNull(outputs);
        assertEquals(1, outputs.size());

        Output output = outputs.get(0);
        assertEquals("field1field2", output.getOutfield1());
        assertEquals("ref1", output.getOutfield2());
        assertEquals("ref2ref3", output.getOutfield3());
        assertEquals(new BigDecimal("20"), output.getOutfield4());
        assertEquals(new BigDecimal("200"), output.getOutfield5());
    }
}
