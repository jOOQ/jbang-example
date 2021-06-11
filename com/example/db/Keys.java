/*
 * This file is generated by jOOQ.
 */
package com.example.db;


import com.example.db.tables.Author;
import com.example.db.tables.Book;
import com.example.db.tables.BookStore;
import com.example.db.tables.BookToBookStore;
import com.example.db.tables.Language;
import com.example.db.tables.records.AuthorRecord;
import com.example.db.tables.records.BookRecord;
import com.example.db.tables.records.BookStoreRecord;
import com.example.db.tables.records.BookToBookStoreRecord;
import com.example.db.tables.records.LanguageRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in 
 * the default schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AuthorRecord> CONSTRAINT_7 = Internal.createUniqueKey(Author.AUTHOR, DSL.name("CONSTRAINT_7"), new TableField[] { Author.AUTHOR.ID }, true);
    public static final UniqueKey<BookRecord> CONSTRAINT_1 = Internal.createUniqueKey(Book.BOOK, DSL.name("CONSTRAINT_1"), new TableField[] { Book.BOOK.ID }, true);
    public static final UniqueKey<BookStoreRecord> CONSTRAINT_F = Internal.createUniqueKey(BookStore.BOOK_STORE, DSL.name("CONSTRAINT_F"), new TableField[] { BookStore.BOOK_STORE.NAME }, true);
    public static final UniqueKey<BookToBookStoreRecord> CONSTRAINT_2 = Internal.createUniqueKey(BookToBookStore.BOOK_TO_BOOK_STORE, DSL.name("CONSTRAINT_2"), new TableField[] { BookToBookStore.BOOK_TO_BOOK_STORE.NAME, BookToBookStore.BOOK_TO_BOOK_STORE.BOOK_ID }, true);
    public static final UniqueKey<LanguageRecord> CONSTRAINT_C = Internal.createUniqueKey(Language.LANGUAGE, DSL.name("CONSTRAINT_C"), new TableField[] { Language.LANGUAGE.ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<BookRecord, AuthorRecord> FK_BOOK_AUTHOR = Internal.createForeignKey(Book.BOOK, DSL.name("FK_BOOK_AUTHOR"), new TableField[] { Book.BOOK.AUTHOR_ID }, Keys.CONSTRAINT_7, new TableField[] { Author.AUTHOR.ID }, true);
    public static final ForeignKey<BookRecord, LanguageRecord> FK_BOOK_LANGUAGE = Internal.createForeignKey(Book.BOOK, DSL.name("FK_BOOK_LANGUAGE"), new TableField[] { Book.BOOK.LANGUAGE_ID }, Keys.CONSTRAINT_C, new TableField[] { Language.LANGUAGE.ID }, true);
    public static final ForeignKey<BookToBookStoreRecord, BookRecord> FK_B2BS_BOOK = Internal.createForeignKey(BookToBookStore.BOOK_TO_BOOK_STORE, DSL.name("FK_B2BS_BOOK"), new TableField[] { BookToBookStore.BOOK_TO_BOOK_STORE.BOOK_ID }, Keys.CONSTRAINT_1, new TableField[] { Book.BOOK.ID }, true);
    public static final ForeignKey<BookToBookStoreRecord, BookStoreRecord> FK_B2BS_BOOK_STORE = Internal.createForeignKey(BookToBookStore.BOOK_TO_BOOK_STORE, DSL.name("FK_B2BS_BOOK_STORE"), new TableField[] { BookToBookStore.BOOK_TO_BOOK_STORE.NAME }, Keys.CONSTRAINT_F, new TableField[] { BookStore.BOOK_STORE.NAME }, true);
}
