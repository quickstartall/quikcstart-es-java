# quikcstart-es-java
This is a sample application to show how to use Elastic Search with Java. I'm using Jest as the Java API for Elastic Search
This sample MusicApp will create some music. Update music and finally delete some music. 
Please look at the comments in the main class MusicApp, it's self-explanatory.

# Prerequisite
 jdk 8 <It can work on other version as well but I'm using jdk8>       
 Maven 3.2.5    
 elasticsearch-5.0.0    

# How to run the application
        (1)Download the bundle for lasticsearch-5.0.0 for windows from https://www.elastic.co/downloads/elasticsearch
        (2)unpack the bundle downloaded in above step
        (3)go to folder/directory bin
        (4)run elasticsearch.bat 
        (5)The elastic search api will, by default, run on port 9200 <http://localhost:9200>. If it's running on this default port skip         following step
                If you run elastic search on other port please update the url in ESJestClient as follows.	
                private static final String SERVER_URI = "http://localhost:9200";	
	(6)Download/clone the project to your local system
	(7)go to project root directory (quickstartall-es-jest)and run mvn clean package
	There will be two jars created under target (A) es-jest-1.0-SNAPSHOT (B) es-jest-1.0-SNAPSHOT-jar-with-dependencies
	Later on is an executable jar created automatically when you run mvn package
        (8) Once the elastic serach is started run the class MusicApp in either of the folowing way:
	(8a)java -jar target\es-jest-1.0-SNAPSHOT-jar-with-dependencies.jar
	(8b) if you are using eclipse, run MusicApp from the project explorer Right-Click ==> Run As ==> Java Application

        (9) You will see output as follows:
        Calling sweet API...
        Following Music created successfully. Enjoy your day!
        com.raquibul.quickstartall.es.model.Music@4d826d77[name=Bollywood Track 1,year=Sun May 28 13:09:05 CEST 2017,lyrics=Chhu kar mera mann ko tune kiya isara..,documentId=1]
        Following Music created successfully. Enjoy your day!
        com.raquibul.quickstartall.es.model.Music@7f77e91b[name=Bollywood Track 2,year=Sun May 28 13:09:07 CEST 2017,lyrics=Zindagi ka safar hai yeh kaisa safar..,documentId=2]
        Following Music created successfully. Enjoy your day!
        com.raquibul.quickstartall.es.model.Music@44a664f2[name=Hollywood Track 3,year=Sun May 28 13:09:07 CEST 2017,lyrics=Tell me babe that you love me..,documentId=3]
        Following Music created successfully. Enjoy your day!
        com.raquibul.quickstartall.es.model.Music@7f9fcf7f[name=Hollywood Track 4,year=Sun May 28 13:09:08 CEST 2017,lyrics=Cause I'm leaving on a jet plane...,documentId=4]
        Hurray, following music found, Enjoy your day!
        ******************************************************************
        com.raquibul.quickstartall.es.model.Music@36f0f1be[name=Bollywood Track 1,year=Sun May 28 13:09:05 CEST 2017,lyrics=Chhu kar mera mann ko tune kiya isara..,documentId=1]
        ******************************************************************
        Hurray, following music found, Enjoy your day!
        ******************************************************************
        com.raquibul.quickstartall.es.model.Music@157632c9[name=Bollywood Track 1 updated,year=Sun May 28 13:09:08 CEST 2017,lyrics=Updated Bollywood song..,documentId=1]
        ******************************************************************
        Hurray, following music found, Enjoy your day!
        ******************************************************************
        com.raquibul.quickstartall.es.model.Music@6ee12bac[name=Hollywood Track 4,year=Sun May 28 13:09:08 CEST 2017,lyrics=Cause I'm leaving on a jet plane...,documentId=4]
        ******************************************************************
        Music with Id[4] deleted successfully. It's gone to heaven now.
        No  music with the ID[4] found, enjoy your day
        Done!



