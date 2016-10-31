package ru.innopolis.master.ms1.university.dmd.showcase.web.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ru.innopolis.master.ms1.university.dmd.showcase.web")
public class AppConfig {



}
