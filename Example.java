//DEPS org.jooq:jooq:${jooq.version:RELEASE}
//DEPS com.h2database:h2:${h2.version:RELEASE}
//SOURCES com/example/db/**

import static org.jooq.impl.DSL.*;
import static com.example.db.Tables.*;
import org.jooq.*;
import java.io.*;
import java.io.File;
import java.util.*;
import com.example.db.tables.records.*;


public class Example {
	public static void main(String[] args) throws Exception {
		try (CloseableDSLContext ctx = using("jdbc:h2:mem:jooq-jbang-example")) {
			execute(ctx, "db.sql");
			execute(ctx, "data.sql");
       
			var query =
				ctx.select(
					BOOK_TO_BOOK_STORE.book().author().FIRST_NAME,
					BOOK_TO_BOOK_STORE.book().author().LAST_NAME,
					BOOK_TO_BOOK_STORE.book().TITLE,
					countDistinct(BOOK_TO_BOOK_STORE.BOOK_ID)
						.over(partitionBy(BOOK_TO_BOOK_STORE.book().AUTHOR_ID)).as("books written by author"),
					countDistinct(BOOK_TO_BOOK_STORE.NAME)
						.over(partitionBy(BOOK_TO_BOOK_STORE.book().AUTHOR_ID)).as("bookstores listing author"),
					BOOK_TO_BOOK_STORE.book().language().CD,
					BOOK_TO_BOOK_STORE.bookStore().NAME)
				   .from(BOOK_TO_BOOK_STORE)
				   .orderBy(1, 2, 3);

			System.out.println("Query:");
			System.out.println(query);

			System.out.println();
			System.out.println("Result:");
			System.out.println(query.fetch());
		}
	}

	private static void execute(DSLContext ctx, String file) throws Exception {
		ctx.parser().parse(Source.of(new File(file)).readString()).executeBatch();
	}
}
