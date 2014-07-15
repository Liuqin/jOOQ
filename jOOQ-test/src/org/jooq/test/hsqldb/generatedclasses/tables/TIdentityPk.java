/**
 * This class is generated by jOOQ
 */
package org.jooq.test.hsqldb.generatedclasses.tables;

/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TIdentityPk extends org.jooq.impl.TableImpl<org.jooq.test.hsqldb.generatedclasses.tables.records.TIdentityPkRecord> {

	private static final long serialVersionUID = 453078674;

	/**
	 * The singleton instance of <code>PUBLIC.T_IDENTITY_PK</code>
	 */
	public static final org.jooq.test.hsqldb.generatedclasses.tables.TIdentityPk T_IDENTITY_PK = new org.jooq.test.hsqldb.generatedclasses.tables.TIdentityPk();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.jooq.test.hsqldb.generatedclasses.tables.records.TIdentityPkRecord> getRecordType() {
		return org.jooq.test.hsqldb.generatedclasses.tables.records.TIdentityPkRecord.class;
	}

	/**
	 * The column <code>PUBLIC.T_IDENTITY_PK.ID</code>. 
	 */
	public final org.jooq.TableField<org.jooq.test.hsqldb.generatedclasses.tables.records.TIdentityPkRecord, java.lang.Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this);

	/**
	 * The column <code>PUBLIC.T_IDENTITY_PK.VAL</code>. 
	 */
	public final org.jooq.TableField<org.jooq.test.hsqldb.generatedclasses.tables.records.TIdentityPkRecord, java.lang.Integer> VAL = createField("VAL", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * Create a <code>PUBLIC.T_IDENTITY_PK</code> table reference
	 */
	public TIdentityPk() {
		super("T_IDENTITY_PK", org.jooq.test.hsqldb.generatedclasses.Public.PUBLIC);
	}

	/**
	 * Create an aliased <code>PUBLIC.T_IDENTITY_PK</code> table reference
	 */
	public TIdentityPk(java.lang.String alias) {
		super(alias, org.jooq.test.hsqldb.generatedclasses.Public.PUBLIC, org.jooq.test.hsqldb.generatedclasses.tables.TIdentityPk.T_IDENTITY_PK);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<org.jooq.test.hsqldb.generatedclasses.tables.records.TIdentityPkRecord, java.lang.Integer> getIdentity() {
		return org.jooq.test.hsqldb.generatedclasses.Keys.IDENTITY_T_IDENTITY_PK;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.jooq.test.hsqldb.generatedclasses.tables.records.TIdentityPkRecord> getPrimaryKey() {
		return org.jooq.test.hsqldb.generatedclasses.Keys.PK_T_IDENTITY_PK;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.jooq.test.hsqldb.generatedclasses.tables.records.TIdentityPkRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.jooq.test.hsqldb.generatedclasses.tables.records.TIdentityPkRecord>>asList(org.jooq.test.hsqldb.generatedclasses.Keys.PK_T_IDENTITY_PK);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.test.hsqldb.generatedclasses.tables.TIdentityPk as(java.lang.String alias) {
		return new org.jooq.test.hsqldb.generatedclasses.tables.TIdentityPk(alias);
	}
}