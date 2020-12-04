package es.bcn.gpa.gpaserveis.integration.orm.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.integration.orm.dao.AuditServeisMdsDao;
import es.bcn.gpa.gpaserveis.integration.orm.model.AuditServeis;
import es.bcn.gpa.gpaserveis.integration.orm.model.AuditServeisExample;

@Component
@Qualifier("auditServeisMdsDao")
public class AuditServeisMdsDaoImpl extends BaseDaoWithBlobsImpl<AuditServeis, BigDecimal, AuditServeisExample>
		implements AuditServeisMdsDao {

}