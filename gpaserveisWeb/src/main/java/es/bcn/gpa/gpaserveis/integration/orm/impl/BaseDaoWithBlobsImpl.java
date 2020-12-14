package es.bcn.gpa.gpaserveis.integration.orm.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.integration.orm.dao.BaseDaoWithBlobs;
import es.bcn.gpa.gpaserveis.integration.orm.model.BaseEntity;
import es.bcn.gpa.gpaserveis.integration.orm.model.BaseEntityExample;
import net.opentrends.openframe.services.persistence.mybatis.template.MyBatisDao;
import net.opentrends.openframe.services.persistence.mybatis.template.MyBatisDaoCallback;
import net.opentrends.openframe.services.persistence.pagination.PaginationAttributes;

/**
 * The Class BaseDaoImpl.
 *
 * @param <T>
 *            the dao type
 * @param <I>
 *            the generic type
 * @param <E>
 *            the element type
 */
@Component
@SuppressWarnings({ "unchecked", "rawtypes" })
public class BaseDaoWithBlobsImpl<T extends BaseEntity, I extends Serializable, E extends BaseEntityExample> extends BaseDaoImpl<T, I, E>
		implements BaseDaoWithBlobs<T, I, E> {
	/**
	 * Logger for this class
	 */
	private static final Log LOGGER = LogFactory.getLog(BaseDaoWithBlobsImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaexpedients.integration.orm.dao.BaseDaoWithBlobs#
	 * selectByExampleWithBLOBs(es.bcn.gpa.gpaexpedients.integration.orm.model.
	 * BaseEntityExample)
	 */
	@Override
	public List<T> selectByExampleWithBLOBs(final E example) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("selectByExampleWithBLOBs(E) - inici"); //$NON-NLS-1$
		}

		List<T> returnList = myBatisTemplate.execute(getBaseDao(), new MyBatisDaoCallback<List<T>>() {

			@Override
			public List<T> execute(MyBatisDao dao) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<List<T>>.execute(MyBatisDao) - inici"); //$NON-NLS-1$
				}

				List<T> returnList2 = ((BaseDaoWithBlobs) dao).selectByExampleWithBLOBs(example);
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<List<T>>.execute(MyBatisDao) - fi"); //$NON-NLS-1$
				}
				return returnList2;
			}
		});
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("selectByExampleWithBLOBs(E) - fi"); //$NON-NLS-1$
		}
		return returnList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaexpedients.integration.orm.dao.BaseDaoWithBlobs#
	 * selectByExampleWithBLOBs(es.bcn.gpa.gpaexpedients.integration.orm.model.
	 * BaseEntityExample,
	 * net.opentrends.openframe.services.persistence.pagination.
	 * PaginationAttributes)
	 */
	@Override
	public List<T> selectByExampleWithBLOBs(final E example, PaginationAttributes paginationAttributes) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("selectByExampleWithBLOBs(E, PaginationAttributes) - inici"); //$NON-NLS-1$
		}

		List<T> returnList = myBatisTemplate.execute(getBaseDao(), new MyBatisDaoCallback<List<T>>() {
			@Override
			public List<T> execute(MyBatisDao dao) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<List<T>>.execute(MyBatisDao) - inici"); //$NON-NLS-1$
				}

				List<T> returnList2 = ((BaseDaoWithBlobs) dao).selectByExampleWithBLOBs(example);
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<List<T>>.execute(MyBatisDao) - fi"); //$NON-NLS-1$
				}
				return returnList2;
			}
		}, paginationAttributes);
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("selectByExampleWithBLOBs(E, PaginationAttributes) - fi"); //$NON-NLS-1$
		}
		return returnList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaexpedients.integration.orm.dao.BaseDaoWithBlobs#
	 * updateByExampleWithBLOBs(es.bcn.gpa.gpaexpedients.integration.orm.model.
	 * BaseEntity,
	 * es.bcn.gpa.gpaexpedients.integration.orm.model.BaseEntityExample)
	 */
	@Override
	public int updateByExampleWithBLOBs(final T record, final E example) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("updateByExampleWithBLOBs(T, E) - inici"); //$NON-NLS-1$
		}

		Integer res = myBatisTemplate.execute(getBaseDao(), new MyBatisDaoCallback<Integer>() {
			@Override
			public Integer execute(MyBatisDao dao) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<Integer>.execute(MyBatisDao) - inici"); //$NON-NLS-1$
				}

				Integer returnInteger = ((BaseDaoWithBlobs) dao).updateByExampleWithBLOBs(record, example);
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<Integer>.execute(MyBatisDao) - fi"); //$NON-NLS-1$
				}
				return returnInteger;
			}
		});
		int returnint = res.intValue();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("updateByExampleWithBLOBs(T, E) - fi"); //$NON-NLS-1$
		}
		return returnint;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaexpedients.integration.orm.dao.BaseDaoWithBlobs#
	 * updateByPrimaryKeyWithBLOBs(es.bcn.gpa.gpaexpedients.integration.orm.
	 * model.BaseEntity)
	 */
	@Override
	public int updateByPrimaryKeyWithBLOBs(final T record) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("updateByPrimaryKeyWithBLOBs(T) - inici"); //$NON-NLS-1$
		}

		Integer res = myBatisTemplate.execute(getBaseDao(), new MyBatisDaoCallback<Integer>() {
			@Override
			public Integer execute(MyBatisDao dao) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<Integer>.execute(MyBatisDao) - inici"); //$NON-NLS-1$
				}

				Integer returnInteger = ((BaseDaoWithBlobs) dao).updateByPrimaryKeyWithBLOBs(record);
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<Integer>.execute(MyBatisDao) - fi"); //$NON-NLS-1$
				}
				return returnInteger;
			}
		});
		int returnint = res.intValue();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("updateByPrimaryKeyWithBLOBs(T) - fi"); //$NON-NLS-1$
		}
		return returnint;
	}

}
