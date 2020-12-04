package es.bcn.gpa.gpaserveis.business.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

import net.opentrends.openframe.services.persistence.pagination.config.PersistencePaginationServiceDefaultConfiguration;

/**
 * The Class PersistenceServiceConfig.
 */
@Configuration
@Import({ PersistencePaginationServiceDefaultConfiguration.class })
@Lazy(true)
public class PersistenceServiceConfig {

	/**
	 * My batis configuration.
	 *
	 * @return the org.apache.ibatis.session. configuration
	 */
	@Bean(name = "myBatisConfiguration")
	public org.apache.ibatis.session.Configuration myBatisConfiguration() {
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		configuration.setMapUnderscoreToCamelCase(true);
		// configuration.getTypeHandlerRegistry().register(String.class,
		// JdbcType.NVARCHAR, new CatalogTypeHandler());
		return configuration;
	}

}