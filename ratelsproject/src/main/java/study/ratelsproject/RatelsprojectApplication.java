package study.ratelsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class RatelsprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatelsprojectApplication.class, args);

		//ApplicationContext context = SpringApplication.run(RatelsprojectApplication.class, args);
		//AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		/*
		String[] beanNames = context.getBeanDefinitionNames();
		Arrays.sort(beanNames);

		for(String beanName : beanNames) {
			System.out.println(beanName);
			Object bean = context.getBean(beanName);
			System.out.println("name  : " + bean.getClass().getName());
		}

		 */

	}

}
