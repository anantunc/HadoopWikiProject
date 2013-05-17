HadoopWikiProject
=================

The objective of this project is to analyze public Wikimedia logs to determine different traffic load as well as popularity patterns using Apache Hadoop. Apache Hadoop is an open-source software framework that supports data-intensive distributed applications, licensed under the Apache v2 license. It supports the running of applications on large clusters of commodity hardware. Hadoop was derived from Google's MapReduce and Google File System (GFS) papers. The dataset for this project comprises of three days’ worth (January 1st, 2012 to January 3rd, 2012) of Wikimedia log entries, which translates to about 5.6GB of compressed data and about 20GB after decompression.
<br><br>
The goal of this project is to:
<br>
1.) Perform temporal analysis on total number of requests per hour.
2.) Find the most popular Wikimedia project based on total views per hour per project.
3.) Find the top 10 most popular pages during a given day.
4.) Find the top 10 pages that returned the most content during a given day.
5.) Determine whether this data obeys Zipf’s law in terms of popularity.