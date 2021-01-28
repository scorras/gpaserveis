package es.bcn.gpa.gpaserveis.integration.orm.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.integration.orm.dao.AuditServeisSignaturesDao;
import es.bcn.gpa.gpaserveis.integration.orm.model.AuditServeis;
import es.bcn.gpa.gpaserveis.integration.orm.model.AuditServeisExample;

@Component
@Qualifier("auditServeisSignaturesDao")
public class AuditServeisSignaturesDaoImpl extends BaseDaoWithBlobsImpl<AuditServeis, BigDecimal, AuditServeisExample>
		implements AuditServeisSignaturesDao {

}