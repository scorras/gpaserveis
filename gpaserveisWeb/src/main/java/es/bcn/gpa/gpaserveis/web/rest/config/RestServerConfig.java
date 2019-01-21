package es.bcn.gpa.gpaserveis.web.rest.config;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaActualitzarSolicitudMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaCercaExpedientsMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaCercaProcedimentsMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaConsultaDadesOperacioMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaConsultaDocumentsMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaConsultaExpedientsMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaConsultaProcedimentsMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaCrearSolicitudMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaObrirSolicitudMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaRegistrarSolicitudMockService;
import net.opentrends.openframe.services.rest.apidocs.config.RestServiceDefaultSwaggerConfiguration;
import net.opentrends.openframe.services.rest.http.ResponseEntity;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@ComponentScan(basePackages = "es.bcn.gpa.gpaserveis.web.rest.controller")
@EnableWebMvc
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

	@Bean(name = "respostaCercaExpedientMock")
	public RespostaCercaExpedientsMockService respostaCercaExpedientMock() {
		RespostaCercaExpedientsMockService respostaCercaExpedientMock = new RespostaCercaExpedientsMockService();
		respostaCercaExpedientMock.initialize();
		return respostaCercaExpedientMock;
	}

	@Bean(name = "respostaConsultaExpedientMock")
	public RespostaConsultaExpedientsMockService respostaConsultaExpedientMock() {
		return new RespostaConsultaExpedientsMockService();
	}

	@Bean(name = "respostaCrearSolicitudMock")
	public RespostaCrearSolicitudMockService respostaCrearSolicitudMock() {
		return new RespostaCrearSolicitudMockService();
	}

	@Bean(name = "respostaActualitzarSolicitudMock")
	public RespostaActualitzarSolicitudMockService respostaActualitzarSolicitudMock() {
		return new RespostaActualitzarSolicitudMockService();
	}

	@Bean(name = "respostaRegistrarSolicitudMock")
	public RespostaRegistrarSolicitudMockService respostaRegistrarSolicitudMock() {
		return new RespostaRegistrarSolicitudMockService();
	}

	@Bean(name = "respostaObrirSolicitudMock")
	public RespostaObrirSolicitudMockService respostaObrirSolicitudMock() {
		return new RespostaObrirSolicitudMockService();
	}

	@Bean(name = "apiDocumentedByRestService")
	public Docket apiDocumentedByRestService() {
		return super.apiDocumentedByRestService().pathProvider(null).genericModelSubstitutes(ResponseEntity.class).forCodeGeneration(true)
		        .useDefaultResponseMessages(true);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean
	public ModelMapper modelMapper(List<PropertyMap> propertyMapList) {
		final ModelMapper modelMapper = new ModelMapper();
		// modelMapper.getConfiguration().setFieldMatchingEnabled(false).setImplicitMappingEnabled(false);
		for (PropertyMap propertyMap : propertyMapList) {
			if (propertyMap != null) {
				modelMapper.addMappings(propertyMap);
			}
		}
		return modelMapper;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}