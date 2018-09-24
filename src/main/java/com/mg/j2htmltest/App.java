package com.mg.j2htmltest;

import static j2html.TagCreator.body;
import static j2html.TagCreator.each;
import static j2html.TagCreator.form;
import static j2html.TagCreator.h1;
import static j2html.TagCreator.html;
import static j2html.TagCreator.input;
import static j2html.TagCreator.li;
import static j2html.TagCreator.ul;
import static java.util.Arrays.asList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import j2html.tags.ContainerTag;
import j2html.tags.Tag;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		File file = new File("C:\\Users\\akanksha\\Desktop\\ABC.html");
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(ul(each(asList(1, 2, 3), i -> li("Number " + i))).renderFormatted());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(generateHTML());

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
