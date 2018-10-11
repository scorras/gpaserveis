package es.bcn.gpa.gpaserveis.test.parent;

import org.springframework.test.context.ContextConfiguration;

import es.bcn.gpa.gpaserveis.test.config.BusinessTestsConfig;

@ContextConfiguration(classes = { BusinessTestsConfig.class })
public abstract class BusinessParentTest extends ParentTest {
}
