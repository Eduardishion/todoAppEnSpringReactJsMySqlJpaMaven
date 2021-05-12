package app1.projectv1;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;


import app1.projectv1.Zmodelos.Auto;
import app1.projectv1.Zmodelos.Propietario;
import app1.projectv1.EntidadesTarea.Tarea;
import app1.projectv1.Zmodelos.repositorioPropietario;
import app1.projectv1.Zmodelos.repositorioAuto;
import java.util.Arrays;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import app1.projectv1.EntidadesTarea.RepositorioTarea;



@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})

public class ApplicationTarea {
        
        //inyeccion de dependeias de las clases a usar 
	@Autowired
	repositorioAuto repoMovil;
        
        @Autowired
        repositorioPropietario repoProp;
        
        @Autowired
        RepositorioTarea repoTarea;
        
    //metodo principal para correr la aplicacion 
    public static void main(String[] args) {
        
		SpringApplication.run(ApplicationTarea.class, args);
	}
        
//        Este bean se usa para configurar y aceptar acceso al API y desbloqueo la seguridad de CORS segunda forma 
//        para permitir peticones de componentes del front end por congifuracion CORS de manera GLOBAL
//        @Bean
//        public WebMvcConfigurer corsConfigurar(){
//            return new WebMvcConfigurerAdapter() {
//                @Override
//                public void addCorsMappings(CorsRegistry registry){
//                    registry.addMapping("/**")
//                            .allowedMethods("GET","POST","PUT","DELETE") //tipos de metodos que permite hacer 
//                            .allowedHeaders("*")                         //tipo de cabeceras que puede recibir
//                            .allowCredentials(true)
//                            .allowedOrigins("http://localhost:3000");    //host al que se le permite hacer hacer peticones 
//                            
//                }
//            };
//        }

//        Este bean se usa para configurar y aceptar acceso al API y desbloqueo la seguridad de CORS primera forma   
//        @Bean 
//        CorsConfigurationSource corsConfigurationSourse(){
//            
//            UrlBasedCorsConfigurationSource sourse = new UrlBasedCorsConfigurationSource();
//            CorsConfiguration config = new CorsConfiguration();
//            
//            config.setAllowedOrigins(Arrays.asList("*"));
//            config.setAllowedMethods(Arrays.asList("*"));
//            config.setAllowedHeaders(Arrays.asList("*"));
//            config.setAllowCredentials(true);
//            config.applyPermitDefaultValues();
//            
//            sourse.registerCorsConfiguration("/**", config);
//            
//            return sourse;
//        }

//      bean para crear datos de inicion en las base da datos
//	@Bean
//	CommandLineRunner runner(){
//		return args ->{
//                   
//                         //creando objetos de tipo propietario
//                        // Propietario propietario1 = new Propietario("Eduardo","Contreras");
//                        // Propietario propietario2 = new Propietario("Jose","Martinez");
//                        // Propietario propietario3 = new Propietario("Sandi","Flores");
//                       
//                         //insercion de objetos en tabla propietario
//                        // repoProp.save(propietario1);
//                        // repoProp.save(propietario2);
//                        // repoProp.save(propietario3);
//                       
//                       
//                        //creando objetos de tipo Auto e insertando objetos en tabla Auto 
//                        // Auto carro = new Auto("Ford","3 puertas"," verde", "123DE", 70, 15000,propietario1);
//                        // repoMovil.save(carro);
//                        
//                   
//                        // carro = new Auto("Douge","5 puertas","rojo", "879FD", 89, 90000,propietario2);
//                        // repoMovil.save(carro);
//                        
//                        
//                        // carro = new Auto("Tollota","2 puertas","blanco", "100FD", 98, 13000,propietario2);
//                        // repoMovil.save(carro);
//                        
//                        
//                        //creando objetos de tipo tarea 
//                        //Tarea tarea1 = new Tarea("comer", "comer con mi novia");
//                        //Tarea tarea2 = new Tarea("cenar", "cenar a las 10:10");
//                        //Tarea tarea3 = new Tarea("correr","por la mañana");
//                        
//                        //insercion de objetos en tabla tarea
//                        //repoTarea.save(tarea1);
//                        //repoTarea.save(tarea2);
//                        //repoTarea.save(tarea3);
//                        
//			
//	    };
//    }

}
