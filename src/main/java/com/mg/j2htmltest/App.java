package com.mg.j2htmltest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import j2html.tags.ContainerTag;
import j2html.tags.Tag;

import java.io.*;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static j2html.TagCreator.*;
import static java.util.Arrays.asList;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		File file = new File("d:\\Profiles\\mogupta\\Desktop\\ABC.html");
		try {
		    new App().readTestFile();
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(ul(each(asList(1, 2, 3), i -> li("Number " + i))).renderFormatted());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

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
