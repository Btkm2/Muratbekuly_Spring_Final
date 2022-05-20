package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class JDBCConfig {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/Java_Spring_Final");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("1234");

        return driverManagerDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        GenericApplicationContext applicationContext = new GenericApplicationContext();
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        return new JdbcTemplate(dataSource);
    }
}
