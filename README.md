# Using jOOQ with jbang

[jbang](https://www.jbang.dev/) allows for quickly working with all sorts of Java libraries without the hassle of setting up environments, dependencies, etc. This catalog allows for using jOOQ's code generator right away on an existing database.

For more information on jbang, see:

- [Installation](https://www.jbang.dev/documentation/guide/latest/installation.html)
- [Usage](https://www.jbang.dev/documentation/guide/latest/usage.html)

The quickest way to set it up is:

```
curl -Ls https://sh.jbang.dev | bash -s - app setup
```

# How to use the example

In a shell, type

```
git clone https://github.com/jOOQ/jbang-example
cd jbang-example
jbang Example.java
```

In order to re-generate the example code, e.g. when your schema changes, just type:

```
jbang codegen@jooq db.xml
```

If you prefer working with a pre-existing database, just edit the `db.xml` file and point it to your database. Add the JDBC driver dependency like this:

```
jbang --deps org.postgresql:postgresql:RELEASE codegen@jooq db.xml
```

To override the jOOQ version from the default `RELEASE` to a specific version, use

```
jbang -Djooq.version=<version> codegen@jooq db.xml
```
