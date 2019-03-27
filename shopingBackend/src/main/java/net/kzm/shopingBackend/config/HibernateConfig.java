package net.kzm.shopingBackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan(basePackages= {"net.kzm.shopingBackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	      //change the below based on the Database
	        private final static String DATABASE_URL="jdbc:mysql://localhost:3306/shopping";
			private final static String DATABASE_DRIVER="com.mysql.jdbc.Driver";
			private final static String DATABASE_DIALECT="org.hibernate.dialect.MySQLDialect";
			private final static String DATABASE_USERNAME="root";
			private final static String DATABASE_PASSWORD="mysql";
			
			@Bean
			public  DataSource getDataSource()
			{
				BasicDataSource dataSource=new BasicDataSource();
				dataSource.setDriverClassName(DATABASE_DRIVER);
				dataSource.setUrl(DATABASE_URL);
				dataSource.setUsername(DATABASE_USERNAME);
				dataSource.setPassword(DATABASE_PASSWORD);
				return dataSource;
			}
			
			@Bean
			public SessionFactory getSessionFactory(DataSource dataSource)
			{
				LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource);
				builder.addProperties(getHibernateProperties());
				builder.scanPackages("net.kzm.shopingBackend.dto");
				return builder.buildSessionFactory();
			}

			private Properties getHibernateProperties() {
				Properties prop=new Properties();
				prop.put("hibernate.dialect",DATABASE_DIALECT);
	            prop.put("hibernate.show_sql","true");
	            prop.put("hibernate.format_sql","true");
				return prop;
			}
			
			@Bean
			public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
			{
				HibernateTransactionManager htm=new HibernateTransactionManager(sessionFactory);
				
				return htm;
			}

}
