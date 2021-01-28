package es.bcn.gpa.gpaserveis.business.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.CompositeDatabasePopulator;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import net.opentrends.openframe.services.configuration.condition.ConditionalOnContext;
import net.opentrends.openframe.services.configuration.condition.ConditionalOnContext.ConditionsMatching;
import net.opentrends.openframe.services.configuration.condition.Eld4ContainerCondition;

/**
 * The Class DataSourceInitializerService.
 */
@Configuration
public class DataSourceInitializerServiceConfig {

	@Value("${carregar.dades.prova}")
	private Boolean carregarDadesProva;

	@Bean
	@ConditionalOnContext(property = "executar.scripts", value = "true", otherConditions = {
			Eld4ContainerCondition.class }, otherConditionsMatching = ConditionsMatching.ALL)
	public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
		final DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);
		initializer.setDatabasePopulator(databasePopulator());
		return initializer;
	}

	private DatabasePopulator databasePopulator() {

		// Create BBDD
		final CompositeDatabasePopulator compositeDatabasePopulator = new CompositeDatabasePopulator();

		compositeDatabasePopulator.addPopulators(createPopulator("/sql/scripts/drop_objects.sql", "UTF-8", "/"));
		compositeDatabasePopulator.addPopulators(createPopulator("/sql/install/01_GPASERVEIS_T.sql", "UTF-8", ";"));
		compositeDatabasePopulator.addPopulators(createPopulator("/sql/install/02_GPASERVEIS_C.sql", "UTF-8", ";"));
		compositeDatabasePopulator.addPopulators(createPopulator("/sql/install/03_GPASERVEIS_P.sql", "UTF-8", "/"));
		compositeDatabasePopulator.addPopulators(createPopulator("/sql/scripts/disable_constraints.sql", "UTF-8", "/"));

		// compositeDatabasePopulator.addPopulators(createPopulator("/sql/install/data/INSERCIOTAULESMESTRES.sql",
		// "UTF-8", ";"));

		if (carregarDadesProva) {
			compositeDatabasePopulator.addPopulators(createPopulator("/sql/test/test_data.sql", "UTF-8", ";"));
		}

		compositeDatabasePopulator.addPopulators(createPopulator("/sql/scripts/enable_constraints.sql", "UTF-8", "/"));
		compositeDatabasePopulator.addPopulators(createPopulator("/sql/scripts/purge_recyclebin.sql", "UTF-8", ";"));

		return compositeDatabasePopulator;
	}

	private static DatabasePopulator createPopulator(String script, String encoding, String separator) {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.setScripts(new ClassPathResource(script));
		populator.setIgnoreFailedDrops(true);
		populator.setSqlScriptEncoding(encoding);
		populator.setSeparator(separator);
		return populator;

	}
}