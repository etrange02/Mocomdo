Eclipse Kepler
JRE 1.7
MySQL 5.6.12

1- Installation de Tomcat v7.0.47 -
Lien : http://apache.websitebeheerjd.nl/tomcat/tomcat-7/v7.0.47/bin/apache-tomcat-7.0.47-windows-x86.zip
Une fois l'archive t�l�charg�e, d�zippez-la � la racine de votre lecteur c:\.

2- Eclipse -
Commencez par d�sipper le contenu de l'archive dans votre workspace Eclipse.
Importez ensuite le projet :
- File -> Import -> General/Existing Projects into Workspace
- Cliquez sur Next
- Dans le premier champ, s�lectionnez votre workspace. Utilisez 'Browse' s'il n'est pas pr�sent dans la liste d�roulante.
- V�rifiez que le projet 'Mocomdo' est coch�
- Cliquez sur Finish

Le projet est maintenant ouvert dans votre Eclipse.

Ensuite, indiquons o� se trouve Tomcat
- Dans la barre de menu, Window -> Preferences
- Dans la colonne de gauche, d�roulez 'server' et s�lectionnez 'Runtime Environments'


3 - Monitoring du cache -
Lien : http://sourceforge.net/projects/hibernate-jcons/files/beta/hibernate-jconsole-1.0.7.jar/download
Commencez par r�cup�rer le jar donn� ci-dessous.

A l'aide de la console, rendez-vous dans le dossier \WebContent\WEB-INF\lib.
Entrez ensuite la commande suivant :
"java -jar hibernate-jconsole-1.0.7.jar"

Une fen�tre s'ouvre. Dans "local process", S�lectionnez "org.apache.catalina.startup.Bootstrap start".
Un message d'erreur peut appara�tre, cliquez sur "Insecure".
Ensuite, rendez-vous dans l'onglet "Hibernate Monitor" pour surveiller le cache.