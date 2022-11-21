package it.aesys.academy.hbonetomany.config;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@EnableTransactionManagement //abilito l'annotation-driven transaction management
@Configuration
public class HibernateConfig {

    // properties che prendo dal file application.yml
    @Autowired
    private org.springframework.core.env.Environment env;

    // configurazione datasource
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("hibernate.driver"));
        dataSource.setUrl(env.getProperty("hibernate.datasource-url"));
        dataSource.setUsername(env.getProperty("hibernate.username"));
        dataSource.setPassword(env.getProperty("hibernate.password"));
        return dataSource;
    }

    // configurazione session factory di hibernate
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(env.getProperty("hibernate.package_to_scan"));

        Properties hibernateProperties = new Properties();
        hibernateProperties.put(Environment.DIALECT, env.getProperty("hibernate.dialect"));
        hibernateProperties.put(Environment.HBM2DDL_AUTO, env.getProperty("hibernate.ddl-auto"));
        hibernateProperties.put(Environment.POOL_SIZE, env.getProperty("hibernate.pool_size"));
        hibernateProperties.put(Environment.SHOW_SQL, env.getProperty("hibernate.show_sql"));
        hibernateProperties.put(Environment.FORMAT_SQL, env.getProperty("hibernate.format_sql"));
        //hibernateProperties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, env.getProperty("hibernate.current_session_context_class"));
        sessionFactory.setHibernateProperties(hibernateProperties);

        return sessionFactory;
    }

    // configurazione transaction manager di hibernate legandolo a spring
    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
