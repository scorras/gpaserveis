package es.bcn.gpa.gpaserveis.integration.orm.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.integration.orm.dao.BaseDao;
import es.bcn.gpa.gpaserveis.integration.orm.model.BaseEntity;
import es.bcn.gpa.gpaserveis.integration.orm.model.BaseEntityExample;
import net.opentrends.openframe.services.persistence.mybatis.template.MyBatisDao;
import net.opentrends.openframe.services.persistence.mybatis.template.MyBatisDaoCallback;
import net.opentrends.openframe.services.persistence.pagination.PaginationAttributes;
import net.opentrends.openframe.services.persistence.pagination.mybatis.template.MyBatisPaginationTemplate;

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
public class BaseDaoImpl<T extends BaseEntity, I extends Serializable, E extends BaseEntityExample> implements BaseDao<T, I, E> {
	/**
	 * Logger for this class
	 */
	private static final Log LOGGER = LogFactory.getLog(BaseDaoImpl.class);

	/** The my batis template. */
	@Autowired(required = true)
	@Qualifier("myBatisTemplate")
	protected MyBatisPaginationTemplate myBatisTemplate;

	/**
	 * Gets the base dao.
	 *
	 * @return the base dao
	 */
	protected Class getBaseDao() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("getBaseDao() - inici"); //$NON-NLS-1$
		}

		Class returnClass = this.getClass().getInterfaces()[0];
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("getBaseDao() - fi"); //$NON-NLS-1$
		}
		return returnClass;
	}

	/**
	 * Update by primary key.
	 *
	 * @param param
	 *            the param
	 * @return the h
	 */
	@Override
	public int updateByPrimaryKey(final T param) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("updateByPrimaryKey(T) - inici"); //$NON-NLS-1$
		}

		Integer res = myBatisTemplate.execute(getBaseDao(), new MyBatisDaoCallback<Integer>() {
			@Override
			public Integer execute(MyBatisDao dao) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<Integer>.execute(MyBatisDao) - inici"); //$NON-NLS-1$
				}

				Integer returnInteger = ((BaseDao) dao).updateByPrimaryKey(param);
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<Integer>.execute(MyBatisDao) - fi"); //$NON-NLS-1$
				}
				return returnInteger;

			}
		});
		int returnint = res.intValue();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("updateByPrimaryKey(T) - fi"); //$NON-NLS-1$
		}
		return returnint;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaexpedients.integration.orm.dao.BaseDao#countByExample(es.
	 * bcn.gpa.gpaexpedients.integration.orm.model.BaseEntityExample)
	 */
	@Override
	public int countByExample(final E example) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("countByExample(E) - inici"); //$NON-NLS-1$
		}

		Integer res = myBatisTemplate.execute(getBaseDao(), new MyBatisDaoCallback<Integer>() {
			@Override
			public Integer execute(MyBatisDao dao) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<Integer>.execute(MyBatisDao) - inici"); //$NON-NLS-1$
				}

				Integer returnInteger = ((BaseDao) dao).countByExample(example);
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<Integer>.execute(MyBatisDao) - fi"); //$NON-NLS-1$
				}
				return returnInteger;
			}
		});
		int returnint = res.intValue();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("countByExample(E) - fi"); //$NON-NLS-1$
		}
		return returnint;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaexpedients.integration.orm.dao.BaseDao#deleteByExample(es.
	 * bcn.gpa.gpaexpedients.integration.orm.model.BaseEntityExample)
	 */
	@Override
	public int deleteByExample(final E example) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("deleteByExample(E) - inici"); //$NON-NLS-1$
		}

		Integer res = myBatisTemplate.execute(getBaseDao(), new MyBatisDaoCallback<Integer>() {
			@Override
			public Integer execute(MyBatisDao dao) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<Integer>.execute(MyBatisDao) - inici"); //$NON-NLS-1$
				}

				Integer returnInteger = ((BaseDao) dao).deleteByExample(example);
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<Integer>.execute(MyBatisDao) - fi"); //$NON-NLS-1$
				}
				return returnInteger;
			}
		});
		int returnint = res.intValue();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("deleteByExample(E) - fi"); //$NON-NLS-1$
		}
		return returnint;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaexpedients.integration.orm.dao.BaseDao#deleteByPrimaryKey(
	 * java.io.Serializable)
	 */
	@Override
	public int deleteByPrimaryKey(final I id) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("deleteByPrimaryKey(I) - inici"); //$NON-NLS-1$
		}

		Integer res = myBatisTemplate.execute(getBaseDao(), new MyBatisDaoCallback<Integer>() {
			@Override
			public Integer execute(MyBatisDao dao) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<Integer>.execute(MyBatisDao) - inici"); //$NON-NLS-1$
				}

				Integer returnInteger = ((BaseDao) dao).deleteByPrimaryKey(id);
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<Integer>.execute(MyBatisDao) - fi"); //$NON-NLS-1$
				}
				return returnInteger;
			}
		});
		int returnint = res.intValue();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("deleteByPrimaryKey(I) - fi"); //$NON-NLS-1$
		}
		return returnint;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaexpedients.integration.orm.dao.BaseDao#insert(es.bcn.gpa.
	 * gpaexpedients.integration.orm.model.BaseEntity)
	 */
	@Override
	public int insert(final T record) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("insert(T) - inici"); //$NON-NLS-1$
		}

		Integer res = myBatisTemplate.execute(getBaseDao(), new MyBatisDaoCallback<Integer>() {
			@Override
			public Integer execute(MyBatisDao dao) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<Integer>.execute(MyBatisDao) - inici"); //$NON-NLS-1$
				}

				Integer returnInteger = ((BaseDao) dao).insert(record);
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<Integer>.execute(MyBatisDao) - fi"); //$NON-NLS-1$
				}
				return returnInteger;
			}
		});
		int returnint = res.intValue();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("insert(T) - fi"); //$NON-NLS-1$
		}
		return returnint;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaexpedients.integration.orm.dao.BaseDao#insertSelective(es.
	 * bcn.gpa.gpaexpedients.integration.orm.model.BaseEntity)
	 */
	@Override
	public int insertSelective(final T record) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("insertSelective(T) - inici"); //$NON-NLS-1$
		}

		Integer res = myBatisTemplate.execute(getBaseDao(), new MyBatisDaoCallback<Integer>() {
			@Override
			public Integer execute(MyBatisDao dao) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<Integer>.execute(MyBatisDao) - inici"); //$NON-NLS-1$
				}

				Integer returnInteger = ((BaseDao) dao).insertSelective(record);
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<Integer>.execute(MyBatisDao) - fi"); //$NON-NLS-1$
				}
				return returnInteger;
			}
		});
		int returnint = res.intValue();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("insertSelective(T) - fi"); //$NON-NLS-1$
		}
		return returnint;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaexpedients.integration.orm.dao.BaseDao#selectByExample(es.
	 * bcn.gpa.gpaexpedients.integration.orm.model.BaseEntityExample)
	 */
	@Override
	public List<T> selectByExample(final E example) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("selectByExample(E) - inici"); //$NON-NLS-1$
		}

		List<T> returnList = myBatisTemplate.execute(getBaseDao(), new MyBatisDaoCallback<List<T>>() {
			@Override
			public List<T> execute(MyBatisDao dao) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<List<T>>.execute(MyBatisDao) - inici"); //$NON-NLS-1$
				}

				List<T> returnList2 = ((BaseDao) dao).selectByExample(example);
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<List<T>>.execute(MyBatisDao) - fi"); //$NON-NLS-1$
				}
				return returnList2;
			}
		});
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("selectByExample(E) - fi"); //$NON-NLS-1$
		}
		return returnList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaexpedients.integration.orm.dao.BaseDao#selectByExample(es.
	 * bcn.gpa.gpaexpedients.integration.orm.model.BaseEntityExample,
	 * net.opentrends.openframe.services.persistence.pagination.
	 * PaginationAttributes)
	 */
	@Override
	public List<T> selectByExample(final E example, PaginationAttributes paginationAttributes) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("selectByExample(E, PaginationAttributes) - inici"); //$NON-NLS-1$
		}

		List<T> returnList = myBatisTemplate.execute(getBaseDao(), new MyBatisDaoCallback<List<T>>() {
			@Override
			public List<T> execute(MyBatisDao dao) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<List<T>>.execute(MyBatisDao) - inici"); //$NON-NLS-1$
				}

				List<T> returnList2 = ((BaseDao) dao).selectByExample(example);
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<List<T>>.execute(MyBatisDao) - fi"); //$NON-NLS-1$
				}
				return returnList2;
			}
		}, paginationAttributes);
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("selectByExample(E, PaginationAttributes) - fi"); //$NON-NLS-1$
		}
		return returnList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaexpedients.integration.orm.dao.BaseDao#selectByPrimaryKey(
	 * java.io.Serializable)
	 */
	@Override
	public T selectByPrimaryKey(final I id) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("selectByPrimaryKey(I) - inici"); //$NON-NLS-1$
		}

		T returnT = myBatisTemplate.execute(getBaseDao(), new MyBatisDaoCallback<T>() {
			@Override
			public T execute(MyBatisDao dao) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<T>.execute(MyBatisDao) - inici"); //$NON-NLS-1$
				}

				T returnT2 = (T) ((BaseDao) dao).selectByPrimaryKey(id);
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<T>.execute(MyBatisDao) - fi"); //$NON-NLS-1$
				}
				return returnT2;
			}
		});
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("selectByPrimaryKey(I) - fi"); //$NON-NLS-1$
		}
		return returnT;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaexpedients.integration.orm.dao.BaseDao#
	 * updateByExampleSelective(es.bcn.gpa.gpaexpedients.integration.orm.model.
	 * BaseEntity,
	 * es.bcn.gpa.gpaexpedients.integration.orm.model.BaseEntityExample)
	 */
	@Override
	public int updateByExampleSelective(final T record, final E example) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("updateByExampleSelective(T, E) - inici"); //$NON-NLS-1$
		}

		Integer res = myBatisTemplate.execute(getBaseDao(), new MyBatisDaoCallback<Integer>() {
			@Override
			public Integer execute(MyBatisDao dao) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<Integer>.execute(MyBatisDao) - inici"); //$NON-NLS-1$
				}

				Integer returnInteger = ((BaseDao) dao).updateByExampleSelective(record, example);
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<Integer>.execute(MyBatisDao) - fi"); //$NON-NLS-1$
				}
				return returnInteger;

			}
		});
		int returnint = res.intValue();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("updateByExampleSelective(T, E) - fi"); //$NON-NLS-1$
		}
		return returnint;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaexpedients.integration.orm.dao.BaseDao#updateByExample(es.
	 * bcn.gpa.gpaexpedients.integration.orm.model.BaseEntity,
	 * es.bcn.gpa.gpaexpedients.integration.orm.model.BaseEntityExample)
	 */
	@Override
	public int updateByExample(final T record, final E example) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("updateByExample(T, E) - inici"); //$NON-NLS-1$
		}

		Integer res = myBatisTemplate.execute(getBaseDao(), new MyBatisDaoCallback<Integer>() {
			@Override
			public Integer execute(MyBatisDao dao) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<Integer>.execute(MyBatisDao) - inici"); //$NON-NLS-1$
				}

				Integer returnInteger = ((BaseDao) dao).updateByExample(record, example);
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<Integer>.execute(MyBatisDao) - fi"); //$NON-NLS-1$
				}
				return returnInteger;

			}
		});
		int returnint = res.intValue();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("updateByExample(T, E) - fi"); //$NON-NLS-1$
		}
		return returnint;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaexpedients.integration.orm.dao.BaseDao#
	 * updateByPrimaryKeySelective(es.bcn.gpa.gpaexpedients.integration.orm.
	 * model.BaseEntity)
	 */
	@Override
	public int updateByPrimaryKeySelective(final T record) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("updateByPrimaryKeySelective(T) - inici"); //$NON-NLS-1$
		}

		Integer res = myBatisTemplate.execute(getBaseDao(), new MyBatisDaoCallback<Integer>() {
			@Override
			public Integer execute(MyBatisDao dao) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<Integer>.execute(MyBatisDao) - inici"); //$NON-NLS-1$
				}

				Integer returnInteger = ((BaseDao) dao).updateByPrimaryKeySelective(record);
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<Integer>.execute(MyBatisDao) - fi"); //$NON-NLS-1$
				}
				return returnInteger;
			}
		});
		int returnint = res.intValue();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("updateByPrimaryKeySelective(T) - fi"); //$NON-NLS-1$
		}
		return returnint;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpadocumentacio.integration.orm.dao.BaseDao#findAll()
	 */
	@Override
	public List<T> findAll() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("findAll() - inici"); //$NON-NLS-1$
		}

		List<T> returnList = myBatisTemplate.execute(getBaseDao(), new MyBatisDaoCallback<List<T>>() {
			@Override
			public List<T> execute(MyBatisDao dao) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<List<T>>.execute(MyBatisDao) - inici"); //$NON-NLS-1$
				}

				List<T> returnList2 = ((BaseDao) dao).selectByExample(null);
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("$MyBatisDaoCallback<List<T>>.execute(MyBatisDao) - fi"); //$NON-NLS-1$
				}
				return returnList2;
			}
		});
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("findAll() - fi"); //$NON-NLS-1$
		}
		return returnList;
	}

}
