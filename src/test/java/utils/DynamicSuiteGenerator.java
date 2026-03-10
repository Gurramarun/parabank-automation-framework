package utils;

import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DynamicSuiteGenerator {

    public static void main(String[] args) throws IOException {

        // 1. Create a suite
        XmlSuite suite = new XmlSuite();
        suite.setName("ParaBank Automation Dynamic Suite");
        suite.setVerbose(1);
        suite.setParallel(XmlSuite.ParallelMode.NONE);

        // 2. Create a test
        XmlTest test = new XmlTest(suite);
        test.setName("All ParaBank Tests");

        // 3. Add classes dynamically (add your test class names here)
        List<XmlClass> classes = new ArrayList<>();
        classes.add(new XmlClass("tests.RegisterTest"));
        classes.add(new XmlClass("tests.LoginTest"));
        classes.add(new XmlClass("tests.AccountOverviewTest"));
        classes.add(new XmlClass("tests.FundTransferTest"));
        classes.add(new XmlClass("tests.BillPaymentTest"));

        test.setXmlClasses(classes);

        // 4. Write the suite to testng.xml
        try (FileWriter writer = new FileWriter("testng.xml")) {
            writer.write(suite.toXml());
        }

        System.out.println("Dynamic testng.xml generated successfully!");
    }
}