package es.bcn.gpa.gpaserveis.integration.orm.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import es.bcn.gpa.gpaserveis.integration.orm.model.BaseEntity;
import es.bcn.gpa.gpaserveis.integration.orm.model.BaseEntityExample;
import net.opentrends.openframe.services.persistence.pagination.PaginationAttributes;

/**
 * The Interface BaseDao.
 *
 * @param <T>
 *            the entity type
 * @param <I>
 *            the entity id type
 * @param <E>
 *            the entity example type
 */
public interface BaseDaoWithBlobs<T extends BaseEntity, I extends Serializable, E extends BaseEntityExample> extends BaseDao<T, I, E> {

	/**
	 * Select by example with BLO bs.
	 *
	 * @param example
	 *            the example
	 * @return the list
	 */
	List<T> selectByExampleWithBLOBs(E example);

	/**
	 * Update by example with BLO bs.
	 *
	 * @param record
	 *            the record
	 * @param example
	 *            the example
	 * @return the int
	 */
	int updateByExampleWithBLOBs(@Param("record") T record, @Param("example") E example);

	/**
	 * Update by primary key with BLO bs.
	 *
	 * @param record
	 *            the record
	 * @return the int
	 */
	int updateByPrimaryKeyWithBLOBs(T record);

	/**
	 * Select by example with BLO bs.
	 *
	 * @param example
	 *            the example
	 * @param paginationAttributes
	 *            the pagination attributes
	 * @return the list
	 */
	List<T> selectByExampleWithBLOBs(E example, PaginationAttributes paginationAttributes);

}
