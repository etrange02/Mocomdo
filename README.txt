Eclipse Kepler
JRE 1.7
MySQL 5.6.12

1- Installation de Tomcat v7.0.47 -
Lien : http://apache.websitebeheerjd.nl/tomcat/tomcat-7/v7.0.47/bin/apache-tomcat-7.0.47-windows-x86.zip
Une fois l'archive téléchargée, dézippez-la à la racine de votre lecteur c:\.

2- MySQL -
On suppose qu'une base de données intitulé 'mdocDB' existe sur le serveur MySQL.

3- Eclipse -

Tomcat pour Eclipse
- Dans la barre de menu, Window -> Preferences
- Dans la colonne de gauche, déroulez 'server' et sélectionnez 'Runtime Environments'
- Cliquez ensuite sur 'Search', sélectionnez le répertoire où se trouve Tomcat.

L'archive se présente sous forme de fichier WAR
Importez ensuite le projet :
- File -> Import
- Ensuite, Web -> WAR file
- Cliquez sur Next
- Ensuite, à l'aide de 'Browse', retrouvez l'archive 'Mocomdo.WAR'. Normalement, la version 7.0.47 du serveur tomcat est déjà sélectionnée.

Paramétrage :
Déroulez l'arbre jusqu'à voir 'Mocomdo -> WebContent -> WEB-INF -> applicationContext.xml'.
Ouvrez le fichier 'applicationContext.xml', passez la vue en 'Source'. Le paramétrage de l'application se fait dans ce fichier.
Dans la partie 'Hibernate Template', vous devez entrez votre configuration.
Par défaut, le projet est configuré pour un serveur MySQL accessible sur le port 3306.

Lancement du serveur :
- Faites un clic droit sur 'index.jsp', 'Run as -> Run on Server'
- Sélectionnez 'Tomcat v7.0 Server' et cliquez sur 'Finish'
Le serveur démarre.

3 - Monitoring du cache -
Lien : http://sourceforge.net/projects/hibernate-jcons/files/beta/hibernate-jconsole-1.0.7.jar/download
Commencez par récupérer le jar donné ci-dessous.

A l'aide de la console, rendez-vous dans le dossier \WebContent\WEB-INF\lib.
Entrez ensuite la commande suivant :
"java -jar hibernate-jconsole-1.0.7.jar"

Une fenêtre s'ouvre. Dans "local process", Sélectionnez "org.apache.catalina.startup.Bootstrap start".
Un message d'erreur peut apparaître, cliquez sur "Insecure".
Ensuite, rendez-vous dans l'onglet "Hibernate Monitor" pour surveiller le cache.