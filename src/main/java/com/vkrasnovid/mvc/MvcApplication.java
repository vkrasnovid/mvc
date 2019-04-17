package com.vkrasnovid.mvc;

import com.vkrasnovid.mvc.dao.EmployeeDAO;
import com.vkrasnovid.mvc.dao.EmployeeDAOImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class MvcApplication {
	public static void main(String[] args) {
		SpringApplication.run(MvcApplication.class, args);
	}

	@Bean
	public EmployeeDAO employeeDAO(JdbcTemplate jdbcTemplate) {
		return new EmployeeDAOImpl(jdbcTemplate);
	}
}
