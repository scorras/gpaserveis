package es.bcn.gpa.gpaserveis.web.rest.config;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import es.bcn.gpa.gpaserveis.web.rest.controller.converter.StringToDocumentComplecioRDTOConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.converter.StringToDocumentIncorporacioNouRDTOConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.converter.StringToRequerimentPreparacioRDTOConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.converter.StringToRespostaNotificacioRDTOConverter;
import net.opentrends.openframe.services.rest.apidocs.config.RestServiceDefaultSwaggerConfiguration;
import net.opentrends.openframe.services.rest.http.ResponseEntity;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@ComponentScan(basePackages = "es.bcn.gpa.gpaserveis.web.rest.controller")
@EnableWebMvc
@Lazy(true)
public class RestServerConfig extends RestServiceDefaultSwaggerConfiguration {

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.opentrends.openframe.services.rest.apidocs.config.
	 * RestServiceDefaultSwaggerConfiguration#apiDocumentedByRestService()
	 */
	@Bean(name = "apiDocumentedByRestService")
	public Docket apiDocumentedByRestService() {
		return super.apiDocumentedByRestService().pathProvider(null).genericModelSubstitutes(ResponseEntity.class).forCodeGeneration(true)
				.useDefaultResponseMessages(true);
	}

	/**
	 * Model mapper.
	 *
	 * @param propertyMapList
	 *            the property map list
	 * @return the model mapper
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean
	public ModelMapper modelMapper(List<PropertyMap> propertyMapList) {
		final ModelMapper modelMapper = new ModelMapper();
		// modelMapper.getConfiguration().setFieldMatchingEnabled(false).setImplicitMappingEnabled(false);
		// modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		for (PropertyMap propertyMap : propertyMapList) {
			if (propertyMap != null) {
				modelMapper.addMappings(propertyMap);
			}
		}
		return modelMapper;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
	 * #addResourceHandlers(org.springframework.web.servlet.config.annotation.
	 * ResourceHandlerRegistry)
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
	 * #addFormatters(org.springframework.format.FormatterRegistry)
	 */
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new StringToDocumentIncorporacioNouRDTOConverter());
		registry.addConverter(new StringToRequerimentPreparacioRDTOConverter());
		registry.addConverter(new StringToDocumentComplecioRDTOConverter());
		registry.addConverter(new StringToRespostaNotificacioRDTOConverter());
	}

}