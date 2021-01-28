package es.bcn.gpa.gpaserveis.integration.orm.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.bcn.gpa.gpaserveis.business.exception.GPAServeisRuntimeException;

public class AuditServeisExample extends BaseEntityExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public AuditServeisExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new GPAServeisRuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new GPAServeisRuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new GPAServeisRuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("AST.ID is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("AST.ID is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(BigDecimal value) {
			addCriterion("AST.ID =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(BigDecimal value) {
			addCriterion("AST.ID <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(BigDecimal value) {
			addCriterion("AST.ID >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("AST.ID >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(BigDecimal value) {
			addCriterion("AST.ID <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(BigDecimal value) {
			addCriterion("AST.ID <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<BigDecimal> values) {
			addCriterion("AST.ID in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<BigDecimal> values) {
			addCriterion("AST.ID not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("AST.ID between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("AST.ID not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andMomentExecucioIsNull() {
			addCriterion("AST.MOMENT_EXECUCIO is null");
			return (Criteria) this;
		}

		public Criteria andMomentExecucioIsNotNull() {
			addCriterion("AST.MOMENT_EXECUCIO is not null");
			return (Criteria) this;
		}

		public Criteria andMomentExecucioEqualTo(Date value) {
			addCriterion("AST.MOMENT_EXECUCIO =", value, "momentExecucio");
			return (Criteria) this;
		}

		public Criteria andMomentExecucioNotEqualTo(Date value) {
			addCriterion("AST.MOMENT_EXECUCIO <>", value, "momentExecucio");
			return (Criteria) this;
		}

		public Criteria andMomentExecucioGreaterThan(Date value) {
			addCriterion("AST.MOMENT_EXECUCIO >", value, "momentExecucio");
			return (Criteria) this;
		}

		public Criteria andMomentExecucioGreaterThanOrEqualTo(Date value) {
			addCriterion("AST.MOMENT_EXECUCIO >=", value, "momentExecucio");
			return (Criteria) this;
		}

		public Criteria andMomentExecucioLessThan(Date value) {
			addCriterion("AST.MOMENT_EXECUCIO <", value, "momentExecucio");
			return (Criteria) this;
		}

		public Criteria andMomentExecucioLessThanOrEqualTo(Date value) {
			addCriterion("AST.MOMENT_EXECUCIO <=", value, "momentExecucio");
			return (Criteria) this;
		}

		public Criteria andMomentExecucioIn(List<Date> values) {
			addCriterion("AST.MOMENT_EXECUCIO in", values, "momentExecucio");
			return (Criteria) this;
		}

		public Criteria andMomentExecucioNotIn(List<Date> values) {
			addCriterion("AST.MOMENT_EXECUCIO not in", values, "momentExecucio");
			return (Criteria) this;
		}

		public Criteria andMomentExecucioBetween(Date value1, Date value2) {
			addCriterion("AST.MOMENT_EXECUCIO between", value1, value2, "momentExecucio");
			return (Criteria) this;
		}

		public Criteria andMomentExecucioNotBetween(Date value1, Date value2) {
			addCriterion("AST.MOMENT_EXECUCIO not between", value1, value2, "momentExecucio");
			return (Criteria) this;
		}

		public Criteria andUsuariIsNull() {
			addCriterion("AST.USUARI is null");
			return (Criteria) this;
		}

		public Criteria andUsuariIsNotNull() {
			addCriterion("AST.USUARI is not null");
			return (Criteria) this;
		}

		public Criteria andUsuariEqualTo(String value) {
			addCriterion("AST.USUARI =", value, "usuari");
			return (Criteria) this;
		}

		public Criteria andUsuariNotEqualTo(String value) {
			addCriterion("AST.USUARI <>", value, "usuari");
			return (Criteria) this;
		}

		public Criteria andUsuariGreaterThan(String value) {
			addCriterion("AST.USUARI >", value, "usuari");
			return (Criteria) this;
		}

		public Criteria andUsuariGreaterThanOrEqualTo(String value) {
			addCriterion("AST.USUARI >=", value, "usuari");
			return (Criteria) this;
		}

		public Criteria andUsuariLessThan(String value) {
			addCriterion("AST.USUARI <", value, "usuari");
			return (Criteria) this;
		}

		public Criteria andUsuariLessThanOrEqualTo(String value) {
			addCriterion("AST.USUARI <=", value, "usuari");
			return (Criteria) this;
		}

		public Criteria andUsuariLike(String value) {
			addCriterion("AST.USUARI like", value, "usuari");
			return (Criteria) this;
		}

		public Criteria andUsuariNotLike(String value) {
			addCriterion("AST.USUARI not like", value, "usuari");
			return (Criteria) this;
		}

		public Criteria andUsuariIn(List<String> values) {
			addCriterion("AST.USUARI in", values, "usuari");
			return (Criteria) this;
		}

		public Criteria andUsuariNotIn(List<String> values) {
			addCriterion("AST.USUARI not in", values, "usuari");
			return (Criteria) this;
		}

		public Criteria andUsuariBetween(String value1, String value2) {
			addCriterion("AST.USUARI between", value1, value2, "usuari");
			return (Criteria) this;
		}

		public Criteria andUsuariNotBetween(String value1, String value2) {
			addCriterion("AST.USUARI not between", value1, value2, "usuari");
			return (Criteria) this;
		}

		public Criteria andMappingAccioIsNull() {
			addCriterion("AST.MAPPING_ACCIO is null");
			return (Criteria) this;
		}

		public Criteria andMappingAccioIsNotNull() {
			addCriterion("AST.MAPPING_ACCIO is not null");
			return (Criteria) this;
		}

		public Criteria andMappingAccioEqualTo(String value) {
			addCriterion("AST.MAPPING_ACCIO =", value, "mappingAccio");
			return (Criteria) this;
		}

		public Criteria andMappingAccioNotEqualTo(String value) {
			addCriterion("AST.MAPPING_ACCIO <>", value, "mappingAccio");
			return (Criteria) this;
		}

		public Criteria andMappingAccioGreaterThan(String value) {
			addCriterion("AST.MAPPING_ACCIO >", value, "mappingAccio");
			return (Criteria) this;
		}

		public Criteria andMappingAccioGreaterThanOrEqualTo(String value) {
			addCriterion("AST.MAPPING_ACCIO >=", value, "mappingAccio");
			return (Criteria) this;
		}

		public Criteria andMappingAccioLessThan(String value) {
			addCriterion("AST.MAPPING_ACCIO <", value, "mappingAccio");
			return (Criteria) this;
		}

		public Criteria andMappingAccioLessThanOrEqualTo(String value) {
			addCriterion("AST.MAPPING_ACCIO <=", value, "mappingAccio");
			return (Criteria) this;
		}

		public Criteria andMappingAccioLike(String value) {
			addCriterion("AST.MAPPING_ACCIO like", value, "mappingAccio");
			return (Criteria) this;
		}

		public Criteria andMappingAccioNotLike(String value) {
			addCriterion("AST.MAPPING_ACCIO not like", value, "mappingAccio");
			return (Criteria) this;
		}

		public Criteria andMappingAccioIn(List<String> values) {
			addCriterion("AST.MAPPING_ACCIO in", values, "mappingAccio");
			return (Criteria) this;
		}

		public Criteria andMappingAccioNotIn(List<String> values) {
			addCriterion("AST.MAPPING_ACCIO not in", values, "mappingAccio");
			return (Criteria) this;
		}

		public Criteria andMappingAccioBetween(String value1, String value2) {
			addCriterion("AST.MAPPING_ACCIO between", value1, value2, "mappingAccio");
			return (Criteria) this;
		}

		public Criteria andMappingAccioNotBetween(String value1, String value2) {
			addCriterion("AST.MAPPING_ACCIO not between", value1, value2, "mappingAccio");
			return (Criteria) this;
		}

		public Criteria andValueAccioIsNull() {
			addCriterion("AST.VALUE_ACCIO is null");
			return (Criteria) this;
		}

		public Criteria andValueAccioIsNotNull() {
			addCriterion("AST.VALUE_ACCIO is not null");
			return (Criteria) this;
		}

		public Criteria andValueAccioEqualTo(String value) {
			addCriterion("AST.VALUE_ACCIO =", value, "valueAccio");
			return (Criteria) this;
		}

		public Criteria andValueAccioNotEqualTo(String value) {
			addCriterion("AST.VALUE_ACCIO <>", value, "valueAccio");
			return (Criteria) this;
		}

		public Criteria andValueAccioGreaterThan(String value) {
			addCriterion("AST.VALUE_ACCIO >", value, "valueAccio");
			return (Criteria) this;
		}

		public Criteria andValueAccioGreaterThanOrEqualTo(String value) {
			addCriterion("AST.VALUE_ACCIO >=", value, "valueAccio");
			return (Criteria) this;
		}

		public Criteria andValueAccioLessThan(String value) {
			addCriterion("AST.VALUE_ACCIO <", value, "valueAccio");
			return (Criteria) this;
		}

		public Criteria andValueAccioLessThanOrEqualTo(String value) {
			addCriterion("AST.VALUE_ACCIO <=", value, "valueAccio");
			return (Criteria) this;
		}

		public Criteria andValueAccioLike(String value) {
			addCriterion("AST.VALUE_ACCIO like", value, "valueAccio");
			return (Criteria) this;
		}

		public Criteria andValueAccioNotLike(String value) {
			addCriterion("AST.VALUE_ACCIO not like", value, "valueAccio");
			return (Criteria) this;
		}

		public Criteria andValueAccioIn(List<String> values) {
			addCriterion("AST.VALUE_ACCIO in", values, "valueAccio");
			return (Criteria) this;
		}

		public Criteria andValueAccioNotIn(List<String> values) {
			addCriterion("AST.VALUE_ACCIO not in", values, "valueAccio");
			return (Criteria) this;
		}

		public Criteria andValueAccioBetween(String value1, String value2) {
			addCriterion("AST.VALUE_ACCIO between", value1, value2, "valueAccio");
			return (Criteria) this;
		}

		public Criteria andValueAccioNotBetween(String value1, String value2) {
			addCriterion("AST.VALUE_ACCIO not between", value1, value2, "valueAccio");
			return (Criteria) this;
		}

		public Criteria andTipusPeticioIsNull() {
			addCriterion("AST.TIPUS_PETICIO is null");
			return (Criteria) this;
		}

		public Criteria andTipusPeticioIsNotNull() {
			addCriterion("AST.TIPUS_PETICIO is not null");
			return (Criteria) this;
		}

		public Criteria andTipusPeticioEqualTo(String value) {
			addCriterion("AST.TIPUS_PETICIO =", value, "tipusPeticio");
			return (Criteria) this;
		}

		public Criteria andTipusPeticioNotEqualTo(String value) {
			addCriterion("AST.TIPUS_PETICIO <>", value, "tipusPeticio");
			return (Criteria) this;
		}

		public Criteria andTipusPeticioGreaterThan(String value) {
			addCriterion("AST.TIPUS_PETICIO >", value, "tipusPeticio");
			return (Criteria) this;
		}

		public Criteria andTipusPeticioGreaterThanOrEqualTo(String value) {
			addCriterion("AST.TIPUS_PETICIO >=", value, "tipusPeticio");
			return (Criteria) this;
		}

		public Criteria andTipusPeticioLessThan(String value) {
			addCriterion("AST.TIPUS_PETICIO <", value, "tipusPeticio");
			return (Criteria) this;
		}

		public Criteria andTipusPeticioLessThanOrEqualTo(String value) {
			addCriterion("AST.TIPUS_PETICIO <=", value, "tipusPeticio");
			return (Criteria) this;
		}

		public Criteria andTipusPeticioLike(String value) {
			addCriterion("AST.TIPUS_PETICIO like", value, "tipusPeticio");
			return (Criteria) this;
		}

		public Criteria andTipusPeticioNotLike(String value) {
			addCriterion("AST.TIPUS_PETICIO not like", value, "tipusPeticio");
			return (Criteria) this;
		}

		public Criteria andTipusPeticioIn(List<String> values) {
			addCriterion("AST.TIPUS_PETICIO in", values, "tipusPeticio");
			return (Criteria) this;
		}

		public Criteria andTipusPeticioNotIn(List<String> values) {
			addCriterion("AST.TIPUS_PETICIO not in", values, "tipusPeticio");
			return (Criteria) this;
		}

		public Criteria andTipusPeticioBetween(String value1, String value2) {
			addCriterion("AST.TIPUS_PETICIO between", value1, value2, "tipusPeticio");
			return (Criteria) this;
		}

		public Criteria andTipusPeticioNotBetween(String value1, String value2) {
			addCriterion("AST.TIPUS_PETICIO not between", value1, value2, "tipusPeticio");
			return (Criteria) this;
		}

		public Criteria andResultatIsNull() {
			addCriterion("AST.RESULTAT is null");
			return (Criteria) this;
		}

		public Criteria andResultatIsNotNull() {
			addCriterion("AST.RESULTAT is not null");
			return (Criteria) this;
		}

		public Criteria andResultatEqualTo(String value) {
			addCriterion("AST.RESULTAT =", value, "resultat");
			return (Criteria) this;
		}

		public Criteria andResultatNotEqualTo(String value) {
			addCriterion("AST.RESULTAT <>", value, "resultat");
			return (Criteria) this;
		}

		public Criteria andResultatGreaterThan(String value) {
			addCriterion("AST.RESULTAT >", value, "resultat");
			return (Criteria) this;
		}

		public Criteria andResultatGreaterThanOrEqualTo(String value) {
			addCriterion("AST.RESULTAT >=", value, "resultat");
			return (Criteria) this;
		}

		public Criteria andResultatLessThan(String value) {
			addCriterion("AST.RESULTAT <", value, "resultat");
			return (Criteria) this;
		}

		public Criteria andResultatLessThanOrEqualTo(String value) {
			addCriterion("AST.RESULTAT <=", value, "resultat");
			return (Criteria) this;
		}

		public Criteria andResultatLike(String value) {
			addCriterion("AST.RESULTAT like", value, "resultat");
			return (Criteria) this;
		}

		public Criteria andResultatNotLike(String value) {
			addCriterion("AST.RESULTAT not like", value, "resultat");
			return (Criteria) this;
		}

		public Criteria andResultatIn(List<String> values) {
			addCriterion("AST.RESULTAT in", values, "resultat");
			return (Criteria) this;
		}

		public Criteria andResultatNotIn(List<String> values) {
			addCriterion("AST.RESULTAT not in", values, "resultat");
			return (Criteria) this;
		}

		public Criteria andResultatBetween(String value1, String value2) {
			addCriterion("AST.RESULTAT between", value1, value2, "resultat");
			return (Criteria) this;
		}

		public Criteria andResultatNotBetween(String value1, String value2) {
			addCriterion("AST.RESULTAT not between", value1, value2, "resultat");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}