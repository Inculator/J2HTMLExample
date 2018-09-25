package com.mg.j2htmltest;

import static j2html.TagCreator.body;
import static j2html.TagCreator.each;
import static j2html.TagCreator.form;
import static j2html.TagCreator.h1;
import static j2html.TagCreator.html;
import static j2html.TagCreator.input;
import static j2html.TagCreator.li;
import static j2html.TagCreator.ul;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import j2html.tags.ContainerTag;
import j2html.tags.Tag;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// File file = new File("d:\\Profiles\\mogupta\\Desktop\\ABC.html");
		File file = new File("C:\\Users\\akanksha\\Desktop\\ABC.html");
		try {
			Example exp = new App().readTestFile();
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(ul(each(exp.getSteps(), step -> li(step.toString()))).renderFormatted());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

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
