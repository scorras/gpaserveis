package es.bcn.gpa.gpaserveis.web.rest.controller.plugin;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.OperationBuilderPlugin;
import springfox.documentation.spi.service.contexts.OperationContext;
import springfox.documentation.swagger.common.SwaggerPluginSupport;

@Component
@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER)
public class UsuariInteressatHeaderBuilder implements OperationBuilderPlugin {

	public static final String API_PORTAL_PATTERN = "/serveis/portal/";

	private ParameterBuilder parameterBuilder = new ParameterBuilder();

	@Override
	public boolean supports(final DocumentationType documentationType) {
		return DocumentationType.SWAGGER_2.equals(documentationType);
	}

	@Override
	public void apply(final OperationContext context) {
		final String mapping = context.requestMappingPattern();
		if (StringUtils.contains(mapping, API_PORTAL_PATTERN)) {
			final List<Parameter> parameters = new LinkedList<>();
			parameters
					.add(parameterBuilder.parameterType("header").name("usuari-interessat").modelRef(new ModelRef("string"))
							.description(
									"Número de document d'identitat de l'ciutadà interessat en nom de qui es realitza la consulta o tràmit")
							.allowMultiple(false).required(false).build());
			parameters.add(parameterBuilder.parameterType("header").name("usuari-autenticat").modelRef(new ModelRef("string"))
					.description("Número de document d'identitat o matrícula de l'empleat públic").allowMultiple(false).required(false)
					.build());
			context.operationBuilder().parameters(parameters);
		}
	}

}