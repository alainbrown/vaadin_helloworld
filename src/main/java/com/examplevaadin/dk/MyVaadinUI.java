package com.examplevaadin.dk;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.Tree;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

	@WebServlet(value = "/*",
			asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false,
			ui = MyVaadinUI.class,
			widgetset = "com.examplevaadin.dk.AppWidgetSet")
	public static class Servlet extends VaadinServlet {}

	@Override protected void init(VaadinRequest request) {

		final VerticalLayout layout = new VerticalLayout();
		// layout.setMargin(true);
		layout.setSizeFull();
		setContent(layout);

		final Button button = new Button("Click Me");
		button.addClickListener(new Button.ClickListener() {

			public void buttonClick(ClickEvent event) {

				layout.addComponent(new Label("Thank you for clicking"));
				button.setEnabled(false);
			}
		});
		layout.addComponent(button);

		HorizontalLayout hor = new HorizontalLayout();
		hor.setSizeFull();
		Tree tree = new Tree();
		tree.addItem();
		hor.addComponent(tree);

		Table table = new Table();
		table.setSizeFull();
		hor.addComponent(table);
		hor.setExpandRatio(table, 1);

		layout.addComponent(hor);
		layout.setExpandRatio(hor, 1);
	}

}
