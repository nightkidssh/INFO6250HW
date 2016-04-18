//package edu.neu.boweiwang.configFiles;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.security.access.SecurityConfig;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.JstlView;
//
///**
// * Created by kym-1992 on 3/30/16.
// */
//@EnableWebMvc
//@Configuration
//@ComponentScan({ "edu.neu.boweiwang.Controller" })
//@Import({ SecurityConfig.class })
//public class appConfig {
//
////    @Bean(name = "dataSource")
////    public DriverManagerDataSource dataSource() {
////        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
////        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
////        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/finalproject6250");
////        driverManagerDataSource.setUsername("root");
////        driverManagerDataSource.setPassword("j-epyppsC5Qg");
////        return driverManagerDataSource;
////    }
//
//    @Bean
//    public InternalResourceViewResolver viewResolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setViewClass(JstlView.class);
//        viewResolver.setPrefix("/WEB-INF/jsp/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }
//}
