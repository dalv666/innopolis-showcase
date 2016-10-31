package ru.innopolis.master.ms1.university.dmd.showcase.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"ru.innopolis.master.ms1.university.dmd.showcase.common.model", "ru.innopolis.master.ms1.university.dmd.showcase.service"})
public class CoreConfig {
}
