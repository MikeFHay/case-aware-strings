case-aware-strings
==================

Type-safe upper-case, lower-case, and case-insensitive strings for Java.

Ever check if your Set&lt;String&gt; {"foo", "bar", "baz"} contains "Foo"? That's probably a bug. Make a Set&lt;LowerCase&gt; instead, and never see that bug again.

All classes in this library are [value-based](http://docs.oracle.com/javase/8/docs/api/java/lang/doc-files/ValueBased.html), meaning they are final, immutable, do not (functionally) use reference equality, and do not have accessible constructors (they are constructed through static factory methods). I played with reflection to write some unit tests which assert this as much as possible.
