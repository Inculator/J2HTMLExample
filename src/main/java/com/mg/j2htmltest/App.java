package com.mg.j2htmltest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import j2html.tags.ContainerTag;
import j2html.tags.Tag;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static j2html.TagCreator.*;

public class App {

	public static void main(String[] args) {
		 File file = new File("d:\\Profiles\\mogupta\\Desktop\\ABC.html");
//		File file = new File("C:\\Users\\akanksha\\Desktop\\ABC.html");
		try {
			Example exp = new App().readTestFile();
            createHtml(file, exp);
        } catch (IOException e) {
			e.printStackTrace();
		}

	}

    private static void createHtml(File file, Example exp) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(ul(each(exp.getSteps(), step -> createDivForEachStep(step))).renderFormatted());
        writer.close();
    }

    private static ContainerTag createDivForEachStep(String step) {
	    String basePath = "D:\\Profiles\\mogupta\\Desktop\\Trainings\\Java FX\\J2HTMLExample\\src\\main\\resources\\images\\";
	    String src = basePath+ "task.png";
	    if(step.equalsIgnoreCase("if"))
	        src = basePath + "If.png";
        if(step.equalsIgnoreCase("tsetup"))
            src = basePath + "Setup.png";
        if(step.equalsIgnoreCase("tswitch"))
            src = basePath + "switch.png";
        return b(div(img().withSrc(src), text(step.toString())));
        //https://github.com/tipsy/j2html/blob/master/src/test/java/j2html/tags/TagCreatorTest.java
    }

    private Example readTestFile() {
		// https://www.mkyong.com/java/jackson-tree-model-example/
		ObjectMapper objectMapper = new ObjectMapper();
		Example exp = new Example();
		try {
			File file = new File(
					Paths.get("src/main/resources/file/_AC_Proposed_Eligibility_Code_Out_Of_Bank_Guarantee.tscenario")
							.toUri());

			JsonNode root = objectMapper.readTree(file);
			List<String> myStepsList = new ArrayList<>();

			JsonNode steps = root.path("steps");
			for (JsonNode node : steps) {
				myStepsList.add(node.path("type").asText());
			}
			exp.setSteps(myStepsList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exp;
	}

	private ClassLoader getClassLoader() {
		return getClass().getClassLoader();
	}

	private static String generateHTML() {

		return html(generateBody()).renderFormatted();
	}

	private static ContainerTag generateBody() {
		return body(generetaH1Title(), generateForm());
	}

	private static ContainerTag generateForm() {
		return form().withMethod("post").withAction("/yourServlet").with(generateUserField(), generatePasswordField());
	}

	private static Tag generateUserField() {
		return input().withType("text").withName("user").withId("user");
	}

	private static ContainerTag generetaH1Title() {
		return h1("Hello World - Body!");
	}

	private static Tag generatePasswordField() {
		return input().withType("password").withName("password").withId("password");
	}
}
