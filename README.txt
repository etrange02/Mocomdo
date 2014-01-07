Eclipse Kepler
JRE 1.7
MySQL 5.6.12

1- Installation de Tomcat v7.0.47 -
Lien : http://apache.websitebeheerjd.nl/tomcat/tomcat-7/v7.0.47/bin/apache-tomcat-7.0.47-windows-x86.zip
Une fois l'archive t�l�charg�e, d�zippez-la � la racine de votre lecteur c:\.

2- MySQL -
On suppose qu'une base de donn�es intitul� 'mdocDB' existe sur le serveur MySQL.

3- Eclipse -

Tomcat pour Eclipse
- Dans la barre de menu, Window -> Preferences
- Dans la colonne de gauche, d�roulez 'server' et s�lectionnez 'Runtime Environments'
- Cliquez ensuite sur 'Search', s�lectionnez le r�pertoire o� se trouve Tomcat.

L'archive se pr�sente sous forme de fichier WAR
Importez ensuite le projet :
- File -> Import
- Ensuite, Web -> WAR file
- Cliquez sur Next
- Ensuite, � l'aide de 'Browse', retrouvez l'archive 'Mocomdo.WAR'. Normalement, la version 7.0.47 du serveur tomcat est d�j� s�lectionn�e.

Param�trage :
D�roulez l'arbre jusqu'� voir 'Mocomdo -> WebContent -> WEB-INF -> applicationContext.xml'.
Ouvrez le fichier 'applicationContext.xml', passez la vue en 'Source'. Le param�trage de l'application se fait dans ce fichier.
Dans la partie 'Hibernate Template', vous devez entrez votre configuration.
Par d�faut, le projet est configur� pour un serveur MySQL accessible sur le port 3306.

Lancement du serveur :
- Faites un clic droit sur 'index.jsp', 'Run as -> Run on Server'
- S�lectionnez 'Tomcat v7.0 Server' et cliquez sur 'Finish'
Le serveur d�marre.

3 - Monitoring du cache -
Lien : http://sourceforge.net/projects/hibernate-jcons/files/beta/hibernate-jconsole-1.0.7.jar/download
Commencez par r�cup�rer le jar donn� ci-dessous.

A l'aide de la console, rendez-vous dans le dossier \WebContent\WEB-INF\lib.
Entrez ensuite la commande suivant :
"java -jar hibernate-jconsole-1.0.7.jar"

Une fen�tre s'ouvre. Dans "local process", S�lectionnez "org.apache.catalina.startup.Bootstrap start".
Un message d'erreur peut appara�tre, cliquez sur "Insecure".
Ensuite, rendez-vous dans l'onglet "Hibernate Monitor" pour surveiller le cache.