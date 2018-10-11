package es.bcn.gpa.gpaserveis.web.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaCercaProcedimentsMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaConsultaDadesOperacioMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaConsultaDocumentsMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaConsultaProcedimentsMockService;
import net.opentrends.openframe.services.rest.apidocs.config.RestServiceDefaultSwaggerConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@ComponentScan(basePackages = "es.bcn.gpa.gpaserveis.web.rest.controller")
@Lazy(true)
public class RestServerConfig extends RestServiceDefaultSwaggerConfiguration {
	
	
    @Bean(name = "respostaCercaProcedimentMock")
	public RespostaCercaProcedimentsMockService respostaCercaProcedimentMock() {
    	RespostaCercaProcedimentsMockService respostaCercaProcedimentMock = new RespostaCercaProcedimentsMockService();
    	respostaCercaProcedimentMock.initialize();
		return respostaCercaProcedimentMock;
	}
	
    @Bean(name = "respostaConsultaProcedimentMock")
	public RespostaConsultaProcedimentsMockService respostaConsultaProcedimentMock() {
		return new RespostaConsultaProcedimentsMockService();
	}	
	
    @Bean(name = "respostaConsultaDadesOperacioMockService")
	public RespostaConsultaDadesOperacioMockService respostaConsultaDadesOperacioMockService() {
		return new RespostaConsultaDadesOperacioMockService();
	}	
    
    @Bean(name = "respostaConsultaDocumentsMockService")
	public RespostaConsultaDocumentsMockService respostaConsultaDocumentsMockService() {
    	RespostaConsultaDocumentsMockService respostaConsultaDocumentsMockService = new RespostaConsultaDocumentsMockService();
    	respostaConsultaDocumentsMockService.initialize();
		return respostaConsultaDocumentsMockService;
	}
    
    
	
    @Bean(name = "apiDocumentedByRestService")
    public Docket apiDocumentedByRestService(){
    	 return new Docket(DocumentationType.SWAGGER_2)
    	            .select()
    	            .apis(RequestHandlerSelectors.any())
    	            .paths(PathSelectors.any())
    	            .build();    
    }    
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
          .addResourceLocations("classpath:/META-INF/resources/");
     
        registry.addResourceHandler("/webjars/**")
          .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}