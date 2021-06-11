/*
 * This file is generated by jOOQ.
 */
package com.example.db.tables;


import com.example.db.DefaultSchema;
import com.example.db.Keys;
import com.example.db.tables.records.BookToBookStoreRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BookToBookStore extends TableImpl<BookToBookStoreRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>BOOK_TO_BOOK_STORE</code>
     */
    public static final BookToBookStore BOOK_TO_BOOK_STORE = new BookToBookStore();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BookToBookStoreRecord> getRecordType() {
        return BookToBookStoreRecord.class;
    }

    /**
     * The column <code>BOOK_TO_BOOK_STORE.NAME</code>.
     */
    public final TableField<BookToBookStoreRecord, String> NAME = createField(DSL.name("NAME"), SQLDataType.VARCHAR(400).nullable(false), this, "");

    /**
     * The column <code>BOOK_TO_BOOK_STORE.BOOK_ID</code>.
     */
    public final TableField<BookToBookStoreRecord, Integer> BOOK_ID = createField(DSL.name("BOOK_ID"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>BOOK_TO_BOOK_STORE.STOCK</code>.
     */
    public final TableField<BookToBookStoreRecord, Integer> STOCK = createField(DSL.name("STOCK"), SQLDataType.INTEGER, this, "");

    private BookToBookStore(Name alias, Table<BookToBookStoreRecord> aliased) {
        this(alias, aliased, null);
    }

    private BookToBookStore(Name alias, Table<BookToBookStoreRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>BOOK_TO_BOOK_STORE</code> table reference
     */
    public BookToBookStore(String alias) {
        this(DSL.name(alias), BOOK_TO_BOOK_STORE);
    }

    /**
     * Create an aliased <code>BOOK_TO_BOOK_STORE</code> table reference
     */
    public BookToBookStore(Name alias) {
        this(alias, BOOK_TO_BOOK_STORE);
    }

    /**
     * Create a <code>BOOK_TO_BOOK_STORE</code> table reference
     */
    public BookToBookStore() {
        this(DSL.name("BOOK_TO_BOOK_STORE"), null);
    }

    public <O extends Record> BookToBookStore(Table<O> child, ForeignKey<O, BookToBookStoreRecord> key) {
        super(child, key, BOOK_TO_BOOK_STORE);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<BookToBookStoreRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_2;
    }

    @Override
    public List<UniqueKey<BookToBookStoreRecord>> getKeys() {
        return Arrays.<UniqueKey<BookToBookStoreRecord>>asList(Keys.CONSTRAINT_2);
    }

    @Override
    public List<ForeignKey<BookToBookStoreRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<BookToBookStoreRecord, ?>>asList(Keys.FK_B2BS_BOOK_STORE, Keys.FK_B2BS_BOOK);
    }

    private transient BookStore _bookStore;
    private transient Book _book;

    public BookStore bookStore() {
        if (_bookStore == null)
            _bookStore = new BookStore(this, Keys.FK_B2BS_BOOK_STORE);

        return _bookStore;
    }

    public Book book() {
        if (_book == null)
            _book = new Book(this, Keys.FK_B2BS_BOOK);

        return _book;
    }

    @Override
    public BookToBookStore as(String alias) {
        return new BookToBookStore(DSL.name(alias), this);
    }

    @Override
    public BookToBookStore as(Name alias) {
        return new BookToBookStore(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public BookToBookStore rename(String name) {
        return new BookToBookStore(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public BookToBookStore rename(Name name) {
        return new BookToBookStore(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<String, Integer, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}