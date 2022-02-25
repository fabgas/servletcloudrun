package org.alma.servletcloudrun;

import java.io.IOException;
import java.util.Base64;

import javax.sql.DataSource;

import org.alma.servletcloudrun.model.Body;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PubSubServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getReader().toString());
		   DataSource pool = (DataSource) req.getServletContext().getAttribute("my-pool");
		Body body = new Gson().fromJson(req.getReader(), Body.class);
		 System.out.println("Fichier uploader" + body);
		String data = body.getMessage().getData();
		 System.out.println("Fichier uploader" + data);
        String target =
                  !StringUtils.isEmpty(data) ? new String(Base64.getDecoder().decode(data)) : "World";
        JsonObject jsonObject = new Gson().fromJson(target, JsonObject.class);
        System.out.println("Fichier uploader" + target);
        System.out.println("nom du fichier" + jsonObject.get("name").getAsString());
	}

	
}
