package com.spring5.practice.config;

import com.spring5.practice.config.security.SecurityConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.DispatcherServlet;


import javax.servlet.*;

public class AppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) {

        // ------------------ region RootContext creation and registration ----------------------
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class , DbConfig.class, SecurityConfig.class);
        rootContext.refresh();

        servletContext.addListener(new ContextLoaderListener(rootContext));
        // ------------------- endregion RootContext creation and registration ----------------------

        // ------------------ region ServletContext creation and registration ----------------------
        AnnotationConfigWebApplicationContext servletConfig = new AnnotationConfigWebApplicationContext();
        servletConfig.register(ServletConfig.class);

        // Multipart Config
        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("servlet", new DispatcherServlet(servletConfig));
        servletRegistration.setMultipartConfig(new MultipartConfigElement("/", 2097152, 4194304, 50));

        // Multipart Filter Config
        FilterRegistration.Dynamic multipartFilter = servletContext.addFilter("multipartFilter", MultipartFilter.class);
        multipartFilter.addMappingForUrlPatterns(null, true, "/*");
        // ------------------ endregion ServletContext creation and registration ----------------------

        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("/");
    }
}
