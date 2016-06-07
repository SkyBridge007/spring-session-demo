/*
 * Copyright 2014-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bridge.session.web;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

// tag::class[]
@WebServlet("/session")
public class SessionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 2878267318695777395L;
	
	private final static Logger logger = Logger.getLogger(SessionServlet.class);

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		logger.info("requestUrl:"+req.getRequestURI()+",Session ID:"+req.getRequestedSessionId());
		String attributeName = req.getParameter("attributeName");
		String attributeValue = req.getParameter("attributeValue");
		req.getSession().setAttribute(attributeName, attributeValue);
		resp.sendRedirect(req.getContextPath() + "/");
	}

	/**
	 * invoke test url:http://localhost:8080/spring-session-demo/springsession?attributeName=name&attributeValue=tiger
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
}
// tag::end[]
