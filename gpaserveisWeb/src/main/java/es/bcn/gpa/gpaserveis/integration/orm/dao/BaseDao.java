package es.bcn.gpa.gpaserveis.integration.orm.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import es.bcn.gpa.gpaserveis.integration.orm.model.BaseEntity;
import es.bcn.gpa.gpaserveis.integration.orm.model.BaseEntityExample;
import net.opentrends.openframe.services.persistence.mybatis.template.MyBatisDao;
import net.opentrends.openframe.services.persistence.pagination.PaginationAttributes;

/**
 * The Interface BaseDao.
 *
 * @param <T>
 *            the entity type
 * @param <E>
 *            the entity example type
 * @param <I>
 *            the entity id type
 */
public interface BaseDao<T extends BaseEntity, I extends Serializable, E extends BaseEntityExample> extends MyBatisDao {

	/**
	 * Count by example.
	 *
	 * @param example
	 *            the example
	 * @return the int
	 */
	int countByExample(E example);

	/**
	 * Delete by example.
	 *
	 * @param example
	 *            the example
	 * @return the int
	 */
	int deleteByExample(E example);

	/**
	 * Delete by primary key.
	 *
	 * @param id
	 *            the id
	 * @return the int
	 */
	int deleteByPrimaryKey(I id);

	/**
	 * Insert.
	 *
	 * @param record
	 *            the record
	 * @return the int
	 */
	int insert(T record);

	/**
	 * Insert selective.
	 *
	 * @param record
	 *            the record
	 * @return the int
	 */
	int insertSelective(T record);

	/**
	 * Select by example.
	 *
	 * @param example
	 *            the example
	 * @return the list
	 */
	List<T> selectByExample(E example);

	/**
	 * Select by example.
	 *
	 * @param example
	 *            the example
	 * @return the list
	 */
	List<T> selectByExample(E example, PaginationAttributes paginationAttributes);

	/**
	 * Select by primary key.
	 *
	 * @param id
	 *            the id
	 * @return the procediments
	 */
	T selectByPrimaryKey(I id);

	/**
	 * Update by example selective.
	 *
	 * @param record
	 *            the record
	 * @param example
	 *            the example
	 * @return the int
	 */
	int updateByExampleSelective(@Param("record") T record, @Param("example") E example);

	/**
	 * Update by example.
	 *
	 * @param record
	 *            the record
	 * @param example
	 *            the example
	 * @return the int
	 */
	int updateByExample(@Param("record") T record, @Param("example") E example);

	/**
	 * Update by primary key selective.
	 *
	 * @param record
	 *            the record
	 * @return the int
	 */
	int updateByPrimaryKeySelective(T record);

	/**
	 * Update by primary key.
	 *
	 * @param record
	 *            the record
	 * @return the int
	 */
	int updateByPrimaryKey(T record);

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<T> findAll();
}
