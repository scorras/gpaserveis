package es.bcn.gpa.gpaserveis.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import es.bcn.gpa.gpaserveis.test.parent.RestServerParentTest;
import net.opentrends.openframe.services.rest.apidocs.filegeneration.ApiDocsFilesGenerator;

/**
 * The Class SwaggerFilesGenerationTest.
 */
public class SwaggerFilesGenerationTest extends RestServerParentTest {

	/** The api docs files generator. */
	@Autowired(required = true)
	@Qualifier("apiDocsFilesGenerator")
	private ApiDocsFilesGenerator apiDocsFilesGenerator;

	/**
	 * Test generate api documentation files.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testGenerateApiDocumentationFiles() throws Exception {
		apiDocsFilesGenerator.generateApiDocumentationFiles();
	}

}